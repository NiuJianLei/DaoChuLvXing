package com.example.lenovo.daochulvxing.util;



import android.app.Notification;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.umeng.socialize.view.BaseDialog;

import org.xutils.common.Callback;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;

import luo.library.base.base.BaseAndroid;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * 版本更新
 */
public class UpdateManager {
    private String downLoadPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/downloads/";
    private int type = 0;//更新方式，0：引导更新，1：安装更新，2：强制更新
    private String url = "";//apk下载地址
    private String updateMessage = "";//更新内容
    private String fileName = null;//文件名
    private boolean isDownload = false;//是否下载
    private NotificationManager mNotifyManager;
    private NotificationCompat.Builder mBuilder;
    private AlertDialog dialog;
    private ProgressDialog progressDialog;

    public static UpdateManager updateManager;

    public static UpdateManager getInstance() {
        if (updateManager == null) {
            updateManager = new UpdateManager();
        }
        return updateManager;
    }

    private UpdateManager() {

    }

    /**
     * 弹出版本更新提示框
     */
    public void showDialog(final Context context) {
        String title = "";
        String left = "";
        boolean cancelable = true;
        if (type == 1 | isDownload) {
            title = "安装新版本";
            left = "立即安装";
        } else {
            title = "发现新版本";
            left = "立即更新";
        }
        if (type == 2) {
            cancelable = false;
        }
        dialog = new AlertDialog.Builder(context).setTitle(title).setMessage(updateMessage).setCancelable(cancelable)
                .setNegativeButton(left, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (type == 1 | isDownload) {
                            InstallUtil.installApk(context,downLoadPath+fileName);
                        } else {
                            if (url != null && !TextUtils.isEmpty(url)) {
                                if (type == 2) {
                                    createProgress(context);
                                } else {
                                    createNotification(context);
                                }
                                downloadFile(context);
                            } else {
                                Toast.makeText(context, "下载地址错误", Toast.LENGTH_SHORT).show();
                            }
                        }
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if (type == 2) {
                            System.exit(0);
                        }
                    }
                })
                .create();
        dialog.show();
    }

    private static final String TAG = "UpdateManager";
    /**
     * 下载apk
     *
     */
    public void downloadFile(final Context context) {
        RequestParams params = new RequestParams(url);
        params.setSaveFilePath(downLoadPath + fileName);
        x.http().request(HttpMethod.GET, params, new Callback.ProgressCallback<File>() {

            @Override
            public void onSuccess(File result) {

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public void onWaiting() {

            }

            @Override
            public void onStarted() {

            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                //实时更新通知栏进度条
                if (type == 0) {
                    Log.e(TAG, "onLoading:"+current+"/"+total );
                    notifyNotification(current, total);
                } else if (type == 2) {
                    progressDialog.setProgress((int) (current * 100 / total));
                }
                if (total == current) {
                    if (type == 0) {
                        mBuilder.setContentText("下载完成");
                        mNotifyManager.notify(10086, mBuilder.build());
                    } else if (type == 2) {
                        progressDialog.setMessage("下载完成");
                    }
                    if (type == 1) {
                        showDialog(context);
                    } else {
                        InstallUtil.installApk(context,downLoadPath+fileName);
                    }
                }
            }
        });
    }

    /**
     * 强制更新时显示在屏幕的进度条
     *
     */
    private void createProgress(Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMax(100);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("正在下载...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
    }

    /**
     * 创建通知栏进度条
     *
     */
    private void createNotification(Context context) {
        mNotifyManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        mBuilder = new NotificationCompat.Builder(context);
        mBuilder.setSmallIcon(BaseAndroid.getBaseConfig().getAppLogo());
        mBuilder.setContentTitle("版本更新");
        mBuilder.setContentText("正在下载...");
        mBuilder.setProgress(0, 0, false);
        Notification notification = mBuilder.build();
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        mNotifyManager.notify(10086, notification);
    }

    /**
     * 更新通知栏进度条
     *
     */
    private void notifyNotification(long percent, long length) {
        mBuilder.setProgress((int) length, (int) percent, false);
        mNotifyManager.notify(10086, mBuilder.build());
    }

    /**
     * 安装apk
     *
     * @param context 上下文
     * @param file    APK文件
     */
    private void installApk(Context context, File file) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    /**
     * @return 当前应用的版本号
     */
    public int getVersionCode(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            int version = info.versionCode;
//            String versionName = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * @return 当前应用的版本名
     */
    public String getVersionName(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
//            int version = info.versionCode;
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return "1.0";
        }
    }

    /**
     * 判断当前网络是否wifi
     */
    public boolean isWifi(Context mContext) {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return true;
        }
        return false;
    }

    public UpdateManager setUrl(String url) {
        this.url = url;
        return this;
    }

    public UpdateManager setType(int type) {
        this.type = type;
        return this;
    }

    public UpdateManager setUpdateMessage(String updateMessage) {
        this.updateMessage = updateMessage;
        return this;
    }

    public UpdateManager setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public UpdateManager setIsDownload(boolean download) {
        isDownload = download;
        return this;
    }

    /**
     * localVersion  为当前安装的版本
     * newVersion    为最新版本
     * */
    public boolean updateApp(String localVersion, String newVersion) {
        String[] localVersionArray = localVersion.split("\\.");
        String[] newVersionArray = newVersion.split("\\.");
        if (localVersionArray.length < newVersionArray.length) {
            int cha = newVersionArray.length - localVersionArray.length;
            for (int i = 0; i < cha; i++) {
                localVersion = localVersion + ".0";
            }
            localVersionArray = localVersion.split("\\.");
        }
        try {
            for (int i = 0; i < newVersionArray.length; i++) {
                int temp = Integer.parseInt(newVersionArray[i]);
                int compar = Integer.parseInt(localVersionArray[i]);
                if (temp > compar) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
