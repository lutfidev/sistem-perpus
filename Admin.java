import java.util.Scanner;

class Admin extends User {
    public Admin(String var1, String var2) {
       super(var1, var2);
    }
    
    public void displayRole() {
       System.out.println(this.name + " adalah Admin.");
    }

    public void interactWithLibrary(Perpustakaan perpustakaan, Scanner scanner) {
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
 