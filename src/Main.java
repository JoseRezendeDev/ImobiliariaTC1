import dao.ClienteDAO;
import dao.ImovelDAO;
import model.Cliente;
import model.Imovel;

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
                        inserirImovel();
                        break;
                    case 2:
                        alterarImovel();
                        break;
                    case 3:
                        excluirImovel();
                        break;
                    case 4:
                        listarUmImovel();
                        break;
                    case 5:
                        listarTodosImoveis();
                        break;
                }
            }
        }
    }

    private static void inserirImovel(){
        Imovel imovel = new Imovel();
        if(imovelDAO.incluirImovel(imovel)){
            System.out.println("Imóvel incluído com sucesso!");
        }else{
            System.out.println("Ops! Algo de errado não deu certo! Verifique as informações do imóvel");
        }
    }

    private static void alterarImovel(){
        Imovel imovel = new Imovel();

        System.out.println("Código do imóvel que deseja alterar: ");
        String codigo = scanner.next();

        if(imovelDAO.alterarImovel(codigo, imovel)){
            System.out.println("Imóvel de código "+codigo+" foi alterado com sucesso!");
        }else{
            System.out.println("Não foi possível encontrar imóvel com esse código :(");
        }
    }

    private static void excluirImovel(){
        System.out.println("Código do imóvel que deseja excluir: ");
        String codigo = scanner.next();
        if(imovelDAO.excluirImovel(codigo)){
            System.out.println("Imóvel de código "+codigo+" foi excluído com sucesso");
        }else{
            System.out.println("Não foi possível excluir imóvel. Código não encontrado");
        }
    }

    private static void listarUmImovel(){
        System.out.println("Código do imóvel que deseja listar: ");
        String codigo = scanner.next();
        Imovel imovel = imovelDAO.getImovel(codigo);

        System.out.println("_________ Informações do imóvel _________");
            exibirInformacoesImovel(imovel);
        System.out.println("__________________");
    }

    private static void listarTodosImoveis(){
        List<Imovel> imovelList = imovelDAO.getImoveis();
        System.out.println("_________ Lista de imóveis _________");
        for(Imovel imovel : imovelList){
            exibirInformacoesImovel(imovel);
        }
        System.out.println("_________ Fim da Lista de imóveis _________");
    }

    public static void exibirInformacoesImovel(Imovel imovel){
        System.out.println("Tipo do imóvel: " + imovel.getTipo());
        System.out.println("Descrição: " + imovel.getDescricao());
        System.out.println("\n");
        System.out.print("Rua: " + imovel.getRua());
        System.out.print(", Número: " + imovel.getNumero());
        System.out.println("Cidade: " + imovel.getCidade());
        System.out.println("\n");
        System.out.println("Valor aluguel: " + imovel.getValorAluguel());
        System.out.println("Valor condomínio: " + imovel.getValorCondominio());
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
