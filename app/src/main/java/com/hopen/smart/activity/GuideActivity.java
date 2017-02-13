package com.hopen.smart.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.hopen.smart.R;
import com.hopen.smart.adapter.GuideAdapter;
import com.hopen.smart.utils.MyLogger;
import com.hopen.smart.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/2/13.
 */
public class GuideActivity extends Activity implements ViewPager.OnPageChangeListener {

    private static final String TAG = "GuideActivity";
    @BindView(R.id.guide_vp)
    ViewPager guideVp;
    @BindView(R.id.bt_start)
    Button btStart;
    @BindView(R.id.ll_container)
    LinearLayout container;
    @BindView(R.id.red_point)
    ImageView redPoint;

    public int[] mImages = new int[]{R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};
    private List<ImageView> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        //隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initViewPager();
    }

    private void initViewPager() {
        list = new ArrayList<>();
        for (int i=0;i<mImages.length;i++) {
            ImageView view = new ImageView(this);
            view.setBackgroundResource(mImages[i]);
            list.add(view);

            ImageView gray = new ImageView(this);
            gray.setImageResource(R.drawable.gray_point);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            if (i>0) {
                params.leftMargin = 20;
            }
            gray.setLayoutParams(params);
            container.addView(gray);
        }
        if (list != null) {
            guideVp.setAdapter(new GuideAdapter(list));
        }

        //为viewpager添加滑动事件
        guideVp.addOnPageChangeListener(this);
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SPUtils.saveBoolean(GuideActivity.this,"isGuideShow",true);
                Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        MyLogger.i(TAG,"页面滑动比例："+positionOffset);
        int width = container.getChildAt(1).getLeft()-container.getChildAt(0).getLeft();
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) redPoint.getLayoutParams();
        int distance = (int) (position*width+positionOffset*width);
        params.leftMargin = distance;
        redPoint.setLayoutParams(params);
    }

    @Override
    public void onPageSelected(int position) {
        if (position == mImages.length - 1) {
            btStart.setVisibility(View.VISIBLE);
        } else {
            btStart.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
