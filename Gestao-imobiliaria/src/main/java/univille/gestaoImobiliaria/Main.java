package univille.gestaoImobiliaria;

import univille.gestaoImobiliaria.DAO.ClienteDAO;
import univille.gestaoImobiliaria.DAO.ContratoDAO;
import univille.gestaoImobiliaria.DAO.ImovelDAO;
import univille.gestaoImobiliaria.Entidades.CadastroCliente;
import univille.gestaoImobiliaria.Entidades.CadastroImovel;
import univille.gestaoImobiliaria.Entidades.ContratoAluguel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main( String[] args )
    {
        int escolha;
        Scanner scanner = new Scanner(System.in);

        System.out.println("===========Imobiliaria DL==============");
        System.out.println();
        System.out.println("Bem vindo(a) ao sistema de gestão imobiliária da Imobiliaria DL !");
        System.out.println();

        // Loop principal do menu do sistema
        do{
            System.out.println("=========== Selecione qual área deseja entrar ==============");
            System.out.println("1- Clientes");
            System.out.println("2- Imóveis");
            System.out.println("3- Contratos de Aluguéis");
            System.out.println("0- Fechar sistema.");

            // Leitura da opção do usuário com tratamento de erro
            try {
                escolha = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida! Por favor, digite um número.");
                scanner.nextLine();
                escolha = -1;
            }
            scanner.nextLine();

            switch (escolha){
                case 1:
                    // Menu da área de Clientes
                    int escolhaCliente;
                    do{
                        System.out.println("          Área do Cliente          ");
                        System.out.println();
                        System.out.println("=========== Selecione o que deseja fazer ==============");
                        System.out.println("1- Cadastrar um cliente");
                        System.out.println("2- Visualizar clientes com mais contratos");
                        System.out.println("3- Visualizar todos os clientes");
                        System.out.println("0- Voltar ao menu de áreas");

                        // Leitura da opção do usuário com tratamento de erro
                        try {
                            escolhaCliente = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Opção inválida! Por favor, digite um número.");
                            scanner.nextLine();
                            escolhaCliente = -1;
                        }
                        scanner.nextLine();

                        switch (escolhaCliente) {
                            case 1:
                                // Cadastro de novo cliente
                                System.out.println("          Cadastro de cliente          ");
                                System.out.println("Digite o nome completo do cliente:");
                                String nome = scanner.nextLine();
                                System.out.println("Digite o email do cliente:");
                                String email = scanner.nextLine();
                                System.out.println("Digite o CPF do cliente (apenas números):");
                                String cpf = scanner.nextLine();

                                CadastroCliente novoCliente = new CadastroCliente(nome, email, cpf);
                                ClienteDAO cliente= new ClienteDAO();
                                cliente.cadastrarCliente(novoCliente);
                                break;

                            case 2:
                                // Mostra o cliente com mais contratos
                                ContratoDAO contratoDAO= new ContratoDAO();
                                contratoDAO.getClienteComMaisContratos();
                                break;

                            case 3:
                                // Lista todos os clientes cadastrados
                                System.out.println("          Lista de clientes          ");
                                ClienteDAO listaDeClientes = new ClienteDAO();
                                listaDeClientes.listarClientes();
                                break;

                            case 0:
                                System.out.println();
                                break;

                            default:
                                System.out.println("Opção inválida!");
                        }

                    } while (escolhaCliente!=0);
                    break;

                case 2:
                    // Menu da área de Imóveis
                    int escolhaImovel;
                    do {
                        System.out.println("          Área do Imóvel          ");
                        System.out.println();
                        System.out.println("=========== Selecione o que deseja fazer ==============");
                        System.out.println("1- Cadastrar um imóvel");
                        System.out.println("2- Visualizar imóveis disponíveis para locação");
                        System.out.println("0- Voltar ao menu de áreas");
                        try {
                            escolhaImovel  = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Opção inválida! Por favor, digite um número.");
                            scanner.nextLine();
                            escolhaImovel = -1;
                        }
                        scanner.nextLine();

                        switch (escolhaImovel){
                            case 1:
                                // Cadastro de novo imóvel
                                System.out.println("          Cadastro de Imóvel          ");
                                System.out.println("Digite o tipo de imóvel:");
                                String tipo = scanner.nextLine();

                                System.out.println("Digite o endereço do imóvel:");
                                String endereco = scanner.nextLine();

                                ImovelDAO verificaImovel = new ImovelDAO();
                                if (verificaImovel.imovelExiste(endereco)) {
                                    System.out.println("Imóvel já cadastrado com este endereço.");
                                    break;
                                }

                                // Valida entrada do tamanho do imóvel
                                double tamanho = 0.0;
                                boolean tamanhoValido = false;
                                while (!tamanhoValido) {
                                    System.out.println("Digite o tamanho do imóvel:");
                                    try {
                                        tamanho = scanner.nextDouble();
                                        tamanhoValido = true;
                                    } catch (InputMismatchException e) {
                                        System.out.println("⚠️ Entrada inválida. Por favor, digite apenas números para o tamanho.");
                                        scanner.nextLine();
                                    }
                                }
                                scanner.nextLine();

                                // Valida classificação do imóvel
                                String classificacao;
                                do {
                                    System.out.println("Comercial ou residencial?:");
                                    classificacao = scanner.nextLine().toLowerCase();

                                    if (!classificacao.equals("comercial") && !classificacao.equals("residencial")) {
                                        System.out.println("Classificação inválida. Digite 'comercial' ou 'residencial'.");
                                    }
                                } while (!classificacao.equals("comercial") && !classificacao.equals("residencial"));

                                CadastroImovel cadastroImovel = new CadastroImovel(tipo, endereco, tamanho, classificacao, false);
                                verificaImovel.cadastrarImovel(cadastroImovel);
                                System.out.println("Imóvel cadastrado com sucesso!");
                                break;

                            case 2:
                                // Lista imóveis disponíveis para locação
                                ImovelDAO listaImovel = new ImovelDAO();
                                listaImovel.imoveisDisponiveis();
                                break;

                            case 0:
                                System.out.println();
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    } while (escolhaImovel!=0);
                    break;

                case 3:
                    // Menu da área de Contratos de Aluguéis
                    int escolhaContrato;
                    do {
                        System.out.println("          Área Contrato de Aluguéis          ");
                        System.out.println();
                        System.out.println("=========== Selecione o que deseja fazer ==============");
                        System.out.println("1- Criar novo contrato");
                        System.out.println("2- Visualizar contratos ativos");
                        System.out.println("3- Visualizar contratos expirando nos proximos 30 dias");
                        System.out.println("0- Voltar ao menu de áreas");

                        try {
                            escolhaContrato = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Opção inválida! Por favor, digite um número.");
                            scanner.nextLine();
                            escolhaContrato = -1;
                        }
                        scanner.nextLine();

                        switch (escolhaContrato){
                            case 1:
                                System.out.println("          Cadastro de Aluguel          ");
                                ClienteDAO clienteDAO = new ClienteDAO();
                                ImovelDAO imovelDAO = new ImovelDAO();

                                CadastroCliente clienteSelecionado = null;
                                while (clienteSelecionado == null) {
                                    clienteDAO.listarClientes();
                                    System.out.println("Digite o número do cliente que alugará (número entre '[]'):");
                                    try {
                                        long idCliente = scanner.nextLong();
                                        scanner.nextLine();
                                        clienteSelecionado = clienteDAO.buscarClientePorId(idCliente);
                                        if (clienteSelecionado == null) {
                                            System.out.println("⚠️ Cliente inválido. Por favor, escolha um da lista.");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Entrada inválida. Por favor, digite um número.");
                                        scanner.nextLine();
                                        clienteSelecionado = null;
                                    }
                                }
                                System.out.println("✅ Cliente " + clienteSelecionado.getNome() + " selecionado com sucesso!");

                                CadastroImovel imovelSelecionado = null;
                                while (imovelSelecionado == null) {
                                    imovelDAO.imoveisDisponiveis();
                                    System.out.println("Digite o ID do imóvel que será alugado (número entre '[]'):");
                                    try {
                                        long idImovel = scanner.nextLong();
                                        scanner.nextLine();
                                        imovelSelecionado = imovelDAO.buscarImovelPorId(idImovel);
                                        if (imovelSelecionado == null || imovelSelecionado.isContratoAlugelAtivo()) {
                                            System.out.println("⚠️ Imóvel inválido ou já alugado. Por favor, escolha um da lista.");
                                            imovelSelecionado = null;
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Entrada inválida. Por favor, digite um número.");
                                        scanner.nextLine();
                                        imovelSelecionado = null;
                                    }
                                }
                                System.out.println("✅ Imóvel " + imovelSelecionado.getEndereco() + " selecionado com sucesso!");

                                BigDecimal valor = null;
                                while (valor == null) {
                                    System.out.println("Digite o valor do aluguel:");
                                    try {
                                        valor = scanner.nextBigDecimal();
                                        scanner.nextLine();
                                    } catch (InputMismatchException e) {
                                        System.out.println("Entrada inválida. Por favor, digite um número.");
                                        scanner.nextLine();
                                        valor = null;
                                    }
                                }

                                LocalDate dataInicio = null;
                                while (dataInicio == null) {
                                    System.out.println("Digite a data de início do contrato (formato AAAA-MM-DD):");
                                    String dataInicioStr = scanner.nextLine();
                                    try {
                                        dataInicio = LocalDate.parse(dataInicioStr);
                                    } catch (java.time.format.DateTimeParseException e) {
                                        System.out.println("Formato de data inválido. Por favor, use AAAA-MM-DD.");
                                    }
                                }

                                LocalDate dataFim = null;
                                while (dataFim == null) {
                                    System.out.println("Digite a data de término do contrato (formato AAAA-MM-DD):");
                                    String dataFimStr = scanner.nextLine();
                                    try {
                                        dataFim = LocalDate.parse(dataFimStr);
                                        if (dataFim.isBefore(dataInicio)) {
                                            System.out.println("⚠️ A data de término não pode ser anterior à data de início.");
                                            dataFim = null;
                                        }
                                    } catch (java.time.format.DateTimeParseException e) {
                                        System.out.println("Formato de data inválido. Por favor, use AAAA-MM-DD.");
                                    }
                                }

                                ContratoAluguel novoAluguel = new ContratoAluguel(valor, dataInicio, dataFim, true, clienteSelecionado, imovelSelecionado);
                                ContratoDAO contratoAluguelDAO = new ContratoDAO();
                                contratoAluguelDAO.cadastrarContrato(novoAluguel);

                                imovelDAO.imovelAlugado(imovelSelecionado.getIdImovel());
                                System.out.println("✅ Status do imóvel atualizado para 'Alugado'.");
                                break;

                            case 2:
                                ContratoDAO contratosAtivos = new ContratoDAO();
                                contratosAtivos.contratosAtivos();
                                break;

                            case 3:
                                ContratoDAO expirando = new ContratoDAO();
                                expirando.contratosExpirandoEm30Dias();
                                break;

                            case 0:
                                System.out.println();
                                break;

                            default:
                                System.out.println("Opção inválida");
                        }
                    } while (escolhaContrato != 0);
                    break;

                case 0:
                    System.out.println("Finalizando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (escolha != 0);
        scanner.close();
    }
}