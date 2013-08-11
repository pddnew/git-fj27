package br.com.caelum.estoque.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.estoque.Produto;

@Repository
@Primary
@Transactional
public class ProdutoHibernateDAO implements ProdutoDAO {

//	private Session session;
	private SessionFactory sessionFactory;
	
	@Autowired
	public ProdutoHibernateDAO(SessionFactory factory){
		this.sessionFactory = factory;
	}
	
	@Override
	public void salvar(Produto produto) {
		sessionFactory.getCurrentSession().save(produto);
	}

	@Override
	public void alterar(Produto produto) {
		sessionFactory.getCurrentSession().update(produto);
	}

	@Override
	public List<Produto> listar() {
		@SuppressWarnings("unchecked")
		List<Produto> produtos = sessionFactory.getCurrentSession().createQuery("from Produto").list();
		return produtos;
	}

	@Override
	public Produto buscarPorId(Long id) {
		return (Produto)sessionFactory.getCurrentSession().get(Produto.class, id);
	}
	
	@Override
	public void remover(Produto produto){
		sessionFactory.getCurrentSession().delete(produto);
	}

	@Override
	public Integer estoqueAtual(Produto produto) {
		Query query = (Query) sessionFactory.getCurrentSession()
				.createQuery("select quantidade from Produto where id = :pid");
		query.setParameter("pid", produto.getId());
		return (Integer)query.uniqueResult();
	}
}
