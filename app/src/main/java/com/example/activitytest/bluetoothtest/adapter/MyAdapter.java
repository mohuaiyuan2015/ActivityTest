package com.example.activitytest.bluetoothtest.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.activitytest.R;
import com.example.activitytest.bluetoothtest.bean.MDevice;

import java.util.List;

/**
 * Created by mohuaiyuan on 2017/7/23.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<MDevice> list;

    public MyAdapter(Context context,List<MDevice>list){
        this.context=context;
        this.list=list;

    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View  bluetoothView;
        TextView tvDevName;
        TextView tvDevSignal;
        TextView tvDevMac;

        public ViewHolder(final View view) {
            super(view);
            bluetoothView=view;
            tvDevName= (TextView) view.findViewById(R.id.tv_dev_name);
            tvDevSignal= (TextView) view.findViewById(R.id.tv_dev_signal);
            tvDevMac= (TextView) view.findViewById(R.id.tv_dev_mac);
        }
    }


    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_device,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.bluetoothView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {

        MDevice mDevice=list.get(position);
        holder.tvDevName.setText(mDevice.getDevice().getName());
        holder.tvDevSignal.setText(mDevice.getRssi()+"dBm");
        holder.tvDevMac.setText(mDevice.getDevice().getAddress());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
