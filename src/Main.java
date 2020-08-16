import dao.ClienteDAO;
import dao.ImovelDAO;
import model.Cliente;
import model.Imovel;

import java.text.ParseException;
import java.util.*;

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
        System.out.println("\nINSERIR IMÓVEL\n");
        Imovel imovel = obterInformacoesImovel();

        while (!imovelDAO.incluirImovel(imovel)){
            System.out.println("\nCódigo inválido! Insira um novo código para esse imóvel");
            System.out.println("Código: ");
            imovel.setCodigo(scanner.nextLine());
        }

        System.out.println("\nImóvel incluído com sucesso!");
    }

    private static void alterarImovel(){
        System.out.println("\nALTERAR IMÓVEL\n");
        Imovel imovel = obterInformacoesImovel();

        while (!imovelDAO.alterarImovel(imovel.getCodigo(), imovel)){
            System.out.println("Não foi encontrado um imóvel com esse código!");
            System.out.println("Digite um código já existente: ");
            imovel.setCodigo(scanner.nextLine());
        }

        System.out.println("Imóvel de código "+imovel.getCodigo()+" foi alterado com sucesso!");
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
        System.out.println("Código do imóvel " + imovel.getCodigo());
        System.out.println("Tipo do imóvel: " + imovel.getTipo());
        System.out.println("Descrição: " + imovel.getDescricao());
        System.out.print("Rua: " + imovel.getRua());
        System.out.println(", Número: " + imovel.getNumero());
        System.out.print("Cidade: " + imovel.getCidade());
        System.out.println("Estado " + imovel.getEstado());
        System.out.println("Itens de segurança: " + String.join(",", imovel.getItensSeguranca()));
        System.out.println("Valor aluguel: " + imovel.getValorAluguel());
        System.out.println("Valor condomínio: " + imovel.getValorCondominio());
    }

    public static Imovel obterInformacoesImovel() {
        Imovel imovel = new Imovel();
        scanner.nextLine();

        System.out.print("Código: ");
        imovel.setCodigo(scanner.nextLine());

        System.out.println("Descrição: ");
        imovel.setDescricao(scanner.nextLine());

        System.out.println("Rua: ");
        imovel.setRua(scanner.nextLine());

        boolean valido = false;
        while (!valido){
            try{
                System.out.println("Número:");
                imovel.setNumero(Integer.parseInt(scanner.nextLine()));
                valido = true;
            }catch (Exception e){
                System.out.println("Valor inválido! Digite novamente");
                valido = false;
            }
        }

        System.out.println("Bairro: ");
        imovel.setBairro(scanner.nextLine());

        System.out.println("Cidade: ");
        imovel.setCidade(scanner.nextLine());

        System.out.println("Estado: ");
        imovel.setEstado(scanner.nextLine());

        System.out.println("Pais: ");
        imovel.setPais(scanner.nextLine());

        System.out.println("CEP: ");
        imovel.setCep(scanner.nextLine());

        System.out.println("Tipo: ");
        imovel.setTipo(scanner.nextLine());

        valido = false;
        while (!valido){
            try{
                System.out.println("Quantidade de garagens: ");
                imovel.setQuantidadeGaragens(Integer.parseInt(scanner.nextLine()));
                valido = true;
            }catch (Exception e){
                System.out.println("Valor inválido! Digite novamente\n");
                valido = false;
            }
        }

        valido = false;
        while (!valido){
            try{
                System.out.println("Quantidade de suites: ");
                imovel.setQuantidadeSuites(Integer.parseInt(scanner.nextLine()));
                valido = true;
            }catch (Exception e){
                System.out.println("Valor inválido! Digite novamente\n");
                valido = false;
            }
        }

        valido = false;
        while (!valido){
            try{
                System.out.println("Quantidade de quartos: ");
                imovel.setQuantidadeQuartos(Integer.parseInt(scanner.nextLine()));
                valido = true;
            }catch (Exception e){
                System.out.println("Valor inválido! Digite novamente\n");
                valido = false;
            }
        }

        System.out.println("Itens de segurança: (separados por vírgula)");
        String[] itens = scanner.nextLine().split(",");
        List<String> itensList = Arrays.asList(itens);
        imovel.setItensSeguranca(itensList);

        valido = false;
        while (!valido){
            try{
                System.out.println("Valor aluguel: ");
                imovel.setValorAluguel(Double.parseDouble(scanner.nextLine()));
                valido = true;
            }catch (Exception e){
                System.out.println("Valor inválido! Digite novamente\n");
                valido = false;
            }
        }

        valido = false;
        while (!valido){
            try{
                System.out.println("Valor condomínio: ");
                imovel.setValorCondominio(Double.parseDouble(scanner.nextLine()));
                valido = true;
            }catch (Exception e){
                System.out.println("Valor inválido! Digite novamente\n");
                valido = false;
            }
        }

        return imovel;
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
