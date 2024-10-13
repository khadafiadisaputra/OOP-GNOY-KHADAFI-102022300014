

import java.util.ArrayList;
import java.util.InputMismatchException;
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
            
            try {
                pilihanMenu = scanner.nextInt();
                scanner.nextLine(); // Konsumsi newline setelah nextInt()

                switch (pilihanMenu) {
                    case 1:
                        tampilkanDaftarPenerbangan(daftarPenerbangan);
                        break;
                    case 2:
                        beliTiket(scanner, daftarPenerbangan);
                        break;
                    case 3:
                        tampilkanPesanan();
                        break;
                    case 4:
                        System.out.println("Terima kasih!");
                        break;
                    default:
                        System.out.println("Menu tidak valid!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid! Harap masukkan angka.");
                scanner.nextLine(); // Membersihkan input yang salah
                pilihanMenu = 0; // Menghindari exit
            }

        } while (pilihanMenu != 4);

        scanner.close();
    }

    private static void tampilkanDaftarPenerbangan(ArrayList<Penerbangan> daftarPenerbangan) {
        System.out.println("\nDaftar Penerbangan yang Tersedia:");
        for (int i = 0; i < daftarPenerbangan.size(); i++) {
            System.out.println((i + 1) + ". ");
            daftarPenerbangan.get(i).tampilDaftarPenerbangan();
        }
    }

    private static void beliTiket(Scanner scanner, ArrayList<Penerbangan> daftarPenerbangan) {
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

        tampilkanDaftarPenerbangan(daftarPenerbangan);

        System.out.print("Pilih nomor penerbangan (ex: 1): ");
        int pilihanPenerbangan = -1;

        try {
            pilihanPenerbangan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline setelah nextInt()
            if (pilihanPenerbangan <= 0 || pilihanPenerbangan > daftarPenerbangan.size()) {
                System.out.println("Nomor penerbangan tidak valid.");
            } else {
                penerbanganDipilih = daftarPenerbangan.get(pilihanPenerbangan - 1);
                System.out.println("Pemesanan Tiket Berhasil Dilakukan. Cek Pesanan Tiket pada Menu (3)");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid! Harap masukkan angka.");
            scanner.nextLine(); // Membersihkan input yang salah
        }
    }

    private static void tampilkanPesanan() {
        if (penumpangTerdaftar != null && penerbanganDipilih != null) {
            System.out.println("====== Detail Tiket Penerbangan =======");
            penumpangTerdaftar.tampilDaftarPenumpang();
            penerbanganDipilih.tampilDaftarPenerbangan();
        } else {
            System.out.println("Pembelian Tiket Tidak Ada atau Data Penumpang Belum Lengkap.");
        }
    }
}
