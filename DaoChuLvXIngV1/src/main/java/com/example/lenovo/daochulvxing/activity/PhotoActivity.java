package com.example.lenovo.daochulvxing.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.base.BaseActivity;
import com.example.lenovo.daochulvxing.util.FileProviderUtils;
import com.example.lenovo.daochulvxing.util.PhotosUtils;
import com.example.lenovo.daochulvxing.util.SpUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import presenter.EmptyPresenter;
import view.EmptyView;

public class PhotoActivity extends BaseActivity<EmptyView, EmptyPresenter> implements View.OnClickListener {


    private ImageView mSettingPhotoBack;
    private ImageView mSettingPhotoOpen;
    private LinearLayout mPrentLl;
    private View view;
    private Button quxiao;
    private Button xiangce;
    private Button xiangji;
    private PopupWindow popupWindow;
    private ImageView mTouxiang;
    private String mImgUrl;
    private String uploadUrl = "http://yun918.cn/study/public/file_upload.php";
    private File camerafile;
    private TextView ok;
    private String sendPhoto="http://yun918.cn/study/public/index.php/uploadheader";
    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int Layoutid() {
        return R.layout.activity_photo;
    }


    public void initView() {



        mSettingPhotoBack = (ImageView) findViewById(R.id.setting_photo_back);
        mSettingPhotoBack.setOnClickListener(this);
        mSettingPhotoOpen = (ImageView) findViewById(R.id.setting_photo_open);
        mSettingPhotoOpen.setOnClickListener(this);

        mPrentLl = (LinearLayout) findViewById(R.id.prent_ll);
        registerForContextMenu(mSettingPhotoOpen);
        mTouxiang = (ImageView) findViewById(R.id.touxiang);

        String photourl = (String) SpUtil.getParam("photourl", "");

        Glide.with(this)
                .load(photourl)
                .into(mTouxiang);

        ok = findViewById(R.id.photo_ok);
        ok.setVisibility(View.GONE);
        mSettingPhotoOpen.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.setting_photo_back:
                finish();
                break;
            case R.id.setting_photo_open:
                view = View.inflate(this, R.layout.openxiangji_popup_layout, null);
                popupWindow = new PopupWindow(view, 1100, 450);
                popupWindow.setBackgroundDrawable(new ColorDrawable());
                popupWindow.setOutsideTouchable(true);
                popupWindow.showAtLocation(mPrentLl, Gravity.BOTTOM, 0, 0);
                initpopupListener();
                mSettingPhotoOpen.setVisibility(View.GONE);
                ok.setVisibility(View.VISIBLE);
                break;
            case R.id.photo_ok:
                Toast.makeText(this, "正在上传头像", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //对popup的监听
    private void initpopupListener() {
        quxiao = view.findViewById(R.id.popup_quxiao);
        xiangce = view.findViewById(R.id.popup_xiangce);
        xiangji = view.findViewById(R.id.popup_xiangji);

        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        xiangji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                camerafile = new File(Environment.getExternalStorageDirectory() + File.separator + "xxx.png");
                PhotosUtils.goCamera(PhotoActivity.this, camerafile);
                popupWindow.dismiss();
            }
        });
        xiangce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhotosUtils.selectPhoto(PhotoActivity.this);
                popupWindow.dismiss();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String filePath = Environment.getExternalStorageDirectory() + File.separator ;

        Uri filtUri;
        File outputFile = new File(filePath+"t.jpg");//裁切后输出的图片
        switch (requestCode) {
            case PhotosUtils.REQUEST_CODE_PAIZHAO:
                //拍照完成，进行图片裁切
                filtUri = FileProviderUtils.uriFromFile(this, camerafile);

                PhotosUtils.doCrop(PhotoActivity.this, filtUri, outputFile);
                break;
            case PhotosUtils.REQUEST_CODE_ZHAOPIAN:
                //相册选择图片完毕，进行图片裁切
                if (data == null || data.getData() == null) {
                    return;
                }
                filtUri = data.getData();
                PhotosUtils.doCrop(PhotoActivity.this, filtUri, outputFile);
                break;
            case PhotosUtils.REQUEST_CODE_CAIQIE:
                //图片裁切完成，显示裁切后的图片
                try {
                    Uri uri = FileProviderUtils.uriFromFile(PhotoActivity.this, outputFile);
//                    Bitmap bitmap = BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(uri));


                    RequestOptions mRequestOptions = RequestOptions.circleCropTransform()
                            .skipMemoryCache(true)
                            .diskCacheStrategy(DiskCacheStrategy.NONE);


                    Glide.with(this)
                            .load(uri)
                            .apply(mRequestOptions)
                            .into(mTouxiang);
                    // file path
                    // okhttp
                    uploadUserIcon(outputFile);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
        }
    }

    private static final String TAG = "PhotoActivity";
    public void uploadUserIcon(final File file) {

        // file --> RequestBody-- MultiPartBody
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"), file);

        MultipartBody multipartBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("key", "monthdemo")
                .addFormDataPart("file", System.currentTimeMillis()+file.getName(), requestBody)
                .build();

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(uploadUrl)
                .post(multipartBody)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: e=" + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                {"code":200,"res":"上传文件成功","data":{"url":"http:\/\/yun918.cn\/study\/public\/uploadfiles\/monthdemo\/tupian_out.jpg"}}

                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());

                    JSONObject data = jsonObject.getJSONObject("data");
                    String result = data.optString("url");

                    // 把图片的服务器url 发送给homeFragment
                    mImgUrl = result;

                    Log.d(TAG, "onResponse: " + result);
                    SpUtil.setParam("photourl",mImgUrl);
                    finish();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }




}