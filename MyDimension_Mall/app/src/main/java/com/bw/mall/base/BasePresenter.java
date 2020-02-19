package com.bw.mall.base;

/**
 * ClassName: MyDimension_Mall
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/19 21:24
 * @Description: 用途：完成特定功能
 */
public abstract class BasePresenter<view> {
    protected view baseView;

    public BasePresenter(){
        initModule();
    }
    //绑定
    protected void attachView(view baseView){
        this.baseView = baseView;
    }
    //解绑
    protected void detachView(){
        if (baseView != null) {
            baseView = null;
        }
    }
    //初始化Module
    protected abstract void initModule();
}
