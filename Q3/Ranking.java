//importa biblioteca
import java.io.*;
import java.util.*;


//Gerencia a leitura, escrita e exibição do ranking de vitórias.
public class Ranking {
    private static final String NOME_ARQUIVO = "ranking.txt";

    
    //Ler o arquivo de ranking
    public Map<String, Integer> lerRanking() {
        Map<String, Integer> rankingData = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                try {
                    String[] partes = linha.split(";");
                    if (partes.length == 2) {
                        //O username é armazenado em minúsculas para consistência
                        String user = partes[0].trim().toLowerCase(); 
                        int vitorias = Integer.parseInt(partes[1].trim());
                        rankingData.put(user, vitorias);
                    }
                } catch (NumberFormatException ignored) {
                    // Ignora linhas com formato de número inválido
                }
            }
        } catch (FileNotFoundException ignored) {
            // Arquivo não existe na primeira execução, retorna mapa vazio
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de ranking: " + e.getMessage());
        }
        return rankingData;
    }

    //Salva ou atualiza uma vitória para o jogador no arquivo    
    public void salvarVitoria(String username) {
        String usernameLower = username.toLowerCase();
        Map<String, Integer> rankingData = lerRanking();

        // Incrementa a vitória (ou inicializa em 1)
        int vitoriasAtuais = rankingData.getOrDefault(usernameLower, 0);
        rankingData.put(usernameLower, vitoriasAtuais + 1);

        // Reescreve todo o arquivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
            for (Map.Entry<String, Integer> entry : rankingData.entrySet()) {
                // Formato: username;vitorias
                bw.write(entry.getKey() + ";" + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar o ranking: " + e.getMessage());
        }
    }

    //Exibe os TOP FIVE jogadores (Regra h).   
    public Map<String, Integer> exibirTopFive() {
        Map<String, Integer> rankingData = lerRanking();

        System.out.println("\n--- RANKING TOP FIVE (Nome e Vitórias) ---");
        
        if (rankingData.isEmpty()) {
            System.out.println("Nenhum registro de vitória ainda.");
        } else {
            // Transforma o mapa em lista de entradas para poder ordenar
            List<Map.Entry<String, Integer>> list = new ArrayList<>(rankingData.entrySet());

            // Ordena pela contagem de vitórias
            list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            // Exibe os 5 primeiros
            for (int i = 0; i < Math.min(5, list.size()); i++) {
                Map.Entry<String, Integer> entry = list.get(i);
                // Converte a primeira letra para maiúscula
                String displayUsername = entry.getKey().substring(0, 1).toUpperCase() + entry.getKey().substring(1);
                System.out.printf("%d. %s - %d vitórias%n", i + 1, displayUsername, entry.getValue());
            }
        }
        System.out.println("------------------------------------------\n");
        
        return rankingData;
    }
}