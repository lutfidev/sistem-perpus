import java.util.Scanner;

// Abstract class User
abstract class User {
    protected String id;
    protected String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void displayRole();

    public void displayInfo() {
        System.out.println("User ID: " + id);
        System.out.println("Name: " + name);
    }

    // Metode Polymorphism
    public abstract void interactWithLibrary(Perpustakaan perpustakaan, Scanner scanner);
}

// Admin class
class Admin extends User {
    private String password; // Atribut password

    public Admin(String id, String name, String password) { // Constructor dengan password
        super(id, name);
        this.password = password;
    }

    @Override
    public void displayRole() {
        System.out.println(name + " adalah Admin.");
    }

    // Metode untuk memverifikasi password
    private boolean verifyPassword(Scanner scanner) {
        System.out.print("Masukkan password: ");
        String inputPassword = scanner.nextLine();
        return inputPassword.equals(password);
    }

    // Polymorphic Method untuk Admin
    @Override
    public void interactWithLibrary(Perpustakaan perpustakaan, Scanner scanner) {
        if (!verifyPassword(scanner)) { // Verifikasi password
            System.out.println("Password salah. Akses ditolak.");
            return;
        }

        System.out.println("\n=== Admin Menu ===");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Hapus Buku");
        System.out.print("Pilih aksi: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        if (pilihan == 1) {
            System.out.print("Masukkan judul buku: ");
            String judul = scanner.nextLine();
            System.out.print("Masukkan nama penulis: ");
            String penulis = scanner.nextLine();
            perpustakaan.tambahBuku(new Buku(judul, penulis));
        } else if (pilihan == 2) {
            System.out.print("Masukkan judul buku yang ingin dihapus: ");
            String judul = scanner.nextLine();
            perpustakaan.hapusBuku(judul);
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }
}

// Member class
class Member extends User {
    public Member(String id, String name) {
        super(id, name);
    }

    @Override
    public void displayRole() {
        System.out.println(name + " adalah Member.");
    }

    @Override
    public void interactWithLibrary(Perpustakaan perpustakaan, Scanner scanner) {
        System.out.println("\n=== Member Menu ===");
        System.out.println("1. Pinjam Buku");
        System.out.println("2. Kembalikan Buku");
        System.out.print("Pilih aksi: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        if (pilihan == 1) {
            System.out.print("Masukkan judul buku yang ingin dipinjam: ");
            String judul = scanner.nextLine();
            perpustakaan.pinjamBuku(judul);
        } else if (pilihan == 2) {
            System.out.print("Masukkan judul buku yang ingin dikembalikan: ");
            String judul = scanner.nextLine();
            perpustakaan.kembalikanBuku(judul);
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }
}

// Buku class
class Buku {
    private String judul;
    private String penulis;
    protected boolean tersedia;

    public Buku(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
        this.tersedia = true;
    }

    public String getJudul() {
        return judul;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean status) {
        this.tersedia = status;
    }

    public void displayBuku() {
        String status = (tersedia) ? "Tersedia" : "Dipinjam";
        System.out.println("Judul: " + judul + " [" + status + "]");
    }
}

// Perpustakaan class
class Perpustakaan {
    private Buku[] daftarBuku;
    private int jumlahBuku;

    public Perpustakaan(int kapasitas) {
        daftarBuku = new Buku[kapasitas];
        jumlahBuku = 0;
    }

    public void tambahBuku(Buku buku) {
        if (jumlahBuku < daftarBuku.length) {
            daftarBuku[jumlahBuku] = buku;
            jumlahBuku++;
            System.out.println("Buku '" + buku.getJudul() + "' berhasil ditambahkan.");
        } else {
            System.out.println("Perpustakaan penuh!");
        }
    }

    public void hapusBuku(String judul) {
        boolean ditemukan = false;
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].getJudul().equalsIgnoreCase(judul)) {
                ditemukan = true;
                System.out.println("Buku '" + daftarBuku[i].getJudul() + "' dihapus.");
                for (int j = i; j < jumlahBuku - 1; j++) {
                    daftarBuku[j] = daftarBuku[j + 1];
                }
                daftarBuku[jumlahBuku - 1] = null;
                jumlahBuku--;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    public void pinjamBuku(String judul) {
        for (Buku buku : daftarBuku) {
            if (buku != null && buku.getJudul().equalsIgnoreCase(judul)) {
                if (buku.isTersedia()) {
                    buku.setTersedia(false);
                    System.out.println("Buku '" + judul + "' berhasil dipinjam.");
                } else {
                    System.out.println("Buku sedang dipinjam.");
                }
                return;
            }
        }
        System.out.println("Buku tidak ditemukan.");
    }

    public void kembalikanBuku(String judul) {
        for (Buku buku : daftarBuku) {
            if (buku != null && buku.getJudul().equalsIgnoreCase(judul)) {
                if (!buku.isTersedia()) {
                    buku.setTersedia(true);
                    System.out.println("Buku '" + judul + "' berhasil dikembalikan.");
                } else {
                    System.out.println("Buku sudah tersedia.");
                }
                return;
            }
        }
        System.out.println("Buku tidak ditemukan.");
    }
}

// Main class
public class sistemperpus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Perpustakaan perpustakaan = new Perpustakaan(10);

        // Inisialisasi Admin dan Member
        User admin = new Admin("A001", "Alice", "12345"); 
        User member = new Member("B002", "Bob");

        System.out.println("\nPilih peran pengguna:");
        System.out.println("1. Admin");
        System.out.println("2. Member");
        System.out.print("Masukkan pilihan: ");
        int role = scanner.nextInt();
        scanner.nextLine();

        if (role == 1) {
            admin.interactWithLibrary(perpustakaan, scanner);
        } else if (role == 2) {
            member.interactWithLibrary(perpustakaan, scanner);
        } else {
            System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}