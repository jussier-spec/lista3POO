import java.time.*;
import java.time.format.DateTimeFormatter;

//classe dos pedidos
class Pedido {
    //atributos do pedido
    public static int id=1;
    public int codigo;
    public String dataCompra;
    public String horaCompra;
    public String enderecoEntrega;
    public int qtdBotijao;
    public double PresoBotijao;
    public double PresoTotalBotijao;
    public String horaEntrega;
    public String Pagamento;
    public String status;

    //construtor da classe pedido
    public Pedido(String enderecoEntrega, int qtdBotijao, double presoBotijao){
        //iniciação do atributo
        this.codigo = id++;
        //Cria um objeto com a data e hora atuais do sistema.
        LocalDateTime agora = LocalDateTime.now();
        //formato da data e da hora
        this.dataCompra = agora.format(DateTimeFormatter.ofPattern("dd/mm/yyyy"));
        this.horaCompra = agora.format(DateTimeFormatter.ofPattern("hh:mm"));
        //Guarda os dados do pedido
        this.enderecoEntrega = enderecoEntrega;
        this.qtdBotijao = qtdBotijao;
        this.PresoBotijao = presoBotijao;
        //Calcula o valor total
        this.PresoTotalBotijao = calcularTotal();
        //Calcula a previção da entrega
        this.horaEntrega = calcularHoraEntrega(agora);
        //quarda o status do pedido
        this.status = "pendente";
    }
    //Metodo para calcular o valor total do pedido
    public double calcularTotal(){
        return qtdBotijao*PresoBotijao;
    }
    //método calcula o horário previsto de entrega
    public String calcularHoraEntrega(LocalDateTime horaCompra){
        //Cria uma nova variável entrega e adiciona 2 horas com plusHours
        LocalDateTime entrega = horaCompra.plusHours(2);
        //Usa DateTimeFormatter para definir o formato da data e hora.
        return entrega.format(DateTimeFormatter.ofPattern("dd/mm/yyyy hh:mm"));
    }
    //Metodo para confirmar o pedido
    public void confirmarPedido(String Pagamento){
        this.Pagamento = Pagamento;
        this.status =  "confirmado";
    }
    //metodo para confirmar a entrega
    public void entregarPedido(){
        this.status = "entregue";
    }
    //metodo para obter o codigo
    public int getCodigo(){
        return codigo;
    }
    //metodo para inserir o status
    public String getStatus(){
        return status;
    }
    //metodo para inserir o novo endereço
    public void setEnderecoEntrega(String novoEndereco){
        this.enderecoEntrega = novoEndereco;
    }
    //reescreve o método toString()
    @Override
    //método para definir o texto que representa o objeto
    public String toString(){
        return  "Pedido #" + codigo + 
                "\nData da compra: " + dataCompra +
                "\nHora da compra: " + horaCompra +
                "\nEndereço de entrega: " + enderecoEntrega +
                "\nQuantidade: " + qtdBotijao +
                "\nPreço unitário: R$ " + PresoBotijao +
                "\nTotal: R$ " + PresoTotalBotijao +
                "\nHora prevista de entrega: " + horaEntrega +
                "\nForma de pagamento: " + (Pagamento == null ? "Não informado" : Pagamento) +
                "\nStatus: " + status + "\n";
    }
}
