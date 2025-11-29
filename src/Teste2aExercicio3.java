import java.util.Stack;

public class Teste2aExercicio3 {
     class BinaryTree<T extends Comparable<? super T>> {
         class Node {
             T value;
             Node left, right;

             Node(T t) {
                 value = t;
                 left = right = null;
             }
         }

         private Node raiz;

         public BinaryTree() {
            raiz = null;
         }

         public void imprimeArvoreNaoRecursivo() {
             Stack<Node> stack = new Stack<>();
             Node noAtual = raiz;

             while (noAtual != null || !stack.isEmpty()) {
                 while (noAtual != null) {
                     stack.push(noAtual);
                     noAtual = noAtual.left;
                 }

                 noAtual = stack.pop();
                 System.out.println(noAtual.value);
                 noAtual = noAtual.right;
             }
         }

         public void removeNos(T valor) {
             raiz = removeNosMenores(raiz, valor);
         }

         private Node removeNosMenores(Node noAtual, T valor) {
            if (noAtual == null) {
                return null;
            }

            if (valor.compareTo(noAtual.value) <= 0) {
                noAtual.left = removeNosMenores(noAtual.left, valor);
                noAtual.right = removeNosMenores(noAtual.right, valor);

                return noAtual;
            }

            return removeNosMenores(noAtual.right, valor);
         }

         public Node novoNo(T valor) {
             if (raiz == null) {
                 raiz = new Node(valor);
                 return raiz;
             }

             Node noAtual = raiz;

             do {
                 if (valor.compareTo(noAtual.value) == 0) {
                     return null;
                 }
                 
                 if (valor.compareTo(noAtual.value) < 0) {
                     if (noAtual.left != null) {
                         noAtual = noAtual.left;
                         continue;
                     } else {
                         noAtual.left = new Node(valor);
                         noAtual = noAtual.left;
                         break;
                     }
                 }
                 if (valor.compareTo(noAtual.value) > 0) {
                     if (noAtual.right != null) {
                         noAtual = noAtual.right;
                         continue;
                     } else {
                         noAtual.right = new Node(valor);
                         noAtual = noAtual.right;
                         break;
                     }
                 }
             } while (true);

             return noAtual;
         }
     }

    }
