import java.util.Iterator;
import java.util.NoSuchElementException;

public class Teste1eExercicio4 {
    static class MinhaString implements Iterable<Character> {
        private String string;

        public MinhaString(String s) {
            string = s;
        }

        @Override
        public Iterator<Character> iterator() {
            return new MinhaStringIterator();
        }

        private class MinhaStringIterator implements Iterator<Character> {
            private int indice = 0;

            @Override
            public boolean hasNext() {
                while (indice < string.length() - 1 &&
                        string.charAt(indice) == ' ' &&
                        string.charAt(indice + 1) == ' ') {
                    indice++;
                }
                return indice < string.length();
            }

            @Override
            public Character next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("String chegou ao fim");
                }
                return string.charAt(indice++);
            }
        }
    }

    public static void teste() {
        MinhaString minhaStr = new MinhaString("    A  casa  é  azul      ");

        System.out.println("Iterando sobre a string (ignorando espaços múltiplos):");

        for (char c : minhaStr) {
            System.out.print(c);
        }

        System.out.println("\nTeste concluído!");
    }
}
