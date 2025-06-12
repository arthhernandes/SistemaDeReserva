package View;

import Controller.ClienteController;
import Controller.MesaController;
import Controller.ReservaController;
import Model.Cliente;
import Model.Mesa;

public class MainView {

    public static void iniciarSistema() {
        int opcao;

        do {
            exibirMenu();
            opcao = InputHelper.lerInt("Escolha uma opção: ");
            verificarOpcao(opcao);
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n=== Sistema de Reserva de Mesas ===");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Adicionar mesa");
        System.out.println("3 - Criar reserva");
        System.out.println("4 - Listar clientes");
        System.out.println("5 - Listar mesas");
        System.out.println("6 - Listar reservas");
        System.out.println("7 - Cancelar reserva");
        System.out.println("0 - Sair");
    }

    private static void verificarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> cadastrarCliente();
            case 2 -> adicionarMesa();
            case 3 -> criarReserva();
            case 4 -> ClienteController.listarClientes();
            case 5 -> MesaController.listarMesas();
            case 6 -> ReservaController.listarReservas();
            case 7 -> ReservaController.cancelarReserva();
            case 0 -> System.out.println("Encerrando o sistema.");
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void cadastrarCliente() {
        System.out.println("\n--- Cadastro de Cliente ---");
        int id = InputHelper.lerInt("ID do cliente: ");
        String nome = InputHelper.lerString("Nome: ");
        String sobrenome = InputHelper.lerString("Sobrenome: ");
        String telefone = InputHelper.lerString("Telefone: ");
        ClienteController.cadastrarCliente(id, nome, sobrenome, telefone);
    }

    private static void adicionarMesa() {
        System.out.println("\n--- Adicionar Mesa ---");
        int numero = InputHelper.lerInt("Número da mesa: ");
        int capacidade = InputHelper.lerInt("Capacidade da mesa: ");
        MesaController.adicionarMesa(numero, capacidade);
    }

    private static void criarReserva() {
        System.out.println("\n--- Criar Reserva ---");
        int idCliente = InputHelper.lerInt("ID do cliente: ");
        Cliente cliente = ClienteController.buscarCliente(idCliente);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        int numeroMesa = InputHelper.lerInt("Número da mesa: ");
        Mesa mesa = MesaController.buscarMesa(numeroMesa);

        if (mesa == null) {
            System.out.println("Mesa não encontrada.");
            return;
        }

        String dataHora = InputHelper.lerString("Data e hora da reserva (dd/mm/yyyy hh:mm): ");
        ReservaController.criarReserva(cliente, mesa, dataHora);
    }

    private void cancelarReserva() {
        int id = InputHelper.lerInt("ID da reserva a cancelar: ");
        boolean sucesso = cancelarReserva(id);
        if (!sucesso) {
            System.out.println("Reserva não encontrada.");
        }
    }
}
}
