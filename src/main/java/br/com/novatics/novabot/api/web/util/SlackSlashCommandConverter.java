package br.com.novatics.novabot.api.web.util;

import java.io.IOException;
import java.util.Map;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.novatics.novabot.api.model.Mensagem;

public class SlackSlashCommandConverter extends AbstractHttpMessageConverter<Mensagem> {

    // no need to reinvent the wheel for parsing the query string
    private static final FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected boolean supports(Class<?> clazz) {
        return (Mensagem.class == clazz);
    }

    @Override
    protected Mensagem readInternal(Class<? extends Mensagem> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        Map<String, String> vals = formHttpMessageConverter.read(null, inputMessage).toSingleValueMap();
        return mapper.convertValue(vals, Mensagem.class);
    }

    @Override
    protected void writeInternal(Mensagem slackSlashCommand, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

    }
}
