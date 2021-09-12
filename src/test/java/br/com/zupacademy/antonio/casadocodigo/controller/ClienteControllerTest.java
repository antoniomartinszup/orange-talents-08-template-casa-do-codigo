package br.com.zupacademy.antonio.casadocodigo.controller;

import br.com.zupacademy.antonio.casadocodigo.controller.form.ClienteForm;
import br.com.zupacademy.antonio.casadocodigo.controller.form.EstadoForm;
import br.com.zupacademy.antonio.casadocodigo.controller.form.PaisForm;
import br.com.zupacademy.antonio.casadocodigo.model.Estado;
import br.com.zupacademy.antonio.casadocodigo.model.Pais;
import br.com.zupacademy.antonio.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.antonio.casadocodigo.repository.PaisRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Test
    @DisplayName("Cadastra Cliente com sucesso")
    public void cadastraSucesso() throws Exception {

        //cenario
        PaisForm paisForm = new PaisForm("Brasil");
        Pais pais = paisRepository.save(paisForm.converteParaModelPais());

        EstadoForm estadoForm = new EstadoForm("Santa Catarina", 1L);
        Estado estado = estadoRepository.save(estadoForm.converteParaModelEstado(paisRepository));

        ClienteForm clienteForm = new ClienteForm("antonio@email.com", "Antonio", "Martins",
                "064.326.849-94", "Rua Waldemar Eggers", "Rua sem saida", "Joinville",
                1L, 1L, "47984750606", "89230793");

        //ação
        MockHttpServletRequestBuilder form = post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(clienteForm));

        //verificação
        mockMvc.perform(form)
                .andExpect(status().isOk());
    }
}