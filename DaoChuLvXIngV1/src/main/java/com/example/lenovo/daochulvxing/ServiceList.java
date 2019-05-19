package com.example.lenovo.daochulvxing;

import com.example.lenovo.daochulvxing.bean.BanMiBean;
import com.example.lenovo.daochulvxing.bean.BanXiangBean;
import com.example.lenovo.daochulvxing.bean.CommentBean;
import com.example.lenovo.daochulvxing.bean.DiquBean;
import com.example.lenovo.daochulvxing.bean.GuanZhu;
import com.example.lenovo.daochulvxing.bean.LoginInfo;
import com.example.lenovo.daochulvxing.bean.Map_TabBean;
import com.example.lenovo.daochulvxing.bean.MyPerson;
import com.example.lenovo.daochulvxing.bean.VersionInfo;
import com.example.lenovo.daochulvxing.bean.XiangBean;
import com.example.lenovo.daochulvxing.bean.ZhuanTiBean;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceList {

    int NAME=0;
    int SEX=1;
    int PHOTO=2;
    int SING=3;


    public static String singUrl="http://api.banmi.com/";
    @FormUrlEncoded
    @POST("api/3.0/account/login/oauth")
    Observable<LoginInfo> getLogin(@Field("oAuthToken") String uid);



    @GET("api/3.0/content/routesbundles")
    //banmi-app-token:登录后的token(请求头)
    Observable<MyPerson> gethome(@Query("page") int page, @Header("banmi-app-token") String token);

    /*
    * 路径:api/3.0/banmi
	请求方式:get
	参数:	page,页面,从1开始
			banmi-app-token:登录后的token(请求头)
    * */
    @GET("api/3.0/banmi")
    Observable<BanMiBean> getBanMi(@Query("page") int page,@Header("banmi-app-token") String token);


    /*
    * 请求修改个人信息
    *
    * */

    @FormUrlEncoded
    @POST("api/3.0/account/updateInfo")
    Observable<ResponseBody> getSetting(@Header("banmi-app-token") String token, @FieldMap HashMap<String,String> hashMap);


    /*
        收藏线路

    * 路径:api/3.0/content/routes/{routeId}/like
	请求方式:get
	参数:	routeId,路线id
			banmi-app-token:登录后的token(请求头)
	结果:略
    * */
    @POST("api/3.0/banmi/{banmiId}/follow")
    Observable<ResponseBody> getLike(@Path("banmiId") int id,@Header("token") String token);

    /*
    * 取消收藏线路
	路径:api/3.0/content/routes/{routeId}/dislike
	请求方式:get
	参数:	routeId,路线id
			banmi-app-token:登录后的token(请求头)
	结果:略
    * */
    @POST("api/3.0/banmi/{banmiId}/unfollow")
    Observable<ResponseBody> getRemove(@Path("banmiId") int id,@Header("token") String token);

    //收藏线路
    @GET("api/3.0/account/followedBanmi")
    Observable<GuanZhu> getGuanZhu(@Header("banmi-app-token") String token,@Query("page") int page);


    //首页详情
    @GET("api/3.0/content/routes/{routeId}")
    Observable<XiangBean>  getXiang(@Path("routeId") int id,@Header("banmi-app-token") String token);

    //伴米详情
    @GET("api/3.0/banmi/{banmiId}")
    Observable<BanXiangBean> getBanXiang(@Path("banmiId") int id,@Query("page") int page,@Header("banmi-app-token") String token);


    //专题列表
    @GET("api/3.0/content/bundles")
    Observable<ZhuanTiBean> getZhuanTi(@Header("banmi-app-token") String token);


    //全部评论
    @GET("api/3.0/content/routes/{routeId}/reviews")
    Observable<CommentBean> getComment(@Path("routeId") int id,@Query("page") int page,@Header("banmi-app-token") String token);

    //版本更新
    @GET("api/app/common/getVersionInfo?operating_system=android")
    Observable<VersionInfo> getVersionInfo(@Header("banmi-app-token") String token);


    //MapTabtitle
    @GET("api/3.0/map/spots")
    Observable<Map_TabBean> getMapTab(@Header("banmi-app-token")String token,@Query("tagID") String id,@Query("cityID") String csid);


    //地区
    @GET("api/3.0/map/cities")
    Observable<DiquBean> getDiqu(@Header("banmi-app-token") String token);

}
