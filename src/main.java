public class main {
    public static void main(String[] args) {
        
        System.out.println("Detail Hewan\n");

        Hewan kucing = new kucing("aghsan", 19, "local");
        System.out.println("ini adalah " + kucing.nama + " !");
        kucing.suara();
        kucing.makan();
        kucing.makan(" royal canin");
        

        System.out.println("\n");
        Hewan burung = new burung("imam", 19, "kuning");
        System.out.println("ini adalah " + burung.nama + " !");
        burung.suara();
        burung.makan();
        burung.makan(" maggot");

        System.out.println("\n");
        kucing.infoHewan();
        burung.infoHewan();
    }
}