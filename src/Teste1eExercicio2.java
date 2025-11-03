public class Teste1eExercicio2 {
    static int pesquisa(int[] arr, int valor) {
        int inicio = 0, fim = arr.length - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (arr[meio] == valor)
                return meio;
            else if (valor < arr[meio])
                fim = meio - 1;
            else
                inicio = meio + 1;
        }
        return -(inicio + 1);
    }

    public static int tamanhoExclusão(int[] m, int[] n) {
        int total = 0;

        for (int i = 0; i < n.length; i++) {
            if (pesquisa(m, n[i]) >= 0)
                total++;
        }

        return total;
    }

    public static int proximo(int m[], int valor) {
        int posicao = pesquisa(m, valor);

        if (posicao >= 0 && posicao < m.length - 1) {
            if (m[posicao + 1] == valor) {
                posicao++;

                if (posicao < m.length - 1) {
                    return m[posicao + 1];
                } else {
                    return valor;
                }
            } else {
                return m[posicao + 1];
            }
        } else {
            int posicaoAbsoluta = Math.abs(posicao + 1);

            if (posicaoAbsoluta < m.length) {
                return m[posicaoAbsoluta];
            } else {
                return valor;
            }
        }
    }
}
