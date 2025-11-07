//importar
import java.util.Random;


//criar classe dado
public class Dado {
    private final int lados = 6;
    private int valorAtual;
    private static final Random random = new Random();

    //motodo para lancar o dado
    public int lancar() {
        this.valorAtual = random.nextInt(lados) + 1; // [0, 5] + 1 -> [1, 6]
        return this.valorAtual;
    }
    //metodo para obter o valor atual do dado
    public int getValorAtual() {
        return valorAtual;
    }
}