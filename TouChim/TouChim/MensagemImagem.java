class MensagemImagem extends Comunicacao {
    private int tamanho;
    private String formato;
    private String resolucao;
    
    public MensagemImagem(int numeroOrigem, int numeroDestino, int tamanho, String formato, String resolucao) {
        super(numeroOrigem, numeroDestino);
        this.tamanho = tamanho;
        this.formato = formato;
        this.resolucao = resolucao;
        super.registrarValorComunicacao(numeroOrigem, tamanho);
        super.registrarValorComunicacao(numeroDestino, tamanho);
    }
    
    public int getTamanho() {
        return tamanho;
    }
    
    public String getFormato() {
        return formato;
    }
    
    public String getResolucao() {
        return resolucao;
    }
}
