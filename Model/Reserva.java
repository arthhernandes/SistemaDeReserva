package Model;

public class Reserva {
    private int idReserva;
    private Cliente cliente;
    private Mesa mesa;
    private String dataHora;

    public Reserva(Cliente cliente, Mesa mesa, String dataHora) {
        this.cliente = cliente;
        this.mesa = mesa;
        this.dataHora = dataHora;
    }

    public int getIdReserva() { return idReserva; }
    public Cliente getCliente() { return cliente; }
    public Mesa getMesa() { return mesa; }
    public String getDataHora() { return dataHora; }

    public void confirmarReserva() {
        mesa.reservar();
        System.out.println("Reserva confirmada para " + cliente.getNome() + " na mesa " + mesa.getNumeroMesa());
    }
}
