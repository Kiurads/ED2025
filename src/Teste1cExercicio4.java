import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Teste1cExercicio4 {
    static class Jogo implements Iterable<String> {
        String equipa1, equipa2;
        List<String> jogEquipa1 = new ArrayList<>();
        List<String> jogEquipa2 = new ArrayList<>();

        public void setEquipas(String n1, String n2) {
            equipa1 = n1;
            equipa2 = n2;
        }

        public void addJogadorVisitado(String nome) {
            jogEquipa1.add(nome);
        }

        public void addJogadorVisitante(String nome) {
            jogEquipa2.add(nome);
        }

        public int getNumeroJogadoresVisitantes() {
            return jogEquipa2.size();
        }

        public int getNumeroJogadoresVisitados() {
            return jogEquipa1.size();
        }

        public String getJogadorVisitado(int idx) {
            return jogEquipa1.get(idx);
        }

        public String getJogadorVisitante(int idx) {
            return jogEquipa2.get(idx);
        }

        public String getEquipa1() {
            return equipa1;
        }

        public String getEquipa2() {
            return equipa2;
        }

        @Override
        public Iterator<String> iterator() {
            return new JogoIterator();
        }

        private class JogoIterator implements Iterator<String> {
            int indiceVisitantes = -1;
            int indiceVisitados = -1;

            @Override
            public boolean hasNext() {
                return indiceVisitantes < getNumeroJogadoresVisitantes() - 1 || indiceVisitados < getNumeroJogadoresVisitados() - 1;
            }

            @Override
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Não existem mais dados");
                }

                if (indiceVisitados == -1) {
                    indiceVisitados = 0;
                    return getEquipa1();
                } else if (indiceVisitados < getNumeroJogadoresVisitados() - 1) {
                    return getJogadorVisitado(indiceVisitados++);
                } else if (indiceVisitantes == -1) {
                    indiceVisitantes = 0;
                    return getEquipa2();
                } else {
                    return getJogadorVisitante(indiceVisitantes++);
                }
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Não pode remover elementos do jogo");
            }
        }
    }
}
