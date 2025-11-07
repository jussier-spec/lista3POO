
//classe jogador com nome, aposta e contagem de vitórias.
public class Jogador {
    private final String username;
    private final int aposta;
    private int vitorias;

    //construtor
    public Jogador(String username, int aposta) {
        // Remove espaços em branco
        this.username = username.trim(); 
        this.aposta = aposta;
        this.vitorias = 0;
    }

    //getters e setters
    public String getUsername() {
        return username;
    }
    //metodo para aposta
    public int getAposta() {
        return aposta;
    }
    
    //metodos para vitorias
    public int getVitorias() {
        return vitorias;
    }

    //metodo para setar vitorias
    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    
    //Incrementa o contador de vitórias do jogador.
    public void incrementarVitoria() {
        this.vitorias++;
    }
}