package Modul3_Medium;

public class Dokter {
    int id_dokter;
    String nama_dokter = null;
    String spesialis = null;
    int pengalaman = 0;
    ListPasien pasien = null;
    Dokter next = null;
    Dokter prev = null;

    Dokter(int id_dokter, String nama_dokter, String spesialis, int pengalaman, ListPasien pasien){
        this.id_dokter = id_dokter;
        this.nama_dokter = nama_dokter;
        this.spesialis = spesialis;
        this.pengalaman = pengalaman;
        this.pasien = pasien;
    }
}
