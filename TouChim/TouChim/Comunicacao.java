import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class Comunicacao {
    private int numeroOrigem;
    private int numeroDestino;
    private static Set<Integer> numerosDeDispositivos;
    private static Map<Integer, List<Comunicacao>> comunicacoesFeitasPorDispositivo = new HashMap<>();
    private static Map<Integer, List<Comunicacao>> comunicacoesRecebidasPorDispositivo = new HashMap<>();
    private static Map<Integer, Map<String, Double>> valorComunicacoesPorDispositivo = new HashMap<>();
    
    public static void setNumerosDeDispositivos(Set<Integer> numeros) {
        numerosDeDispositivos = numeros;
    }
    
    public Comunicacao(int numeroOrigem, int numeroDestino) {
        if (!numerosDeDispositivos.contains(numeroOrigem) || !numerosDeDispositivos.contains(numeroDestino)) {
            System.out.println("Números de dispositivos inválidos.");
            return;
        }
        this.numeroOrigem = numeroOrigem;
        this.numeroDestino = numeroDestino;
        registarComunicacaoPorNumero(numeroOrigem, this, comunicacoesFeitasPorDispositivo);
        registarComunicacaoPorNumero(numeroDestino, this, comunicacoesRecebidasPorDispositivo);
    }
    
    private void registarComunicacaoPorNumero(int numero, Comunicacao comunicacao, Map<Integer, List<Comunicacao>> mapa) {
        mapa.computeIfAbsent(numero, k -> new ArrayList<>()).add(comunicacao);
    }
    
    public int getNumeroOrigem() {
        return numeroOrigem;
    }
    
    public int getNumeroDestino() {
        return numeroDestino;
    }
    
    public static List<Comunicacao> getComunicacoesFeitasPorDispositivo(int numeroDispositivo) {
        return new ArrayList<>(comunicacoesFeitasPorDispositivo.getOrDefault(numeroDispositivo, new ArrayList<>()));
    }

    public static List<Comunicacao> getComunicacoesRecebidasPorDispositivo(int numeroDispositivo) {
        return new ArrayList<>(comunicacoesRecebidasPorDispositivo.getOrDefault(numeroDispositivo, new ArrayList<>()));
    }
    
    protected void registrarValorComunicacao(int numero, double valor) {
        String tipoComunicacao = this.getClass().getSimpleName();
        valorComunicacoesPorDispositivo.computeIfAbsent(numero, k -> new HashMap<>()).put(tipoComunicacao, valor);
    }
    
    public static Map<Integer, Map<String, Double>> getValorComunicacoesPorDispositivoCompleto() {
        return Collections.unmodifiableMap(valorComunicacoesPorDispositivo);
    }
}