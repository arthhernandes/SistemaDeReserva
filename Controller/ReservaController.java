package Controller;

import Model.Cliente;
import Model.Mesa;
import Model.Reserva;

import java.util.ArrayList;

public class ReservaController {
    private ArrayList<Reserva> reservas = new ArrayList<>();

    public void criarReserva(Cliente cliente, Mesa mesa, String dataHora) {
        if (mesa.isDisponivel()) {
            Reserva novaReserva = new Reserva(cliente, mesa, dataHora);
            reservas.add(novaReserva);
            mesa.reservar(); // Atualiza estado da mesa
            System.out.println("Reserva criada para " + cliente.getNome() + " na mesa " + mesa.getNumeroMesa());
        } else {
            System.out.println("Mesa " + mesa.getNumeroMesa() + " está ocupada.");
        }
    }

    public void listarReservas() {
        for (Reserva reserva : reservas) {
            System.out.println("Reserva ID: " + reserva.getIdReserva() + " | Cliente: " + reserva.getCliente().getNome() +
                    " | Mesa: " + reserva.getMesa().getNumeroMesa() + " | Data: " + reserva.getDataHora());
        }
    }
}
