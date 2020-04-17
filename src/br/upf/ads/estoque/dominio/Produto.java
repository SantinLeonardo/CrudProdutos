
package br.upf.ads.estoque.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;
    private String especificacao;
    private Float preco;
    private Float quantidadeEstoque;
    private Float estoqueMinimo;

    public void validar() throws ValidarException {
        //Lista de erros que o método pode inicializar, quando encontrar erros de validação
        List<String> erros = new ArrayList<>();
        //O nome é obrigatório e deve ter entre 2 e 60 caracteres.
        if (nome == null)
            erros.add("O nome é obrigatório.");
        else if (nome.trim().length() < 2 || nome.trim().length() > 60)
            erros.add("O nome precisa ter entre 2 e 60 caracteres.");
        //O Preço deve ser superior a zero.
        else if ( preco == null || preco <= 0)
                erros.add("O Preço é obrigatório e deve ser maior que zero.");
        else if(estoqueMinimo == null || estoqueMinimo <0)
            erros.add("O estoque mínimo deve ser igual ou superior a zero");
            
        // Se houveram erros gera a exception
        if (erros.size() > 0)
        throw new ValidarException(erros);
    }
    
    public Produto() {
    }

    public Produto(Long id, String nome, String especificacao, Float preco, Float quantidadeEstoque, Float estoqueMinimo) {
        this.id = id;
        this.nome = nome;
        this.especificacao = especificacao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.estoqueMinimo = estoqueMinimo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.upf.ads.estoque.dominio.Produto{" + "id=" + id + '}';
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Float getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Float quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Float getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(Float estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }
    
    public String relatorioProduto(){
        return null;
    
    }
    
    
}
