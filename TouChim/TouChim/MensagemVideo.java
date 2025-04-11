class MensagemVideo extends Comunicacao {
    private String resolucao;
    private String formato;
    private double duracao;
    
    public MensagemVideo(int numeroOrigem, int numeroDestino, String resolucao, String formato, double duracao) {
        super(numeroOrigem, numeroDestino);
        this.resolucao = resolucao;
        this.formato = formato;
        this.duracao = duracao;
        super.registrarValorComunicacao(numeroOrigem, duracao);
        super.registrarValorComunicacao(numeroDestino, duracao);
    }
    
    public String getResolucao() {
        return resolucao;
    }
    
    public String getFormato() {
        return formato;
    }
    
    public double getDuracao() {
        return duracao;
    }
}