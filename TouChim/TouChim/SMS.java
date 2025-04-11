class SMS extends Comunicacao {
    private int tamanho;
    private String texto;
    
    public SMS(int numeroOrigem, int numeroDestino, int tamanho, String texto) {
        super(numeroOrigem, numeroDestino);
        this.tamanho = tamanho;
        this.texto = texto;
        super.registrarValorComunicacao(numeroOrigem, tamanho);
        super.registrarValorComunicacao(numeroDestino, tamanho);
    }
    
    public int getTamanho() {
        return tamanho;
    }
    
    public String getTexto() {
        return texto;
    }
}