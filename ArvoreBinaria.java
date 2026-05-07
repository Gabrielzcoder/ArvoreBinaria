package arvore;

public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
    }

    private boolean estaVazia() {
        if(raiz.getConteudo() == null) {
            return true;
        }else {
            return false;
        }
    }

    public void inserirElemento(Integer conteudo) {
        No novoNo = new No(conteudo);
        if(estaVazia()) {
            this.raiz.setConteudo(conteudo);
            return;
        }else {
            No noAux = encontraCaminho(raiz, conteudo);
            if (noAux.getConteudo() < novoNo.getConteudo()) {
                noAux.setDireita(novoNo);
            } else if(noAux.getConteudo() > novoNo.getConteudo()) {
                noAux.setEsquerda(novoNo);
            } else {
                System.out.println("Esse nó já existe na árvore");
            }
        }
    }

    private No encontraCaminho(No no, Integer conteudo) {
        if(conteudo < no.getConteudo()) {
            if(no.getEsquerda() != null) {
                return encontraCaminho(no.getEsquerda(), conteudo);
            }
            return no;
        }
        if(conteudo > no.getConteudo()) {
            if(no.getDireita() != null) {
                 return encontraCaminho(no.getDireita(), conteudo);
            }
            return no;
        }
        return no;
    }

    public void removerElemento(Integer conteudo) {
        realizarRemocao(raiz, conteudo, raiz);
    }

    private No realizarRemocao(No no, Integer conteudo, No pai) {
        if(conteudo < no.getConteudo()) {
            if(no.getEsquerda() != null) {
                return realizarRemocao(no.getEsquerda(), conteudo, no);
            }else {
                System.out.println("Esse nó não existe na árvore");
                return no;
            }
        }
        if(conteudo > no.getConteudo()) {
            if(no.getDireita() != null) {
                return realizarRemocao(no.getDireita(), conteudo, no);
            }else {
                System.out.println("Esse nó não existe na árvore");
                return no;
            }
        }
        if(no.getEsquerda() != null && no.getDireita()!= null) {
            No maior = antecessor(no.getEsquerda());
            if(no.getConteudo() < pai.getConteudo()) {
                maior.setDireita(no.getDireita());
                pai.setEsquerda(maior);
            }else {
                maior.setDireita(no.getDireita());
                pai.setDireita(maior);
            }
        }
        if(no.getConteudo() < pai.getConteudo()) {
            if(no.getEsquerda() != null){
                pai.setEsquerda(no.getEsquerda());
                return no;
            }
            if(no.getDireita() != null) {
                pai.setEsquerda(no.getDireita());
                return no;
            }
            pai.setEsquerda(null);
        }
        if(no.getConteudo() > pai.getConteudo()) {
            if(no.getEsquerda() != null){
                pai.setDireita(no.getEsquerda());
                return no;
            }
            if(no.getDireita() != null) {
                pai.setDireita(no.getDireita());
                return no;
            }
            pai.setDireita(null);
        }
        return no;
    }

    private No antecessor (No no) {
        if (no.getDireita() == null) {
            return no;
        }
        antecessor(no.getDireita());
        return no;
    }

    public void exibir(Integer percurso) {
        if(estaVazia()) {
            System.out.println("Essa Árvore está vazia");
            return;
        }
        switch(percurso) {
            case(1):
                System.out.println("Exibindo Árvore em PréOrdem:");
                preOrdem(raiz);
                break;
            case(2):
                System.out.println("Exibindo Árvore em EmOrdem:");
                emOrdem(raiz);
                break;
            case(3):
                System.out.println("Exibindo Árvore em PósOrdem:");
                posOrdem(raiz);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }
    private void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }
    private void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }
}
