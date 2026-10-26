package a1;

public class colaboradorPadrao extends colaborador { // classe colaboradorPadrao que herda da classe colaborador

    public colaboradorPadrao(String numRegistro, String nome) {
        super(numRegistro, nome); // chama o construtor da classe pai (colaborador) para inicializar numRegistro e nome
    }

    @Override
    public double calcularSalario() {
        return SALARIO_BASE; 
    }
    
}
