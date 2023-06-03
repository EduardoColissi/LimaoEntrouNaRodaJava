import java.util.Random;

public class PrincipalLimao {
    public static void main(String[] args) {
        LimaoEntrouNaRoda l = new LimaoEntrouNaRoda(10);
        l.imprimeRoda();
        System.out.println("*****");
        boolean acabou = false;
        Pessoa p = null;
        while(!acabou){
            Random r = new Random();
            int posicao = l.passaObjeto(r.nextInt(100 + 1));
            p = l.removePosicao(posicao);
            l.imprimeRoda();
            System.out.println("************");
            acabou = p != null;
        }
        System.out.println(p);
    }
}
