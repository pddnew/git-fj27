package br.com.caelum.estoque.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.caelum.estoque.Usuario;
@Repository
public class UsuarioHibernateDAO implements UsuarioDAO {

	private HibernateTemplate hbnTemplate;
	@Autowired
	public UsuarioHibernateDAO(SessionFactory factory){
		hbnTemplate = new HibernateTemplate(factory);
	}
	
	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException, DataAccessException {
		@SuppressWarnings("rawtypes")
		List usuarios
			= hbnTemplate.find("from Usuario where login = :login", arg0);
		if(!usuarios.isEmpty())
			return (Usuario)usuarios.get(0);
		return null;
	}
}
