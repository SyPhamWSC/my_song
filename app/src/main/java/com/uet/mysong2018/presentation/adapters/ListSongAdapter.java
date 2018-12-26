package com.uet.mysong2018.presentation.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.uet.mysong2018.R;
import com.uet.mysong2018.common.Utils;
import com.uet.mysong2018.domain.model.ItemSongModel;

import java.util.ArrayList;
import java.util.List;

public class ListSongAdapter extends BaseAdapter {

    private List<ItemSongModel> datas = new ArrayList<>();
    private Context context;

    public ListSongAdapter(List<ItemSongModel> list, Context context) {
        this.datas = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_view, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvNameSong = convertView.findViewById(R.id.tv_name_song);
            viewHolder.tvNameSinger = convertView.findViewById(R.id.tv_name_singer);
            viewHolder.tvTimer = convertView.findViewById(R.id.tv_timer);
            viewHolder.imageView = convertView.findViewById(R.id.iv_song);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (!datas.isEmpty()) {
            ItemSongModel item = datas.get(position);
            viewHolder.tvNameSong.setText(item.getNameSong());
            viewHolder.tvNameSinger.setText(item.getNameSinger());
            viewHolder.tvTimer.setText(item.getTime());

            Drawable drawable = Utils.getInstance().getDrawableByName(item.getNameImage());
            viewHolder.imageView.setImageDrawable(drawable);
        }

        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView tvNameSong, tvNameSinger, tvTimer;
    }
}
