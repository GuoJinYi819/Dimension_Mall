package com.bw.mall;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;

import com.bw.mall.adapter.HomePageAdapter;
import com.bw.mall.base.BaseActivity;
import com.bw.mall.base.BasePresenter;
import com.bw.mall.customview.MyViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomePageActivity extends BaseActivity {

    @BindView(R.id.home_vp)
    MyViewPager homeVp;
    @BindView(R.id.home_tab)
    TabLayout homeTab;
    private Unbinder unbinder;
    private int[] tabfalse = {R.mipmap.common_tab_home_xhdpi,R.mipmap.common_tab_circle_n,R.mipmap.commom_tab_xhdpi
    ,R.mipmap.common_tab_list_n_xhdpi,R.mipmap.common_tab_my_n_xhdpi};
    private int[] tabture = {R.mipmap.common_tab_btn_home_s_xhdi,R.mipmap.common_tab_btn_circle_s_xhdpi,R.mipmap.commom_tab_xhdpi
    ,R.mipmap.common_tab_btn_list_s_xhdpi,R.mipmap.common_tab_btn_my_s_xhdpi};

    @Override
    protected int initLayoutId() {
        return R.layout.activity_home_page;
    }

    @Override
    protected void initView() {
        //绑定 butterknife
        unbinder = ButterKnife.bind(this);
        //初始化图标
        TabLayout.Tab tab = homeTab.newTab();
        tab.setIcon(R.mipmap.common_tab_home_xhdpi);
        homeTab.addTab(tab);

        tab = homeTab.newTab();
        tab.setIcon(R.mipmap.common_tab_circle_n);
        homeTab.addTab(tab);

        tab = homeTab.newTab();
        tab.setIcon(R.mipmap.commom_tab_xhdpi);
        homeTab.addTab(tab);

        tab = homeTab.newTab();
        tab.setIcon(R.mipmap.common_tab_list_n_xhdpi);
        homeTab.addTab(tab);

        tab = homeTab.newTab();
        tab.setIcon(R.mipmap.common_tab_my_n_xhdpi);
        homeTab.addTab(tab);


        //设置适配器
        HomePageAdapter homePageAdapter = new HomePageAdapter(getSupportFragmentManager());
        homeVp.setAdapter(homePageAdapter);

    }


    @Override
    protected void initListener() {
        //默认首页
        homeTab.setScrollPosition(0,0,false);
        TabLayout.Tab tabAt = homeTab.getTabAt(0);
        tabAt.setIcon(tabture[0]);
        //设置TabLayout 监听
        homeTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选中tab
                int position = tab.getPosition(); //获取当前tab位置 下标
                homeVp.setCurrentItem(position);
                tab.setIcon(tabture[position]); //根据当前tab位置，设置图标
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //未选中 tab
                tab.setIcon(tabfalse[tab.getPosition()]); //设置tabfalse 数组里未选中的图标
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //重新选择
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
