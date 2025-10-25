import java.util.List;
import java.util.ListIterator;

public class Ficha5 {
    // ----------------
    // 1. Fill the list
    // ----------------
    public static <T> void exercicio1(List<T> list, T value) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, value);
        }
    }

    // ---------------------------------
    // 2. Iterate list and print reverse
    // ---------------------------------
    public static <T> void exercicio2(List<T> list) {
        ListIterator<T> iterator = list.listIterator(list.size() - 1);

        while (iterator.hasPrevious()) {
            System.out.print(iterator.previous());
        }
    }






}
