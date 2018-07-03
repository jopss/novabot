package br.com.novatics.novabot.api.web.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Classe para retorno de dados do arquivo de parametros de sistema.
 */
@Service
public class ParametrosSistemaUtil {

	private static final String AMB_DESENV = "DESENVOLVIMENTO";
	private static final String AMB_HOMOLOG = "HOMOLOGACAO";

	@Value("${app.ambiente}")
	private String ambiente;

	@Value("${app.url.base}")
	private String urlBase;


	public String getUrlBaseRef() {
		return urlBase;
	}

	public String getAmbiente() {
		return ambiente;
	}

	public boolean isDesenvolvimento() {
		return AMB_DESENV.equalsIgnoreCase(ambiente);
	}

	public boolean isHomologacao() {
		return AMB_HOMOLOG.equalsIgnoreCase(ambiente);
	}

}
