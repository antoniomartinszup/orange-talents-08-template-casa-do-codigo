package br.com.zupacademy.antonio.casadocodigo.controller.dto;

import br.com.zupacademy.antonio.casadocodigo.model.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroDto {

    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer paginas;
    private String isbn;
    private LocalDate lancamento;
    private Long idCategoria;
    private Long idAutor;

    @Deprecated
    public LivroDto() {
    }

    public LivroDto(Long id, String titulo, String resumo, String sumario, BigDecimal preco, Integer paginas,
                    String isbn, LocalDate lancamento, Long idAutor, Long idCategoria) {
        this.id = id;
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

    public static LivroDto converteParaLivroDto(Livro livro) {

        return new LivroDto(livro.getId(), livro.getTitulo(), livro.getResumo(), livro.getSumario(), livro.getPreco(),
                livro.getPaginas(), livro.getIsbn(), livro.getLancamento(),
                (livro.getAutor().getId()),
                (livro.getCategoria().getId()));
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

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }
}