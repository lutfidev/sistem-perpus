import java.util.Scanner;

class Member extends User {
    public Member(String var1, String var2) {
       super(var1, var2);
    }
 
    public void displayRole() {
       System.out.println(this.name + " adalah Member.");
    }
 
   //  public void displayInfo() {
   //     System.out.println("=== Member Info ===");
   //     super.displayInfo();
   //  }

    public void interactWithLibrary(Perpustakaan perpustakaan, Scanner scanner) {
        System.out.println("1. Pinjam Buku");
        System.out.println("2. Kembalikan Buku");
        System.out.print("Pilih tindakan: ");
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