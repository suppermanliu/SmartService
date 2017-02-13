package com.hopen.smart.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hopen.smart.R;
import com.hopen.smart.adapter.MainVpFragmentAdapter;
import com.hopen.smart.base.BaseFragment;
import com.hopen.smart.base.LoadNetDataInterface;
import com.hopen.smart.fragment.GovFragment;
import com.hopen.smart.fragment.HomeFragment;
import com.hopen.smart.fragment.NewsFragment;
import com.hopen.smart.fragment.SettingFragment;
import com.hopen.smart.fragment.SmartFragment;
import com.hopen.smart.view.NoScrollViewPager;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.main_vp)
    NoScrollViewPager mainVp;
    @BindView(R.id.group)
    RadioGroup group;

    public List<Fragment> list;
    @BindView(R.id.home)
    RadioButton home;
    @BindView(R.id.news)
    RadioButton news;
    @BindView(R.id.smart)
    RadioButton smart;
    @BindView(R.id.gov)
    RadioButton gov;
    @BindView(R.id.setting)
    RadioButton setting;
    public SlidingMenu slidingMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initViewPager();
        group.setOnCheckedChangeListener(this);
        mainVp.addOnPageChangeListener(this);
        initSlidingMenu();
    }

    private void initSlidingMenu() {
        slidingMenu = new SlidingMenu(this);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        slidingMenu.setBehindOffset(230);
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        slidingMenu.setMenu(R.layout.activity_main_sliding);
    }

    private void initViewPager() {
        list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new NewsFragment());
        list.add(new SmartFragment());
        list.add(new GovFragment());
        list.add(new SettingFragment());

        if (list != null) {
            mainVp.setAdapter(new MainVpFragmentAdapter(getSupportFragmentManager(), list));
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int item =0;
        switch (checkedId) {
            case R.id.home:
                item = 0;
                slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
                break;
            case R.id.news:
                item = 0;
                slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
                break;
            case R.id.smart:
                item = 0;
                slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
                break;
            case R.id.gov:
                item = 0;
                slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
                break;
            case R.id.setting:
                item = 0;
                slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
                break;
            default:
                break;
        }
        mainVp.setCurrentItem(item,false);
        BaseFragment  fragment = (BaseFragment) list.get(item);
        if (fragment instanceof LoadNetDataInterface) {
            ((LoadNetDataInterface) fragment).loadNetData();
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                home.setChecked(true);
                break;
            case 1:
                news.setChecked(true);
                break;
            case 2:
                smart.setChecked(true);
                break;
            case 3:
                gov.setChecked(true);
                break;
            case 4:
                setting.setChecked(true);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
