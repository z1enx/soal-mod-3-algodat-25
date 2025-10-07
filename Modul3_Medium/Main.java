package Modul3_Medium;

public class Main {
    public static void main(String[] args) {
        // Buat list data pasien dan langsung tambahkan pasien
        ListPasien daftar_pasien_1 = new ListPasien();
        daftar_pasien_1.addPasien(new Pasien(1, "Daniel Carter", 20, 110, 75));
        daftar_pasien_1.addPasien(new Pasien(2, "Alicia Morgan", 45, 135, 85));
        daftar_pasien_1.addPasien(new Pasien(3, "Ryan Mitchell", 33, 125, 80));
        daftar_pasien_1.addPasien(new Pasien(4, "Natalie Brooks", 55, 145, 95));
        daftar_pasien_1.addPasien(new Pasien(5, "Brandon Cooper", 28, 118, 78));
        daftar_pasien_1.addPasien(new Pasien(6, "Laura Henderson", 60, 160, 100));
        
        ListPasien daftar_pasien_2 = new ListPasien();
        daftar_pasien_2.addPasien(new Pasien(1, "Ethan Sullivan", 37, 128, 82));
        daftar_pasien_2.addPasien(new Pasien(2, "Chloe Ramirez", 50, 142, 94));
        daftar_pasien_2.addPasien(new Pasien(3, "Marcus Lee", 29, 117, 76));
        daftar_pasien_2.addPasien(new Pasien(4, "Sophie Turner", 61, 155, 98));
        
        ListPasien daftar_pasien_3 = new ListPasien();
        daftar_pasien_3.addPasien(new Pasien(1, "Benjamin Foster", 42, 132, 88));
        daftar_pasien_3.addPasien(new Pasien(2, "Hannah Price", 34, 120, 79));
        daftar_pasien_3.addPasien(new Pasien(3, "William Scott", 58, 150, 92));

        // Buat list data dokter
        ListDokter daftar_dokter = new ListDokter();
        daftar_dokter.addDokter(new Dokter(1, "Dr. Michael Harris", "Kardiologi", 12, daftar_pasien_1));
        daftar_dokter.addDokter(new Dokter(2, "Dr. Emily Parker", "Neurologi", 15, daftar_pasien_2));
        daftar_dokter.addDokter(new Dokter(3, "Dr. Jonathan Reed", "Ortopedi", 20, daftar_pasien_3));

        System.out.println("===============================================================");
        System.out.println("            SISTEM MANAJEMEN RUMAH SAKIT");
        System.out.println("      Analisis Kinerja Algoritma Sorting & Searching");
        System.out.println("===============================================================");
        System.out.println();

        // Menampilkan Daftar Dokter
        System.out.println("Rumah sakit memiliki beberapa dokter dengan spesialisasi berbeda.");
        System.out.println("Berikut adalah daftar dokter yang tersedia:\n");
        daftar_dokter.display();
        System.out.println();

        // Menampilkan Data Awal
        System.out.println("Berikut adalah data lengkap dokter beserta daftar pasien mereka:\n");
        daftar_dokter.displayDokterDanPasien();

        // ===== SKENARIO 1: Bubble Sort - Mengurutkan berdasarkan Sistolik =====
        System.out.println("===============================================================");
        System.out.println("  SKENARIO 1: Mengurutkan Pasien Berdasarkan Tekanan Sistolik");
        System.out.println("===============================================================\n");
        
        System.out.println("Dr. Michael Harris (Kardiologi) ingin melihat pasien-pasiennya");
        System.out.println("yang diurutkan berdasarkan tekanan darah SISTOLIK untuk");
        System.out.println("menentukan prioritas penanganan.\n");
        
        System.out.println("Data pasien Dr. Michael Harris saat ini:");
        System.out.println("---------------------------------------------------------------");
        daftar_pasien_1.displayPasien();
        System.out.println();
        
        System.out.println("Mengurutkan pasien dari tekanan sistolik TERENDAH ke TERTINGGI");
        System.out.println("menggunakan algoritma Bubble Sort...\n");
        daftar_dokter.bubbleSortPasienBySistolik("Dr. Michael Harris", "asc");
        System.out.println();
        
        System.out.println("Hasil setelah diurutkan (Ascending):");
        System.out.println("---------------------------------------------------------------");
        daftar_pasien_1.displayPasien();
        System.out.println();
        
        System.out.println("Kemudian, Dr. Michael Harris ingin melihat urutan sebaliknya,");
        System.out.println("dari tekanan sistolik TERTINGGI ke TERENDAH...\n");
        daftar_dokter.bubbleSortPasienBySistolik("Dr. Michael Harris", "desc");
        System.out.println();
        
        System.out.println("Hasil setelah diurutkan (Descending):");
        System.out.println("---------------------------------------------------------------");
        daftar_pasien_1.displayPasien();
        System.out.println();

        // ===== SKENARIO 2: Insertion Sort - Mengurutkan berdasarkan Nama =====
        System.out.println("===============================================================");
        System.out.println("  SKENARIO 2: Mengurutkan Pasien Berdasarkan Nama (Alfabetis)");
        System.out.println("===============================================================\n");
        
        System.out.println("Dr. Emily Parker (Neurologi) perlu membuat laporan pasien");
        System.out.println("yang diurutkan secara alfabetis untuk memudahkan pencatatan");
        System.out.println("dan administrasi.\n");
        
        System.out.println("Data pasien Dr. Emily Parker saat ini:");
        System.out.println("---------------------------------------------------------------");
        daftar_pasien_2.displayPasien();
        System.out.println();
        
        System.out.println("Mengurutkan pasien dari A-Z menggunakan algoritma");
        System.out.println("Insertion Sort...\n");
        daftar_dokter.insertionSortPasienByNama("Dr. Emily Parker", "asc");
        System.out.println();
        
        System.out.println("Hasil setelah diurutkan (A-Z):");
        System.out.println("---------------------------------------------------------------");
        daftar_pasien_2.displayPasien();
        System.out.println();
        
        System.out.println("Dr. Emily Parker juga ingin melihat urutan sebaliknya (Z-A)...\n");
        daftar_dokter.insertionSortPasienByNama("Dr. Emily Parker", "desc");
        System.out.println();
        
        System.out.println("Hasil setelah diurutkan (Z-A):");
        System.out.println("---------------------------------------------------------------");
        daftar_pasien_2.displayPasien();
        System.out.println();

        // ===== SKENARIO 3: Linear Search - Mencari pasien berdasarkan nama =====
        System.out.println("===============================================================");
        System.out.println("  SKENARIO 3: Mencari Pasien Berdasarkan Nama");
        System.out.println("===============================================================\n");
        
        System.out.println("Dr. Jonathan Reed (Ortopedi) perlu mencari data pasien");
        System.out.println("tertentu dengan cepat untuk konsultasi.\n");
        
        System.out.println("Data pasien Dr. Jonathan Reed:");
        System.out.println("---------------------------------------------------------------");
        daftar_pasien_3.displayPasien();
        System.out.println();
        
        System.out.println("Mencari pasien bernama 'Hannah Price' menggunakan");
        System.out.println("algoritma Linear Search...\n");
        daftar_dokter.linearSearchPasien("Dr. Jonathan Reed", "Hannah Price");
        System.out.println();
        
        System.out.println("---------------------------------------------------------------");
        System.out.println("Mencari pasien bernama 'William Scott'...\n");
        daftar_dokter.linearSearchPasien("Dr. Jonathan Reed", "William Scott");
        System.out.println();
        
        System.out.println("---------------------------------------------------------------");
        System.out.println("Mencari pasien bernama 'John Doe' (tidak terdaftar)...\n");
        daftar_dokter.linearSearchPasien("Dr. Jonathan Reed", "John Doe");
        System.out.println();

        // ===== SKENARIO 4: Binary Search - Mencari pasien berdasarkan umur =====
        System.out.println("===============================================================");
        System.out.println("  SKENARIO 4: Mencari Pasien Berdasarkan Umur");
        System.out.println("===============================================================\n");
        
        System.out.println("Dr. Michael Harris ingin mencari pasien berdasarkan kategori");
        System.out.println("umur tertentu untuk penelitian medis.\n");
        
        System.out.println("Mencari pasien berusia 45 tahun menggunakan algoritma");
        System.out.println("Binary Search (data akan diurutkan terlebih dahulu)...\n");
        daftar_dokter.binarySearchPasienByUmur("Dr. Michael Harris", 45);
        System.out.println();
        
        System.out.println("---------------------------------------------------------------");
        System.out.println("Data pasien setelah diurutkan berdasarkan umur:");
        System.out.println("---------------------------------------------------------------");
        daftar_pasien_1.displayPasien();
        System.out.println();
        
        System.out.println("Mencari pasien berusia 28 tahun...\n");
        daftar_dokter.binarySearchPasienByUmur("Dr. Michael Harris", 28);
        System.out.println();
        
        System.out.println("---------------------------------------------------------------");
        System.out.println("Mencari pasien berusia 99 tahun (tidak ada)...\n");
        daftar_dokter.binarySearchPasienByUmur("Dr. Michael Harris", 99);
        System.out.println();
    }
}