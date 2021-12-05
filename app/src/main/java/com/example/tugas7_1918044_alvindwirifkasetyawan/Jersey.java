package com.example.tugas7_1918044_alvindwirifkasetyawan;

public class Jersey {
    private String _id, _nama, _ukuran;
    public Jersey (String id, String nama, String ukuran) {
        this._id = id;
        this._nama = nama;
        this._ukuran = ukuran;
    }
    public Jersey() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_ukuran() {
        return _ukuran;
    }
    public void set_ukuran(String _ukuran) {
        this._ukuran = _ukuran;
    }
}
