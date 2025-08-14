public class getSet {
    public static void main (String[] args) {
        Caneta c1 = new Caneta ("BIC", "Vermelha", 0.7f);
        c1.status();
        System.out.println("\n");
        Caneta c2 = new Caneta("Faber", "Rosa", 0.1f);
        c2.status();
    }
}
