import java.util.List;
import java.util.ListIterator;

public class Teste1eExercicio3 {
    public static <T extends Comparable<? super T>> void f(List<T> primeiro, List<T> segundo) {
        T menor = segundo.getFirst();

        for (int i = 1; i < segundo.size(); i++) {
            if (menor.compareTo(segundo.get(i)) > 0) menor = segundo.get(i);
        }

        ListIterator<T> iteratorPrimeiro = primeiro.listIterator();

        while(iteratorPrimeiro.hasNext()) {
            if (iteratorPrimeiro.next().compareTo(menor) < 0)
                iteratorPrimeiro.remove();
        }
    }
}
