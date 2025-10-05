public class ListKategori {
    Kategori head;

    public ListKategori() {
        this.head = null;
    }

    public void addKategori(String nama) {
        Kategori newKategori = new Kategori(nama);
        if(head == null) head = newKategori;
        else {
            Kategori current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = newKategori;
        }
    }

    public void display() {
        if(head == null) {
            System.out.println("Belum ada kategori");
            System.out.println();
            return;
        }
        Kategori current = head;
        while(current != null) {
            System.out.println("Kategori " + current.nama);
            current.product.display();
            current = current.next;
        }
        System.out.println();
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

    private void swap(Kategori a, Kategori b) {
        String nama = b.nama;
        ListProduct product = b.product;

        b.nama = a.nama;
        b.product = a.product;

        a.nama = nama;
        a.product = product;
    }

    private void selectionSort(ListProduct list, String sortBy, String order) {
        for(Product i = list.head; i != null; i = i.next) {
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
            }
            swap(i, min);
        }
    }

    private void bubbleSort(ListKategori list, String order) {
        boolean swapped;
        do {
            Kategori current = list.head;
            swapped = false;

            while(current.next != null){
                boolean swap = false;
                if(order.equalsIgnoreCase("asc")) {
                    if(current.nama.compareTo(current.next.nama) > 0) {
                        swap = true;
                    }
                }else {
                    if(current.nama.compareTo(current.next.nama) < 0) {
                        swap = true;
                    }
                }
                if(swap) {
                    swap(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
        }while(swapped);
    }

    public void linearSearch(String nama) {
        if(head == null) {
            System.out.println("Tidak ada kategori apapun dalam list ini");
            System.out.println();
            return;
        }
        Kategori current = head;
        while(current != null && !current.nama.equalsIgnoreCase(nama)) {
            current = current.next;
        }
        if(current == null) {
            System.out.println("Kategori tidak ditemukan");
            return;
        }
        System.out.println("Kategori " + current.nama);
        current.product.display();
        System.out.println();
    }

    private Product searchMiddleProduct(Product left, Product right) {
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

    private Product binarySearchProduct(ListProduct list, String nama) {
        selectionSort(list, "nama", "asc");

        Product left = list.head;
        Product right = null;

        do {
            Product middle = searchMiddleProduct(left, right);

            if (middle == null) break;

            int comparison = middle.nama.compareTo(nama);
            if (comparison == 0) {
                return middle;
            } else if (comparison < 0) {
                left = middle.next;
            } else {
                right = middle;
            }
        } while (right == null || right != left);

        if (left != null && left.nama.equals(nama)) return left;
        
        return null;
    }

    public void binarySearch(ListKategori list, String nama) {
        bubbleSort(list, "nama");

        Kategori current = list.head;
        while(current != null) {
            Product product = binarySearchProduct(current.product, nama);
            if(product != null) {
                System.out.println(current.nama);
                System.out.println("--- " + product.nama + " - " + product.harga + " - " + product.rating);
                return;
            }
            current = current.next;
        }
        System.out.println("Product '" + nama + "' tidak ditemukan.");
    }

    public void sort(ListKategori list, String sortBy, String order) {
        list.bubbleSort(list, order);

        Kategori current = list.head;
        while(current != null) {
            list.selectionSort(current.product, sortBy, order);
            current = current.next;
        }
    }
}
