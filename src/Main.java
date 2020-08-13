import dao.ClienteDAO;
import dao.ImovelDAO;
import model.Cliente;
import model.Imovel;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
        System.out.println("\n\n");
    }

    public static void exibirInformacoesCliente(Cliente cliente){
        System.out.println("Nome: "+cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("Data de nascimento: " + cliente.getDataNascimento());
        System.out.println("Sexo: " + cliente.getSexo());
        System.out.println("Salário: " + cliente.getSalario());
        System.out.println("Emails: ");
        for (String s : cliente.getEmails())
            System.out.println(s);
        System.out.println("Telefones: ");
        for (String s : cliente.getTelefones())
            System.out.println(s);
        System.out.println("\n\n");
    }

    private static void listarTodosClientes() {
        List<Cliente> clientes = clienteDAO.getClientes();
        System.out.println("_________ Lista de clientes _________");
        for (Cliente cliente : clientes) {
            exibirInformacoesCliente(cliente);
        }
        System.out.println("___________________");
    }

    private static void listarUmCliente() {
        System.out.println("CPF do cliente que deseja listar:");
        String cpf = scanner.next();
        Cliente cliente = clienteDAO.getCliente(cpf);
        if (cliente != null)
            exibirInformacoesCliente(cliente);
        else {
            System.out.println("Cliente não encontrado");
        }
    }

    private static void excluirCliente() {
        System.out.println("CPF do cliente que deseja excluir:");
        String cpf = scanner.next();
        clienteDAO.excluirCliente(cpf);
    }

    private static void alterarCliente() {
        System.out.println("CPF do cliente que deseja alterar: ");
        String cpf = scanner.next();

        boolean existeCliente = clienteDAO.getCliente(cpf) != null;

        if (!existeCliente) {
            System.out.println("Cliente não encontrado");
            return ;
        }

        Cliente cliente = new Cliente();

        System.out.println("Nome: ");
        cliente.setNome(scanner.next());
        System.out.println("CPF: ");
        cliente.setCpf(scanner.next());

        System.out.println("Data de nascimento: ");
        boolean dataValida = false;
        while (!dataValida) {
            try {
                cliente.setDataNascimento(scanner.next());
                dataValida = true;
            } catch (ParseException e) {
                System.out.println("Data inválida, digite novamente:");
            }
        }

        System.out.println("Sexo: ");
        boolean sexoValido = false;
        while (!sexoValido) {
            try {
                cliente.setSexo(scanner.next());
                sexoValido = true;
            } catch (Exception e) {
                System.out.println("Sexo inválido, digite novamente: ");
            }
        }

        System.out.println("Salário: ");
        cliente.setSalario(scanner.nextDouble());
        System.out.println("Emails (q para terminar): ");

        List<String> emails = new ArrayList<>();
        String email = scanner.next();
        while (!email.equalsIgnoreCase("q")) {
            emails.add(email);
            email = scanner.next();
        }
        cliente.setEmails(emails);

        System.out.println("Telefones (q para terminar): ");
        List<String> telefones = new ArrayList<>();
        String telefone = scanner.next();
        while (!telefone.equalsIgnoreCase("q")) {
            telefones.add(telefone);
            telefone = scanner.next();
        }
        cliente.setTelefones(telefones);

        clienteDAO.alterarCliente(cpf, cliente);
    }

    private static void inserirCliente() {
        Cliente cliente = new Cliente();
        System.out.println("INSERIR CLIENTE");
        System.out.println("Nome: ");
        cliente.setNome(scanner.next());
        System.out.println("CPF: ");
        cliente.setCpf(scanner.next());

        System.out.println("Data de nascimento: ");
        boolean dataValida = false;
        while (!dataValida) {
            try {
                cliente.setDataNascimento(scanner.next());
                dataValida = true;
            } catch (ParseException e) {
                System.out.println("Data inválida, digite novamente:");
            }
        }

        System.out.println("Sexo: ");
        boolean sexoValido = false;
        while (!sexoValido) {
            try {
                cliente.setSexo(scanner.next());
                sexoValido = true;
            } catch (Exception e) {
                System.out.println("Sexo inválido, digite novamente: ");
            }
        }

        System.out.println("Salário: ");
        cliente.setSalario(scanner.nextDouble());
        System.out.println("Emails (q para terminar): ");

        List<String> emails = new ArrayList<>();
        String email = scanner.next();
        while (!email.equalsIgnoreCase("q")) {
            emails.add(email);
            email = scanner.next();
        }
        cliente.setEmails(emails);

        System.out.println("Telefones (q para terminar): ");
        List<String> telefones = new ArrayList<>();
        String telefone = scanner.next();
        while (!telefone.equalsIgnoreCase("q")) {
            telefones.add(telefone);
            telefone = scanner.next();
        }
        cliente.setTelefones(telefones);

        clienteDAO.inserirCliente(cliente);
    }

    private static int exibirMenu() {
        System.out.println();
        System.out.println("+++++++++++++ MENU PRINCIPAL +++++++++++++");
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
