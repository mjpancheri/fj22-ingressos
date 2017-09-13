package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class SessaoTest {

    @Test
    public void oPrecoDaSessaoDeveSerIgualASomaDaSalaMaisOPrecoDoFilme() {

	Sala sala = new Sala("Eldorado - IMAX", new BigDecimal("22.5"));
	Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12.0"));

	BigDecimal somaDosPrecosDaSalaEFilme = sala.getPreco().add(filme.getPreco());

	Sessao sessao = new Sessao(LocalTime.now(), filme, sala);

	Assert.assertEquals(somaDosPrecosDaSalaEFilme, sessao.getPreco());
    }

    @Test
    public void garanteLugarA1OcupadoEA2A3Disponiveis() {
	Lugar a1 = new Lugar("A", 1);
	Lugar a2 = new Lugar("A", 2);
	Lugar a3 = new Lugar("A", 3);

	Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12.0"));

	Sala eldorado1 = new Sala("Eldorado 1", new BigDecimal("8.5"));

	Sessao sessao = new Sessao(LocalTime.now(), filme, eldorado1);

	Ingresso ingresso = new Ingresso(sessao, a1, TipoDeIngresso.INTEIRO);

	Set<Ingresso> ingressos = Stream.of(ingresso).collect(Collectors.toSet());

	sessao.setIngressos(ingressos);

	Assert.assertFalse(sessao.isDisponivel(a1));
	Assert.assertTrue(sessao.isDisponivel(a2));
	Assert.assertTrue(sessao.isDisponivel(a3));

    }

}
