package br.com.zupacademy.antonio.casadocodigo.controller;

import br.com.zupacademy.antonio.casadocodigo.controller.form.CategoriaForm;
import br.com.zupacademy.antonio.casadocodigo.model.Categoria;
import br.com.zupacademy.antonio.casadocodigo.repository.CategoriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import javax.transaction.Transactional;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
class CategoriaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    @DisplayName("Cadastra Categoria com sucesso")
    public void cadastraSucesso() throws Exception {

        //cenario
        CategoriaForm categoriaForm = new CategoriaForm("Tecnologia");

        //ação
        MockHttpServletRequestBuilder form = post("/categoria")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(categoriaForm));

        //verificação
        mockMvc.perform(form)
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Falha no cadastro da Categoria atributo nome")
    public void falhaNoCadastroCategoriaNome() throws Exception {

        //cenario
        CategoriaForm categoriaForm = new CategoriaForm("");

        //ação
        MockHttpServletRequestBuilder form = post("/categoria")
                .locale(new Locale("pt", "BR"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(categoriaForm));

        //verificação
        mockMvc.perform(form)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].campo").value("nome"))
                .andExpect(jsonPath("$[0].erro").value("não deve estar em branco"))
                .andReturn().getResponse();
    }

    @Test
    @DisplayName("Falha no cadastro da Categoria atributo nome duplicado")
    public void falhaNoCadastroCategoriaNomeDuplicado() throws Exception {

        //cenario
        Categoria categoriaDuplicada = categoriaRepository.save(new Categoria("Tecnologia"));
        CategoriaForm categoriaForm = new CategoriaForm("Tecnologia");

        //ação
        MockHttpServletRequestBuilder form = post("/categoria")
                .locale(new Locale("pt", "BR"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(categoriaForm));

        //verificação
        mockMvc.perform(form)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].campo").value("nome"))
                .andExpect(jsonPath("$[0].erro").value("Item já cadastrado"))
                .andReturn().getResponse();
    }

}