package com.bw.mall.utils;

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
    //构造方法私有化
    private NetUtil(){

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



    //接口回调
    public interface NetCallBack{
        //成功
        void NetSuccess(String json);
        //失败
        void NetFiled(String error);
    }
}
