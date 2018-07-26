package com.carlos.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.carlos.models.User;

public class UserEM extends EntityManager {
	private static UserEM instance = null;

	private UserEM() {
		super();
	}

	public static final UserEM getInstance() {
		if (instance == null)
			instance = new UserEM();
		return instance;
	}
	
	
	
	public List<User> getLista() throws Exception{
		List<User> listaUsuarios = null;

		Session session = factory.openSession();
		listaUsuarios = session.createQuery("FROM User", User.class).getResultList();
		session.close();

		return listaUsuarios;
	}
	
	public User getUserByEmailAndPass(String email, String password) throws Exception {
		User usuario = null;

		Session session = factory.openSession();
		usuario = session.createQuery("FROM User WHERE email=:email AND password=:password", User.class)
				.setParameter("email", email).setParameter("password", password).getSingleResult();
		session.close();

		return usuario;
	}

	public User getUsuarioToken(String email, String password) {
		User user = null;

		try {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			String hql = "FROM User WHERE email='" + email + "' AND password='" + password + "' ";
			user = session.createQuery(hql, User.class).getSingleResult();
			t.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return user;

	}

	public boolean deleteUser(int uid) throws Exception {
		boolean isOk = false;

		User usuario = null;
		Session session = factory.openSession();
		usuario = (User) session.createQuery("DELETE FROM User WHERE userId =?", User.class);
		session.close();

		isOk = true;

		return isOk;
	}

	public boolean deleteUser(User aUser) throws Exception {
		boolean isOk = false;

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		session.delete(aUser);

		t.commit();
		session.close();

		isOk = true;

		return isOk;
	}

}
