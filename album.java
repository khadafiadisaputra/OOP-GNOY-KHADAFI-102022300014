public class album {
    int Rented, Total;
    String Namaartis, Judul;

    public album(int Rented, int Total, String Namaartis, String Judul) {
        this.Rented = Rented;
        this.Total = Total;
        this.Namaartis = Namaartis;
        this.Judul = Judul;
    }
    public int getRented() {
        return Rented;
    }

    public int getTotal() {
        return Total;
    }

    public void setRented(int Rented) {
        this.Rented = Rented;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }


    public String getNamaartis() {
        return Namaartis;
    }

    public String getJudul() {
        return Judul;
    }

    public void setNamaartis(String Namaartis) {
        this.Namaartis = Namaartis;
    }

    public void setJudul(String Judul) {
        this.Judul = Judul;
    }

    

}
