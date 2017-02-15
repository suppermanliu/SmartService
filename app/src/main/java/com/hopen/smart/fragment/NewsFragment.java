package com.hopen.smart.fragment;

import android.view.View;

import com.google.gson.Gson;
import com.hopen.smart.activity.MainActivity;
import com.hopen.smart.base.BaseFragment;
import com.hopen.smart.base.LoadNetDataInterface;
import com.hopen.smart.bean.NewsCenterBean;
import com.hopen.smart.utils.Contants;
import com.hopen.smart.utils.MyLogger;
import com.hopen.smart.utils.MyToast;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Administrator on 2017/2/13.
 */

public class NewsFragment extends BaseFragment implements LoadNetDataInterface {

    private static final String TAG = "NewsFragment";

    @Override
    public void initTitle() {
        setDisplayMenu(true);
        setDisplayPic(false);
        setTitle("新闻中心");
    }

    @Override
    public View initView() {
        return null;
    }

    @Override
    public void loadNetData() {
        OkHttpUtils
                .get()
                .url(Contants.NEWS_CATEGORY)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        MyLogger.i(TAG, e.getMessage());
                        MyToast.show(context, "获取数据失败");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        MyLogger.i(TAG, response);
                        parseJson(response);
                    }
                });
    }

    private void parseJson(String response) {
        Gson gson = new Gson();
        NewsCenterBean newsCenterBean = gson.fromJson(response, NewsCenterBean.class);
        if (newsCenterBean != null) {
            ((MainActivity) getActivity()).getDataFromNews(newsCenterBean.data);
        }
    }
}
