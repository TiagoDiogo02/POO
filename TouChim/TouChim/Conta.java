import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Conta {
    private int codigo;
    private List<Dispositivo> dispositivos;
    
    public Conta(int codigo) {
        this.codigo = codigo;
        dispositivos = new ArrayList<>();
    }
    
    public void adicionarDispositivo(Dispositivo dispositivo) {
        dispositivos.add(dispositivo);
        ordenarDispositivosPorNumero();
    }
    
    private void ordenarDispositivosPorNumero() {
        Collections.sort(dispositivos, (d1, d2) -> Integer.compare(d1.getNumero(), d2.getNumero()));
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }
}