import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;

public class Teste2bExercicio3 {
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

         public void imprimeMenores(Node noAtual, T valor) {
             if (noAtual == null) {
                 return;
             }

             if (valor.compareTo(noAtual.value) > 0) {
                 System.out.print(noAtual.value + " ");
                 imprimeMenores(noAtual.left, valor);
                 imprimeMenores(noAtual.right, valor);
             } else {
                 imprimeMenores(noAtual.left, valor);
             }
         }

         public BinaryTree<T> criaArvoreMenores(T valor) {
             BinaryTree<T> arvoreMenores = new BinaryTree<>();
             arvoreMenores.raiz = copiaMenores(raiz, valor);
             return arvoreMenores;
         }

         private Node copiaMenores(Node noAtual, T valor) {
             if (noAtual == null) {
                 return null;
             }

             if (valor.compareTo(noAtual.value) > 0) {
                 Node novoNo = new Node(noAtual.value);

                 novoNo.left = copiaMenores(noAtual.left, valor);
                 novoNo.right = copiaMenores(noAtual.right, valor);

                 return novoNo;
             }

             return copiaMenores(noAtual.left, valor);
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
