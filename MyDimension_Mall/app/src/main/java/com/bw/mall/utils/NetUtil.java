package com.bw.mall.utils;

import android.os.Handler;
import android.os.Looper;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * ClassName: MyDimension_Mall
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/19 20:38
 * @Description: 用途：完成特定功能
 */
public class NetUtil {
    //单例模式
    //定义静态实例
    private static NetUtil instance;
    private final OkHttpClient okHttpClient;
    private Handler handler =new Handler(Looper.myLooper());

    //构造方法私有化
    private NetUtil(){
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS) //设置请求超时时间 5秒
                .readTimeout(5, TimeUnit.SECONDS) //设置读取超时时间 5秒
                .writeTimeout(5, TimeUnit.SECONDS) //设置写入超时时间 5秒
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)) //添加日志拦截器 自动打印日志 body
                .build();
    }
    //暴露get方法
    public static NetUtil getInstance(){
        if (instance == null) {
            //双重校验锁
            synchronized (NetUtil.class){
                if (instance == null) {
                    instance = new NetUtil();
                }
            }
        }
        return instance;
    }

    //post请求
    public void doPostUser(String path, Map<String,String> param ,NetCallBack netCallBack){
        //模板 添加数据
        FormBody.Builder formbody = new FormBody.Builder();
        //遍历map集合
        Set<Map.Entry<String, String>> entries = param.entrySet();
        for(Map.Entry<String,String> entry : entries ){
            String key = entry.getKey();
            String value = entry.getValue();
            //添加
            formbody.add(key,value);
        }
        RequestBody requestBody = formbody.build();
        //构建请求
        Request request = new Request.Builder()
                .url(path)
                .post(requestBody)
                .build();
        //创建Call对象
        Call call= okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                String message = e.getMessage();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        netCallBack.netFiled(message);
                    }
                });
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                ResponseBody body = response.body();
                String json = body.string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        netCallBack.netFiled(json);
                    }
                });

            }
        });


    }


    //接口回调
    public interface NetCallBack{
        //成功
        void netSuccess(String json);
        //失败
        void netFiled(String error);
    }
}
