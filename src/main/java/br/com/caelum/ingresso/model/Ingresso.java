package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ingresso {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Sessao sessao;

    @ManyToOne
    private Lugar lugar;

    @Enumerated(EnumType.STRING)
    private TipoDeIngresso tipoDeIngresso;
    BigDecimal preco;

    /**
     * @deprecated hibernate only
     */
    public Ingresso() {

    }

    public Ingresso(Sessao sessao, Lugar lugar, TipoDeIngresso tipoDeIngresso) {
	this.sessao = sessao;
	this.lugar = lugar;
	this.tipoDeIngresso = tipoDeIngresso;
	this.preco = this.tipoDeIngresso.aplicaDesconto(sessao.getPreco());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public void setTipoDeIngresso(TipoDeIngresso tipoDeIngresso) {
        this.tipoDeIngresso = tipoDeIngresso;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Sessao getSessao() {
	return sessao;
    }

    public BigDecimal getPreco() {
	return preco;
    }

    public Lugar getLugar() {
	return lugar;
    }

    public TipoDeIngresso getTipoDeIngresso() {
	return tipoDeIngresso;
    }

}
