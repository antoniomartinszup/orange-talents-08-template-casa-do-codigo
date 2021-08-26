package br.com.zupacademy.antonio.casadocodigo.controller.form;

import br.com.zupacademy.antonio.casadocodigo.model.Autor;
import br.com.zupacademy.antonio.casadocodigo.model.Categoria;
import br.com.zupacademy.antonio.casadocodigo.model.Livro;
import br.com.zupacademy.antonio.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.antonio.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.antonio.casadocodigo.validate.IdUnico;
import br.com.zupacademy.antonio.casadocodigo.validate.ItemGenericoUnico;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroForm {

    @NotBlank
    @ItemGenericoUnico(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Length(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @DecimalMin(value = "20")
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer paginas;

    @NotBlank
    @ItemGenericoUnico(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate lancamento;

    @NotNull
    @IdUnico(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;

    @NotNull
    @IdUnico(domainClass = Autor.class, fieldName = "id")
    private Long idAutor;

    public LivroForm(String titulo, String resumo, String sumario, BigDecimal preco, Integer paginas, String isbn,
                     @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING) LocalDate lancamento, Long idAutor, Long idCategoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.lancamento = lancamento;
        this.idAutor = idAutor;
        this.idCategoria = idCategoria;
    }


    public Livro converteParaModelLivro(AutorRepository aRepo, CategoriaRepository cRepo) {

        Autor autor = aRepo.findById(idAutor).get();
        Categoria categoria = cRepo.findById(idCategoria).get();

        return new Livro(this.titulo, this.resumo, this.preco, this.paginas,this.isbn,
                categoria, autor, this.sumario, this.lancamento);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getLancamento() {
        return lancamento;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }
}