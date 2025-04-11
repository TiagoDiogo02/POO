class ChamadaNormal extends Comunicacao {
    private double duracao;
    
    public ChamadaNormal(int numeroOrigem, int numeroDestino, double duracao) {
        super(numeroOrigem, numeroDestino);
        this.duracao = duracao;
        super.registrarValorComunicacao(numeroOrigem, duracao);
        super.registrarValorComunicacao(numeroDestino, duracao);
    }
    
    public double getDuracao() {
        return duracao;
    }
}
