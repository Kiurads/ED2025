import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;

public class Teste2aExercicio2 {
    class ServicoEncomendas {
        PriorityQueue<Encomenda> queue;

        public ServicoEncomendas() {
            queue = new PriorityQueue<>(new Comparator<Encomenda>() {
                @Override
                public int compare(Encomenda o1, Encomenda o2) {
                    if (o1.urgente && !o2.urgente) {
                        return 1;
                    }

                    if (!o1.urgente && o2.urgente) {
                        return -1;
                    }

                    return o2.dataDePedido.compareTo(o1.dataDePedido);
                }
            });
        }
    }
    class Encomenda {
        boolean urgente;
        Date dataDePedido;
    };
}
