import java.util.Scanner;

public class Member extends User {
    public Member(String id, String name) {
        super(id, name);
    }

    @Override
    public void displayRole() {
        System.out.println(name + " adalah Member.");
    }

    @Override
    public void interactWithLibrary(Perpustakaan perpustakaan, Scanner scanner) {
        boolean isRunning = true; // Variabel untuk mengontrol loop
        while (isRunning) {
            System.out.println("\n--- Menu Member ---");
            System.out.println("1. Meminjam Buku");
            System.out.println("2. Mengembalikan Buku");
            System.out.println("3. Menampilkan Buku yang Tersedia");
            System.out.println("4. Keluar");
            System.out.print("Pilih fungsi yang akan digunakan: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline setelah nextInt()

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan judul buku yang ingin dipinjam: ");
                    String judulPinjam = scanner.nextLine();
                    perpustakaan.pinjamBuku(judulPinjam);
                    break;
                case 2:
                    System.out.print("Masukkan judul buku yang ingin dikembalikan: ");
                    String judulKembali = scanner.nextLine();
                    perpustakaan.kembalikanBuku(judulKembali);
                    break;
                case 3:
                    perpustakaan.tampilkanBukuTersedia();
                    break;
                case 4:
                    System.out.println("Keluar dari program. Terima kasih!");
                    isRunning = false; // Keluar dari loop
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}