import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Telemovel extends Dispositivo{
    private Map<String, Integer> contactos = new HashMap<>();
    
    public Telemovel(int numero, String modoFuncionamento) {
        super(numero, modoFuncionamento);
    }
    
    public void adicionarContacto(String nome, int numero) {
        contactos.put(nome, numero);
    }
    
     public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("Não existem contatos.");
        } else {
            System.out.println("Lista de contatos:");
            for (Map.Entry<String, Integer> entry : contactos.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
    
    public int getNumeroDoContacto(String nome) {
        Integer numero = contactos.get(nome);
        if (numero == null) {
            System.out.println("O nome do contato '" + nome + "' não foi encontrado.");
        }
        return numero;
    }

    public void enviarMensagem(int numeroDestinatario, String mensagem) {
        System.out.println("Enviando mensagem para o número " + numeroDestinatario + ":");
        System.out.println(mensagem);
    }

    public void efetuarChamada(int numeroChamada) {
        System.out.println("Efetuando chamada para o número " + numeroChamada);
    }
}