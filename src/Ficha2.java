import java.util.*;

public class Ficha2 {
    // -------------------- EXERCÍCIO BASE --------------------
    static int[] criaArrayCom(int valor, int dimensao, boolean diferentes) {
        int[] m = new int[dimensao];
        if (diferentes) {
            for (int i = 0; i < dimensao; i++)
                m[i] = i * 10;
            if ((valor % 10 != 0) || (0 > valor) || (valor > (dimensao - 1) * 10))
                m[0] = valor;
        } else {
            Random r = new Random();
            int gama = Math.max(Math.abs(valor), 10);
            for (int i = 0; i < dimensao; i++)
                m[i] = r.nextInt(gama * 4) - gama * 2;
            m[0] = valor;
        }
        Arrays.sort(m);
        return m;
    }

    // -------------------- 1. Pesquisa binária recursiva --------------------
    static boolean pesquisaBinariaRecursiva(int[] arr, int valor, int inicio, int fim) {
        if (inicio > fim)
            return false;

        int meio = (inicio + fim) / 2;

        if (arr[meio] == valor)
            return true;
        else if (valor < arr[meio])
            return pesquisaBinariaRecursiva(arr, valor, inicio, meio - 1);
        else
            return pesquisaBinariaRecursiva(arr, valor, meio + 1, fim);
    }

