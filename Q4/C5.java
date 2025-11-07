//Classe C5 herda de C2
//implementa a interface I1
public class C5 extends C2 implements i1 {
    
    private String atributoC5;

    public C5() {
        super("C1 da C5", 55);
        this.atributoC5 = "C5 - Inicial";
        System.out.println("C5 construído.");
    }

    //Método próprio (versão 1)
    public String metodoC5() {
        return "C5: Método próprio, sem argumentos.";
    }

    //Sobrecarga de métodos (Método próprio, versão 2)
    public String metodoC5(String prefixo) {
        return "C5: Método próprio sobrecarregado. Prefixo: " + prefixo;
    }
    
    // Implementação da Interface I1
    @Override
    public void metodoI1(String mensagem) {
        this.atributoC5 = mensagem; 
        System.out.println("C5 - I1: Atributo C5 atualizado para: " + this.atributoC5);
    }
}