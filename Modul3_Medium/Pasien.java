package Modul3_Medium;

public class Pasien {
    int id_pasien;
    String nama_pasien;
    int umur;
    int sistolik;
    int diastolik;
    Pasien next = null;
    Pasien prev = null;

    Pasien(int id_pasien, String nama_pasien, int umur, int sistolik, int diastolik){
        this.id_pasien = id_pasien;
        this.nama_pasien = nama_pasien; 
        this.umur = umur;
        this.sistolik = sistolik;
        this.diastolik = diastolik;
    }
}
