package br.com.caelum.estoque.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.caelum.estoque.Movimentacao;

@Repository
public class MovimentacaoDAO {

	private final SessionFactory factory;
	
	@Autowired
	public MovimentacaoDAO(SessionFactory factory){
		this.factory = factory;
	}
	
	public void salvar(Movimentacao movimentacao){
		factory.getCurrentSession().save(movimentacao);
	}
	
	@SuppressWarnings("unchecked")
	public List<Movimentacao> listarPorProdutoId(Long produtoId){
		Query query = (Query)factory.getCurrentSession().createQuery(
				"select * from Movimentacao where produto_id = :produto_id");
		query.setParameter("produto_id", produtoId);
		return (( List<Movimentacao> ) query.getResultList());
	}
}
