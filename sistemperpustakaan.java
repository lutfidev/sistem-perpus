    import java.util.ArrayList;
    import java.util.Scanner;
    

    abstract class User {
        protected String id;
        protected String name;
        

        public User(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public abstract void displayRole();  
        // Method yang akan dioverride (Polymorphism)
        public void displayInfo() {
            System.out.println("User ID: " + id);
            System.out.println("Name: " + name);
        }
    }


  
    class Admin extends User {
        public Admin(String id, String name) {
            super(id, name);
        }

        @Override
        public void displayRole() {
            System.out.println(name + " adalah Admin."); 
        }
    }

    //Child Class Member
    class Member extends User {
        public Member(String id, String name) {
            super(id, name);
        }

        //Override displayInfo() untuk Member
        @Override
        public void displayRole()    
        {
            System.out.println(name + " adalah Member.");
            
        }
        public void displayInfo() {
            System.out.println("=== Member Info ===");
            super.displayInfo();
        }
    }

    // Class Buku untuk menyimpan informasi buku
    class Buku {
        private String judul;
        private String penulis;
        // Status ketersediaan buku
        protected boolean tersedia; 
        
        
    
        public Buku(String judul, String penulis) {
            this.judul = judul;
            this.penulis = penulis;
            // membuat default, status buku tersedia
            this.tersedia = true; 
        }
    
        public String getJudul() {
            return judul;
        }
    
        public String getPenulis() {
            return penulis;
        }

        public boolean isTersedia() {
            return tersedia;
        }

        public void setTersedia(boolean status) {
            this.tersedia = status;
        }
    
        public void displayBuku() {
            String status = (tersedia) ? "Tersedia" : "Dipinjam";
            System.out.println("Judul: " + judul + ", Penulis: " + penulis + " [" + status + "]");
        }
    }

    // Class Perpustakaan untuk mengelola daftar buku
    class Perpustakaan {
        private Buku[] daftarBuku;
        private int jumlahBuku;
    
        public Perpustakaan(int kapasitas) {
            daftarBuku = new Buku[kapasitas];
            jumlahBuku = 0;
        }
    
        // Menambahkan buku ke perpustakaan
        public void tambahBuku(Buku buku) {
            if (jumlahBuku < daftarBuku.length) {
                daftarBuku[jumlahBuku] = buku;
                jumlahBuku++;
                System.out.println("Buku berhasil ditambahkan: " + buku.getJudul());
            } else {
                System.out.println("Perpustakaan penuh! Tidak bisa menambahkan buku baru.");
            }
        }


        // Menghapus buku berdasarkan judul
        public void hapusBuku(String judul) {
            boolean ditemukan = false;
            for (int i = 0; i < jumlahBuku; i++) {
                if (daftarBuku[i].getJudul().equalsIgnoreCase(judul)) {
                    ditemukan = true;
                    System.out.println("Buku " + daftarBuku[i].getJudul() + " dihapus.");
                    // Menggeser elemen setelah buku yang dihapus
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

        // Mencari buku berdasarkan judul
        public void cariBuku(String judul) {
            boolean ditemukan = false;
            for (int i = 0; i < jumlahBuku; i++) {
                if (daftarBuku[i].getJudul().equalsIgnoreCase(judul)) {
                    System.out.println("Buku ditemukan:");
                    daftarBuku[i].displayBuku();
                    ditemukan = true;
                    break;
                }
            }
            if (!ditemukan) {
                System.out.println("Buku dengan judul '" + judul + "' tidak ditemukan.");
            }
        }

        public void tampilkanSemuaBuku() {
            
        System.out.println("--------------------------------------");
            if (jumlahBuku == 0) {
                
                System.out.println("Tidak ada buku di perpustakaan.");
            } else {
                System.out.println("Daftar Buku di Perpustakaan:");
                for (int i = 0; i < jumlahBuku; i++) {
                    daftarBuku[i].displayBuku();
                }
            }
        }

    // Menampilkan semua buku yang tersedia
    public void tampilkanBukuTersedia() {
        System.out.println("--------------------------------------");
        System.out.println("\nDaftar Buku yang Tersedia:");
        boolean adaBukuTersedia = false;
    
        for (int i = 0; i < jumlahBuku; i++) { // Pastikan hanya iterasi sampai jumlahBuku yang valid
            if (daftarBuku[i] != null && daftarBuku[i].isTersedia()) { 
                daftarBuku[i].displayBuku();
                adaBukuTersedia = true;
            }
        }
    
        if (!adaBukuTersedia) {
            System.out.println("Tidak ada buku yang tersedia saat ini.");
        }
    }

        // Meminjam buku berdasarkan judul
    public void pinjamBuku(String judul) {
        for (Buku buku : daftarBuku) {
            if (buku.getJudul().equalsIgnoreCase(judul)) {
                if (buku.isTersedia()) {
                    buku.setTersedia(false);
                    System.out.println("--------------------------------------");
                    System.out.println("Buku '" + judul + "' berhasil dipinjam.");
                } else {
                    System.out.println("--------------------------------------");
                    System.out.println("Buku '" + judul + "' sedang dipinjam.");
                }
                return;
            }
        }
        System.out.println("Buku dengan judul '" + judul + "' tidak ditemukan.");
    }

     // Mengembalikan buku berdasarkan judul
     public void kembalikanBuku(String judul) {
        for (Buku buku : daftarBuku) {
            if (buku.getJudul().equalsIgnoreCase(judul)) {
                if (!buku.isTersedia()) {
                    buku.setTersedia(true);
                    System.out.println("Buku '" + judul + "' berhasil dikembalikan.");
                } else {
                    System.out.println("Buku '" + judul + "' sudah tersedia.");
                }
                return;
            }
        }
        System.out.println("Buku dengan judul '" + judul + "' tidak ditemukan.");
    }

    /*public void MenuBuku() {
        while (true) {
            // Menampilkan menu
            System.out.println("\n===== Data Buku =====");
            
            System.out.println("1. Menambah Data Buku Baru");
            System.out.println("2. Menghapus data Buku di Perpustakaan");
            System.out.println("3. Mencari data Buku di Perpustakaan");
            System.out.print("Pilih fungsi yang akan digunakan: ");
            Scanner bukuScanner = new Scanner(System.in);
            int buku = bukuScanner.nextInt(); // Membaca input angka
            bukuScanner.nextLine();
            switch (buku) {
                case 1:
                    tambahBuku(null);
                    break;
                case 2:
                
                break;
                default:
            System.out.println("Pilihan tidak valid! Silakan coba lagi.");
            }
        }
    }
    */
        
    }
    
    
    public class SistemPerpustakaan {

        public static void main(String[] args) {
          
            System.out.println("Sistem Perpustakaan Berjalan...");
            Admin admin = new Admin("A001", "Alice");
            Member member = new Member("B23", "tes");
                      
            Perpustakaan perpustakaan = new Perpustakaan(10);
            perpustakaan.tambahBuku(new Buku("Harry Potter", "J.K. Rowling"));
            perpustakaan.tambahBuku(new Buku("Laskar Pelangi", "Andrea Hirata"));
            perpustakaan.tambahBuku(new Buku("The Hobbit", "J.R.R. Tolkien"));
            
            

            

                            
        // Menampilkan Menu pada Sistem Aplikasi
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        // Loop menu menggunakan while
        while (true) {
            // Menampilkan menu
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

            pilihan = scanner.nextInt(); // Membaca input angka

            switch (pilihan) {
                case 1:
                    admin.displayInfo();
                    break;
                case 2:
                member.displayInfo();
                    break;
                case 3:
                admin.displayRole();
                    break;
                case 4:
                member.displayRole();
                    break;
                 case 5:
                 //perpustakaan.tampilkanSemuaBuku();
                 //perpustakaan.MenuBuku(); 
                 scanner.nextLine();  // Tambahkan ini jika sebelumnya ada scanner.nextInt()
                
                System.out.print("Masukkan judul buku: ");
                String tambahjudul = scanner.nextLine();
                System.out.print("Masukkan nama penulis: ");
                String tambahpenulis = scanner.nextLine();
                 perpustakaan.tambahBuku(new Buku(tambahjudul, tambahpenulis));
                 perpustakaan.tampilkanSemuaBuku();
                break;
                case 6:
                //Menghapus
                scanner.nextLine();  // Tambahkan ini jika sebelumnya ada scanner.nextInt()
                    System.out.print("Masukkan judul buku: ");
                String hapusjudul = scanner.nextLine();
                perpustakaan.hapusBuku(hapusjudul);
                perpustakaan.tampilkanSemuaBuku();
                    break;
                    case 7:
                    //Mencari Data Buku
                    scanner.nextLine();  // Tambahkan ini jika sebelumnya ada scanner.nextInt()
                    System.out.print("Masukkan judul buku: ");
                String carijudul = scanner.nextLine();
                perpustakaan.cariBuku(carijudul);
                    break;
                    
                case 8:
                perpustakaan.tampilkanSemuaBuku();
                    break;
                case 9:
                perpustakaan.tampilkanSemuaBuku();
                System.out.println("Buku yang dipinjam");
                scanner.nextLine();  // Tambahkan ini jika sebelumnya ada scanner.nextInt()
                String judul = scanner.nextLine();
                    perpustakaan.pinjamBuku(judul);
                    break;
                case 10:
                perpustakaan.tampilkanSemuaBuku();
                System.out.println("Buku yang dikembalikan");
                scanner.nextLine();  // Tambahkan ini jika sebelumnya ada scanner.nextInt()
String kembali = scanner.nextLine();
                perpustakaan.kembalikanBuku(kembali);
                    break;
                case 11:
                    // Menampilkan kembali daftar buku yang tersedia setelah pengembalian
        perpustakaan.tampilkanBukuTersedia();
                    break;
                case 12:
                    System.out.println("Keluar dari program. Terima kasih!");
                    scanner.close(); // Tutup Scanner
                    return; // Keluar dari loop dan program
                default:
                    System.out.println("Pilihan tidak valid! Silakan coba lagi.");
            }
        }


        }
    }
    