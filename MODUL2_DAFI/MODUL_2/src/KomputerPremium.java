class KomputerPremium extends Komputer {
    protected boolean ruangPrivate;

    public KomputerPremium(int jumlahKomputer, String namaWarnet, float hargaPerJam, boolean ruangPrivate) {
        super(jumlahKomputer, namaWarnet, hargaPerJam);
        this.ruangPrivate = ruangPrivate;
    }
    @Override
    public void Informasi() {
        super.Informasi();
    if (ruangPrivate) {
        System.out.println("fasilitas ruangan premium: ");
        System.out.println("-Ruangan ber-AC pribadi");
        System.out.println("-Sofa gaming exclusive");
        System.out.println("-Komputer spesifikasi tinggi");
        System.out.println("-Koneksi internet dediacted 100mbps");
    }
    else {
        System.out.println("fasilitas ruangan standar: ");
        System.out.println("-Ruangan gerah");
        System.out.println("-Sofa majapahit");
        System.out.println("-Komputer spesifikasi rendah");
        System.out.println("-Koneksi internet dediacted 1mbps");
    }
    }
    
    public void pesan(int nomorKomputer) {
        System.out.println(" memesan komputer nomor "+nomorKomputer);
    }

    public void TambahLayanan(String makanan) {
        System.out.println(" menambah layanan makanan "+ makanan);
    }

    public void TambahLayanan(String makanan, String minuman) {
        System.out.println("menambah layanan makanan"+ makanan+ " dan minuman " +minuman);
    }
    // To do: Buatlah Method Informasi memakai Polymorphism Override dengan isi yang sesuai dengan ketentuan 
    // (boleh berbeda dengan output jurnal tetapi dengan cangkupan masih sesuai oleh materi modul!)
    
    // To do: Buatlah method Pesan sesuai dengan ketentuan
    
    // To do: Buatlah method TambahLayanan sesuai dengan ketentuan
    
    // To do: Buatlah method TambahLayanan memakai Polymorphism Overloading sesuai dengan ketentuan
    
}
