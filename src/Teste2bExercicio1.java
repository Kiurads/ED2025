import java.util.HashMap;
import java.util.HashSet;

public class Teste2bExercicio1 {
    class DadosJogos {
        private HashMap<String, Integer> assistenciasEmCasa;
        private HashMap<String, HashSet<String>> visitantesPorEquipa;

        public DadosJogos() {
            assistenciasEmCasa = new HashMap<>();
            visitantesPorEquipa = new HashMap<>();
        }

        public void defineJogo(String eqCasa, String eqVisitante, int assistencia) {
            assistenciasEmCasa.put(eqCasa, assistenciasEmCasa.getOrDefault(eqCasa, 0) + assistencia);

            if (!visitantesPorEquipa.containsKey(eqCasa)) {
                visitantesPorEquipa.put(eqCasa, new HashSet<>());
            }

            visitantesPorEquipa.get(eqCasa).add(eqVisitante);
        }

        public int getAssistenciaTotalEmCasa(String nomeEquipa) {
            return assistenciasEmCasa.getOrDefault(nomeEquipa, -1);
        }

        public HashSet<String> getEquipasVisitantes(String nomeEquipa) {
            return visitantesPorEquipa.getOrDefault(nomeEquipa, null);
        }
    }
}
