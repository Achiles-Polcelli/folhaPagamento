package a1;

public abstract class colaborador { // classe abstrata colaborador, que serve como base para os tipos de colaboradores (padrão, comissionado e produção)
    
    protected String numRegistro; // variáveis para armazenar o número de registro e o nome do colaborador
    protected String nome; // variáveis para armazenar o número de registro e o nome do colaborador
    protected static final double SALARIO_BASE = 2000.00; // salario base para TODOS

    public colaborador(String numRegistro, String nome) { // construtor da classe colaborador, que recebe o número de registro e o nome do colaborador
        this.numRegistro = numRegistro;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getNumRegistro() {
        return numRegistro;
    }

    public abstract double calcularSalario();
}
