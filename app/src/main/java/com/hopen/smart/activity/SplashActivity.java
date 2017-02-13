package com.hopen.smart.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.hopen.smart.R;
import com.hopen.smart.utils.SPUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends Activity implements Animation.AnimationListener {

    @BindView(R.id.rl_splash)
    RelativeLayout rlSplash;

    public Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        //创建动画合集
        Animation animation = createAnimation();
        //开启动画
        rlSplash.startAnimation(animation);

        //为动画添加监听
        animation.setAnimationListener(this);
    }

    public Animation createAnimation() {
        AnimationSet set = new AnimationSet(false);

        //旋转
        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(2000);
        rotate.setFillAfter(true);

        //缩放
        ScaleAnimation scale = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(2000);
        scale.setFillAfter(true);

        //渐变
        AlphaAnimation alpha = new AlphaAnimation(0, 1);
        alpha.setDuration(1000);
        alpha.setFillAfter(true);

        set.addAnimation(rotate);
        set.addAnimation(scale);
        set.addAnimation(alpha);
        return set;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        handler.postDelayed(new Task(),2000);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    class Task implements Runnable{
        @Override
        public void run() {
            boolean isGuideShow = SPUtils.getBoolean(SplashActivity.this, "isGuideShow", false);
            if (isGuideShow) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            } else {
                startActivity(new Intent(SplashActivity.this, GuideActivity.class));
            }
            finish();
        }
    }
}
