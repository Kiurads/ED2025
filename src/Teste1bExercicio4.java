import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Teste1bExercicio4 {
    static class Pessoa implements Iterable<String>{
        final private String nome;
        final private String morada;

        public Pessoa(String nome, String morada) {
            this.nome = nome;
            this.morada = morada;
        }

        @Override
        public Iterator<String> iterator() {
            return new PessoaStringIterator();
        }

        private class PessoaStringIterator implements Iterator<String> {
            String valor;

            @Override
            public boolean hasNext() {
                return !valor.equals(morada);
            }

            @Override
            public String next() {
                if (valor.isEmpty()) {
                    valor = nome;
                } else if (valor.equals(nome)) {
                    valor = morada;
                } else {
                    throw new NoSuchElementException("Não existem mais dados");
                }

                return valor;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Não é permitido apagar valores");
            }
        }
    }
}
