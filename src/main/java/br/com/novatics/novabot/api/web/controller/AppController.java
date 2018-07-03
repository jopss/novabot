package br.com.novatics.novabot.api.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.novatics.novabot.api.web.util.NovabotController;
import br.com.novatics.novabot.api.web.util.ParametrosSistemaUtil;

@RestController
public class AppController extends NovabotController {

	@Autowired
	private ParametrosSistemaUtil param;

	@GetMapping("/teste")
	public String teste() {
		return "App API NovaBot esta no ar! Ambiente: "+param.getAmbiente();
	}
}
