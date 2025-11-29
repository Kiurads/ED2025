import java.util.*;

public class Teste2bExercicio2 {
    class FilaAuditorias {
        private PriorityQueue<Organizacao> queue;

        public FilaAuditorias() {
            queue = new PriorityQueue<>(new Comparator<Organizacao>() {
                @Override
                public int compare(Organizacao o1, Organizacao o2) {
                    if (o1.numeroQueixas > o2.numeroQueixas) {
                        return 1;
                    }

                    if (o2.numeroQueixas > o1.numeroQueixas) {
                        return -1;
                    }

                    return o1.dataUltimaAuditoria.compareTo(o2.dataUltimaAuditoria);
                }
            });
        }

    }

    class Organizacao {
        private int numeroQueixas;
        private Date dataUltimaAuditoria;
    };

}
