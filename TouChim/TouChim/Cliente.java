import java.util.ArrayList;
import java.util.List;

class Cliente {
    private int codigo;
    private String nome;
    private List<Conta> contas;
    
    public Cliente(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        contas = new ArrayList<>();
    }
    
    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public String getNome() {
        return nome;
    }
    
    public List<Conta> getContas() {
        return contas;
    }
}
