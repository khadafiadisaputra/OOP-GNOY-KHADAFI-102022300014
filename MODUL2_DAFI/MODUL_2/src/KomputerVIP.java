class KomputerVIP extends Komputer {
    protected boolean vipCard;

    public KomputerVIP(int jumlahKomputer, String namaWarnet, float hargaPerJam, boolean vipCard) {
        super(jumlahKomputer, namaWarnet, hargaPerJam);
        this.vipCard = vipCard;
    }
    @Override
    public void Informasi() {
        super.Informasi();
        if (vipCard) {
            System.out.println("Benefit member");
            System.out.println("-Diskon 10% untuk bermain di atas 3 jam");
            System.out.println("-Gratis minuman setiap jam bermain");
            System.out.println("-Prioritas booking komputer gaming");
        }
        else {
            System.out.println("nabung lagi ya mas");
        }
    }

    public void Login(String Username) {
        System.out.println("login dengan username: " + Username);
    }

    public void Bermain(int jam) {
        System.out.println(" bermain selama " + jam + " jam ");
    }

    public void Bermain(int jam, int menitTambahan) {
        System.out.println(" nambah billing selama " + jam + " jam " + menitTambahan + "3 menit");
    }
    // To do: Buatlah Method Informasi memakai Polymorphism Override dengan isi yang sesuai dengan ketentuan 
    // (boleh berbeda dengan output jurnal tetapi dengan cangkupan masih sesuai oleh materi modul!)
    
    // To do: Buatlah method Login sesuai dengan ketentuan
    
    // To do: Buatlah method Bermain sesuai dengan ketentuan
    
    // To do: Buatlah method Bermain memakai Polymorphism Overloading sesuai dengan ketentuan

}