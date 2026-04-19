package ricardo.gabriel.praticando_spring.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MensagemRepository {

    public String obterMensagem() {
        return "Esta é a mensagem do repositório!";
    }
}
