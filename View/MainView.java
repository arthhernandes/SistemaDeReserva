package View;

import Controller.ClienteController;
import Controller.MesaController;
import Controller.ReservaController;
import Model.Cliente;
import Model.Mesa;
import View.InputHelper;


public class MainView {


    public static void menuPrincipal() {
        int opcao;
        do {
            System.out.println("\n--- Sistema de Reserva de Mesas ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Adicionar Mesa");
            System.out.println("4. Listar Mesas");
            System.out.println("5. Criar Reserva");
            System.out.println("6. Listar Reservas");
            System.out.println("7. Cancelar Reserva");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = InputHelper.getInt("");

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    adicionarMesa();
                    break;
                case 4:
                    listarMesas();
                    break;
                case 5:
                    criarReserva();
                    break;
                case 6:
                    listarReservas();
                    break;
                case 7:
                    cancelarReserva();
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void cadastrarCliente() {
        System.out.println("\n--- Cadastrar Novo Cliente ---");
        int id = InputHelper.getInt("Digite o ID do cliente: ");
        String nome = InputHelper.getString("Digite o nome do cliente: ");
        String sobrenome = InputHelper.getString("Digite o sobrenome do cliente: ");
        String telefone = InputHelper.getString("Digite o telefone do cliente: ");
        ClienteController.cadastrarCliente(id, nome, sobrenome, telefone);
        ClienteController.salvarClientes();
        
    }

    private static void listarClientes() {
        System.out.println("\n--- Clientes Cadastrados ---");
        ClienteController.listarClientes();
    }

    private static void adicionarMesa() {
        System.out.println("\n--- Adicionar Nova Mesa ---");
        int numero = InputHelper.getInt("Digite o número da mesa: ");
        int capacidade = InputHelper.getInt("Digite a capacidade da mesa: ");
        MesaController.adicionarMesa(numero, capacidade);
        MesaController.salvarMesas();
    }

    private static void listarMesas() {
        System.out.println("\n--- Mesas Disponíveis ---");
        MesaController.listarMesas();
    }

    private static void criarReserva() {
        System.out.println("\n--- Criar Nova Reserva ---");
        int idCliente = InputHelper.getInt("Digite o ID do cliente: ");
        Cliente cliente = ClienteController.buscarCliente(idCliente);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        int numeroMesa = InputHelper.getInt("Digite o número da mesa para a reserva: ");
        Mesa mesa = MesaController.buscarMesa(numeroMesa);

        if (mesa == null) {
            System.out.println("Mesa não encontrada.");
            return;
        }

        String dataHora = InputHelper.getString("Digite a data e hora da reserva (Ex: 12-06-2025 19:00): ");
        ReservaController.criarReserva(cliente, mesa, dataHora);
        ReservaController.salvarReservas();
    }

    private static void listarReservas() {
        System.out.println("\n--- Reservas Existentes ---");
        ReservaController.listarReservas();
    }

    private static void cancelarReserva() {
        System.out.println("\n--- Cancelar Reserva ---");
        int idReserva = InputHelper.getInt("Digite o ID da reserva a ser cancelada: ");
        ReservaController.cancelarReserva(idReserva);
    }
}