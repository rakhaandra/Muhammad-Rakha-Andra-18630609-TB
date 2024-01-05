/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package raka.appkepegawaian.entity;

/**
 *
 * @author rakha
 */
public class Pegawai {

    private String kode_pegawai;
    private String nama;
    private String tempattanggallahir;
    private String alamat;
    private String tahunmasuk;
    private String notelpon;


    //class buku
    public Pegawai() {
    }

    public Pegawai(String kode_pegawai, String nama, String tempattanggallahir, String alamat, String tahunmasuk, String notelpon) {
        this.kode_pegawai = kode_pegawai;
        this.nama = nama;
        this.tempattanggallahir = tempattanggallahir;
        this.alamat = alamat;
        this.tahunmasuk = tahunmasuk;
        this.notelpon = notelpon;
    }


    public String getKode() {
        return kode_pegawai;
    }

    public void setKode(String kode_pegawai) {
        this.kode_pegawai = kode_pegawai;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempat() {
        return tempattanggallahir;
    }

    public void setTempat(String tempattanggallahir) {
        this.tempattanggallahir = tempattanggallahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTahun() {
        return tahunmasuk;
    }

    public void setTahun(String tahunmasuk) {
        this.tahunmasuk = tahunmasuk;
    }

    public String getNotelpon() {
        return notelpon;
    }

    public void setNotelpon(String notelpon) {
        this.notelpon = notelpon;
    }
}
