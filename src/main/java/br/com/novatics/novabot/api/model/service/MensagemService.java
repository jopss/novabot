package br.com.novatics.novabot.api.model.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.novatics.novabot.api.model.Mensagem;
import br.com.novatics.novabot.api.model.repository.MensagemRepository;

@Service
public class MensagemService {
	
	@Autowired
	private MensagemRepository mensagemRepository;

	public void salvar(Mensagem mensagem) {
		if(StringUtils.isNotEmpty(mensagem.getText())) {
			int idxBy = mensagem.getText().indexOf("by");
			if(idxBy > 0) {
				String msg = mensagem.getText().substring(0, idxBy);
				String user = mensagem.getText().substring(idxBy+2);
				user = user.replace(":", "").replace("@", "");
				mensagem.setText(msg.trim());
				mensagem.setUserBy(user.trim());
			}
		}
		this.mensagemRepository.save(mensagem);
	}
	
	public List<Mensagem> retornarMensagens(){
		return (List<Mensagem>) this.mensagemRepository.findAll();
	}

}
