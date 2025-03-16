public class Perpustakaan {
    private Buku[] daftarBuku;
    private int jumlahBuku;

    public Perpustakaan(int kapasitas) {
        this.daftarBuku = new Buku[kapasitas];
        this.jumlahBuku = 0;
        inisialisasiBuku(); // Menambahkan 3 buku pertama saat objek Perpustakaan dibuat
    }

    public Perpustakaan() {
        this(50); // Kapasitas default 50
    }

    // Metode untuk menambahkan 3 buku pertama
    private void inisialisasiBuku() {
        tambahBukuTanpaPesan(new Buku("Harry Potter", "J.K. Rowling"));
        tambahBukuTanpaPesan(new Buku("Laskar Pelangi", "Andrea Hirata"));
        tambahBukuTanpaPesan(new Buku("The Hobbit", "J.R.R. Tolkien"));
    }

    // Metode untuk menambah buku tanpa mencetak pesan
    private void tambahBukuTanpaPesan(Buku buku) {
        if (jumlahBuku < daftarBuku.length) {
            daftarBuku[jumlahBuku] = buku;
            jumlahBuku++;
        } else {
            System.out.println("Perpustakaan penuh! Tidak bisa menambahkan buku baru.");
        }
    }

    // Metode untuk menambah buku dengan mencetak pesan
    public void tambahBuku(Buku buku) {
        if (jumlahBuku < daftarBuku.length) {
            daftarBuku[jumlahBuku] = buku;
            jumlahBuku++;
            System.out.println("Buku berhasil ditambahkan: " + buku.getJudul());
        } else {
            System.out.println("Perpustakaan penuh! Tidak bisa menambahkan buku baru.");
        }
    }

    // Metode untuk menghapus buku
    public void hapusBuku(String judul) {
        boolean ditemukan = false;
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].getJudul().equalsIgnoreCase(judul)) {
                ditemukan = true;
                System.out.println("Buku " + daftarBuku[i].getJudul() + " dihapus.");
                for (int j = i; j < jumlahBuku - 1; j++) {
                    daftarBuku[j] = daftarBuku[j + 1];
                }
                daftarBuku[jumlahBuku - 1] = null;
                jumlahBuku--;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Buku dengan judul '" + judul + "' tidak ditemukan.");
        }
    }

    // Metode untuk mencari buku
    public void cariBuku(String judul) {
        boolean ditemukan = false;
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].getJudul().equalsIgnoreCase(judul)) {
                System.out.println("Buku ditemukan:");
                System.out.println("Judul: " + daftarBuku[i].getJudul() + ", Penulis: " + daftarBuku[i].getPenulis() +
                        ", Status: " + (daftarBuku[i].isTersedia() ? "Tersedia" : "Dipinjam"));
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Buku dengan judul '" + judul + "' tidak ditemukan.");
        }
    }

    // Metode untuk menampilkan semua buku
    public void tampilkanSemuaBuku() {
        System.out.println("Daftar Buku di Perpustakaan:");
        if (jumlahBuku == 0) {
            System.out.println("Tidak ada buku di perpustakaan.");
        } else {
            for (int i = 0; i < jumlahBuku; i++) {
                System.out.println("Judul: " + daftarBuku[i].getJudul() + ", Penulis: " + daftarBuku[i].getPenulis() +
                        ", Status: " + (daftarBuku[i].isTersedia() ? "Tersedia" : "Dipinjam"));
            }
        }
    }

    // Metode untuk menampilkan buku yang tersedia
    public void tampilkanBukuTersedia() {
        System.out.println("Daftar Buku yang Tersedia:");
        boolean adaBukuTersedia = false;
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].isTersedia()) {
                System.out.println("Judul: " + daftarBuku[i].getJudul() + ", Penulis: " + daftarBuku[i].getPenulis());
                adaBukuTersedia = true;
            }
        }
        if (!adaBukuTersedia) {
            System.out.println("Tidak ada buku yang tersedia saat ini.");
        }
    }

    // Metode untuk meminjam buku
    public void pinjamBuku(String judul) {
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].getJudul().equalsIgnoreCase(judul)) {
                if (daftarBuku[i].isTersedia()) {
                    daftarBuku[i].setTersedia(false);
                    System.out.println("Buku '" + judul + "' berhasil dipinjam.");
                } else {
                    System.out.println("Buku '" + judul + "' sedang dipinjam.");
                }
                return;
            }
        }
        System.out.println("Buku dengan judul '" + judul + "' tidak ditemukan.");
    }

    // Metode untuk mengembalikan buku
    public void kembalikanBuku(String judul) {
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].getJudul().equalsIgnoreCase(judul)) {
                if (!daftarBuku[i].isTersedia()) {
                    daftarBuku[i].setTersedia(true);
                    System.out.println("Buku '" + judul + "' berhasil dikembalikan.");
                } else {
                    System.out.println("Buku '" + judul + "' sudah tersedia.");
                }
                return;
            }
        }
        System.out.println("Buku dengan judul '" + judul + "' tidak ditemukan.");
    }
}