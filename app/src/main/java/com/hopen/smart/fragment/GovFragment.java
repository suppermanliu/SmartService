package com.hopen.smart.fragment;

import android.view.View;

import com.hopen.smart.base.BaseFragment;
import com.hopen.smart.base.LoadNetDataInterface;

/**
 * Created by Administrator on 2017/2/13.
 */

public class GovFragment extends BaseFragment implements LoadNetDataInterface{

    @Override
    public void initTitle() {
        setDisplayMenu(true);
        setDisplayPic(false);
        setTitle("政务");
    }

    @Override
    public View initView() {
        return null;
    }

    @Override
    public void loadNetData() {

    }
}
