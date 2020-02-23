package com.bw.mall;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.bw.mall.adapter.HomePageAdapter;
import com.bw.mall.base.BaseActivity;
import com.bw.mall.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomePageActivity extends BaseActivity {

    @BindView(R.id.home_vp)
    ViewPager homeVp;
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
        //设置ViewPager监听事件
        homeVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                //页面滑动
            }

            @Override
            public void onPageSelected(int i) {
                //页面选中
                homeTab.setScrollPosition(i,0,true);
                TabLayout.Tab tabAt = homeTab.getTabAt(i);
                //设置图标 根据选中的i下标
                tabAt.setIcon(tabture[i]);
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                //页面更改
            }
        });
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
                //不知道
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
