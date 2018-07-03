package br.com.novatics.novabot.api.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.novatics.novabot.api.model.Mensagem;

public interface MensagemRepository extends CrudRepository<Mensagem, Long> {

}
