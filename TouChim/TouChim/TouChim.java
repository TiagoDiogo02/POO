import java.util.ArrayList;
import java.util.List;

class TouChim {
    private List<Cliente> clientes;
    
    public TouChim() {
        clientes = new ArrayList<>();
    }
    
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    
    public List<Cliente> getClientes() {
        return clientes;
    }
}