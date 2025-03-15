import java.util.Scanner;

public class SistemPerpustakaan {
   public SistemPerpustakaan() {
   }

   public static void main(String[] var0) {
      System.out.println("Sistem Perpustakaan Berjalan...");
      Admin var1 = new Admin("A001", "Alice");
      Member var2 = new Member("B23", "tes");
      Perpustakaan var3 = new Perpustakaan(10);
      var3.tambahBuku(new Buku("Harry Potter", "J.K. Rowling"));
      var3.tambahBuku(new Buku("Laskar Pelangi", "Andrea Hirata"));
      var3.tambahBuku(new Buku("The Hobbit", "J.R.R. Tolkien"));
      Scanner var4 = new Scanner(System.in);

      while(true) {
         System.out.println("\n===== Sistem Perpustakaan =====");
         System.out.println("1. Display Info Admin");
         System.out.println("2. Display Info Member");
         System.out.println("3. Display Role Member");
         System.out.println("4. Display Role Member");
         System.out.println("5. Menambah Data Buku");
         System.out.println("6. Menghapus Data buku");
         System.out.println("7. Mencari Data buku");
         System.out.println("8. Menampilkan Semua Data Buku");
         System.out.println("9. Peminjaman Buku");
         System.out.println("10. Pengembalian Buku");
         System.out.println("11. Menampilkan Buku yang Tersedia");
         System.out.println("12. Keluar");
         System.out.print("Pilih fungsi yang akan digunakan: ");
         int var5 = var4.nextInt();
         switch (var5) {
            case 1:
               var1.displayInfo();
               break;
            case 2:
               var2.displayInfo();
               break;
            case 3:
               var1.displayRole();
               break;
            case 4:
               var2.displayRole();
               break;
            case 5:
               var4.nextLine();
               System.out.print("Masukkan judul buku: ");
               String var6 = var4.nextLine();
               System.out.print("Masukkan nama penulis: ");
               String var7 = var4.nextLine();
               var3.tambahBuku(new Buku(var6, var7));
               var3.tampilkanSemuaBuku();
               break;
            case 6:
               var4.nextLine();
               System.out.print("Masukkan judul buku: ");
               String var8 = var4.nextLine();
               var3.hapusBuku(var8);
               var3.tampilkanSemuaBuku();
               break;
            case 7:
               var4.nextLine();
               System.out.print("Masukkan judul buku: ");
               String var9 = var4.nextLine();
               var3.cariBuku(var9);
               break;
            case 8:
               var3.tampilkanSemuaBuku();
               break;
            case 9:
               var3.tampilkanSemuaBuku();
               System.out.println("Buku yang dipinjam");
               var4.nextLine();
               String var10 = var4.nextLine();
               var3.pinjamBuku(var10);
               break;
            case 10:
               var3.tampilkanSemuaBuku();
               System.out.println("Buku yang dikembalikan");
               var4.nextLine();
               String var11 = var4.nextLine();
               var3.kembalikanBuku(var11);
               break;
            case 11:
               var3.tampilkanBukuTersedia();
               break;
            case 12:
               System.out.println("Keluar dari program. Terima kasih!");
               var4.close();
               return;
            default:
               System.out.println("Pilihan tidak valid! Silakan coba lagi.");
         }
      }
   }
}