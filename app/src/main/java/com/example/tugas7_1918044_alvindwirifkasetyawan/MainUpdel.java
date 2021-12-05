package com.example.tugas7_1918044_alvindwirifkasetyawan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Sukuran;
    private EditText Enama, Eukuran;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sukuran = i.getStringExtra("Iukuran");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Eukuran = (EditText) findViewById(R.id.updel_ukuran);
        Enama.setText(Snama);
        Eukuran.setText(Sukuran);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sukuran = String.valueOf(Eukuran.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sukuran.equals("")){
                    Eukuran.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi ukuran",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateJersey(new Jersey(Sid, Snama, Sukuran));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteJersey(new Jersey(Sid, Snama, Sukuran));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
