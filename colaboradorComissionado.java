package a1;

public class colaboradorComissionado extends colaborador { // classe colaboradorComissionado que herda da classe colaborador
    private double totalVendas; // variavel para armazenar o total de vendas realizadas pelo colaborador
    private double percentualComissao; // variavel para armazenar o percentual de comissão do colaborador

    public colaboradorComissionado(String numRegistro, 
        String nome, 
        double totalVendas, 
        double percentualComissao) {

        super(numRegistro, nome);
        this.totalVendas = totalVendas;
        this.percentualComissao = percentualComissao;
    }

    @Override 
    public double calcularSalario() {
        return SALARIO_BASE + (totalVendas * percentualComissao / 100);
    }
}
