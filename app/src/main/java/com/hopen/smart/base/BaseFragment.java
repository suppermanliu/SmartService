package com.hopen.smart.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hopen.smart.R;
import com.hopen.smart.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/2/14.
 */

public abstract class BaseFragment extends Fragment {

    @BindView(R.id.menu)
    ImageButton menu;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.change)
    ImageButton change;
    @BindView(R.id.container)
    FrameLayout container;

    public Context context;

    public BaseFragment() {
        context = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.base_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initTitle();
    }

    //初始化标题栏
    public abstract void initTitle();
    //设置标题栏文字
    public void setTitle(String text){
        title.setText(text);
    }
    //设置是否显示标题栏左侧菜单按钮
    public void setDisplayMenu(boolean isShow){
        menu.setVisibility(isShow? View.VISIBLE: View.INVISIBLE);
    }
    //设置是否显示标题栏右侧按钮
    public void setDisplayPic(boolean isShow){
        change.setVisibility(isShow? View.VISIBLE: View.INVISIBLE);
    }

    //初始化布局
    public abstract View initView();
    //为容器添加内容
    public void addView(View view){
        container.removeAllViews();
        container.addView(view);
    }

    @OnClick(R.id.menu)
    public void onClick() {
        MainActivity mActivity = (MainActivity) getActivity();
        mActivity.slidingMenu.toggle();
    }
}
