package com.applicationframwork.android.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.applicationframwork.android.R;

import java.util.ArrayList;

/**
 * Created by gauravkumar.singh on 7/21/2016.
 */
public class MenuAdapter extends BaseAdapter {

    private Context context;
    ArrayList<String> menuArrayList;
    Integer[] imageIDs = { R.drawable.images, R.drawable.images1, R.drawable.images2,
            R.drawable.images3, R.drawable.images4, R.drawable.images5, R.drawable.images7,
            R.drawable.images, R.drawable.images1, R.drawable.images2,R.drawable.images4
    };

    public MenuAdapter(Context context,ArrayList<String> menuList) {
        this.context = context;
        this.menuArrayList = menuList;

    }

    @Override
    public int getCount() {
        return menuArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.menu_adapter_view, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.menuTextView.setText(menuArrayList.get(position));
        viewHolder.menuImgView.setImageResource(imageIDs[position]);

        return convertView;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView menuTextView;
        public ImageView menuImgView;

        public ViewHolder(View v) {
            super(v);
            menuTextView = (TextView) v.findViewById(R.id.txt_menu);
            menuImgView = (ImageView) v.findViewById(R.id.img_menu);

        }

    }
}
