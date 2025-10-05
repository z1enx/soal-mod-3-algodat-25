public class Main {

    public static void main(String[] args) throws Exception {
        ListKategori list = new ListKategori();

        list.addKategori("Milk");
        list.head.product.addProduct("Ultramilk", 7000, 4.8);
        list.head.product.addProduct("Clevo", 3000, 2.5);
        list.head.product.addProduct("Indomilk", 8000, 4.95);
        list.head.product.addProduct("Bear Brend", 10000, 3.5);
        list.head.product.addProduct("Greenfield", 7500, 4);

        list.addKategori("Snack");
        list.head.next.product.addProduct("Oreo", 12000, 4.8);
        list.head.next.product.addProduct("Japota", 10000, 4.3);
        list.head.next.product.addProduct("Chitato", 13000, 5);
        list.head.next.product.addProduct("Chocolatos Keju", 7000, 2.5);
        list.head.next.product.addProduct("Pillow", 5000, 5);

        list.addKategori("Soap");
        list.head.next.next.product.addProduct("Lifebuoy", 4000, 4.7);
        list.head.next.next.product.addProduct("Dettol", 4500, 4.9);
        list.head.next.next.product.addProduct("Giv", 3000, 4.4);
        list.head.next.next.product.addProduct("Nuvo", 3500, 4.5);
        list.head.next.next.product.addProduct("Shinzui", 5000, 4.8);

        list.addKategori("Detergent");
        list.head.next.next.next.product.addProduct("Rinso", 25000, 4.8);
        list.head.next.next.next.product.addProduct("Daia", 18000, 4.5);
        list.head.next.next.next.product.addProduct("Attack", 28000, 4.9);
        list.head.next.next.next.product.addProduct("So Klin", 22000, 4.6);
        list.head.next.next.next.product.addProduct("Boom", 15000, 4.3);

        list.addKategori("Noodle");
        list.head.next.next.next.next.product.addProduct("Indomie Goreng", 3500, 5.0);
        list.head.next.next.next.next.product.addProduct("Mie Sedaap", 3000, 4.8);
        list.head.next.next.next.next.product.addProduct("Sarimi Isi 2", 4000, 4.4);
        list.head.next.next.next.next.product.addProduct("Supermi", 2800, 4.2);
        list.head.next.next.next.next.product.addProduct("Pop Mie", 6000, 4.6);

        list.addKategori("Drink");
        list.head.next.next.next.next.next.product.addProduct("Teh Botol Sosro", 5000, 4.8);
        list.head.next.next.next.next.next.product.addProduct("Aqua 600ml", 3500, 4.9);
        list.head.next.next.next.next.next.product.addProduct("Coca-Cola", 6000, 4.5);
        list.head.next.next.next.next.next.product.addProduct("Sprite", 6000, 5);
        list.head.next.next.next.next.next.product.addProduct("Pocari Sweat", 7000, 4.7);

        // System.out.println("Sebelum diurutkan");
        // list.display();

        // list.sort(list, "nama", "asc");

        // System.out.println("Setelah diurutkan berdasarkan Nama");
        // list.display();

        // list.binarySearch(list, "Sprite");

        list.linearSearch("Milk");
    }
}
