import java.util.Iterator;
import java.util.List;

public class Teste1cExercicio3 {
    public static <T extends Comparable<T>> int contaUnicos(List<T> lista) {
        if (lista.isEmpty()) {
            return 0;
        }

        int contador = 1;

        Iterator<T> iterator = lista.iterator();

        T anterior = iterator.next();

        while (iterator.hasNext()) {
            T atual = iterator.next();

            if (anterior.compareTo(atual) != 0) {
                contador++;
            }

            anterior = atual;
        }

        // for (int i = 0; i < lista.size() - 1; i++) {
        //     if (lista.get(i).compareTo(lista.get(i + 1)) != 0) {
        //         contador++;
        //     }
        // }

        return contador;
    }
}
