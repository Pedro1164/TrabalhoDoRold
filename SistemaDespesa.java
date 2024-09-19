import java.util.ArrayList;
import java.util.Scanner;

public class SistemaDespesa {
    private ArrayList<Despesa> despesas;
    private ArrayList<String> tiposDespesa;
    private ArrayList<Usuario> usuarios;

    // Construtor da classe das despesas
    public SistemaDespesa() {
        despesas = new ArrayList<>();
        tiposDespesa = new ArrayList<>();
        usuarios = new ArrayList<>();
    }
    
    // Método para adicionar despesas
    public void adicionarDespesa(Scanner scanner) {
        System.out.println("Digite o nome ou descrição da despesa:");
        String descricao = scanner.nextLine();
        System.out.println("Digite o valor da despesa:");
        double valor = scanner.nextDouble();
        scanner.nextLine();  
        System.out.println("Digite a data de vencimento (dd/mm/aaaa):");
        String dataVencimento = scanner.nextLine();
        System.out.println("Selecione a categoria da despesa:"); //aqui aparece um menu para (...)
        System.out.println("1. Saúde");         // (...) para que o usuario possa escohler a categoria
        System.out.println("2. Moradia");
        System.out.println("3. Alimentação");
        System.out.println("4. Transporte");
        System.out.println("5. Outros");
        int opcaoCategoria = scanner.nextInt();
        scanner.nextLine();  
        String categoria = obterCategoriaPorOpcao(opcaoCategoria);
        
        // Cria uma nova despesa e adiciona a lista
        Despesa despesa = new Despesa(descricao, valor, dataVencimento, categoria);
        despesas.add(despesa);
        System.out.println("Despesa adicionada com sucesso!");
    }

    // Método auxiliar para obter a categoria pela opção selecionada
    private String obterCategoriaPorOpcao(int opcao) {
        switch (opcao) {
            case 1: return "Saúde";
            case 2: return "Moradia";
            case 3: return "Alimentação";
            case 4: return "Transporte";
            case 5: return "Outros";
            default: return "Não especificado";
        }
    }

    // Método para registrar um pagamento
    public void registrarPagamento(Scanner scanner) {
        System.out.println("Digite a descrição da despesa a ser paga:");
        String descricao = scanner.nextLine();
        
        // Procura pela despesa e ira registrar o pagamento
        for (Despesa despesa : despesas) {
            if (despesa.getDescricao().equalsIgnoreCase(descricao) && !despesa.isPaga()) {
                despesa.registrarPagamento();
                System.out.println("Pagamento registrado com sucesso!");
                return;
            }
        }
        System.out.println("Esta despesa não foi encontrada ou já foi paga.");
    }

