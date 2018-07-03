package br.com.novatics.novabot.api.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.novatics.novabot.api.model.Mensagem;
import br.com.novatics.novabot.api.model.repository.MensagemRepository;

@Service
public class MensagemService {
	
	@Autowired
	private MensagemRepository mensagemRepository;

	public void salvar(Mensagem mensagem) {
		this.mensagemRepository.save(mensagem);
	}
	
	public List<Mensagem> retornarMensagens(){
		return (List<Mensagem>) this.mensagemRepository.findAll();
	}

}
