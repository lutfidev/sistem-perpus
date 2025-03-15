class Buku {
    private String judul;
    private String penulis;
    protected boolean tersedia;
 
    public Buku(String var1, String var2) {
       this.judul = var1;
       this.penulis = var2;
       this.tersedia = true;
    }
 
    public String getJudul() {
       return this.judul;
    }
 
    public String getPenulis() {
       return this.penulis;
    }
 
    public boolean isTersedia() {
       return this.tersedia;
    }
 
    public void setTersedia(boolean var1) {
       this.tersedia = var1;
    }
 
    public void displayBuku() {
       String var1 = this.tersedia ? "Tersedia" : "Dipinjam";
       System.out.println("Judul: " + this.judul + ", Penulis: " + this.penulis + " [" + var1 + "]");
    }
 }
 