    // Método que vai listar um submenu das despesas
    public void listarDespesas(boolean pagas, Scanner scanner) {
        System.out.println("Despesas " + (pagas ? "Pagas" : "Abertas") + ":");
        for (Despesa despesa : despesas) {
            if (despesa.isPaga() == pagas) {
                System.out.println(despesa);
            }
        }

        System.out.println("\nDigite a descrição da despesa para editar ou excluir, ou digite 'voltar' para voltar ao menu principal:");
        String descricao = scanner.nextLine();
        if (descricao.equalsIgnoreCase("voltar")) {
            return; //aqui o usuario escolhe a despesa que ira mudar pelo nome
        }

        Despesa despesaSelecionada = null;
        for (Despesa despesa : despesas) {
            if (despesa.getDescricao().equalsIgnoreCase(descricao)) {
                despesaSelecionada = despesa;
                break;
            }
        }

        if (despesaSelecionada == null) {
            System.out.println("Despesa não encontrada.");
            return;
        }

        boolean voltar = false; // assim que ele escolher a despesa, aparece este submenu
        while (!voltar) {
            System.out.println("1. Editar Despesa");
            System.out.println("2. Excluir Despesa");
            System.out.println("3. Voltar ao Menu Principal");
            int opcao = scanner.nextInt();
            scanner.nextLine();  
            switch (opcao) {
                case 1:
                    editarDespesa(despesaSelecionada, scanner);
                    break;
                case 2:
                    excluirDespesa(despesaSelecionada);
                    voltar = true; // Voltar ao menu principal após excluir
                    break;
                case 3:
                    voltar = true; // Voltar ao menu principal
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Esse método permite o usuario modificar apenas um dado da despesa em vez de ter que modificar tudo
    private void editarDespesa(Despesa despesa, Scanner scanner) {
        System.out.println("Editar Despesa:");
        System.out.println("1. Editar Descrição");
        System.out.println("2. Editar Valor");
        System.out.println("3. Editar Data de Vencimento");
        System.out.println("4. Editar Categoria");
        int opcao = scanner.nextInt();
        scanner.nextLine();  
        switch (opcao) {
            case 1:
                System.out.println("Digite a nova descrição:");
                String novaDescricao = scanner.nextLine();
                despesa.setDescricao(novaDescricao);
                break;
            case 2:
                System.out.println("Digite o novo valor:");
                double novoValor = scanner.nextDouble();
                scanner.nextLine();  // Consumir nova linha
                despesa.setValor(novoValor);
                break;
            case 3:
                System.out.println("Digite a nova data de vencimento (dd/mm/aaaa):");
                String novaData = scanner.nextLine();
                despesa.setDataVencimento(novaData);
                break;
            case 4:
                System.out.println("Digite a nova categoria:");
                String novaCategoria = scanner.nextLine();
                despesa.setCategoria(novaCategoria);
                break;
            default:
                System.out.println("Opção inválida.");
        }
        System.out.println("Despesa atualizada com sucesso!");
    }

    // Método para excluir uma despesa
    private void excluirDespesa(Despesa despesa) {
        despesas.remove(despesa);
        System.out.println("Despesa removida com sucesso!");
    }

    // Método para gerenciar tipos de despesa
    public void gerenciarTiposDespesa(Scanner scanner) {
        System.out.println("Gerenciar Tipos de Despesa:");
        System.out.println("1. Adicionar Tipo de Despesa ");
        System.out.println("2. Listar Tipos de Despesa");
        System.out.println("3. Remover Tipo de Despesa");

        int opcao = scanner.nextInt();
        scanner.nextLine(); 
        switch (opcao) {
            case 1:
                System.out.println("Digite o nome do novo tipo de despesa:");
                String tipo = scanner.nextLine();
                tiposDespesa.add(tipo);
                System.out.println("Tipo de despesa adicionado com sucesso!");
                break;
            case 2:
                System.out.println("Tipos de Despesa:");
                for (String t : tiposDespesa) {
                    System.out.println(t);
                }
                break;
            case 3:
                System.out.println("Digite o nome do tipo de despesa a ser removido:");
                String tipoRemover = scanner.nextLine();
                tiposDespesa.remove(tipoRemover);
                System.out.println("Tipo de despesa removido com sucesso!");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    // Método para chamar o gerenciamento de usuários
    public void chamarGerenciamentoUsuarios(Scanner scanner) {
        Usuario.gerenciarUsuarios(usuarios, scanner);
    }

    // Esse método principal é para iniciar o sistema de despesas 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaDespesa sistema = new SistemaDespesa();
        
        boolean sair = false;
        while (!sair) {
             // Nosso Menu bonito :)
             System.out.println("\n-----------|$|-------------");
             System.out.println("\nMenu Principal:");
             System.out.println("1. Entrar Despesa");
             System.out.println("2. Anotar Pagamento");
             System.out.println("3. Listar Despesas em Aberto no Período");
             System.out.println("4. Listar Despesas Pagas no Período");
             System.out.println("5. Gerenciar Tipos de Despesa");
             System.out.println("6. Gerenciar Usuários");
             System.out.println("7. Sair");
            
             // Aqui ele ira ler qual opção o usuario escolheu
             int opcao = scanner.nextInt();
            scanner.nextLine(); 
            
            // A ação para cada opcao
            switch (opcao) {
                case 1:
                    sistema.adicionarDespesa(scanner);
                    break;
                case 2:
                    sistema.registrarPagamento(scanner);
                    break;
                case 3:
                    sistema.listarDespesas(false, scanner);
                    break;
                case 4:
                    sistema.listarDespesas(true, scanner);
                    break;
                case 5:
                    sistema.gerenciarTiposDespesa(scanner);
                    break;
                case 6:
                    sistema.chamarGerenciamentoUsuarios(scanner);
                    break;
                case 7:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        
        scanner.close();
    }
} // fim 
