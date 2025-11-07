//Classe C2 herda de C1
public class C2 extends C1 {
    //Atributo próprio
    private int atributoC2;

    //Sobrecarga de construtores - Construtor 1 (Padrão)
    public C2() {
        super("C1 da C2 Padrão");
        this.atributoC2 = 10;
        System.out.println("C2 construído (Padrão).");
    }

    //Sobrecarga de construtores - Construtor 2 (Personalizado)
    public C2(String c1Attr, int c2Attr) {
        super(c1Attr);
        this.atributoC2 = c2Attr;
        System.out.println("C2 construído (Personalizado).");
    }

    //Sobreposição de método do C1 (Obrigatório por ser abstrato)
    @Override
    public void metodoAbstrato() {
        System.out.println("C2: Implementação do método abstrato de C1.");
    }

    public int getAtributoC2() {
        return atributoC2;
    }
}