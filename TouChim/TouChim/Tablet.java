class Tablet extends Dispositivo {
    private int memoriaDisponivel;
    
    public Tablet(int numero, String modoFuncionamento, int memoriaDisponivel) {
        super(numero, modoFuncionamento);
        this.memoriaDisponivel = memoriaDisponivel;
    }
    
    public int getMemoriaDisponivel() {
        return memoriaDisponivel;
    }
}