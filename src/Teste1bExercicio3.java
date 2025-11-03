import java.util.ArrayList;
import java.util.Iterator;

public class Teste1bExercicio3 {
    static <T extends Comparable<? super T>> void f(ArrayList<T> array, T valor) {
        Iterator<T> iterator = array.iterator();

        while (iterator.hasNext()) {
            T atual = iterator.next();

            if (valor.compareTo(atual) > 0) {
                iterator.remove();
            }
        }
    }
}
