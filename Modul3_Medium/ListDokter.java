package Modul3_Medium;

public class ListDokter {
    Dokter head = null;
    Dokter tail = null;

    public void addDokter(Dokter dokter) {
        if (this.head == null) {
            head = dokter;
            tail = dokter;
        } else {
            dokter.prev = tail;
            tail.next = dokter;
            tail = dokter;
        }
    }

    public void display() {
        Dokter start = head;
        if (start == null) {
            System.out.println("Tidak ada data");
            return;
        }

        // Header tabel
        System.out.println("---------------------------------------------------------------");
        System.out.println("ID\tNama Dokter\t\tSpesialis\tPengalaman");
        System.out.println("---------------------------------------------------------------");

        // Isi tabel
        for (; start != null; start = start.next) {
            System.out.println(start.id_dokter + "\t" +
                    start.nama_dokter + "\t" +
                    start.spesialis + "\t" +
                    start.pengalaman);
        }

        System.out.println("---------------------------------------------------------------");
    }

    public void displayDokterDanPasien() {
        Dokter current = head;
        
        if (current == null) {
            System.out.println("Tidak ada data dokter");
            return;
        }
        
        while (current != null) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("Dokter: " + current.nama_dokter);
            System.out.println("Spesialis: " + current.spesialis);
            System.out.println("Pengalaman: " + current.pengalaman + " tahun");
            System.out.println("---------------------------------------------------------------");
            System.out.println("Daftar Pasien:");
            System.out.println();
            
            if (current.pasien != null) {
                current.pasien.displayPasien();
            } else {
                System.out.println("Tidak ada pasien");
                System.out.println("---------------------------------------------------------------");
            }
            
            System.out.println();
            current = current.next;
        }
    }

    // Method untuk swap node pasien (bukan data)
    private void swapNodePasien(ListPasien listPasien, Pasien a, Pasien b) {
        if (a == b) return;

        // Simpan prev dan next dari a dan b
        Pasien prevA = a.prev;
        Pasien nextA = a.next;
        Pasien prevB = b.prev;
        Pasien nextB = b.next;

        // Jika a dan b bersebelahan
        if (a.next == b) {
            // a -> b menjadi b -> a
            a.next = nextB;
            a.prev = b;
            b.next = a;
            b.prev = prevA;

            if (prevA != null) prevA.next = b;
            else listPasien.head = b;

            if (nextB != null) nextB.prev = a;
            else listPasien.tail = a;
        } else if (b.next == a) {
            // b -> a menjadi a -> b
            b.next = nextA;
            b.prev = a;
            a.next = b;
            a.prev = prevB;

            if (prevB != null) prevB.next = a;
            else listPasien.head = a;

            if (nextA != null) nextA.prev = b;
            else listPasien.tail = b;
        } else {
            // a dan b tidak bersebelahan
            a.prev = prevB;
            a.next = nextB;
            b.prev = prevA;
            b.next = nextA;

            if (prevA != null) prevA.next = b;
            else listPasien.head = b;

            if (nextA != null) nextA.prev = b;
            else listPasien.tail = b;

            if (prevB != null) prevB.next = a;
            else listPasien.head = a;

            if (nextB != null) nextB.prev = a;
            else listPasien.tail = a;
        }

        // Update ID berdasarkan posisi baru
        updatePasienIds(listPasien);
    }

    // Method untuk update ID pasien berdasarkan urutan node
    private void updatePasienIds(ListPasien listPasien) {
        Pasien current = listPasien.head;
        int id = 1;
        while (current != null) {
            current.id_pasien = id++;
            current = current.next;
        }
    }

    // 1. Bubble Sort - Sorting pasien berdasarkan sistolik (swap by node)
    public void bubbleSortPasienBySistolik(String nama_dokter, String order) {
        Dokter dokter = findDokterByNama(nama_dokter);
        
        if (dokter == null) {
            System.out.println("Dokter dengan nama " + nama_dokter + " tidak ditemukan");
            return;
        }

        if (dokter.pasien == null || dokter.pasien.head == null) {
            System.out.println("Tidak ada pasien untuk dokter ini");
            return;
        }

        boolean swapped;
        do {
            Pasien current = dokter.pasien.head;
            swapped = false;

            while (current != null && current.next != null) {
                boolean shouldSwap = false;
                
                if (order.equalsIgnoreCase("asc")) {
                    if (current.sistolik > current.next.sistolik) {
                        shouldSwap = true;
                    }
                } else if (order.equalsIgnoreCase("desc")) {
                    if (current.sistolik < current.next.sistolik) {
                        shouldSwap = true;
                    }
                }

                if (shouldSwap) {
                    Pasien next = current.next;
                    swapNodePasien(dokter.pasien, current, next);
                    swapped = true;
                    current = next; // Lanjut ke node yang sudah di-swap
                } else {
                    current = current.next;
                }
            }
        } while (swapped);

        System.out.println("Pasien dokter " + dokter.nama_dokter + " berhasil diurutkan berdasarkan sistolik (" + order + ")");
    }

    // 2. Insertion Sort - Sorting pasien berdasarkan nama (tanpa swap id_pasien)
    public void insertionSortPasienByNama(String nama_dokter, String order) {
        Dokter dokter = findDokterByNama(nama_dokter);
        
        if (dokter == null) {
            System.out.println("Dokter dengan nama " + nama_dokter + " tidak ditemukan");
            return;
        }

        if (dokter.pasien == null || dokter.pasien.head == null) {
            System.out.println("Tidak ada pasien untuk dokter ini");
            return;
        }

        Pasien sorted = null;
        Pasien current = dokter.pasien.head;

        while (current != null) {
            Pasien next = current.next;
            
            // Insert current ke sorted list
            if (sorted == null || 
                (order.equalsIgnoreCase("asc") && current.nama_pasien.compareTo(sorted.nama_pasien) < 0) ||
                (order.equalsIgnoreCase("desc") && current.nama_pasien.compareTo(sorted.nama_pasien) > 0)) {
                
                current.next = sorted;
                current.prev = null;
                if (sorted != null) {
                    sorted.prev = current;
                }
                sorted = current;
            } else {
                Pasien temp = sorted;
                while (temp.next != null && 
                       ((order.equalsIgnoreCase("asc") && temp.next.nama_pasien.compareTo(current.nama_pasien) < 0) ||
                        (order.equalsIgnoreCase("desc") && temp.next.nama_pasien.compareTo(current.nama_pasien) > 0))) {
                    temp = temp.next;
                }
                
                current.next = temp.next;
                current.prev = temp;
                if (temp.next != null) {
                    temp.next.prev = current;
                }
                temp.next = current;
            }
            
            current = next;
        }

        // Update head dan tail
        dokter.pasien.head = sorted;
        Pasien temp = sorted;
        while (temp.next != null) {
            temp = temp.next;
        }
        dokter.pasien.tail = temp;

        // Update ID berdasarkan urutan node baru
        updatePasienIds(dokter.pasien);

        System.out.println("Pasien dokter " + dokter.nama_dokter + " berhasil diurutkan berdasarkan nama (" + order + ")");
    }

    // 3. Linear Search - Mencari pasien berdasarkan nama di dokter tertentu
    public void linearSearchPasien(String nama_dokter, String nama_pasien) {
        Dokter dokter = findDokterByNama(nama_dokter);
        
        if (dokter == null) {
            System.out.println("Dokter dengan nama " + nama_dokter + " tidak ditemukan");
            return;
        }

        if (dokter.pasien == null || dokter.pasien.head == null) {
            System.out.println("Tidak ada pasien untuk dokter ini");
            return;
        }

        Pasien current = dokter.pasien.head;
        while (current != null) {
            if (current.nama_pasien.equalsIgnoreCase(nama_pasien)) {
                System.out.println("Pasien ditemukan pada dokter " + dokter.nama_dokter);
                System.out.println("ID: " + current.id_pasien);
                System.out.println("Nama: " + current.nama_pasien);
                System.out.println("Umur: " + current.umur);
                System.out.println("Sistolik: " + current.sistolik);
                System.out.println("Diastolik: " + current.diastolik);
                return;
            }
            current = current.next;
        }

        System.out.println("Pasien dengan nama '" + nama_pasien + "' tidak ditemukan pada dokter " + dokter.nama_dokter);
    }

    // 4. Binary Search - Mencari pasien berdasarkan umur di dokter tertentu
    public void binarySearchPasienByUmur(String nama_dokter, int umur) {
        Dokter dokter = findDokterByNama(nama_dokter);
        
        if (dokter == null) {
            System.out.println("Dokter dengan nama " + nama_dokter + " tidak ditemukan");
            return;
        }

        if (dokter.pasien == null || dokter.pasien.head == null) {
            System.out.println("Tidak ada pasien untuk dokter ini");
            return;
        }

        // Sort dulu berdasarkan umur menggunakan bubble sort
        sortPasienByUmur(dokter.pasien, "asc");

        // Binary search
        Pasien left = dokter.pasien.head;
        Pasien right = null;

        do {
            Pasien middle = searchMiddlePasien(left, right);

            if (middle == null) break;

            if (middle.umur == umur) {
                System.out.println("Pasien ditemukan pada dokter " + dokter.nama_dokter);
                System.out.println("ID: " + middle.id_pasien);
                System.out.println("Nama: " + middle.nama_pasien);
                System.out.println("Umur: " + middle.umur);
                System.out.println("Sistolik: " + middle.sistolik);
                System.out.println("Diastolik: " + middle.diastolik);
                return;
            } else if (middle.umur < umur) {
                left = middle.next;
            } else {
                right = middle;
            }
        } while (right == null || right != left);

        if (left != null && left.umur == umur) {
            System.out.println("Pasien ditemukan pada dokter " + dokter.nama_dokter);
            System.out.println("ID: " + left.id_pasien);
            System.out.println("Nama: " + left.nama_pasien);
            System.out.println("Umur: " + left.umur);
            System.out.println("Sistolik: " + left.sistolik);
            System.out.println("Diastolik: " + left.diastolik);
            return;
        }

        System.out.println("Pasien dengan umur " + umur + " tidak ditemukan pada dokter " + dokter.nama_dokter);
    }

    // Helper method untuk mencari middle node (untuk binary search)
    private Pasien searchMiddlePasien(Pasien left, Pasien right) {
        if (left == null) {
            return null;
        }
        Pasien slow = left;
        Pasien fast = left;

        while (fast != right && fast.next != right) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper method untuk sorting pasien berdasarkan umur (untuk binary search)
    private void sortPasienByUmur(ListPasien listPasien, String order) {
        boolean swapped;
        do {
            Pasien current = listPasien.head;
            swapped = false;

            while (current != null && current.next != null) {
                boolean shouldSwap = false;
                
                if (order.equalsIgnoreCase("asc")) {
                    if (current.umur > current.next.umur) {
                        shouldSwap = true;
                    }
                } else {
                    if (current.umur < current.next.umur) {
                        shouldSwap = true;
                    }
                }

                if (shouldSwap) {
                    Pasien next = current.next;
                    swapNodePasien(listPasien, current, next);
                    swapped = true;
                    current = next;
                } else {
                    current = current.next;
                }
            }
        } while (swapped);
    }

    // Helper method untuk mencari dokter berdasarkan NAMA
    private Dokter findDokterByNama(String nama_dokter) {
        Dokter current = head;
        while (current != null) {
            if (current.nama_dokter.equalsIgnoreCase(nama_dokter)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}