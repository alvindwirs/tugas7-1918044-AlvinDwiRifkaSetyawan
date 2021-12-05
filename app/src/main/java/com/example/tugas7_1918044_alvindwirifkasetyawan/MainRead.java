package com.example.tugas7_1918044_alvindwirifkasetyawan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Jersey> ListJersey = new ArrayList<Jersey>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListJersey
        );
        mListView = (ListView) findViewById(R.id.list_jersey);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListJersey.clear();
        List<Jersey> Jersey = db.ReadJersey();
        for (Jersey jrs : Jersey) {
            Jersey daftar = new Jersey();
            daftar.set_id(jrs.get_id());
            daftar.set_nama(jrs.get_nama());
            daftar.set_ukuran(jrs.get_ukuran());
            ListJersey.add(daftar);
            if ((ListJersey.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int
            i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Jersey detailMhs = (Jersey) o;
        String Sid = detailMhs.get_id();
        String Snama = detailMhs.get_nama();
        String Sukuran = detailMhs.get_ukuran();
        Intent goUpdel = new Intent(MainRead.this,
                MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Iukuran", Sukuran);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListJersey.clear();
        mListView.setAdapter(adapter_off);

        List<Jersey> Jersey = db.ReadJersey();
        for (Jersey jrs : Jersey) {
            Jersey daftar = new Jersey();
            daftar.set_id(jrs.get_id());
            daftar.set_nama(jrs.get_nama());
            daftar.set_ukuran(jrs.get_ukuran());
            ListJersey.add(daftar);
            if ((ListJersey.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
