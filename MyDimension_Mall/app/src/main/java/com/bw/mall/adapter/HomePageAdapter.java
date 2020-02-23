package com.bw.mall.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bw.mall.fragment.CircleFragment;
import com.bw.mall.fragment.HomeFragment;
import com.bw.mall.fragment.ListFragment;
import com.bw.mall.fragment.MyFragment;
import com.bw.mall.fragment.ShoppingFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MyDimension_Mall
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/23 16:41
 * @Description: 用途：完成特定功能
 */
public class HomePageAdapter extends FragmentPagerAdapter {
    private List<Fragment> list = new ArrayList<>();
    public HomePageAdapter(FragmentManager fm) {
        super(fm);
        list.add(new HomeFragment());
        list.add(new CircleFragment());
        list.add(new ShoppingFragment());
        list.add(new ListFragment());
        list.add(new MyFragment());
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
