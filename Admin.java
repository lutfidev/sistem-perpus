import java.util.Scanner;

public class Admin extends User {
    private String password;

    public Admin(String id, String name, String password) {
        super(id, name);
        this.password = password;
    }

    @Override
    public void displayRole() {
        System.out.println(name + " adalah Admin.");
    }

    @Override
    public void interactWithLibrary(Perpustakaan perpustakaan, Scanner scanner) {
        System.out.print("Masukkan password admin: ");
        String inputPassword = scanner.nextLine();
        if (!inputPassword.equals(password)) {
            System.out.println("Password salah. Akses ditolak.");
            return;
        }

        boolean isRunning = true; // Variabel untuk mengontrol loop
        while (isRunning) {
            System.out.println("\n--- Menu Admin ---");
            System.out.println("1. Menambah Data Buku");
            System.out.println("2. Menghapus Data Buku");
            System.out.println("3. Mencari Data Buku");
            System.out.println("4. Menampilkan semua Data Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih fungsi yang akan digunakan: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline setelah nextInt()

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan judul buku: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan nama penulis: ");
                    String penulis = scanner.nextLine();
                    perpustakaan.tambahBuku(new Buku(judul, penulis));
                    break;
                case 2:
                    System.out.print("Masukkan judul buku yang ingin dihapus: ");
                    String judulHapus = scanner.nextLine();
                    perpustakaan.hapusBuku(judulHapus);
                    break;
                case 3:
                    System.out.print("Masukkan judul buku yang ingin dicari: ");
                    String judulCari = scanner.nextLine();
                    perpustakaan.cariBuku(judulCari);
                    break;
                case 4:
                    perpustakaan.tampilkanSemuaBuku();
                    break;
                case 5:
                    System.out.println("Keluar dari program. Terima kasih!");
                    isRunning = false; // Keluar dari loop
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}