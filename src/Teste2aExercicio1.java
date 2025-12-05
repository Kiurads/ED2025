import java.util.HashMap;

public class Teste2aExercicio1 {
    class GestorCidades {
        private HashMap<String, Integer> cidades;

        public GestorCidades() {
            cidades = new HashMap<>();
        }

        public void defineCidade(String nome1, int populacao) {
            cidades.put(nome1, populacao);
        }

        public void migracao(String origem, String destino, int quantos) {
            if (!cidades.containsKey(origem) || !cidades.containsKey(destino)) {
                return;
            }

            if (cidades.get(origem) < quantos) {
                return;
            }

            cidades.put(origem, cidades.get(origem) - quantos);
            cidades.put(destino, cidades.get(destino) + quantos);
        }

        public int getPopulacao(String cidade) {
            return cidades.get(cidade);
        }
    }
}
