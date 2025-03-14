import java.util.ArrayList;

abstract class User {
    protected String id;
    protected String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void displayRole();  // Harus ditambahkan di User!
     // Method yang akan dioverride (Polymorphism)
    public void displayInfo() {
        System.out.println("User ID: " + id);
        System.out.println("Name: " + name);
    }
}


/*



    Override displayInfo() untuk menampilkan informasi khusus Admin
    @Override
    public void displayInfo() {
        System.out.println("List Admin:");
        super.displayInfo();
    }
}
*/

class Admin extends User {
    public Admin(String id, String name) {
        super(id, name);
    }

    @Override
    public void displayRole() {
        System.out.println(name + " adalah Admin."); 
    }
}

// Child Class Member
class Member extends User {
    public Member(String id, String name) {
        super(id, name);
    }

    // Override displayInfo() untuk Member
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
 
    public Buku(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
    }
 
    public String getJudul() {
        return judul;
    }
 
    public String getPenulis() {
        return penulis;
    }
 
    public void displayBuku() {
        System.out.println("Judul: " + judul + ", Penulis: " + penulis);
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
}

public class SistemPerpustakaan {

    public static void main(String[] args) {
        System.out.println("Sistem Perpustakaan Berjalan...");
        Admin admin = new Admin("A001", "Alice");
        Member member = new Member("B23", "tes");

        admin.displayInfo();
        member.displayInfo();
    }

}
