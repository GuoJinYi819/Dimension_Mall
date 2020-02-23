package com.bw.mall;

import android.app.Application;
import android.content.Context;

/**
 * ClassName: MyDimension_Mall
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/23 11:59
 * @Description: 用途：完成特定功能
 */
public class App extends Application {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
