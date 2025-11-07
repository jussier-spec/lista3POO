// Classe Abstrata C1
public abstract class C1 {
    //Atributo próprio
    protected String atributoC1 = "Valor C1 Padrão";

    // Construtor
    public C1(String atributoC1) {
        this.atributoC1 = atributoC1;
        System.out.println("C1 construído.");
    }

    public void metodoC1() {
        System.out.println("C1: Executando método base. Atributo: " + this.atributoC1);
    }
    
    //Método abstrato (demonstração de abstração)
    public abstract void metodoAbstrato(); 
}
