public class burung extends Hewan {
    private String warnaBulu;

    public burung(String nama, int umur, String warnaBulu) {
        super(nama, umur);
        this.warnaBulu = warnaBulu;
    }
    @Override
    public void suara() {
        System.out.println(nama + " bersuara.");
    }
    @Override
    public void infoHewan() {
        super.infoHewan();
        System.out.println("warna: " + warnaBulu);
    }
    
}
