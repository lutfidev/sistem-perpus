class Perpustakaan {
    private Buku[] daftarBuku;
    private int jumlahBuku;
 
    public Perpustakaan(int var1) {
       this.daftarBuku = new Buku[var1];
       this.jumlahBuku = 0;
    }
 
    public void tambahBuku(Buku var1) {
       if (this.jumlahBuku < this.daftarBuku.length) {
          this.daftarBuku[this.jumlahBuku] = var1;
          ++this.jumlahBuku;
          System.out.println("Buku berhasil ditambahkan: " + var1.getJudul());
       } else {
          System.out.println("Perpustakaan penuh! Tidak bisa menambahkan buku baru.");
       }
 
    }
 
    public void hapusBuku(String var1) {
       boolean var2 = false;
 
       for(int var3 = 0; var3 < this.jumlahBuku; ++var3) {
          if (this.daftarBuku[var3].getJudul().equalsIgnoreCase(var1)) {
             var2 = true;
             Buku var10001 = this.daftarBuku[var3];
             System.out.println("Buku " + var10001.getJudul() + " dihapus.");
 
             for(int var4 = var3; var4 < this.jumlahBuku - 1; ++var4) {
                this.daftarBuku[var4] = this.daftarBuku[var4 + 1];
             }
 
             this.daftarBuku[this.jumlahBuku - 1] = null;
             --this.jumlahBuku;
             break;
          }
       }
 
       if (!var2) {
          System.out.println("Buku dengan judul '" + var1 + "' tidak ditemukan.");
       }
 
    }
 
    public void cariBuku(String var1) {
       boolean var2 = false;
 
       for(int var3 = 0; var3 < this.jumlahBuku; ++var3) {
          if (this.daftarBuku[var3].getJudul().equalsIgnoreCase(var1)) {
             System.out.println("Buku ditemukan:");
             this.daftarBuku[var3].displayBuku();
             var2 = true;
             break;
          }
       }
 
       if (!var2) {
          System.out.println("Buku dengan judul '" + var1 + "' tidak ditemukan.");
       }
 
    }
 
    public void tampilkanSemuaBuku() {
       System.out.println("--------------------------------------");
       if (this.jumlahBuku == 0) {
          System.out.println("Tidak ada buku di perpustakaan.");
       } else {
          System.out.println("Daftar Buku di Perpustakaan:");
 
          for(int var1 = 0; var1 < this.jumlahBuku; ++var1) {
             this.daftarBuku[var1].displayBuku();
          }
       }
 
    }
 
    public void tampilkanBukuTersedia() {
       System.out.println("--------------------------------------");
       System.out.println("\nDaftar Buku yang Tersedia:");
       boolean var1 = false;
 
       for(int var2 = 0; var2 < this.jumlahBuku; ++var2) {
          if (this.daftarBuku[var2] != null && this.daftarBuku[var2].isTersedia()) {
             this.daftarBuku[var2].displayBuku();
             var1 = true;
          }
       }
 
       if (!var1) {
          System.out.println("Tidak ada buku yang tersedia saat ini.");
       }
 
    }
 
    public void pinjamBuku(String var1) {
       Buku[] var2 = this.daftarBuku;
       int var3 = var2.length;
 
       for(int var4 = 0; var4 < var3; ++var4) {
          Buku var5 = var2[var4];
          if (var5.getJudul().equalsIgnoreCase(var1)) {
             if (var5.isTersedia()) {
                var5.setTersedia(false);
                System.out.println("--------------------------------------");
                System.out.println("Buku '" + var1 + "' berhasil dipinjam.");
             } else {
                System.out.println("--------------------------------------");
                System.out.println("Buku '" + var1 + "' sedang dipinjam.");
             }
 
             return;
          }
       }
 
       System.out.println("Buku dengan judul '" + var1 + "' tidak ditemukan.");
    }
 
    public void kembalikanBuku(String var1) {
       Buku[] var2 = this.daftarBuku;
       int var3 = var2.length;
 
       for(int var4 = 0; var4 < var3; ++var4) {
          Buku var5 = var2[var4];
          if (var5.getJudul().equalsIgnoreCase(var1)) {
             if (!var5.isTersedia()) {
                var5.setTersedia(true);
                System.out.println("Buku '" + var1 + "' berhasil dikembalikan.");
             } else {
                System.out.println("Buku '" + var1 + "' sudah tersedia.");
             }
 
             return;
          }
       }
 
       System.out.println("Buku dengan judul '" + var1 + "' tidak ditemukan.");
    }
 }
 