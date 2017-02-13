package com.hopen.smart.fragment;

import android.view.View;

import com.hopen.smart.base.BaseFragment;
import com.hopen.smart.base.LoadNetDataInterface;

/**
 * Created by Administrator on 2017/2/13.
 */

public class SmartFragment extends BaseFragment implements LoadNetDataInterface{

    @Override
    public void initTitle() {
        setDisplayPic(false);
        setDisplayMenu(true);
        setTitle("智慧服务");
    }

    @Override
    public View initView() {
        return null;
    }

    @Override
    public void loadNetData() {

    }
}
