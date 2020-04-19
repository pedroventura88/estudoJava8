package interfaces.funcionais.entidade;

import java.util.Objects;

public class Livros {
    private String nome;
    private int valor;
    private boolean aVenda;
    private String estadoLivro;

    public Livros(String nome, int valor, String estadoLivro) {
        this.nome = nome;
        this.valor = valor;
        this.estadoLivro = estadoLivro;
        this.aVenda = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isaVenda() {
        return aVenda;
    }

    public void setaVenda() {
        this.aVenda = true;
    }

    public String getEstadoLivro() {
        return estadoLivro;
    }

    public void setEstadoLivro(String estadoLivro) {
        this.estadoLivro = estadoLivro;
    }

    //método criado para comparar o objeto inteiro
    //escrever "eq + espaço". Ele irá gerar este comparador.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livros livros = (Livros) o;
        return valor == livros.valor &&
                aVenda == livros.aVenda &&
                Objects.equals(nome, livros.nome) &&
                Objects.equals(estadoLivro, livros.estadoLivro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, valor, aVenda, estadoLivro);
    }
}

