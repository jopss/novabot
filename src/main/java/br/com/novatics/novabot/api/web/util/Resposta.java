package br.com.novatics.novabot.api.web.util;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import br.com.novatics.novabot.api.model.util.Modelo;

@JsonAutoDetect(fieldVisibility=Visibility.ANY)
public class Resposta {
        
	private Integer codigo;
	private List<Modelo> lista = new ArrayList<>();
	private List<RespostaMensagem> mensagens = new ArrayList<>();
        
        private Resposta(Integer codigo){
                this.codigo = codigo;
        }
        
        public static Resposta sucesso(){
                return new Resposta(200);
        }
        
        public static Resposta erro(){
                return new Resposta(500);
        }
        
        public static Resposta validacao(){
                return new Resposta(403);
        }
	
        public static Resposta permissaoNegada(){
                return new Resposta(401);
        }
        
        /**
         * As mensagens possuem chave e valor. Por padrao, a chave das mensagens
         * sera 'mensagem'.
         * 
         * @param valorMensagem String
         * @return Resposta
         */
        public Resposta comMensagem(String valorMensagem){
                mensagens.add(new RespostaMensagem(valorMensagem));
                return this;
        }
        
        public Resposta comMensagem(String chave, String valor){
                mensagens.add(new RespostaMensagem(chave, valor));
                return this;
        }
        
	public Resposta comLista(List lista) {
		this.lista = lista;
                return this;
	}
	
        /**
         * Mesmo que seja um objeto de retorno, sera inserido dentro
         * da listagem.
         * 
         * @param modelo Modelo
         * @return Resposta
         */
	public Resposta comDado(Modelo modelo) {
		this.lista.add(modelo);
                return this;
	}

}
