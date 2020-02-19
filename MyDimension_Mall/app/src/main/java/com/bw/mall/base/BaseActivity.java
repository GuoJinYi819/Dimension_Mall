package com.bw.mall.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * ClassName: MyDimension_Mall
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/19 21:18
 * @Description: 用途：完成特定功能
 */
public abstract class BaseActivity<p extends BasePresenter> extends AppCompatActivity {
    protected p presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
        //设置视图
        int layoutId = initLayoutId();
        setContentView(layoutId);
        initView();
        initListener();
        initData();
    }
    //初始化布局
    protected abstract int initLayoutId();
    //初始化控件
    protected abstract void initView();
    //初始化监听
    protected abstract void initListener();
    //初始化数据
    protected abstract void initData();
    //初始化presenter层
    protected abstract p initPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //MVP 防止内存泄露处理
        if (presenter != null) {
            presenter = null;
        }
    }
}
