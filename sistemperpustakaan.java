    import java.util.ArrayList;
    

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
        protected boolean tersedia; 
        // Status ketersediaan buku
    
        public Buku(String judul, String penulis) {
            this.judul = judul;
            this.penulis = penulis;
            this.tersedia = true; // Secara default, buku tersedia
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
        
    }

    public class SistemPerpustakaan {

        public static void main(String[] args) {
          
            System.out.println("Sistem Perpustakaan Berjalan...");
            Admin admin = new Admin("A001", "Alice");
            Member member = new Member("B23", "tes");

            
            admin.displayInfo();
            member.displayInfo();
            admin.displayRole();
            member.displayRole();

            Perpustakaan perpustakaan = new Perpustakaan(5);
            perpustakaan.tambahBuku(new Buku("Harry Potter", "J.K. Rowling"));
            perpustakaan.tambahBuku(new Buku("Laskar Pelangi", "Andrea Hirata"));
            perpustakaan.tambahBuku(new Buku("The Hobbit", "J.R.R. Tolkien"));
            
            perpustakaan.tampilkanSemuaBuku();

            perpustakaan.pinjamBuku("Harry Potter");

            perpustakaan.tampilkanSemuaBuku();

            // Menampilkan buku yang tersedia
            perpustakaan.tampilkanBukuTersedia();

                    // Mengembalikan buku
        perpustakaan.kembalikanBuku("Harry Potter");

        // Menampilkan kembali daftar buku yang tersedia setelah pengembalian
        perpustakaan.tampilkanBukuTersedia();

        
        }
    }
    