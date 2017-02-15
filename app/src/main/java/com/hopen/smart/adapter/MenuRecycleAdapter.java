package com.hopen.smart.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hopen.smart.R;
import com.hopen.smart.activity.MainActivity;
import com.hopen.smart.bean.NewsCenterBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/16.
 */

public class MenuRecycleAdapter extends RecyclerView.Adapter<MenuRecycleAdapter.ViewHolder> {

    public Context context;
    public ArrayList<NewsCenterBean.DataBean> data;
    public int selectedPosion;

    public void setData(ArrayList<NewsCenterBean.DataBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public MenuRecycleAdapter(Context context, ArrayList<NewsCenterBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        View MenuView;
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            MenuView = itemView;
            title = (TextView) itemView.findViewById(R.id.menu_title);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.menu_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.title.setText(data.get(position).title);
        if (selectedPosion == position) {
            holder.title.setEnabled(true);
        } else {
            holder.title.setEnabled(false);
        }
        holder.MenuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPosion!=position) {
                    selectedPosion=position;
                    notifyDataSetChanged();
                    ((MainActivity)context).getMainTabFragment().setTitle(data.get(position).title);
                    ((MainActivity)context).slidingMenu.toggle();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }
}
