package br.com.zupacademy.antonio.casadocodigo.controller;

import br.com.zupacademy.antonio.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.antonio.casadocodigo.model.Autor;
import br.com.zupacademy.antonio.casadocodigo.repository.AutorRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
class AutorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    AutorRepository autorRepository;

    @Test
    @DisplayName("Cadastra Autor com sucesso")
    public void cadastraSucesso() throws Exception {

        //cenario
        AutorForm autorForm = new AutorForm("Antonio", "antonio@email.com", "Muito bom");

        //ação
        MockHttpServletRequestBuilder form = post("/autor")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(autorForm));

        //verificação
        mockMvc.perform(form)
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Falha no cadastro do Autor atributo nome")
    public void falhaNoCadastroAutorNome() throws Exception {

        //cenario
        AutorForm autorForm = new AutorForm("", "antonio@email.com", "Muito bom");

        //ação
        MockHttpServletRequestBuilder form = post("/autor")
                .locale(new Locale("pt", "BR"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(autorForm));

        //verificação
        mockMvc.perform(form)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].campo").value("nome"))
                .andExpect(jsonPath("$[0].erro").value("não deve estar em branco"))
                .andReturn().getResponse();
    }

    @Test
    @DisplayName("Falha no cadastro do Autor atributo email")
    public void falhaNoCadastroAutorEmail() throws Exception {

        //cenario
        AutorForm autorForm = new AutorForm("Antonio", "", "Muito bom");

        //ação
        MockHttpServletRequestBuilder form = post("/autor")
                .locale(new Locale("pt", "BR"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(autorForm));

        //verificação
        mockMvc.perform(form)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].campo").value("email"))
                .andExpect(jsonPath("$[0].erro").value("não deve estar em branco"))
                .andReturn().getResponse();
    }

    @Test
    @DisplayName("Falha no cadastro do Autor atributo descricao")
    public void falhaNoCadastroAutorDescricao() throws Exception {

        //cenario
        AutorForm autorForm = new AutorForm("Antonio", "antonio@email.com", "");

        //ação
        MockHttpServletRequestBuilder form = post("/autor")
                .locale(new Locale("pt", "BR"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(autorForm));

        //verificação
        mockMvc.perform(form)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].campo").value("descricao"))
                .andExpect(jsonPath("$[0].erro").value("não deve estar em branco"))
                .andReturn().getResponse();
    }

    @Test
    @DisplayName("Falha no cadastro do Autor atributo email formato invalido")
    public void falhaNoCadastroAutorEmailFormatoInvalido() throws Exception {

        //cenario
        AutorForm autorForm = new AutorForm("Antonio", "antonio.martins.com", "Muito bom");

        //ação
        MockHttpServletRequestBuilder form = post("/autor")
                .locale(new Locale("pt", "BR"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(autorForm));

        //verificação
        mockMvc.perform(form)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].campo").value("email"))
                .andExpect(jsonPath("$[0].erro").value("deve ser um endereço de e-mail bem formado"))
                .andReturn().getResponse();
    }

    @Test
    @DisplayName("Falha no cadastro do Autor atributo email duplicado")
    public void falhaNoCadastroAutorEmailDuplicado() throws Exception {

        //cenario
        Autor autorDuplicado = (new Autor("Antonio", "antonio@email.com", "Muito bom"));
        autorRepository.save(autorDuplicado);
        AutorForm autorForm = new AutorForm("Tony", "antonio@email.com", "Top");

        //ação
        MockHttpServletRequestBuilder form = post("/autor")
                .locale(new Locale("pt", "BR"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(autorForm));

        //verificação
        mockMvc.perform(form)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].campo").value("email"))
                .andExpect(jsonPath("$[0].erro").value("Item já cadastrado"))
                .andReturn().getResponse();
    }
}