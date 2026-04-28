public class Algoritmos2 {

    public int fa(int n) {
        int i, j, k, res = 0;
        int cont_op = 0;

        for (i = n; i <= n; i += i / 2 + 1) {
            for (j = i / 2; j <= i * i; j += i + 1) {
                for (k = n; k <= 2 * n; k += i + 1) {
                    res = res + n;
                    cont_op++;
                }
            }
        }

        return cont_op;
    }
}