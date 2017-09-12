package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

public class SessaoTest {
    
    @Test
    public void oPrecoDaSessaoDeveSerIgualASomaDaSalaMaisOPrecoDoFilme(){
	
	Sala sala = new Sala("Eldorado - IMAX", new BigDecimal("22.5"));
	Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI"	, new BigDecimal("12.0"));
	
	BigDecimal somaDosPrecosDaSalaEFilme = sala.getPreco().add(filme.getPreco());
	
	Sessao sessao = new Sessao(LocalTime.now(), filme, sala);
	
	Assert.assertEquals(somaDosPrecosDaSalaEFilme, sessao.getPreco());
    }

}
