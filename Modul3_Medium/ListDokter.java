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

    public void displayDokterDanPasien() {
        Dokter current = head;
        
        if (current == null) {
            System.out.println("Tidak ada data dokter");
            return;
        }
        
        while (current != null) {
            System.out.println("----------------------------------------------------------");
            System.out.println("ID Dokter: " + current.id_dokter);
            System.out.println("Dokter: " + current.nama_dokter);
            System.out.println("Spesialis: " + current.spesialis);
            System.out.println("Pengalaman: " + current.pengalaman + " tahun");
            System.out.println("----------------------------------------------------------");
            System.out.println("Daftar Pasien:");
            System.out.println();
            
            if (current.pasien != null) {
                current.pasien.displayPasien();
            } else {
                System.out.println("Tidak ada pasien");
                System.out.println("----------------------------------------------------------");
            }
            
            System.out.println();
            current = current.next;
        }
    }

    public void displayPasien(String nama_dokter) {
        Dokter dokter = findDokterByNama(nama_dokter);
        
        if (dokter == null) {
            System.out.println("Dokter dengan nama " + nama_dokter + " tidak ditemukan");
            return;
        }

        if (dokter.pasien == null || dokter.pasien.head == null) {
            System.out.println("Tidak ada pasien untuk dokter " + dokter.nama_dokter);
            return;
        }

        dokter.pasien.displayPasien();
    }

    private void swapNodePasien(ListPasien listPasien, Pasien a, Pasien b) {
        if (a == b) return;

        Pasien prevA = a.prev;
        Pasien nextA = a.next;
        Pasien prevB = b.prev;
        Pasien nextB = b.next;

        if (a.next == b) {
            a.next = nextB;
            a.prev = b;
            b.next = a;
            b.prev = prevA;

            if (prevA != null) prevA.next = b;
            else listPasien.head = b;

            if (nextB != null) nextB.prev = a;
            else listPasien.tail = a;
        } else if (b.next == a) {
            b.next = nextA;
            b.prev = a;
            a.next = b;
            a.prev = prevB;

            if (prevB != null) prevB.next = a;
            else listPasien.head = a;

            if (nextA != null) nextA.prev = b;
            else listPasien.tail = b;
        } else {
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

        updatePasienIds(listPasien);
    }

    private void updatePasienIds(ListPasien listPasien) {
        Pasien current = listPasien.head;
        int id = 1;
        while (current != null) {
            current.id_pasien = id++;
            current = current.next;
        }
    }

    // ==================== SELECTION SORT ====================
    
    // 1. Selection Sort - Pasien by Nama (Ascending)
    public void selectionSortPasienByNama(String nama_dokter) {
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
            Pasien min = current;
            Pasien temp = current.next;
            
            while (temp != null) {
                if (temp.nama_pasien.compareTo(min.nama_pasien) < 0) {
                    min = temp;
                }
                temp = temp.next;
            }
            
            if (min != current) {
                swapNodePasien(dokter.pasien, current, min);
                current = min.next;
            } else {
                current = current.next;
            }
        }

        System.out.println("Pasien dokter " + dokter.nama_dokter + " berhasil diurutkan berdasarkan nama (ascending) - Selection Sort");
    }

    // 2. Selection Sort - Pasien by Sistolik (Ascending)
    public void selectionSortPasienBySistolik(String nama_dokter) {
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
            Pasien min = current;
            Pasien temp = current.next;
            
            while (temp != null) {
                if (temp.sistolik < min.sistolik) {
                    min = temp;
                }
                temp = temp.next;
            }
            
            if (min != current) {
                swapNodePasien(dokter.pasien, current, min);
                current = min.next;
            } else {
                current = current.next;
            }
        }

        System.out.println("Pasien dokter " + dokter.nama_dokter + " berhasil diurutkan berdasarkan sistolik (ascending) - Selection Sort");
    }

    // ==================== INSERTION SORT ====================

    // 3. Insertion Sort - Pasien by Nama (Ascending)
    public void insertionSortPasienByNama(String nama_dokter) {
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
            
            if (sorted == null || current.nama_pasien.compareTo(sorted.nama_pasien) < 0) {
                current.next = sorted;
                current.prev = null;
                if (sorted != null) {
                    sorted.prev = current;
                }
                sorted = current;
            } else {
                Pasien temp = sorted;
                while (temp.next != null && temp.next.nama_pasien.compareTo(current.nama_pasien) < 0) {
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

        dokter.pasien.head = sorted;
        Pasien temp = sorted;
        while (temp.next != null) {
            temp = temp.next;
        }
        dokter.pasien.tail = temp;

        updatePasienIds(dokter.pasien);

        System.out.println("Pasien dokter " + dokter.nama_dokter + " berhasil diurutkan berdasarkan nama (ascending) - Insertion Sort");
    }

    // 4. Insertion Sort - Pasien by Sistolik (Ascending)
    public void insertionSortPasienBySistolik(String nama_dokter) {
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
            
            if (sorted == null || current.sistolik < sorted.sistolik) {
                current.next = sorted;
                current.prev = null;
                if (sorted != null) {
                    sorted.prev = current;
                }
                sorted = current;
            } else {
                Pasien temp = sorted;
                while (temp.next != null && temp.next.sistolik < current.sistolik) {
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

        dokter.pasien.head = sorted;
        Pasien temp = sorted;
        while (temp.next != null) {
            temp = temp.next;
        }
        dokter.pasien.tail = temp;

        updatePasienIds(dokter.pasien);

        System.out.println("Pasien dokter " + dokter.nama_dokter + " berhasil diurutkan berdasarkan sistolik (ascending) - Insertion Sort");
    }

    // ==================== LINEAR SEARCH ====================

    // 5. Linear Search - Pasien by Umur
    public void linearSearchPasienByUmur(String nama_dokter, int umur) {
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
        boolean found = false;
        
        while (current != null) {
            if (current.umur == umur) {
                if (!found) {
                    System.out.println("Pasien ditemukan pada dokter " + dokter.nama_dokter);
                    found = true;
                }
                System.out.println("ID: " + current.id_pasien);
                System.out.println("Nama: " + current.nama_pasien);
                System.out.println("Umur: " + current.umur);
                System.out.println("Sistolik: " + current.sistolik);
                System.out.println("Diastolik: " + current.diastolik);
                System.out.println();
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("Pasien dengan umur " + umur + " tidak ditemukan pada dokter " + dokter.nama_dokter);
        }
    }

    // 6. Linear Search - Pasien by Nama
    public void linearSearchPasienByNama(String nama_dokter, String nama_pasien) {
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

    // ==================== BINARY SEARCH ====================

    // 7. Binary Search - Pasien by Umur
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

        sortPasienByUmur(dokter.pasien);

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

    // 8. Binary Search - Pasien by Nama
    public void binarySearchPasienByNama(String nama_dokter, String nama_pasien) {
        Dokter dokter = findDokterByNama(nama_dokter);
        
        if (dokter == null) {
            System.out.println("Dokter dengan nama " + nama_dokter + " tidak ditemukan");
            return;
        }

        if (dokter.pasien == null || dokter.pasien.head == null) {
            System.out.println("Tidak ada pasien untuk dokter ini");
            return;
        }

        sortPasienByNamaForBinary(dokter.pasien);

        Pasien left = dokter.pasien.head;
        Pasien right = null;

        do {
            Pasien middle = searchMiddlePasien(left, right);

            if (middle == null) break;

            int comparison = middle.nama_pasien.compareToIgnoreCase(nama_pasien);

            if (comparison == 0) {
                System.out.println("Pasien ditemukan pada dokter " + dokter.nama_dokter);
                System.out.println("ID: " + middle.id_pasien);
                System.out.println("Nama: " + middle.nama_pasien);
                System.out.println("Umur: " + middle.umur);
                System.out.println("Sistolik: " + middle.sistolik);
                System.out.println("Diastolik: " + middle.diastolik);
                return;
            } else if (comparison < 0) {
                left = middle.next;
            } else {
                right = middle;
            }
        } while (right == null || right != left);

        if (left != null && left.nama_pasien.equalsIgnoreCase(nama_pasien)) {
            System.out.println("Pasien ditemukan pada dokter " + dokter.nama_dokter);
            System.out.println("ID: " + left.id_pasien);
            System.out.println("Nama: " + left.nama_pasien);
            System.out.println("Umur: " + left.umur);
            System.out.println("Sistolik: " + left.sistolik);
            System.out.println("Diastolik: " + left.diastolik);
            return;
        }

        System.out.println("Pasien dengan nama '" + nama_pasien + "' tidak ditemukan pada dokter " + dokter.nama_dokter);
    }


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

    private void sortPasienByUmur(ListPasien listPasien) {
        Pasien current = listPasien.head;
        
        while (current != null) {
            Pasien min = current;
            Pasien temp = current.next;
            
            while (temp != null) {
                if (temp.umur < min.umur) {
                    min = temp;
                }
                temp = temp.next;
            }
            
            if (min != current) {
                swapNodePasien(listPasien, current, min);
                current = min.next;
            } else {
                current = current.next;
            }
        }
    }

    private void sortPasienByNamaForBinary(ListPasien listPasien) {
        Pasien current = listPasien.head;
        
        while (current != null) {
            Pasien min = current;
            Pasien temp = current.next;
            
            while (temp != null) {
                if (temp.nama_pasien.compareTo(min.nama_pasien) < 0) {
                    min = temp;
                }
                temp = temp.next;
            }
            
            if (min != current) {
                swapNodePasien(listPasien, current, min);
                current = min.next;
            } else {
                current = current.next;
            }
        }
    }

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