import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

abstract class Dispositivo {
    private int numero;
    private String modoFuncionamento;
    private static Set<Integer> numerosUtilizados = new HashSet<>();
    private static List<Dispositivo> dispositivos = new ArrayList<>();
    public Dispositivo(int numero, String modoFuncionamento) {
        setnumero(numero);
        this.numero = numero;
        setModoFuncionamento(modoFuncionamento);
        Comunicacao.setNumerosDeDispositivos(Dispositivo.getnumdisp());
        dispositivos.add(this);
    }
    
    void setModoFuncionamento(String modo) {
        if ("4G".equalsIgnoreCase(modo) || "5G".equalsIgnoreCase(modo)) {
            this.modoFuncionamento = modo;
        } else {
           System.out.println("Modo de funcionamento inválido. Use 4G ou 5G.");
        }
        numerosUtilizados.add(numero);
    }
    
    void setnumero(int numero){
        if (numerosUtilizados.contains(numero)) {
            System.out.println("Número de dispositivo já está a ser utilizado.");
            return;
        }
        numerosUtilizados.add(numero);
    }
    
    public static Set<Integer> getnumdisp() {
        return new HashSet<>(numerosUtilizados); // Retorna uma cópia do conjunto para evitar modificações externas
    }
    
    public int getNumero() {
        return numero;
    }
    
    public String getModoFuncionamento() {
        return modoFuncionamento;
    }
    
    public static List<Dispositivo> getDispositivos5G() {
        List<Dispositivo> dispositivos5G = new ArrayList<>();
        for (Dispositivo dispositivo : dispositivos) {
            if ("5G".equalsIgnoreCase(dispositivo.getModoFuncionamento())) {
                dispositivos5G.add(dispositivo);
            }
        }
        return dispositivos5G;
    }
}
