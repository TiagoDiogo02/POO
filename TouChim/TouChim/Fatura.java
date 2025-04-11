public class Fatura {
    private String descricao;
    private double valor;

    public Fatura(String descricao) {
        this.descricao = descricao;
        this.valor = Tabela();
        if(valor!=0.0){
            System.out.println("Fatura "+valor);
        }
    }

    public String getDescricao() {
        return descricao;
    }
    
    public double getValor() {
        return valor;
    }
    
    public double Tabela() {
        double valor=0.0;
        switch (descricao) {
            case "MensagemVideo":
                valor = 2.0;
                break;
            case "MensagemImagem":
                valor = 1.0;
                break;
            case "Download":
                valor = 0.5;
                break;
            case "ChamadaNormal":
                valor = 3.0;
                break;
            case "SMS":
                valor = 1.5;
                break;
            case "ChamadaVideo":
                valor = 4.0;
                break;
            default:
                System.out.println("Descrição de fatura inválida.");
        }
        return valor-=valor*0.23;
    }
}