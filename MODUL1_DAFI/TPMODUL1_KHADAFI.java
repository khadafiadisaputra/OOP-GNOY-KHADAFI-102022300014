Package MODUL1_DAFI;

import java.util.ArrayList;
import java.util.Scanner;

class Penerbangan {
    private String nomorPenerbangan;
    private String bandaraKeberangkatan;
    private String bandaraTujuan;
    private String waktuKeberangkatan;
    private String waktuKedatangan;
    private float hargaTiket;

    public Penerbangan(String nomorPenerbangan, String bandaraKeberangkatan, String bandaraTujuan, String waktuKeberangkatan, String waktuKedatangan, float hargaTiket) {
        this.nomorPenerbangan = nomorPenerbangan;
        this.bandaraKeberangkatan = bandaraKeberangkatan;
        this.bandaraTujuan = bandaraTujuan;
        this.waktuKeberangkatan = waktuKeberangkatan;
        this.waktuKedatangan = waktuKedatangan;
        this.hargaTiket = hargaTiket;
    }

    public String getNomorPenerbangan() {
        return nomorPenerbangan;
    }

    public String getBandaraKeberangkatan() {
        return bandaraKeberangkatan;
    }

    public String getBandaraTujuan() {
        return bandaraTujuan;
    }

    public String getWaktuKeberangkatan() {
        return waktuKeberangkatan;
    }

    public String getWaktuKedatangan() {
        return waktuKedatangan;
    }

    public float getHargaTiket() {
        return hargaTiket;
    }

    public void tampilDaftarPenerbangan() {
        System.out.println("Nomor Penerbangan: " + nomorPenerbangan);
        System.out.println("Bandara Keberangkatan: " + bandaraKeberangkatan + " ---> Bandara Tujuan: " + bandaraTujuan);
        System.out.println("Waktu Keberangkatan: " + waktuKeberangkatan + " ---> Waktu Kedatangan: " + waktuKedatangan);
        System.out.println("Harga Tiket: Rp." + hargaTiket);
        System.out.println();
    }
}

class Penumpang {
    private String NIK;
    private String namaDepan;
    private String namaBelakang;

    public Penumpang(String NIK, String namaDepan, String namaBelakang) {
        this.NIK = NIK;
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
    }

    public void tampilDaftarPenumpang() {
        System.out.println("Nomor Induk Kependudukan: " + NIK);
        System.out.println("Nama Depan: " + namaDepan);
        System.out.println("Nama Belakang: " + namaBelakang);
        System.out.println();
    }
}

public class TPMODUL1_KHADAFI {
    private static Penumpang penumpangTerdaftar;
    private static Penerbangan penerbanganDipilih;

    public static void main(String[] args) {
        ArrayList<Penerbangan> daftarPenerbangan = new ArrayList<>();
        daftarPenerbangan.add(new Penerbangan("GA101", "CGK, Jakarta", "DPS, Bali", "06:30", "08:15", 1200000));
        daftarPenerbangan.add(new Penerbangan("QZ202", "SUB, Surabaya", "KNO, Medan", "09:00", "11:45", 1350000));

        Scanner scanner = new Scanner(System.in);
        int pilihanMenu;

        do {
            System.out.println("====== EAD Ticket Booking System =======");
            System.out.println("1. Tampilkan Daftar Penerbangan");
            System.out.println("2. Beli Tiket");
            System.out.println("3. Tampilkan Pesanan Tiket");
            System.out.println("4. Exit");
            System.out.print("Silahkan pilih menu: ");
            pilihanMenu = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline setelah nextInt()

            switch (pilihanMenu) {
                case 1:
                    // Tampilkan daftar penerbangan
                    System.out.println("\nDaftar Penerbangan yang Tersedia:");
                    for (int i = 0; i < daftarPenerbangan.size(); i++) {
                        System.out.println((i + 1) + ". ");
                        daftarPenerbangan.get(i).tampilDaftarPenerbangan();
                    }
                    break;
                case 2:
                    // Beli tiket
                    if (penumpangTerdaftar == null) {
                        System.out.println("Silahkan isi data diri Anda terlebih dahulu!\n----------------------");
                        System.out.print("Masukkan NIK: ");
                        String NIK = scanner.nextLine();
                        System.out.print("Masukkan Nama Depan: ");
                        String namaDepan = scanner.nextLine();
                        System.out.print("Masukkan Nama Belakang: ");
                        String namaBelakang = scanner.nextLine();
                        penumpangTerdaftar = new Penumpang(NIK, namaDepan, namaBelakang);
                        System.out.println("\nTerima Kasih telah mengisi data Pelanggan.");
                    }

                    // Pilih penerbangan
                    System.out.println("Silahkan pilih tiket penerbangan yang tersedia:");
                    for (int i = 0; i < daftarPenerbangan.size(); i++) {
                        System.out.println((i + 1) + ". ");
                        daftarPenerbangan.get(i).tampilDaftarPenerbangan();
                    }
                    System.out.print("Pilih nomor penerbangan (ex: 1): ");
                    int pilihanPenerbangan = scanner.nextInt();
                    scanner.nextLine(); // Konsumsi newline setelah nextInt()

                    penerbanganDipilih = daftarPenerbangan.get(pilihanPenerbangan - 1);
                    System.out.println("Pemesanan Tiket Berhasil Dilakukan. Cek Pesanan Tiket pada Menu (3)");
                    break;
                case 3:
                    // Tampilkan pesanan tiket
                    if (penerbanganDipilih != null) {
                        System.out.println("====== Detail Tiket Penerbangan =======");
                        penumpangTerdaftar.tampilDaftarPenumpang();
                        penerbanganDipilih.tampilDaftarPenerbangan();
                    } else {
                        System.out.println("Pembelian Tiket Tidak Ada");
                    }
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Menu tidak valid!");
                    break;
            }
        } while (pilihanMenu != 4);

        scanner.close();
    }
}
