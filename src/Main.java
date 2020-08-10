import dao.ClienteDAO;
import dao.ImovelDAO;
import model.Cliente;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static ClienteDAO clienteDAO;
    private static ImovelDAO imovelDAO;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        clienteDAO = new ClienteDAO();
        imovelDAO = new ImovelDAO();

        int opcaoMenu = -1;
        int opcaoSubmenu = -1;

        while (true) {
            opcaoMenu = exibirMenu();
            opcaoSubmenu = exibirSubmenu(opcaoMenu);

            if (opcaoMenu == 1) {
                switch (opcaoSubmenu) {
                    case 1:
                        inserirCliente();
                        break;
                    case 2:
                        alterarCliente();
                        break;
                    case 3:
                        excluirCliente();
                        break;
                    case 4:
                        listarUmCliente();
                        break;
                    case 5:
                        listarTodosClientes();
                        break;
                }
            } else if (opcaoMenu == 2) {
                switch (opcaoSubmenu) {
                    case 1:
//                        inserirImovel();
                        break;
                    case 2:
//                        alterarImovel();
                        break;
                    case 3:
//                        excluirImovel();
                        break;
                    case 4:
//                        listarUmImovel();
                        break;
                    case 5:
//                        listarTodosImoveis();
                        break;
                }
            }
        }
    }

    private static void listarTodosClientes() {
        List<Cliente> clientes = clienteDAO.getClientes();
        for (Cliente cliente : clientes) {
            // CHAMAR METODO QUE LISTA UM CLIENTE
        }
    }

    private static void listarUmCliente() {
        System.out.println("CPF do cliente que deseja listar:");
        String cpf = scanner.next();
        Cliente cliente = clienteDAO.getCliente(cpf);

        // FAZER METODO QUE LISTA UM CLIENTE
    }

    private static void excluirCliente() {
        System.out.println("CPF do cliente que deseja excluir:");
        String cpf = scanner.next();
        clienteDAO.excluirCliente(cpf);
    }

    private static void alterarCliente() {
        Cliente cliente = new Cliente();

        System.out.println("CPF do cliente que deseja alterar: ");
        String cpf = scanner.next();

        // PEGAR OS DADOS ATUALIZADOS DO CLIENTE E SETAR NO OBJETO CLIENTE

        clienteDAO.alterarCliente(cpf, cliente);
    }

    private static void inserirCliente() {
        Cliente cliente = new Cliente();

        // PEGAR OS DADOS DO NOVO CLIENTE E SETAR NO OBJETO CLIENTE

        clienteDAO.inserirCliente(cliente);
    }

    private static int exibirMenu() {
        System.out.println();
        System.out.println("============= MENU PRINCIPAL =============");
        System.out.println("1. Submenu de Clientes");
        System.out.println("2. Submenu de Imóveis");
        System.out.println("3. Sair");
        return scanner.nextInt();
    }

    private static int exibirSubmenu(int opcaoMenu) {
        switch (opcaoMenu) {
            case 1:
                return exibirSubmenuClientes();
            case 2:
                return exibirSubmenuImoveis();
            case 3:
                System.exit(1);
            default:
                return -1;
        }
    }

    private static int exibirSubmenuClientes() {
        System.out.println("------ Submenu de Clientes -------");
        System.out.println("1. Inserir cliente");
        System.out.println("2. Alterar cliente");
        System.out.println("3. Excluir cliente");
        System.out.println("4. Listar um cliente");
        System.out.println("5. Listar todos os clientes");
        return scanner.nextInt();
    }

    private static int exibirSubmenuImoveis() {
        System.out.println("------ Submenu de Imóveis-------");
        System.out.println("1. Inserir imóvel");
        System.out.println("2. Alterar imóvel");
        System.out.println("3. Excluir imóvel");
        System.out.println("4. Listar um imóvel");
        System.out.println("5. Listar todos os imóveis");
        return scanner.nextInt();
    }
}
