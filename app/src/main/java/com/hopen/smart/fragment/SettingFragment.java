package com.hopen.smart.fragment;

import android.view.View;

import com.hopen.smart.base.BaseFragment;

/**
 * Created by Administrator on 2017/2/13.
 */

public class SettingFragment extends BaseFragment {

    @Override
    public void initTitle() {
        setDisplayMenu(false);
        setDisplayPic(false);
        setTitle("设置");
    }

    @Override
    public View initView() {
        return null;
    }
}
