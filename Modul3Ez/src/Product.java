public class Product {
    String nama;
    int harga;
    double rating;
    Product next;

    public Product(String nama, int harga, double rating) {
        this.nama = nama;
        this.harga = harga;
        this.rating = rating;
        this.next = null;
    }
}
