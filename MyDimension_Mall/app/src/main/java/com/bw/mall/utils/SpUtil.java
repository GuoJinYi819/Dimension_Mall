package com.bw.mall.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.bw.mall.App;

/**
 * ClassName: MyDimension_Mall
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/23 11:58
 * @Description: 用途：完成特定功能
 */
public class SpUtil {
    private static final String SP_NAME = "sp";
    public static final String SP_PHONE="phone";
    public static final String SP_PWD="pwd";
    //单例模式
    private static SpUtil instance;
    private final SharedPreferences sp = App.context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    private final SharedPreferences.Editor edit = sp.edit();
    private SpUtil(){

    }
    public static SpUtil getInstance(){
        if (instance == null) {
            synchronized (SpUtil.class){
                if (instance == null) {
                    instance = new SpUtil();
                }
            }
        }
        return instance;
    }
    //存
    public void setCacheData(String key,String value){
        edit.putString(key,value);
        //提交
        edit.commit();
    }
    //取
    public String getCachData(String key){
        String value = sp.getString(key, "");
        return value;
    }

}
