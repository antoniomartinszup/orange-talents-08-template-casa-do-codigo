package br.com.zupacademy.antonio.casadocodigo.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @Length(max = 500)
    private String resumo;
    private String sumario;

    @Min(20)
    private BigDecimal preco;

    @Min(100)
    private Integer paginas;
    private String isbn;
    private LocalDate lancamento;

    @ManyToOne
    private Autor autor;

    @ManyToOne
    private Categoria categoria;

    @Deprecated
    public Livro() {
    }

    public Livro(String titulo, String resumo, BigDecimal preco, Integer paginas, String isbn, Categoria categoria,
                 Autor autor, String sumario, LocalDate lancamento) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.categoria = categoria;
        this.autor = autor;
        this.sumario = sumario;
        this.lancamento = lancamento;
    }

    public Long getId() {
        return id;
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

    public Autor getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}