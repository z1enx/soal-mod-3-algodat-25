package Modul3_Medium;

public class ListPasien {
    Pasien head = null;
    Pasien tail = null;

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
}
