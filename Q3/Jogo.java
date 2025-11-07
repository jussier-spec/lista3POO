//importa bibliotecas
import java.util.*;

//Classe que coordena o Jogo de Dados.
public class Jogo {
    private static final int MAX_JOGADORES = 11; 
    private final List<Jogador> jogadores;
    private final Dado dado1; 
    private final Dado dado2; 
    private final Ranking Ranking;
    private final Scanner scanner;

    //construtor
    public Jogo() {
        this.jogadores = new ArrayList<>();
        this.dado1 = new Dado();
        this.dado2 = new Dado();
        this.Ranking = new Ranking();
        this.scanner = new Scanner(System.in);
    }
    
    // Método para limpar a tela
    private void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    
    // Método para aguardar o usuário
    private void pausarEContinuar() {
        System.out.println("\nPressione ENTER para continuar...");
        try {
            // Aguarda o ENTER
            System.in.read(); 
            scanner.nextLine();
        } catch (Exception ignored) {
            // Ignora exceções
        }
    }

    
    //Coleta os dados dos jogadores e suas apostas.
    private boolean lerDadosJogadores(Map<String, Integer> rankingData) {
        System.out.println("--- CADASTRO DE JOGADORES (Máx. 11) ---");
        Set<String> usernamesValidos = new HashSet<>();

        //percorre o número máximo de jogadores
        for (int i = 0; i < MAX_JOGADORES; i++) {
            System.out.printf("\nJogador %d:%n", i + 1);
            
            //valida o nome do jogador
            String username;
            boolean nomeValido = false;

            //loop até obter um nome válido
            while (!nomeValido) {
                System.out.print("Nome de usuário (ou 'FIM' para começar): ");
                username = scanner.nextLine().trim();

                if (username.equalsIgnoreCase("FIM")) {
                    if (i == 0) {
                        System.out.println("Pelo menos um jogador deve ser cadastrado.");
                        continue;
                    }
                    return jogadores.size() > 0;
                }
                
                if (username.isEmpty()) {
                    System.out.println("Nome de usuário não pode ser vazio.");
                    continue;
                }
                
                // Validação
                String usernameLower = username.toLowerCase(); 
                if (usernamesValidos.contains(usernameLower)) {
                    System.out.println("Nome de usuário já existe. Tente outro nome.");
                    continue;
                }
                
                // Nome válido
                usernamesValidos.add(usernameLower);
                nomeValido = true;
                
                int aposta = -1;
                while (!(aposta >= 2 && aposta <= 12)) {
                    System.out.print("Valor da aposta (entre 2 e 12): ");
                    try {
                        aposta = Integer.parseInt(scanner.nextLine().trim());
                        if (!(aposta >= 2 && aposta <= 12)) {
                            System.out.println("Aposta inválida. Deve ser entre 2 e 12.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. A aposta deve ser um número.");
                    }
                }
                
                // Cria e adiciona o jogador
                Jogador jogador = new Jogador(username, aposta);
                
                // Carrega vitórias anteriores
                int vitoriasAnteriores = rankingData.getOrDefault(usernameLower, 0);
                jogador.setVitorias(vitoriasAnteriores);
                
                this.jogadores.add(jogador);
                System.out.printf("'%s' cadastrado com aposta %d. Vitórias anteriores: %d%n", 
                                  username, aposta, vitoriasAnteriores);
                break; 
            }
        }
        return jogadores.size() > 0;
    }

    
    //Lança os dois dados e calcula a soma
    private int lancarDados() {
        System.out.println("\n--- LANÇAMENTO DOS DADOS ---");
        
        int v1 = dado1.lancar();
        int v2 = dado2.lancar();
        int soma = v1 + v2;
        
        System.out.printf("Dado 1: %d%n", v1);
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        System.out.printf("Dado 2: %d%n", v2);
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        System.out.printf("\nSOMA SORTEADA: %d%n", soma);
        
        return soma;
    }

    
    //Verifica quais jogadores venceram
    private List<Jogador> verificarVencedores(int soma) {
        List<Jogador> vencedores = new ArrayList<>();
        for (Jogador jogador : jogadores) {
            if (jogador.getAposta() == soma) {
                vencedores.add(jogador);
            }
        }
        
        return vencedores;
    }

    //Exibe o resultado e atualiza o ranking
    private void exibirResultadoEAtualizarRanking(int soma, List<Jogador> vencedores) {
        System.out.println("\n--- RESULTADO DO JOGO ---");
        
        if (!vencedores.isEmpty()) {
            System.out.printf("VITÓRIA! O número %d foi apostado por:%n", soma);
            for (Jogador jogador : vencedores) {
                // Atualiza o ranking no arquivo
                Ranking.salvarVitoria(jogador.getUsername());
                
                // Atualiza o objeto Jogador
                jogador.incrementarVitoria(); 
                
                System.out.printf("- %s (Agora com %d vitórias!)%n", 
                                  jogador.getUsername(), jogador.getVitorias());
            }
        } else {
            System.out.printf("A 'máquina' venceu! Ninguém apostou no número %d.%n", soma); 
        }
        
        System.out.println("---------------------------\n");
    }

    
    //Executa o fluxo principal do jogo.
    public void iniciar() {
        limparTela();
        
        // 1. Tela Inicial: Exibir Ranking
        Map<String, Integer> rankingData = Ranking.exibirTopFive();
        System.out.println("BEM-VINDO AO JOGO DE DADOS!");
        pausarEContinuar();
        limparTela();
        
        // 2. Coleta de Dados dos Jogadores
        if (!lerDadosJogadores(rankingData)) {
            System.out.println("Nenhum jogador cadastrado. Encerrando o jogo.");
            return;
        }

        pausarEContinuar();
        limparTela();

        // 3. Lançamento dos Dados
        int soma = lancarDados();
        
        // 4. Verificação de Vencedores 
        List<Jogador> vencedores = verificarVencedores(soma);
        
        // 5. Exibição e Atualização do Ranking 
        exibirResultadoEAtualizarRanking(soma, vencedores);
        
        pausarEContinuar();
        limparTela();
        
        // Exibe o ranking final atualizado
        Ranking.exibirTopFive();
        
        System.out.println("\nFim do jogo!");
    }

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.iniciar();
    }
}