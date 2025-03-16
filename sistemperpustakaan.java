import java.util.Scanner;

public class SistemPerpustakaan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Perpustakaan perpustakaan = new Perpustakaan(); // Menggunakan constructor default

        System.out.println("Sistem Perpustakaan Berjalan...");
        System.out.println("1. Login Admin");
        System.out.println("2. Login Member");
        System.out.print("Pilih tipe login: ");
        int tipeLogin = scanner.nextInt();
        scanner.nextLine();

        if (tipeLogin == 1) {
            Admin admin = new Admin("A001", "Admin", "12345");
            admin.interactWithLibrary(perpustakaan, scanner);
        } else if (tipeLogin == 2) {
            System.out.print("Masukkan ID Member: ");
            String idMember = scanner.nextLine();
            System.out.print("Masukkan Nama Member: ");
            String namaMember = scanner.nextLine();
            Member member = new Member(idMember, namaMember);
            member.interactWithLibrary(perpustakaan, scanner);
        } else {
            System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}