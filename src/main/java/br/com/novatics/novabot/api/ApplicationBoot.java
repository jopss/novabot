package br.com.novatics.novabot.api;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import br.com.novatics.novabot.api.web.util.SlackSlashCommandConverter;

@SpringBootApplication
public class ApplicationBoot extends WebMvcConfigurationSupport {
        
	public static void main(String[] args) {
		SpringApplication.run(ApplicationBoot.class, args);
	}
	
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        SlackSlashCommandConverter slackSlashCommandConverter = new SlackSlashCommandConverter();
        MediaType mediaType = new MediaType("application","x-www-form-urlencoded", Charset.forName("UTF-8"));
        slackSlashCommandConverter.setSupportedMediaTypes(Arrays.asList(mediaType));
        converters.add(slackSlashCommandConverter);
        super.addDefaultHttpMessageConverters(converters);
    }
	
//	@Bean
//	public Jackson2ObjectMapperBuilder jacksonBuilder() {
//		Jackson2ObjectMapperBuilder b = new Jackson2ObjectMapperBuilder();
//		b.indentOutput(true).dateFormat(new SimpleDateFormat("dd/MM/yyyy"));
//		return b; 
//	} 
	
}
