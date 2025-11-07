package Modul3_Medium;

public class ListPasien {
    Pasien head = null;
    Pasien tail = null;
    
    // Backup untuk menyimpan data awal
    private Pasien backupHead = null;
    private Pasien backupTail = null;

    public void addPasien(Pasien pasien) {
        if (this.head == null) {
            head = pasien;
            tail = pasien;
        } else {
            pasien.prev = tail;
            tail.next = pasien;
            tail = pasien;
        }
    }

   public void displayPasien() {
        Pasien start = head;
if (start == null) {
    System.out.println("No patient data available");
    return;
}

System.out.println("ID\tPatient Name\tAge\tSystolic\tDiastolic");
while (start != null) {
    System.out.println(
            start.id_pasien + "\t" +
                    start.nama_pasien + "\t " +
                    start.umur + "\t" +
                    start.sistolik + "\t\t" +
                    start.diastolik);
    start = start.next;
}

        System.out.println("----------------------------------------------------------");
    }

    // Method untuk backup data pasien
    public void backup() {
        if (head == null) {
            backupHead = null;
            backupTail = null;
            return;
        }

        // Clear backup lama
        backupHead = null;
        backupTail = null;

        // Copy semua node
        Pasien current = head;
        while (current != null) {
            Pasien newPasien = new Pasien(
                current.id_pasien,
                current.nama_pasien,
                current.umur,
                current.sistolik,
                current.diastolik
            );

            if (backupHead == null) {
                backupHead = newPasien;
                backupTail = newPasien;
            } else {
                newPasien.prev = backupTail;
                backupTail.next = newPasien;
                backupTail = newPasien;
            }

            current = current.next;
        }
    }

    // Method untuk restore data dari backup
    public void restore() {
        if (backupHead == null) {
            return;
        }

        // Clear data saat ini
        head = null;
        tail = null;

        // Copy dari backup
        Pasien current = backupHead;
        while (current != null) {
            Pasien newPasien = new Pasien(
                current.id_pasien,
                current.nama_pasien,
                current.umur,
                current.sistolik,
                current.diastolik
            );

            if (head == null) {
                head = newPasien;
                tail = newPasien;
            } else {
                newPasien.prev = tail;
                tail.next = newPasien;
                tail = newPasien;
            }

            current = current.next;
        }
    }
}