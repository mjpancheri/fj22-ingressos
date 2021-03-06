package br.com.caelum.ingresso.model.form;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.caelum.ingresso.dao.LugarDao;
import br.com.caelum.ingresso.dao.SessaoDao;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.TipoDeIngresso;

public class CarrinhoForm {

    private List<Ingresso> ingressos = new ArrayList<>();

    public List<Ingresso> getIngressos() {
	return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
	this.ingressos = ingressos;
    }

    public List<Ingresso> toIngressos(SessaoDao sessaoDao, LugarDao lugarDao) {
	return this.ingressos.stream().map(i -> {
	    Sessao sessao = sessaoDao.findOne(i.getSessao().getId());
	    Lugar lugar = lugarDao.findOne(i.getLugar().getId());
	    TipoDeIngresso tipoDeIngresso = i.getTipoDeIngresso();
	    return new Ingresso(sessao, lugar, tipoDeIngresso);
	}).collect(Collectors.toList());
    }

}
