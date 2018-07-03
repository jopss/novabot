package br.com.novatics.novabot.api.web.util;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.novatics.novabot.api.exception.NovabotException;

/**
 * Superclasse de todo Controlador do sistema.
 */
@CrossOrigin
public class NovabotController {
	
		@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
        @ExceptionHandler(NovabotException.class)
        @ResponseBody
        public String appException(HttpServletRequest req, Exception ex) {
                System.err.println("Request: " + req.getRequestURL() + " -> Lancou: " + ex);
                return "{mensagem: " + ex.getMessage() + "}";
        }
}
	

	

