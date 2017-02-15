package com.hopen.smart.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/15.
 */

public class NewsCenterBean {

    public ArrayList<DataBean> data;
    public ArrayList<Integer> extend;
    public int retcode;

    public class DataBean{
        public ArrayList<ChildrenBean> children;
        public int id;
        public int type;
        public String title;
        public String url;
        public String url1;
    }

    public class ChildrenBean{
        public int id;
        public int type;
        public String title;
        public String url;

    }
}
