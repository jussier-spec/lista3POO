//Classe C3 herda de C1
//C3 implementa interfaces I1 e I2
public class C3 extends C1 implements i1, i2 {
    //Atributo próprio
    private boolean atributoC3;

    public C3(String c1Attr, boolean c3Attr) {
        super(c1Attr);
        this.atributoC3 = c3Attr;
        System.out.println("C3 construído.");
    }

    //Sobreposição de método do C1 (Obrigatório por ser abstrato)
    @Override
    public void metodoAbstrato() {
        System.out.println("C3: Implementação do método abstrato de C1. Estado C3: " + this.atributoC3);
    }
    
    public void metodoC3() {
        System.out.println("C3: Método próprio executado.");
    }

    // Implementação da Interface I1
    @Override
    public void metodoI1(String mensagem) {
        System.out.println("C3 - i1: Recebi a mensagem: " + mensagem);
    }

    // Implementação da Interface I2
    @Override
    public void metodoI2_A() {
        System.out.println("C3 - I2: Executando método A.");
    }

    @Override
    public int metodoI2_B(int valor) {
        System.out.println("C3 - I2: Executando método B. Recebi: " + valor);
        return valor * 2;
    }
}