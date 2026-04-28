public class Algoritmos1 {

    public int fa(int n) {
        int i, j, k, res = 0;
        int cont_op = 0;

        for (i = 1; i <= n + 1; i++) {
            for (j = 1; j <= i * i; j += i + 1) {
                for (k = i / 2; k <= n + j; k += 2) {
                    res = res + n - 1;
                    cont_op++;
                }
            }
        }

        return cont_op;
    }
}