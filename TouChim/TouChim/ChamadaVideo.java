class ChamadaVideo extends Comunicacao {
    private double duracao;
    private String resolucao;
    
    public ChamadaVideo(int numeroOrigem, int numeroDestino, double duracao, String resolucao) {
        super(numeroOrigem, numeroDestino);
        this.duracao = duracao;
        this.resolucao = resolucao;
        super.registrarValorComunicacao(numeroOrigem, duracao);
        super.registrarValorComunicacao(numeroDestino, duracao);
    }
    
    public double getDuracao() {
        return duracao;
    }
    
    public String getResolucao() {
        return resolucao;
    }
}
