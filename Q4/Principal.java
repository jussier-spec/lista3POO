//Implementa a classe Principal para testar todos os métodos.
public class Principal {
      public static void main(String[] args) {
        System.out.println("--- 1. TESTE C2 (Herança de C1, Sobrecarga de Construtor) ---");
        
        // Objeto de C2 usando construtor 1 (Padrão)
        C2 objetoC2_1 = new C2();
        objetoC2_1.metodoC1();
        objetoC2_1.metodoAbstrato();
        System.out.println("Atributo C2: " + objetoC2_1.getAtributoC2());
        
        // Objeto de C2 usando construtor 2 (Personalizado)
        C2 objetoC2_2 = new C2("C1 Pers. C2", 200);
        System.out.println("-----------------------------------------------------------------");

        
        System.out.println("--- 2. TESTE C3 (Herança de C1, Implementa I1 e I2) ---");
        
        // Objeto de C3
        C3 objetoC3 = new C3("C1 de C3", true);
        objetoC3.metodoC1(); 
        objetoC3.metodoAbstrato(); 
        objetoC3.metodoC3(); 
        
        // Métodos das interfaces
        objetoC3.metodoI1("Olá, interface I1!");
        objetoC3.metodoI2_A();
        int resultado = objetoC3.metodoI2_B(15);
        System.out.println("C3 - I2: Retorno do método B: " + resultado);
        System.out.println("-----------------------------------------------------------------");


        System.out.println("--- 3. TESTE C4 (Herança de C2, Sobreposição de método C1) ---");
        
        // Objeto de C4
        C4 objetoC4 = new C4();
        // Demonstra Sobreposição de C1 em C4
        objetoC4.metodoC1(); 
        objetoC4.metodoAbstrato(); 
        System.out.println("Atributo C4: " + objetoC4.getAtributoC4());
        System.out.println("-----------------------------------------------------------------");


        System.out.println("--- 4. TESTE C5 (Herança de C2, Implementa I1, Sobrecarga de Métodos) ---");
        
        // Objeto de C5
        C5 objetoC5 = new C5();
        objetoC5.metodoAbstrato();
        
        //Demonstração de Sobrecarga de Métodos
        System.out.println(objetoC5.metodoC5());
        System.out.println(objetoC5.metodoC5("Teste de Prefixo"));
        
        // Método da Interface I1
        objetoC5.metodoI1("C5 testando I1");
        System.out.println("-----------------------------------------------------------------");
        
        
        System.out.println("--- 5. TESTE DE POLIMORFISMO (Referência de Tipo Abstrato/Interface) ---");

        // Polimorfismo com C1 (referência abstrata)
        C1 referenciaC1 = objetoC4; 
        referenciaC1.metodoAbstrato();

        // Polimorfismo com I1 (referência de interface)
        i1 referenciaI1 = objetoC5;
        referenciaI1.metodoI1("Chamada polimórfica!");
    }
}