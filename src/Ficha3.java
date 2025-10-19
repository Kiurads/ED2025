public class Ficha3 {

    // -----------------------------
    // 1. Comparação por referência
    // -----------------------------
    public static <T> boolean apareceMaisDeUmaVezPorReferencia(T[] array, T elemento) {
        int contador = 0;
        for (T item : array) {
            if (item == elemento) { // comparação por referência
                contador++;
                if (contador > 1) return true;
            }
        }
        return false;
    }

    // -----------------------------
    // 2. Comparação com compareTo
    // -----------------------------
    public static <T extends Comparable<T>> boolean apareceMaisDeUmaVezPorComparacao(T[] array, T elemento) {
        int contador = 0;
        for (T item : array) {
            if (item.compareTo(elemento) == 0) {
                contador++;
                if (contador > 1) return true;
            }
        }
        return false;
    }

    // -----------------------------
    // 3. Hierarquia Figura / Rectangulo
    // -----------------------------

    // Classe abstrata Figura
    static abstract class Figura implements Comparable<Figura> {
        public abstract double area();

        @Override
        public int compareTo(Figura outra) {
            return Double.compare(this.area(), outra.area());
        }
    }

    // Subclasse Rectangulo
    static class Rectangulo extends Figura {
        private double largura, altura;

        public Rectangulo(double largura, double altura) {
            this.largura = largura;
            this.altura = altura;
        }

        @Override
        public double area() {
            return largura * altura;
        }

        @Override
        public String toString() {
            return "Rectangulo(" + largura + ", " + altura + ")";
        }
    }

    public static int compararFiguras(Figura f1, Figura f2) {
        return f1.compareTo(f2);
    }

    public static <T> int compararRectangulo(Rectangulo r, T outro) {
        if (outro instanceof Comparable<?>) {
            Comparable<T> comp = (Comparable<T>) outro;
            try {
                return -comp.compareTo((T) r); // inverte sinal para manter coerência
            } catch (ClassCastException e) {
                System.out.println("Tipos incompatíveis!");
                return 0;
            }
        }
        throw new IllegalArgumentException("O objeto não é comparável com Rectangulo.");
    }

    public static <T extends Comparable<? super T>> int comparar(T obj1, T obj2) {
        return obj1.compareTo(obj2);
    }

    // -----------------------------
    // 4. Método search
    // -----------------------------
    public static <T extends Comparable<T>> boolean search(T[] array, T valor) {
        for (T elemento : array) {
            if (elemento.compareTo(valor) > 0) return true;
        }
        return false;
    }

    // -----------------------------
    // 5. Classe Ponto com genéricos
    // -----------------------------
    static class Ponto<X extends Number, Y extends Number> {
        private X x;
        private Y y;

        public Ponto(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        public void copy(Ponto<? extends X, ? extends Y> outro) {
            this.x = outro.x;
            this.y = outro.y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    public static void test() {
        System.out.println("\n=== 1. Por referência ===");
        String a = "ola";
        String b = new String("ola");
        String c = a;
        String[] array1 = {a, b, c};
        System.out.println(apareceMaisDeUmaVezPorReferencia(array1, a)); // true

        System.out.println("\n=== 2. Por compareTo ===");
        Integer[] nums = {1, 2, 3, 2, 4};
        System.out.println(apareceMaisDeUmaVezPorComparacao(nums, 2)); // true

        System.out.println("\n=== 3. Figura / Rectangulo ===");
        Rectangulo r1 = new Rectangulo(2, 3);
        Rectangulo r2 = new Rectangulo(4, 1);
        System.out.println("Comparar figuras: " + compararFiguras(r1, r2)); // compara por área
        System.out.println("Comparar rectângulo com outro: " + compararRectangulo(r1, r2));

        System.out.println("\n=== 4. Metodo Search ===");
        Integer m[] = {3, 2, 6, 3};
        String n[] = {"Ada", "Albino"};
        System.out.println(search(m, 2));         // true
        System.out.println(search(n, "Francisco"));// false

        System.out.println("\n=== 5. Ponto ===");
        Ponto<Integer, Integer> p = new Ponto<>(3, 4);
        Ponto<Number, Number> x = new Ponto<>(0, 0);
        System.out.println(p); // (3,4)
        System.out.println(x); // (0,0)
        x.copy(p);
        System.out.println(x); // (3,4)
        // Ponto<String, Integer> erro = new Ponto<>("olá", 3); // erro de compilação
    }
}
