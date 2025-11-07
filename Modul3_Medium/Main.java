package Modul3_Medium;

public class Main {
        public static void main(String[] args) {
                ListPasien daftar_pasien_1 = new ListPasien();
                daftar_pasien_1.addPasien(new Pasien(1, "Daniel Carter", 20, 110, 75));
                daftar_pasien_1.addPasien(new Pasien(2, "Alicia Morgan", 45, 135, 85));
                daftar_pasien_1.addPasien(new Pasien(3, "Ryan Mitchell", 33, 125, 80));
                daftar_pasien_1.addPasien(new Pasien(4, "Natalie Brooks", 55, 145, 95));
                daftar_pasien_1.addPasien(new Pasien(5, "Brandon Cooper", 28, 118, 78));
                daftar_pasien_1.addPasien(new Pasien(6, "Laura Walker", 60, 160, 100));
                daftar_pasien_1.addPasien(new Pasien(7, "Jonathan Reed", 39, 130, 84));
                daftar_pasien_1.addPasien(new Pasien(8, "Emily Parker", 26, 119, 77));
                daftar_pasien_1.addPasien(new Pasien(9, "Christian Hall", 52, 148, 96));
                daftar_pasien_1.addPasien(new Pasien(10, "Victoria Adams", 47, 140, 92));
                daftar_pasien_1.addPasien(new Pasien(11, "Samuel Morris", 31, 123, 81));
                daftar_pasien_1.addPasien(new Pasien(12, "Olivia Turner", 29, 116, 76));
                daftar_pasien_1.addPasien(new Pasien(13, "Andrew Scott", 58, 155, 99));
                daftar_pasien_1.addPasien(new Pasien(14, "Grace Phillips", 42, 133, 87));
                daftar_pasien_1.addPasien(new Pasien(15, "Dylan Hughes", 36, 127, 82));

                ListPasien daftar_pasien_2 = new ListPasien();

                daftar_pasien_2.addPasien(new Pasien(1, "Ethan Sullivan", 37, 128, 82));
                daftar_pasien_2.addPasien(new Pasien(2, "Chloe Ramirez", 50, 142, 94));
                daftar_pasien_2.addPasien(new Pasien(3, "Marcus Turner", 29, 117, 76));
                daftar_pasien_2.addPasien(new Pasien(4, "Sophie Turner", 61, 155, 98));
                daftar_pasien_2.addPasien(new Pasien(5, "Liam Anderson", 46, 138, 90));
                daftar_pasien_2.addPasien(new Pasien(6, "Isabella Moore", 33, 125, 83));
                daftar_pasien_2.addPasien(new Pasien(7, "Jason Bennett", 41, 131, 86));
                daftar_pasien_2.addPasien(new Pasien(8, "Madison Clark", 27, 118, 77));
                daftar_pasien_2.addPasien(new Pasien(9, "George Ramirez", 54, 150, 97));
                daftar_pasien_2.addPasien(new Pasien(10, "Sophia Grant", 44, 139, 91));
                daftar_pasien_2.addPasien(new Pasien(11, "Patrick Carter", 35, 126, 82));
                daftar_pasien_2.addPasien(new Pasien(12, "Abigail Foster", 30, 120, 79));
                daftar_pasien_2.addPasien(new Pasien(13, "Nicholas Hayes", 59, 156, 101));
                daftar_pasien_2.addPasien(new Pasien(14, "Ella Simmons", 43, 134, 88));
                daftar_pasien_2.addPasien(new Pasien(15, "Lucas Griffin", 38, 129, 84));
                            

                ListPasien daftar_pasien_3 = new ListPasien();
                daftar_pasien_3.addPasien(new Pasien(1, "Oliver Foster", 42, 132, 88));
                daftar_pasien_3.addPasien(new Pasien(2, "Hannah Price", 34, 120, 79));
                daftar_pasien_3.addPasien(new Pasien(3, "William Scott", 58, 150, 92));
                daftar_pasien_3.addPasien(new Pasien(4, "Amelia Collins", 41, 134, 88));
                daftar_pasien_3.addPasien(new Pasien(5, "Henry Walton", 63, 159, 101));
                daftar_pasien_3.addPasien(new Pasien(6, "Mia Thompson", 27, 115, 75));
                daftar_pasien_3.addPasien(new Pasien(7, "Joshua Morgan", 39, 129, 83));
                daftar_pasien_3.addPasien(new Pasien(8, "Charlotte Gray", 32, 118, 78));
                daftar_pasien_3.addPasien(new Pasien(9, "Anthony Rivera", 55, 147, 95));
                daftar_pasien_3.addPasien(new Pasien(10, "Natalie Hughes", 46, 136, 89));
                daftar_pasien_3.addPasien(new Pasien(11, "Christian Bell", 30, 122, 81));
                daftar_pasien_3.addPasien(new Pasien(12, "Amelia Barnes", 28, 117, 76));
                daftar_pasien_3.addPasien(new Pasien(13, "Sebastian Gray", 60, 158, 100));
                daftar_pasien_3.addPasien(new Pasien(14, "Lilian Cooper", 40, 133, 87));
                daftar_pasien_3.addPasien(new Pasien(15, "Jackson Perez", 35, 126, 82));

                ListDokter daftar_dokter = new ListDokter();
                daftar_dokter.addDokter(new Dokter(1, "Dr. Michael Harris", "Cardiology", 12, daftar_pasien_1));
                daftar_dokter.addDokter(new Dokter(2, "Dr. Emily Parker", "Neurology", 15, daftar_pasien_2));
                daftar_dokter.addDokter(new Dokter(3, "Dr. Jonathan Reed", "Orthopedics", 20, daftar_pasien_3));


                System.out.println("======  Menampilkan Seluruh Data Dokter dan Pasien  ======");
                daftar_dokter.displayDokterDanPasien();
                long startTime;
                long endTime;
                double waktu;
                                startTime = System.nanoTime();
                daftar_dokter.linearSearchPasienByNama("Dr. Emily Parker", "Patrick Carter");
                endTime = System.nanoTime();
                waktu = (double) (endTime - startTime) / 1000000000.0;
                System.out.printf("Waktu eksekusi: %.8f detik\n", waktu);
                System.out.println();
                


                System.out.println("========================================================================================");
                System.out.println(" Mencari pasien dari Dr. Jonathan Reed yang bernama Sebastian Gray dengan Linear Search ");
                System.out.println("========================================================================================");
                startTime = System.nanoTime();
                daftar_dokter.linearSearchPasienByNama("Dr. Jonathan Reed", "Sebastian Gray");
                endTime = System.nanoTime();
                waktu = (double) (endTime - startTime) / 1000000000.0;
                System.out.printf("Waktu eksekusi: %.8f detik\n", waktu);
                System.out.println();

                System.out.println("===================================================================================");
                System.out.println(" Mencari pasien dari Dr. Michael Harris yang berumur 45 tahun dengan Linear Search ");
                System.out.println("===================================================================================");
                startTime = System.nanoTime();
                 daftar_dokter.linearSearchPasienByUmur("Dr. Michael Harris", 45);
                 endTime = System.nanoTime();
                 waktu = (double) (endTime - startTime) / 1000000000.0;
                System.out.printf("Waktu eksekusi: %.8f detik\n", waktu);
                System.out.println();

                System.out.println(
                                "===================================================================================");
                System.out.println(
                                " Mengurutkan pasien dari Dr. Jonathan Reed berdasarkan Nama dengan Selection Sort ");
                System.out.println(
                                "===================================================================================");
                daftar_dokter.backupPasienData("Dr. Jonathan Reed");//bakcup juga sudah ada di dalam method sort, bebas mau taruh dimana
                startTime = System.nanoTime();
                daftar_dokter.selectionSortPasienByNama("Dr. Jonathan Reed");
                endTime = System.nanoTime();
                daftar_dokter.displayPasien("Dr. Jonathan Reed");
                waktu = (double) (endTime - startTime) / 1000000000.0;
                System.out.printf("Waktu eksekusi: %.8f detik\n", waktu);
                System.out.println();

                System.out.println("=================================================================================");
                System.out.println(" Mengurutkan pasien dari Dr. Jonathan Reed berdasarkan nama dengan Insertion Sort ");
                System.out.println("=================================================================================");
                daftar_dokter.restorePasienData("Dr. Jonathan Reed");//wajib, agar data yg dirurutkan adalah data acak, bukan hasil sort sebelumnya
                startTime = System.nanoTime();
                daftar_dokter.insertionSortPasienByNama("Dr. Jonathan Reed");
                endTime = System.nanoTime();
                daftar_dokter.displayPasien("Dr. Jonathan Reed");
                waktu = (double) (endTime - startTime) / 1000000000.0;
                System.out.printf("Waktu eksekusi: %.8f detik\n", waktu);
                System.out.println();

                System.out.println(
                                "==============================================================================================");
                System.out.println(
                                " Mengurutkan pasien dari Dr. Emily Parker berdasarkan tekanan systolic dengan Selection Sort ");
                System.out.println(
                                "==============================================================================================");
                                daftar_dokter.backupPasienData("Dr. Emily Parker");
                startTime = System.nanoTime();
                daftar_dokter.selectionSortPasienBySistolik("Dr. Emily Parker");
                endTime = System.nanoTime();
                daftar_dokter.displayPasien("Dr. Emily Parker");
                waktu = (double) (endTime - startTime) / 1000000000.0;
                System.out.printf("Waktu eksekusi: %.8f detik\n", waktu);
                System.out.println();

                System.out.println(
                                "===============================================================================================");
                System.out.println(
                                " Mengurutkan pasien dari Dr. Emily Parker berdasarkan tekanan sistolic dengan Insertion Sort ");
                System.out.println(
                                "===============================================================================================");
                                daftar_dokter.restorePasienData("Dr. Emily Parker");
                startTime = System.nanoTime();
                daftar_dokter.insertionSortPasienBySistolik("Dr. Emily Parker");
                endTime = System.nanoTime();
                daftar_dokter.displayPasien("Dr. Emily Parker");
                waktu = (double) (endTime - startTime) / 1000000000.0;
                System.out.printf("Waktu eksekusi: %.8f detik\n", waktu);
                System.out.println();




                System.out.println("========================================================================================");
                System.out.println(" Mencari pasien dari Dr. Jonathan Reed yang bernama Sebastian Gray dengan Binary Search ");
                System.out.println("========================================================================================");
                startTime = System.nanoTime();
                daftar_dokter.binarySearchPasienByNama("Dr. Jonathan Reed", "Sebastian Gray");
                endTime = System.nanoTime();
                waktu = (double) (endTime - startTime) / 1000000000.0;
                System.out.printf("Waktu eksekusi: %.8f detik\n", waktu);
                System.out.println();

                System.out.println(
                                "===============================================================================================");
                System.out.println(
                                " Mengurutkan pasien dari Dr. Michael Harris berdasarkan umur dengan Insertion Sort ");
                System.out.println(
                                "===============================================================================================");
                startTime = System.nanoTime();
                daftar_dokter.insertionSortPasienByUmur("Dr. Michael Harris");;
                endTime = System.nanoTime();
                daftar_dokter.displayPasien("Dr. Michael Harris");
                waktu = (double) (endTime - startTime) / 1000000000.0;
                System.out.printf("Waktu eksekusi: %.8f detik\n", waktu);
                System.out.println();


                System.out.println("=================================================================================");
                System.out.println(" Mencari pasien dari Dr. Michael Harris yang berumur 45 tahun dengan Binary Search ");
                System.out.println("=================================================================================");
                startTime = System.nanoTime();
                daftar_dokter.binarySearchPasienByUmur("Dr. Michael Harris", 45);
                endTime = System.nanoTime();
                waktu = (double) (endTime - startTime) / 1000000000.0;
                System.out.printf("Waktu eksekusi: %.8f detik\n", waktu);
                System.out.println();

                
        }

}