    // -------------------- 2. Pesquisa binária iterativa --------------------
    static boolean pesquisaBinariaIterativa(int[] arr, int valor) {
        int inicio = 0, fim = arr.length - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (arr[meio] == valor)
                return true;
            else if (valor < arr[meio])
                fim = meio - 1;
            else
                inicio = meio + 1;
        }
        return false;
    }

    // -------------------- 3. Pesquisa binária com posição --------------------
    static int pesquisaBinariaPosicao(int[] arr, int valor) {
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
        return -1;
    }

    // -------------------- 4. Pesquisa binária com posição de inserção --------------------
    static int pesquisaBinariaInsercao(int[] arr, int valor) {
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

    // -------------------- 5. Percentagem de valores menores --------------------
    static double percentagemMenores(int[] arr, int valor) {
        int pos = pesquisaBinariaInsercao(arr, valor);
        int countMenores = (pos >= 0) ? pos : Math.abs(pos + 1);
        return (double) countMenores / arr.length;
    }

    // -------------------- 6. Quantos valores dentro de intervalo --------------------
    static int contaValoresNoIntervalo(int[] arr, int min, int max) {
        int posMin = pesquisaBinariaInsercao(arr, min);
        int posMax = pesquisaBinariaInsercao(arr, max);

        int start = (posMin >= 0) ? posMin : Math.abs(posMin + 1);
        int end = (posMax >= 0) ? posMax : Math.abs(posMax + 1) - 1;

        if (start > end) return 0;
        return end - start + 1;
    }

    // -------------------- 7. Verifica se valor está repetido --------------------
    static boolean valorRepetido(int[] arr, int valor) {
        int pos = pesquisaBinariaPosicao(arr, valor);
        if (pos == -1) return false;
        boolean temAnterior = (pos > 0 && arr[pos - 1] == valor);
        boolean temSeguinte = (pos < arr.length - 1 && arr[pos + 1] == valor);
        return temAnterior || temSeguinte;
    }

    // -------------------- 8. Maior elemento menor que Z --------------------
    static int maiorMenorQueZ(int[] arr, int z) {
        int pos = pesquisaBinariaInsercao(arr, z);
        if (pos >= 0) {
            // valor encontrado → devolve o anterior se existir
            return (pos > 0) ? arr[pos - 1] : z;
        } else {
            int insercao = Math.abs(pos + 1);
            if (insercao == 0) return z;
            return arr[insercao - 1];
        }
    }

    // -------------------- 9. Pesquisa em array com positivos seguidos de negativos --------------------
    // Exemplo: {3,6,8, -10,-3,-2,-1}
    static boolean pesquisaPosNeg(int[] arr, int valor) {
        // encontra ponto onde começam os negativos (primeiro < 0)
        int inicioNeg = 0;
        int inicio = 0, fim = arr.length - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (arr[meio] < 0) {
                inicioNeg = meio;
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }

        if (valor >= 0)
            return pesquisaBinariaIterativa(Arrays.copyOfRange(arr, 0, inicioNeg), valor);
        else
            return pesquisaBinariaIterativa(Arrays.copyOfRange(arr, inicioNeg, arr.length), valor);
    }

    // -------------------- 10. Índice da primeira posição com valor > índice --------------------
    static int indicePrimeiroValorMaiorQueIndice(int[] arr) {
        int inicio = 0, fim = arr.length - 1, resultado = -1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (arr[meio] > meio) {
                resultado = meio;
                fim = meio - 1; // procurar mais à esquerda
            } else {
                inicio = meio + 1;
            }
        }
        return resultado;
    }

    // -------------------- MAIN DE TESTE --------------------
    public static void teste() {
        int[] arr = {3, 7, 12, 15};
        System.out.println("Array base: " + Arrays.toString(arr));

        System.out.println("\n=== Exercício 1: Pesquisa Binária Recursiva ===");
        for (int v : new int[]{12, 5, 15, 1})
            System.out.println("Valor=" + v + " -> " + pesquisaBinariaRecursiva(arr, v, 0, arr.length - 1));

        System.out.println("\n=== Exercício 2: Pesquisa Binária Iterativa ===");
        for (int v : new int[]{12, 5, 15, 1})
            System.out.println("Valor=" + v + " -> " + pesquisaBinariaIterativa(arr, v));

        System.out.println("\n=== Exercício 3: Pesquisa Binária (posição) ===");
        for (int v : new int[]{12, 5, 15, 1})
            System.out.println("Valor=" + v + " -> posição=" + pesquisaBinariaPosicao(arr, v));

        System.out.println("=== Exercício 4 ===");
        int[] arr4 = {3, 7, 12, 15};
        int[] valores = {15, 3, 1, 4, 10, 13, 16};
        for (int v : valores) {
            int r = pesquisaBinariaInsercao(arr4, v);
            System.out.print("Valor = " + v + " -> " + r);
            if (r < 0) System.out.print(" (inserir em " + Math.abs(r + 1) + ")");
            System.out.println();
        }

        System.out.println("\n=== Exercício 5 ===");
        for (int v : new int[]{15, 14, 3, 1, 100})
            System.out.println("Valor=" + v + " -> " + percentagemMenores(arr4, v));

        System.out.println("\n=== Exercício 6 ===");
        int[][] intervalos = {{0, 15}, {3, 7}, {4, 14}, {4, 5}, {0, 100}};
        for (int[] inter : intervalos)
            System.out.println("(" + inter[0] + "," + inter[1] + ") -> " + contaValoresNoIntervalo(arr4, inter[0], inter[1]));

        System.out.println("\n=== Exercício 7 ===");
        int[] arr7 = {3, 3, 7, 12, 12, 15};
        for (int v : new int[]{15, 14, 12, 3})
            System.out.println("Valor=" + v + " -> repetido=" + valorRepetido(arr7, v));

        System.out.println("\n=== Exercício 8 ===");
        for (int v : new int[]{15, 14, 3, 1, 100})
            System.out.println("Valor=" + v + " -> " + maiorMenorQueZ(arr4, v));

        System.out.println("\n=== Exercício 9 ===");
        int[] arr9 = {3, 6, 8, -10, -3, -2, -1};
        for (int v : new int[]{8, -3, 5, -2, 0, -10})
            System.out.println("Valor=" + v + " -> encontrado=" + pesquisaPosNeg(arr9, v));

        System.out.println("\n=== Exercício 10 ===");
        int[][] arrays10 = {
                {3, 7, 12, 15},
                {-3, 1, 7, 12, 15},
                {-15, -14, 1, 2, 3, 4}
        };
        for (int[] a : arrays10)
            System.out.println(Arrays.toString(a) + " -> índice=" + indicePrimeiroValorMaiorQueIndice(a));
    }
}
