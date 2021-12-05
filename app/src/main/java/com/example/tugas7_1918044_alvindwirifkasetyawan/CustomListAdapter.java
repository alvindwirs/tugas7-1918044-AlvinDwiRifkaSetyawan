package com.example.tugas7_1918044_alvindwirifkasetyawan;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Jersey> Jersey;
    public CustomListAdapter(Activity activity, List<Jersey>
            Jersey) {
        this.activity = activity;
        this.Jersey = Jersey;
    }
    @Override
    public int getCount() {
        return Jersey.size();
    }
    @Override
    public Object getItem(int location) {
        return Jersey.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView nama = (TextView)
                convertView.findViewById(R.id.text_nama);
        TextView ukuran = (TextView)
                convertView.findViewById(R.id.text_ukuran);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Jersey m = Jersey.get(position);
        nama.setText("Nama : "+ m.get_nama());
        ukuran.setText("Ukuran : "+ m.get_ukuran());
        return convertView;
    }
}
