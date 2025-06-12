package Controller;

import Model.Cliente;
import Model.Mesa;
import Model.Reserva;

import java.util.ArrayList;

public class ReservaController {
    private static ArrayList<Reserva> reservas = new ArrayList<>();

    public static void criarReserva(Cliente cliente, Mesa mesa, String dataHora) {
        if (mesa.isDisponivel()) {
            Reserva novaReserva = new Reserva(cliente, mesa, dataHora);
            reservas.add(novaReserva);
            mesa.reservar();
            System.out.println(" Reserva criada para " + cliente.getNome() + " na mesa " + mesa.getNumeroMesa());
        } else {
            System.out.println("Mesa " + mesa.getNumeroMesa() + " está ocupada.");
        }
    }

    public static void listarReservas() {
        for (Reserva reserva : reservas) {
            System.out.println("Reserva ID: " + reserva.getIdReserva() + " | Cliente: " + reserva.getCliente().getNome() +
                    " | Mesa: " + reserva.getMesa().getNumeroMesa() + " | Data: " + reserva.getDataHora());
        }
    }

    public static void cancelarReserva(int idReserva) {
        Reserva reservaParaCancelar = null;

        for (Reserva reserva : reservas) {
            if (reserva.getIdReserva() == idReserva) {
                reservaParaCancelar = reserva;
                break;
            }
        }

        if (reservaParaCancelar != null) {
            reservaParaCancelar.getMesa().liberar();
            reservas.remove(reservaParaCancelar);
            System.out.println("Reserva ID " + idReserva + " foi cancelada com sucesso.");
        } else {
            System.out.println("Reserva com ID " + idReserva + " não encontrada.");
        }
    }

    public static ArrayList<Reserva> getReservas() {
        return reservas;
    }

}
