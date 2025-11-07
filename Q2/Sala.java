//criar classe Sala
public class Sala {
    // tamanho da sala 
    public static final int MAX_LINHA = 20;  // Linhas de 0 a 19
    public static final int MAX_COLUNA = 40; // Colunas de 0 a 39

    // Atributos
    private int linha;
    private int coluna;
    private int passo;

    // Construtor da classe Sala
    public Sala(int linhaInicial, int colunaInicial, int passoInicial) {
        this.passo = passoInicial;
        
        // Inicializa a posição verificando os limites
        if (linhaInicial >= 0 && linhaInicial < MAX_LINHA) {
            this.linha = linhaInicial;
        } else {
            System.out.println("Aviso: Linha inicial fora dos limites. Redefinindo para 0.");
            this.linha = 0;
        }

        if (colunaInicial >= 0 && colunaInicial < MAX_COLUNA) {
            this.coluna = colunaInicial;
        } else {
            System.out.println("Aviso: Coluna inicial fora dos limites. Redefinindo para 0.");
            this.coluna = 0;
        }
    }
    
    // Métodos Getters
    public int getLinha() { return linha; }
    public int getColuna() { return coluna; }
    public int getPasso() { return passo; }

    //Mostra a posição atual (coordenadas) do robô.
    public void mostrarPosicaoAtual() {
        System.out.println("Posição Atual do Robô R1: (" + this.linha + ", " + this.coluna + ")");
    }
    //Método auxiliar para mover o robô com restrições de limites
    private void mover(int novaLinha, int novaColuna) {
        // Restrição da Linha
        if (novaLinha < 0) {
            this.linha = 0; 
        } else if (novaLinha >= MAX_LINHA) {
            this.linha = MAX_LINHA - 1; 
        } else {
            this.linha = novaLinha; 
        }

        // Restrição da Coluna
        if (novaColuna < 0) {
            this.coluna = 0; 
        } else if (novaColuna >= MAX_COLUNA) {
            this.coluna = MAX_COLUNA - 1; 
        } else {
            this.coluna = novaColuna; 
        }
    }

    // Métodos de Movimento
    //Move o robô para cima
    public void andarCima() {
        int novaLinha = this.linha - this.passo;
        mover(novaLinha, this.coluna);
        System.out.println("Robô andou " + this.passo + " passos para Frente.");
    }

    
    //Move o robô para baixo
    public void andarBaixo() {
        int novaLinha = this.linha + this.passo;
        mover(novaLinha, this.coluna);
        System.out.println("Robô andou " + this.passo + " passos para Baixo.");
    }

    
    //Move o robô para a Direita
    public void andarDireita() {
        int novaColuna = this.coluna + this.passo;
        mover(this.linha, novaColuna);
        System.out.println("Robô andou " + this.passo + " passos para Direita.");
    }

    
    //Move o robô para a Esquerda
    public void andarEsquerda() {
        int novaColuna = this.coluna - this.passo;
        mover(this.linha, novaColuna);
        System.out.println("Robô andou " + this.passo + " passos para Esquerda.");
    }
}