import java.util.Scanner;

class Admin extends User {
    private String password; // Tambahkan atribut password

    // Constructor dengan parameter id, name, dan password
    public Admin(String id, String name, String password) {
        super(id, name);
        this.password = password;
    }

    @Override
    public void displayRole() {
        System.out.println(this.name + " adalah Admin.");
    }

    // Metode untuk memverifikasi password
    private boolean verifyPassword(Scanner scanner) {
        System.out.print("Masukkan password: ");
        String inputPassword = scanner.nextLine();
        return inputPassword.equals(this.password);
    }

    @Override
    public void interactWithLibrary(Perpustakaan perpustakaan, Scanner scanner) {
        // Verifikasi password sebelum menampilkan menu
        if (!verifyPassword(scanner)) {
            System.out.println("Password salah. Akses ditolak.");
            return;
        }

        System.out.println("\n=== Admin Menu ===");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Hapus Buku");
        System.out.print("Pilih tindakan: ");
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