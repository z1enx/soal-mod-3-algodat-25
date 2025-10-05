public class ListProduct {
    Product head;

    public ListProduct() {
        this.head = null;
    }

    public void addProduct(String nama, int harga, double rating) {
        Product newProduct = new Product(nama, harga, rating);
        if(head == null) head = newProduct;
        else {
            Product current = head;
            while(current.next != null) current = current.next;
            current.next = newProduct;
        }
    }

    public void display() {
        if(head == null) {
            System.out.println("Belum ada produk untuk kategori ini");
            return;
        }
        Product current = head;
        System.out.println("    Nama - Harga - Rating");
        while(current != null) {
            System.out.println("--- " + current.nama + " - " + current.harga + " - " + current.rating);
            current = current.next;
        }
        System.out.println();
    }
}
