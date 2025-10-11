package Modul3_Medium;

public class Main {
    public static void main(String[] args) {
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
        daftar_pasien_2.addPasien(new Pasien(5, "Liam Anderson", 46, 138, 90));
        daftar_pasien_2.addPasien(new Pasien(6, "Isabella Moore", 33, 125, 83));

        ListPasien daftar_pasien_3 = new ListPasien();
        daftar_pasien_3.addPasien(new Pasien(1, "Benjamin Foster", 42, 132, 88));
        daftar_pasien_3.addPasien(new Pasien(2, "Hannah Price", 34, 120, 79));
        daftar_pasien_3.addPasien(new Pasien(3, "William Scott", 58, 150, 92));
        daftar_pasien_3.addPasien(new Pasien(4, "Ava Collins", 41, 134, 88));
        daftar_pasien_3.addPasien(new Pasien(5, "Henry Walton", 63, 159, 101));
        daftar_pasien_3.addPasien(new Pasien(6, "Mia Thompson", 27, 115, 75));

        ListDokter daftar_dokter = new ListDokter();
        daftar_dokter.addDokter(new Dokter(1, "Dr. Michael Harris", "Kardiologi", 12, daftar_pasien_1));
        daftar_dokter.addDokter(new Dokter(2, "Dr. Emily Parker", "Neurologi", 15, daftar_pasien_2));
        daftar_dokter.addDokter(new Dokter(3, "Dr. Jonathan Reed", "Ortopedi", 20, daftar_pasien_3));

        System.out.println("======  Menampilkan seluruh data dokter dan pasien  ======");
        daftar_dokter.displayDokterDanPasien();

        System.out.println("===================================================================================");
        System.out.println(" Mengurutkan pasien dari Dr. Michael Harris berdasarkan Nama dengan Selection Sort ");
        System.out.println("===================================================================================");
        System.out.println();

        long startTime = System.nanoTime();
        daftar_dokter.selectionSortPasienByNama("Dr. Michael Harris");
        long endTime = System.nanoTime();
        daftar_dokter.displayPasien("Dr. Michael Harris");
        double waktu = (double) (endTime - startTime) / 1000000000.0;
        System.out.printf("Waktu eksekusi: %.8f detik\n", waktu);
        System.out.println();

        System.out.println("=================================================================================");
        System.out.println(" Mengurutkan pasien dari Dr. Emily Parker berdasarkan nama dengan Insertion Sort ");
        System.out.println("=================================================================================");
        System.out.println();
        startTime = System.nanoTime();
        daftar_dokter.insertionSortPasienByNama("Dr. Emily Parker");
        endTime = System.nanoTime();
        daftar_dokter.displayPasien("Dr. Emily Parker");
        waktu = (double) (endTime - startTime) / 1000000000.0;
        System.out.printf("Waktu eksekusi: %.8f detik\n", waktu);
        System.out.println();

        System.out.println(
                "==============================================================================================");
        System.out.println(
                " Mengurutkan pasien dari Dr. Jonathan Reed berdasarkan tekanan sistolik dengan Selection Sort ");
        System.out.println(
                "==============================================================================================");
        startTime = System.nanoTime();
        daftar_dokter.selectionSortPasienBySistolik("Dr. Jonathan Reed");
        endTime = System.nanoTime();
        daftar_dokter.displayPasien("Dr. Jonathan Reed");
        waktu = (double) (endTime - startTime) / 1000000000.0;
        System.out.printf("Waktu eksekusi: %.8f detik\n", waktu);
        System.out.println();

        System.out.println(
                "===============================================================================================");
        System.out.println(
                " Mengurutkan pasien dari Dr. Michael Harris berdasarkan tekanan sistolik dengan Insertion Sort ");
        System.out.println(
                "===============================================================================================");
        System.out.println();
        startTime = System.nanoTime();
        daftar_dokter.insertionSortPasienBySistolik("Dr. Michael Harris");
        endTime = System.nanoTime();
        daftar_dokter.displayPasien("Dr. Michael Harris");
        waktu = (double)(endTime - startTime) / 1000000000.0;
        System.out.printf("Waktu eksekusi: %.8f detik\n", waktu);
        System.out.println();

        System.out.println("==============================================================================");
        System.out.println(" Mencari pasien dari Dr. Michael Harris berdasarkan umur dengan Linear Search ");
        System.out.println("==============================================================================");
        System.out.println();
        System.out.println("Mencari pasien berumur 45 tahun dengan Linear Search");
        startTime = System.nanoTime();
        daftar_dokter.linearSearchPasienByUmur("Dr. Michael Harris", 45);
        endTime = System.nanoTime();
        waktu = (double) (endTime - startTime) / 1000000000.0;
        System.out.printf("Waktu eksekusi: %.8f detik\n", waktu);
        System.out.println();

        System.out.println("============================================================================");
        System.out.println(" Mencari pasien dari Dr. Emily Parker berdasarkan umur dengan Binary Search ");
        System.out.println("============================================================================");
        System.out.println();
        System.out.println("Mencari pasien berumur 61 tahun dengan Binary Search");
        startTime = System.nanoTime();
        daftar_dokter.binarySearchPasienByUmur("Dr. Emily Parker", 61);
        endTime = System.nanoTime();
        waktu = (double) (endTime - startTime) / 1000000000.0;
        System.out.printf("Waktu eksekusi: %.8f detik\n", waktu);
        System.out.println();

        System.out.println("=============================================================================");
        System.out.println(" Mencari pasien dari Dr. Jonathan Reed berdasarkan nama dengan Linear Search ");
        System.out.println("=============================================================================");

        System.out.println("Mencari pasien 'Chloe Ramirez' dengan Linear Search");
        startTime = System.nanoTime();
        daftar_dokter.linearSearchPasienByNama("Dr. Jonathan Reed", "Ava Collins");
        endTime = System.nanoTime();
        waktu = (double) (endTime - startTime) / 1000000000.0;
        System.out.printf("Waktu eksekusi: %.8f detik\n", waktu);
        System.out.println();

        System.out.println("==============================================================================");
        System.out.println(" Mencari pasien dari Dr. Michael Harris berdasarkan nama dengan Binary Search ");
        System.out.println("==============================================================================");
        System.out.println("Mencari pasien 'Brandon Cooper' dengan Binary Search");
        startTime = System.nanoTime();
        daftar_dokter.binarySearchPasienByNama("Dr. Michael Harris", "Brandon Cooper");
        endTime = System.nanoTime();
        waktu = (double) (endTime - startTime) / 1000000000.0;
        System.out.printf("Waktu eksekusi: %.8f detik\n", waktu);
        System.out.println();
    }
}