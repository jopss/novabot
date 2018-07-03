package br.com.novatics.novabot.api.web.util;

public class RespostaMensagem {
        
        private String chave = "mensagem";
        private String valor;

        public RespostaMensagem(String valor) {
                this.valor = valor;
        }

        public RespostaMensagem(String chave, String valor) {
                this.chave = chave;
                this.valor = valor;
        }

        public String getChave() {
                return chave;
        }

        public String getValor() {
                return valor;
        }
}
