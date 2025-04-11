public class Main {
    public static void main(String[] args) {
        Telemovel telemovel = new Telemovel(123456789, "Modo de funcionamento");
        GestaoMovel gestaoMovel = new GestaoMovel(telemovel);

        // Adicionar alguns contactos
        Contacto contacto1 = new Contacto("João", 111111111);
        Contacto contacto2 = new Contacto("Maria", 222222222);
        Contacto contacto3 = new Contacto("Pedro", 333333333);

        gestaoMovel.adicionarContacto(contacto1);
        gestaoMovel.adicionarContacto(contacto2);
        gestaoMovel.adicionarContacto(contacto3);

        // Enviar mensagem
        gestaoMovel.enviarMensagem(contacto2.getNumero(), "Olá, Maria!");

        // Efetuar chamada
        gestaoMovel.efetuarChamada(contacto3.getNumero());

        // Adicionar novo contacto
        Contacto novoContacto = new Contacto("Ana", 444444444);
        gestaoMovel.adicionarContacto(novoContacto);

        // Ver contactos
        System.out.println("Contactos:");
        for (Contacto contacto : gestaoMovel.getContactos()) {
            System.out.println(contacto.getNome() + " - " + contacto.getNumero());
        }

        // Ver modo de funcionamento
        System.out.println("Modo de funcionamento: " + gestaoMovel.getModoFuncionamento());

        // Alterar modo de funcionamento
        System.out.println("Modo de funcionamento alterado: " + gestaoMovel.getModoFuncionamento());
    }
}