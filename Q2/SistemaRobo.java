//importar biblioteca
import java.util.Scanner;

//classe do sistema do robo
public class SistemaRobo {

    //Metodo para exibir a sala e o robo na posição atual
    public static void mostrarSala(Sala Sala) {
        int maxLinha = Sala.MAX_LINHA;
        int maxColuna = Sala.MAX_COLUNA;
        int linhaRobo = Sala.getLinha();
        int colunaRobo = Sala.getColuna();

        //desenha a separação e as laterais da sala
        String linhaDivisora = "_".repeat(maxColuna + 2);

        System.out.println("\n" + linhaDivisora);
        System.out.printf("SALA %dx%d | Robô R1 em (%d, %d)\n", maxLinha, maxColuna, linhaRobo, colunaRobo);
        System.out.println(linhaDivisora);

        //percorre a matriz da sala para desenhar o robo na posição correta
        for (int r = 0; r < maxLinha; r++) {
            System.out.print("|");
            for (int c = 0; c < maxColuna; c++) {
                if (r == linhaRobo && c == colunaRobo) {
                    //o robo é representado pelo numero 1
                    System.out.print("1");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }

        System.out.println(linhaDivisora);
    }
    //classe principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //Instanciar 1 objeto Robô: R1 na posição (0,0)
        System.out.println("\n");
        Sala R1 = new Sala(0, 0, 1); 
        
        R1.mostrarPosicaoAtual();
        mostrarSala(R1);

        //Loop de Deslocamento Interativo
        System.out.println("\n");
        int escolha = -1;

        //Enquanto a escolha for diferente de 0, continua o loop
        while (escolha != 0) {
            System.out.println("\nEscolha o movimento do Robô R1");
            System.out.println("1 - Andar para Cima");
            System.out.println("2 - Andar para Baixo");
            System.out.println("3 - Andar para Direita");
            System.out.println("4 - Andar para Esquerda");
            System.out.println("0 - Sair");
            System.out.print("Digite sua escolha: ");

            if (scanner.hasNextInt()) {
                escolha = scanner.nextInt();
                scanner.nextLine();

                //Executa o movimento baseado na escolha do usuário
                switch (escolha) {
                    case 1:
                        R1.andarCima();
                        break;
                    case 2:
                        R1.andarBaixo();
                        break;
                    case 3:
                        R1.andarDireita();
                        break;
                    case 4:
                        R1.andarEsquerda();
                        break;
                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
                
                // A cada escolha, o sistema deve mostrar a sala novamente
                if (escolha >= 1 && escolha <= 4) {
                    R1.mostrarPosicaoAtual();
                    mostrarSala(R1);
                }
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
            }
        }
        
        System.out.println("Programa finalizado. Posição final do Robô:");
        R1.mostrarPosicaoAtual();
        scanner.close();
    }
}