package a1;

public class colaboradorProducao extends /* estende, para indicar que uma classe herda de outra*/ colaborador{ // classe colaboradorProducao que herda da classe colaborador
    private int pecasProduzidas; // variavel para armazenar o número de peças produzidas
    private double valorPorPeca; // variavel para armazenar o valor pago por peça produzida

    public colaboradorProducao(
        String numRegistro,
        String nome,
        int pecasProduzidas,
        double valorPorPeca
    ) {
        super(numRegistro, nome);
        this.pecasProduzidas = pecasProduzidas;
        this.valorPorPeca = valorPorPeca;
    }

    @Override
    public double calcularSalario() {
        return SALARIO_BASE + (pecasProduzidas * valorPorPeca); 
    }

}
