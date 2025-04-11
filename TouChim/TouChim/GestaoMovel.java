import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class GestaoMovel {
    private Telemovel telemovel;
    private List<Contacto> contactos;


    public GestaoMovel(Telemovel telemovel) {
        this.telemovel = telemovel;
        this.contactos = new ArrayList<>();
    }

    public void adicionarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public void enviarMensagem(int numeroDestinatario, String mensagem) {
        telemovel.enviarMensagem(numeroDestinatario, mensagem);
       
    }

    public void efetuarChamada(int numeroChamada) {
        telemovel.efetuarChamada(numeroChamada);
    }

    public List<Contacto> getContactos() {
        return new ArrayList<>(contactos);
    }

    public String getModoFuncionamento() {
        return telemovel.getModoFuncionamento();
    }
    
    private static double valorTotalFaturas = 0.0;
    private static List<Fatura> faturas = new ArrayList<>();

    public static void adicionarFatura(Fatura fatura) {
        faturas.add(fatura);
        valorTotalFaturas += fatura.getValor();
        System.out.println("Fatura " + fatura.getValor() + " adicionada. Valor total das faturas: " + valorTotalFaturas);
    }

    public static double getValorTotalFaturas() {
        return valorTotalFaturas;
    }

    public static List<Fatura> getFaturas() {
        return new ArrayList<>(faturas);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Telemovel telemovel = new Telemovel(123456789, "Modo de funcionamento");
        GestaoMovel gestaoMovel = new GestaoMovel(telemovel);

        boolean sair = false;

        while (!sair) {
            System.out.println("MENU:");
            System.out.println("1 - Enviar mensagem");
            System.out.println("2 - Efetuar chamada");
            System.out.println("3 - Ver contactos");
            System.out.println("4 - Adicionar contacto");
            System.out.println("5 - Ver modo de funcionamento");
            System.out.println("6 - Alterar modo de funcionamento");
            System.out.println("7 - Ver faturas");
            System.out.println("8 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                     System.out.print("Número do destinatário: ");
                    int numeroDestinatario = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    System.out.print("Mensagem: ");
                    String mensagem = scanner.nextLine();

                    gestaoMovel.enviarMensagem(numeroDestinatario, mensagem);

                    // Determinar o tipo de mensagem com base no conteúdo (exemplo simples)
                    String tipoMensagem;
                    if (mensagem.contains("video")) {
                        tipoMensagem = "MensagemVideo";
                    } else if (mensagem.contains("imagem")) {
                        tipoMensagem = "MensagemImagem";
                    } else {
                        tipoMensagem = "SMS";
                    }

                    // Criar uma fatura para a mensagem e adicioná-la ao gestor de faturas
                    Fatura faturaMensagem = new Fatura(tipoMensagem);
                    GestaoMovel.adicionarFatura(faturaMensagem);

                    // Exibir a mensagem com o valor da fatura
                    System.out.println("Mensagem enviada! Fatura: " + faturaMensagem.getValor());
                    break;
                case 2:
                    System.out.print("Número do destinatário: ");
                    int numeroChamada = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    gestaoMovel.efetuarChamada(numeroChamada);

                    // Solicitar o tipo de chamada ao usuário
                    System.out.println("Escolha o tipo de chamada:");
                    System.out.println("1 - Chamada Normal");
                    System.out.println("2 - Chamada de Video");
                    System.out.print("Opção: ");
                    int opcaoTipoChamada = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    String tipoChamada;
                    switch (opcaoTipoChamada) {
                        case 1:
                            tipoChamada = "ChamadaNormal";
                        break;
                        case 2:
                            tipoChamada = "ChamadaVideo";
                        break;
                        default:
                            System.out.println("Opção inválida. Chamada não faturada.");
                        return; // Se a opção for inválida, sai do método sem faturar a chamada.
                    }

                    // Criar uma fatura para a chamada e adicioná-la ao gestor de faturas
                    Fatura faturaChamada = new Fatura(tipoChamada);
                    GestaoMovel.adicionarFatura(faturaChamada);

                    // Exibir a mensagem com o valor da fatura
                    System.out.println("Chamada efetuada! Fatura: " + faturaChamada.getValor());
                    break;

                case 3:
                    System.out.println("Contactos:");
                    for (Contacto contacto : gestaoMovel.getContactos()) {
                        System.out.println(contacto.getNome() + " - " + contacto.getNumero());
                    }
                    break;

                case 4:
                    System.out.print("Nome do contacto: ");
                    String nomeContacto = scanner.nextLine();

                    System.out.print("Número do contacto: ");
                    int numeroContacto = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    Contacto novoContacto = new Contacto(nomeContacto, numeroContacto);
                    gestaoMovel.adicionarContacto(novoContacto);
                    System.out.println("Contacto adicionado!");
                    break;

                case 5:
                    System.out.println("Modo de funcionamento: " + gestaoMovel.getModoFuncionamento());
                    break;

                case 6:
                    System.out.print("Novo modo de funcionamento: ");
                    String novoModoFuncionamento = scanner.nextLine();
                    System.out.println("Modo de funcionamento alterado!");
                    break;

                case 7:// Exibir faturas
                    System.out.println("Faturas:");
                    for (Fatura fatura : GestaoMovel.getFaturas()) {
                        System.out.println(fatura.getDescricao() + " - " + fatura.getValor());
                    }
                    break;
                    
                case 8:
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                break;
            }
            System.out.println();
        }

        scanner.close();
    }
}