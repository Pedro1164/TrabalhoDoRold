import java.io.Serializable;

public class Despesa implements Serializable {
    private String descricao;
    private double valor;
    private String dataVencimento;
    private String categoria;
    private boolean paga;

    // Construtor da classe Despesa
    public Despesa(String descricao, double valor, String dataVencimento, String categoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.categoria = categoria;
        this.paga = false; // Originalmente, entrará como não paga
    }

    // Como as despesas irão entrar originalmente como não pagas,
    // neste método iremos classificá-las como pagas
    public void registrarPagamento() {
        this.paga = true;
    }

    // Mostra a descrição da despesa
    public String getDescricao() {
        return descricao;
    }

    // Mostra o valor
    public double getValor() {
        return valor;
    }

    // Mostra a data de vencimento
    public String getDataVencimento() {
        return dataVencimento;
    }

    // Mostra a categoria da despesa
    public String getCategoria() {
        return categoria;
    }

    // Verifica se a despesa está paga
    public boolean isPaga() {
        return paga;
    }

    // Define uma nova descrição
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Define um novo valor
    public void setValor(double valor) {
        this.valor = valor;
    }

    // Define uma nova data de vencimento
    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    // Define uma nova categoria
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Retorna uma string representando a despesa
    @Override
    public String toString() {
        return "\n-----------|$|-------------\n" +
               "\nDespesa:\n" +
               "Descrição: " + descricao + "\n" +
               "Valor: " + valor + "\n" +
               "Data de Vencimento: " + dataVencimento + "\n" +
               "Categoria: " + categoria + "\n" +
               "Paga: " + (paga ? "Sim" : "Não");
    }
}
