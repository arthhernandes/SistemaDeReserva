package Model;

public class Cliente extends Pessoa {

    public Cliente(int id, String nome, String sobrenome, String telefone) {
        super(id, nome, sobrenome, telefone);
    }


    public void fazerReserva(Reserva reserva) {
        System.out.println("Reserva feita para " + getNome() + " na mesa " + reserva.getMesa().getNumeroMesa());
    }

    public void cancelarReserva(Reserva reserva) {
        System.out.println("Reserva cancelada para " + getNome() + ".");
    }

    public void listarReservas() {
        System.out.println("Listando reservas de " + getNome());
    }

}
