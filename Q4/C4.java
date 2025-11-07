//Classe C4 herda de C2
public class C4 extends C2 {
    
    private double atributoC4;

    public C4() {
        // Chama o construtor padrão de C2
        super(); 
        this.atributoC4 = 4.4;
        System.out.println("C4 construído.");
    }
    
    public C4(String c1Attr, int c2Attr, double c4Attr) {
        // Chama o construtor personalizado de C2
        super(c1Attr, c2Attr);
        this.atributoC4 = c4Attr;
        System.out.println("C4 construído (Personalizado).");
    }

    public double getAtributoC4() {
        return atributoC4;
    }
    
    //Sobreposição de método de C1 (Método concreto)
    @Override
    public void metodoC1() {
        // Chama a implementação de C1 (ou C2 se C2 tivesse sobrescrito)
        super.metodoC1(); 
        System.out.println("C4: SOBREPOSIÇÃO! Adicionando lógica específica de C4.");
    }
}