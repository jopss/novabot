package br.com.novatics.novabot.api;

import br.com.novatics.novabot.api.model.util.Modelo;
import br.com.novatics.novabot.api.util.FormatadorUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.ResultActions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

/**
 * Classe mae dos testes que centraliza configurações.
 */
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:application-test.properties")
@Rollback(false)
public abstract class AppTestsUtils {

        @Autowired
        protected MockMvc mvc;
        
        public ResultActions requestGet(String url) throws Exception{
                return this.mvc.perform(get(url)).andDo(print()).andExpect(status().isOk());
        }
        
        public ResultActions requestPost(String url, Modelo modelo) throws Exception{
                MockHttpServletRequestBuilder configPost = post(url).contentType(MediaType.APPLICATION_JSON).content(FormatadorUtil.convertToJson(modelo));
                return this.mvc.perform(configPost).andExpect(status().isOk());
        }
        
}
