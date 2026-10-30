package a1;

import java.util.ArrayList; // "banco de dados"
import java.util.List; // 
import java.util.Scanner; // puxa o que o usuário digita 

public class Principal {

  private static final Scanner scanner = new Scanner(System.in); // Scanner para entrada de dados
  private static final List<colaborador> colaboradores = new ArrayList<>(); // Lista para armazenar os colaboradores

  // Main
  public static void main(String[] args) {
    boolean continuar = true; // Variável para controlar o loop do menu

    while (continuar) {
      printMenu();
      String opcao = scanner.nextLine();
      switch (opcao) { // mostra as opções do menu
        case "1" -> colaboradorPadrao();
        case "2" -> colaboradorComissionado();
        case "3" -> colaboradorProducao();
        case "4" -> gerarFolhaPagamento();
        case "5" -> resumoFolha(); // exibe o resumo da folha (quantidade, total e média salarial)
        case "0" -> {
          System.out.println("Saindo do sistema. Até logo.");
          continuar = false;
        }
        default -> System.out.println("Opção inválida. Tente novamente.");
      }
    }
    scanner.close();
  }

  // Menu do sistema
  private static void printMenu() {
    System.out.println("\n--- Sistema de Folha de Pagamento ---");
    System.out.println("1. Registrar Colaborador Padrão");
    System.out.println("2. Registrar Colaborador Comissionado");
    System.out.println("3. Registrar Colaborador de Produção");
    System.out.println("4. Gerar Folha de Pagamento");
    System.out.println("5. Exibir Resumo da Folha");
    System.out.println("0. Sair");
    System.out.print("Selecione uma opção: ");
  }

  // Adicionar colaborador padrão
  private static void colaboradorPadrao() {
    System.out.print("Nome: ");
    String nome = scanner.nextLine(); // puxa o nome do colaborador
    System.out.print("Número de Registro: ");
    String numRegistro = scanner.nextLine(); // puxa o número de registro do colaborador
    
    // Adiciona o colaborador padrão à lista
    colaboradores.add(new colaboradorPadrao(numRegistro, nome)); // adiciona o colaboradorPadrao a lista de funcionarios
    System.out.println("Colaborador Padrão registrado com sucesso.");
  }

  // Adicionar colaborador comissionado
  private static void colaboradorComissionado() {
    System.out.print("Nome: ");
    String nome = scanner.nextLine(); // puxa o nome do colaborador
    System.out.print("Número de Registro: ");
    String numRegistro = scanner.nextLine(); // puxa o número de registro do colaborador

    System.out.print("Total de vendas: ");
    double vendas = Integer.parseInt(scanner.nextLine()); // puxa o total de vendas do colaborador
    System.out.print("Percentual de comissão: ");
    double percentual = Double.parseDouble(scanner.nextLine()); // puxa o percentual de comissão do colaborador

    // Adiciona o colaborador comissionado à lista
    colaboradores.add(new colaboradorComissionado(numRegistro, nome, vendas, percentual));
    System.out.println("Colaborador Comissionado registrado com sucesso."); // adiciona o colaboradorComissionado a lista de funcionarios
  }

  // Adicionar colaborador de produção
  private static void colaboradorProducao() {
    System.out.print("Nome: ");
    String nome = scanner.nextLine(); // puxa o nome do colaborador
    System.out.print("Número de Registro: ");
    String numRegistro = scanner.nextLine(); // puxa o número de registro do colaborador
    System.out.print("Peças produzidas: ");
    int pecas = Integer.parseInt(scanner.nextLine()); // puxa o número de peças produzidas do colaborador
    System.out.print("Valor por peça: ");
    double valorPeca = Double.parseDouble(scanner.nextLine()); // puxa o valor por peça do colaborador

    // Adiciona o colaborador de produção à lista
    colaboradores.add(new colaboradorProducao(numRegistro, nome, pecas, valorPeca));
    System.out.println("Colaborador de Produção registrado com sucesso."); // adiciona o colaboradorProducao a lista de funcionarios
  }

    // Gerar folha de pagamento

    private static void gerarFolhaPagamento() {
        System.out.println("\n--- Relatório de Folha de Pagamento ---");
        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum colaborador encontrado no banco de dados."); // menagem de erro caso não haja colaboradores cadastrados
            return;
        }

        for (colaborador colaborador : colaboradores) {
            System.out.println("Nome: " + colaborador.getNome());
            System.out.println ("Número de Registro: " +   colaborador.getNumRegistro());
            System.out.printf("Salário: R$ %.2f%n", colaborador.calcularSalario());
            System.out.println("---------------------------"); 
        }
    }

    // Exibir resumo da folha de pagamento
    private static void resumoFolha() {
        System.out.println("\n--- Resumo da Folha de Pagamento ---");
        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum colaborador encontrado no banco de dados."); // evita dividir por zero no cálculo da média
            return;
        }

        int quantidade = colaboradores.size(); // quantidade total de colaboradores cadastrados
        double totalFolha = 0; // acumulador: começa em 0 e vai somando o salário de cada colaborador

        for (colaborador c : colaboradores) {
            totalFolha += c.calcularSalario(); // cada tipo de colaborador calcula o próprio salário (polimorfismo)
        }

        double mediaSalarial = totalFolha / quantidade; // média = soma total dos salários ÷ quantidade de colaboradores

        System.out.println("Quantidade de colaboradores: " + quantidade);
        System.out.printf("Total da folha de pagamento: R$ %.2f%n", totalFolha);
        System.out.printf("Média salarial: R$ %.2f%n", mediaSalarial);
    }
}
