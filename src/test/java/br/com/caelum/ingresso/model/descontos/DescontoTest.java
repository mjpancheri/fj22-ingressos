package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.TipoDeIngresso;

public class DescontoTest {

    @Test
    public void deveConcederDesconto30PorcentoParaIngressoClienteBanco() {
	
	Lugar lugar = new Lugar("A",1);
	Sala sala = new Sala("Eldorado - IMAX", new BigDecimal("20.5"));
	Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12"));

	Sessao sessao = new Sessao(LocalTime.now(), filme, sala);
	Ingresso ingresso = new Ingresso(sessao, lugar, TipoDeIngresso.BANCO);

	BigDecimal precoEsperado = new BigDecimal("22.75");

	Assert.assertEquals(precoEsperado, ingresso.getPreco());
    }

    @Test
    public void deveConcederDesconto50PorcentoParaIngressoEstudante() {
	Lugar lugar = new Lugar("A",1);
	Sala sala = new Sala("Eldorado - IMAX", new BigDecimal("20.5"));
	Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12"));

	Sessao sessao = new Sessao(LocalTime.now(), filme, sala);
	Ingresso ingresso = new Ingresso(sessao, lugar, TipoDeIngresso.ESTUDANTE);

	BigDecimal precoEsperado = new BigDecimal("16.25");

	Assert.assertEquals(precoEsperado, ingresso.getPreco());
    }

    @Test
    public void naoDeveConcederDescontoParaIngressoNormal() {
	Lugar lugar = new Lugar("A",1);
	Sala sala = new Sala("Eldorado - IMAX", new BigDecimal("20.5"));
	Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12"));

	Sessao sessao = new Sessao(LocalTime.now(), filme, sala);
	Ingresso ingresso = new Ingresso(sessao, lugar, TipoDeIngresso.INTEIRO);

	BigDecimal precoEsperado = new BigDecimal("32.5");

	Assert.assertEquals(precoEsperado, ingresso.getPreco());
    }

}
