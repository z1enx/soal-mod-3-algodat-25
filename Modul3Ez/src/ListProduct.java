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
        System.out.printf("  %-30s | %10s | %s\n", "Nama Produk", "Harga", "Rating");
        System.out.println("  --------------------------------------------------");
        while(current != null) {
            System.out.printf("- %-30s | Rp %,8d | %.1f\n", current.nama, current.harga, current.rating);
            current = current.next;
        }
    }

    private void swap(Product a, Product b) {
        String nama = b.nama;
        int harga = b.harga;
        double rating = b.rating;

        b.nama = a.nama;
        b.harga = a.harga;
        b.rating = a.rating;

        a.nama = nama;
        a.harga = harga;
        a.rating = rating;
    }

    public int[] selectionSort(String sortBy, String order) {
        int counter[] = {0,0};
        for(Product i = this.head; i != null; i = i.next) {
            Product min = i;
            for(Product j = i.next; j != null; j = j.next) {
                if(order.equalsIgnoreCase("asc")) {
                    if(sortBy.equalsIgnoreCase("harga")) {
                        if(j.harga < min.harga) {
                            min = j;
                        }
                    } else if(sortBy.equalsIgnoreCase("nama")) {
                        if(j.nama.compareTo(min.nama) < 0) {
                            min = j;
                        }
                    } else if(sortBy.equalsIgnoreCase("rating")) {
                        if(j.rating < min.rating) {
                            min = j;
                        }
                    }
                } else {
                    if(sortBy.equalsIgnoreCase("harga")) {
                        if(j.harga > min.harga) {
                            min = j;
                        }
                    } else if(sortBy.equalsIgnoreCase("nama")) {
                        if(j.nama.compareTo(min.nama) > 0) {
                            min = j;
                        }
                    } else if(sortBy.equalsIgnoreCase("rating")) {
                        if(j.rating > min.rating) {
                            min = j;
                        }
                    }
                }
                counter[0]++;
            }
            swap(i, min);
            counter[1]++;
        }
        return counter;
    }

    public int[] bubbleSort(String sortBy, String order) {
        boolean swapped;
        int counter[] = {0,0};
        do {
            Product current = this.head;
            swapped = false;

            while(current.next != null){
                boolean swap = false;
                if(order.equalsIgnoreCase("asc")) {
                    if(sortBy.equalsIgnoreCase("nama")) {
                        if(current.nama.compareTo(current.next.nama) > 0) {swap = true;}
                    } else if(sortBy.equalsIgnoreCase("harga")) {
                        if(current.harga > current.next.harga) swap = true;
                    } else if(sortBy.equalsIgnoreCase("rating")) {
                        if(current.rating > current.next.rating) swap = true;
                    }
                }else if(order.equalsIgnoreCase("desc")) {
                    if(sortBy.equalsIgnoreCase("nama")) {
                        if(current.nama.compareTo(current.next.nama) < 0) {swap = true;}
                    } else if(sortBy.equalsIgnoreCase("harga")) {
                        if(current.harga < current.next.harga) swap = true;
                    } else if(sortBy.equalsIgnoreCase("rating")) {
                        if(current.rating < current.next.rating) swap = true;
                    }
                }else {
                    System.out.println("Inputan order tidak sesuai");
                }
                if(swap) {
                    swap(current, current.next);
                    swapped = true;
                    counter[1]++;
                }
                counter[0]++;
                current = current.next;
            }
        }while(swapped);
        return counter;
    }

    public void linearSearch(String nama) {
        if(head == null) {
            System.out.println("Tidak ada produk apapun dalam list ini");
            System.out.println();
            return;
        }
        Product current = head;
        while(current != null && !current.nama.equalsIgnoreCase(nama)) {
            current = current.next;
        }
        if(current == null) {
            System.out.println("Produk tidak ditemukan");
            return;
        }else {
            System.out.printf("  %-30s | %10s | %s\n", "Nama Produk", "Harga", "Rating");
            System.out.println("  --------------------------------------------------");
            System.out.printf("- %-30s | Rp %,8d | %.1f\n", current.nama, current.harga, current.rating);
        }
    }

    private Product searchMiddle(Product left, Product right) {
        if (left == null) {
            return null;
        }
        Product slow = left;
        Product fast = left;

        while (fast != right && fast.next != right) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void binarySearch(String nama) {
        if(head == null) {
            System.out.println("Tidak ada produk apapun dalam list ini");
            return;
        }

        // selectionSort("nama", "asc");

        Product left = this.head;
        Product right = null;

        do {
            Product middle = searchMiddle(left, right);

            if (middle == null) break;

            int comparison = middle.nama.compareTo(nama);
            if (comparison == 0) {
                System.out.printf("  %-30s | %10s | %s\n", "Nama Produk", "Harga", "Rating");
                System.out.println("  --------------------------------------------------");
                System.out.printf("- %-30s | Rp %,8d | %.1f\n", middle.nama, middle.harga, middle.rating);
                return;
            } else if (comparison < 0) {
                left = middle.next;
            } else {
                right = middle;
            }
        } while (right == null || right != left);

        if (left != null && left.nama.equals(nama)) {
            System.out.printf("  %-30s | %10s | %s\n", "Nama Produk", "Harga", "Rating");
            System.out.println("  --------------------------------------------------");
            System.out.printf("- %-30s | Rp %,8d | %.1f\n", left.nama, left.harga, left.rating);
            return;
        }
        System.out.println("Produk tidak ditemukan");
        return;
    }

    public ListProduct copyList() {
        ListProduct newList = new ListProduct();
        Product temp = this.head;
        while(temp != null) {
            newList.addProduct(temp.nama, temp.harga, temp.rating);
            temp = temp.next;
        }
        return newList;
    }
}
