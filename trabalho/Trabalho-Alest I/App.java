public class App {
    public static void main(String[] args) {
        Algoritmos5 f = new Algoritmos5();

        for (int n = 0; n <= 20; n++) {
            int r = f.fa(n);
            System.out.println(n + ";" + r);
        }
    }
}