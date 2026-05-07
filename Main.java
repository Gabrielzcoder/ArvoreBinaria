package arvore;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserirElemento(5);
        arvore.inserirElemento(3);
        arvore.inserirElemento(7);
        arvore.inserirElemento(2);
        arvore.inserirElemento(6);
        arvore.inserirElemento(10);

        System.out.println("Escolha um percurso: ");
        System.out.println("[ 1 ] PréOrdem");
        System.out.println("[ 2 ] EmOrdem");
        System.out.println("[ 3 ] PósOrdem");
        int op = sc.nextInt();
        arvore.exibir(op);

        arvore.removerElemento(7);

        arvore.exibir(1);
    }
}
