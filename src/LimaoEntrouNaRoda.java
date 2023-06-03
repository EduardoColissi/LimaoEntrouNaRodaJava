import java.util.Random;

public class LimaoEntrouNaRoda {
    private Node<Pessoa> head;
    private int quantidade;


    public LimaoEntrouNaRoda(int quantidade) {
        this.quantidade = quantidade;
        this.head = criarPessoas(quantidade);
    }

    public int passaObjeto(int x) {
        int pos = x % quantidade;
        return pos;
    }

    private Node<Pessoa> criarPessoas(int quantidadePessoas) {
        Random r = new Random();
        Node<Pessoa> primeiro = new Node<>(new Pessoa("Pessoa 1", r.nextInt(100) + 1));
        Node<Pessoa> anterior = primeiro;
        for (int i = 2; i <= quantidadePessoas; i++) {
            Node<Pessoa> atual = new Node<>(new Pessoa("Pessoa " + i, r.nextInt(100) + 1));
            anterior.setNext(atual);
            anterior = atual;
        }
        anterior.setNext(primeiro);
        return primeiro;
    }

    public Pessoa removePosicao(int x) {
        if (head == null || quantidade <= 0 || x < 0 || x >= quantidade) {
            return null;
        }

        Node<Pessoa> current = head;

        for (int i = 0; i < x; i++) {
            current = current.getNext();
        }

        Node<Pessoa> removedNode = current.getNext();
        current.setNext(removedNode.getNext());

        head = current.getNext();
        quantidade--;

        if (quantidade == 1) {
            return head.getElement();
        }

        return null;
    }

    public void imprimeRoda(){
        if (quantidade == 0) {
            return;
        }

        Node<Pessoa> atual = head;
        for (int i = 0; i < quantidade; i++ ){
            System.out.println(atual.getElement().toString());
            atual = atual.getNext();
        }
    }
}