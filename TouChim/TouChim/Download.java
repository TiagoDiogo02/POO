class Download extends Comunicacao {
    private int tamanho;
    private double duracao;
    
    public Download(int numeroOrigem, int numeroDestino, int tamanho, double duracao) {
        super(numeroOrigem, numeroDestino);
        this.tamanho = tamanho;
        this.duracao = duracao;
        super.registrarValorComunicacao(numeroOrigem, duracao);
        super.registrarValorComunicacao(numeroDestino, duracao);
    }
    
    public int getTamanho() {
        return tamanho;
    }
    
    public double getDuracao() {
        return duracao;
    }
}