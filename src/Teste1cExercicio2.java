public class Teste1cExercicio2 {
    public static boolean pesquisa(int[] m, int valorX, int valorY) {
        int min = 0;
        int max = (m.length / 2) - 1;

        while (min <= max) {
            int meio = (max + min) / 2;
            int meioX = meio * 2;
            int meioY = meioX + 1;

            if (m[meioX] == valorX) {
                if (m[meioY] == valorY) {
                    return true;
                } else {
                    if (m[meioY] > valorY) {
                        max = meio - 1;
                    } else {
                        min = meio + 1;
                    }
                }
            } else {
                if (m[meioX] > valorX) {
                    max = meio - 1;
                } else {
                    min = meio + 1;
                }
            }
        }

        return false;
    }
}
