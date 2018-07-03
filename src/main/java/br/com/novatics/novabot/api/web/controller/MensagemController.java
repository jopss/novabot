package br.com.novatics.novabot.api.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.novatics.novabot.api.model.Mensagem;
import br.com.novatics.novabot.api.model.service.MensagemService;
import br.com.novatics.novabot.api.web.util.NovabotController;
import br.com.novatics.novabot.api.web.util.Resposta;

@RestController
public class MensagemController extends NovabotController {

	@Autowired
	private MensagemService mensagemService;

//	@RequestMapping(
//        value = "/mensagem/salvar", method = RequestMethod.POST,
//        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE
//    )
	@PostMapping(value = "/mensagem/salvar", produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public Resposta cadastrar(@RequestBody Mensagem mensagem) {
		mensagemService.salvar(mensagem);
		return Resposta.sucesso().comDado(mensagem);
	}

	@GetMapping(value = "/mensagens", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resposta listar() {
		List<Mensagem> lista = mensagemService.retornarMensagens();
		return Resposta.sucesso().comLista(lista);
	}
	
}
