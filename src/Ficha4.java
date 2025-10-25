import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Ficha4 {
    static class DezReais implements Iterable<Double> {
        ArrayList<Double> array;

        public DezReais() {
            array = new ArrayList<>();
        }

        public void add(Double x) throws ArrayIndexOutOfBoundsException {
            if (array.size() < 10) {
                array.add(x);
            } else {
                throw new ArrayIndexOutOfBoundsException("O tamanho máximo é de 10 elementos");
            }
        }

        @Override
        public Iterator<Double> iterator() {
            return new DezReaisIterator();
        }

        private class DezReaisIterator implements Iterator<Double> {
            private int indice = 0;

            @Override
            public boolean hasNext() {
                return indice < array.size();
            }

            @Override
            public Double next() {
                if (hasNext())
                    return array.get(indice++);
                throw new NoSuchElementException("O array não tem mais elementos");
            }
        }
    }

    public static void teste() {
        DezReais dezReais = new DezReais();

        for (int i = 0; i < 10; i++) {
            dezReais.add((double) i / 10);
        }

        Iterator<Double> iterator = dezReais.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        /*
        try {
            dezReais.add(1.0);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Deu coco: " + e.getMessage());
        } finally {
            System.out.println("Cheguei ao fim");
        }
        */
    }
}
