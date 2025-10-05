public class Kategori {
    String nama;
    ListProduct product;
    Kategori next;

    public Kategori(String nama) {
        this.nama = nama;
        this.product = new ListProduct();
        this.next = null;
    }
}
