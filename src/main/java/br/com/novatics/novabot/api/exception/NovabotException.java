package br.com.novatics.novabot.api.exception;

public class NovabotException extends RuntimeException {

        public NovabotException(String message) {
                super(message);
        }

        public NovabotException(Throwable cause) {
                super(cause);
        }
        
}
