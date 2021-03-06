package br.edu.univas.bd.fut.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.univas.bd.fut.entities.Time;
import br.edu.univas.bd.fut.util.HibernateUtil;

public class maintenanceTeam {
	
	EntityManager em = HibernateUtil.getEntityManager();
	Time team = new Time();
	Date d = new Date();
	
	public void createTeam (String nome, String pais, String Estadio) {
		
		team.setNome(nome);
		team.setPais(pais);
		team.setEstadio(Estadio);
		team.setDtRegistro(d);

		em.getTransaction().begin();
		em.persist(team);
		em.getTransaction().commit();
	
	}
	
	public void updateTeam(Integer intTeam, String nome, String pais, String Estadio){
		Time objTeam = em.find(Time.class, intTeam);
		
		objTeam.setNome(nome);
		objTeam.setPais(pais);
		objTeam.setEstadio(Estadio);
		objTeam.setDtRegistro(d);

		em.getTransaction().begin();
		em.merge(objTeam);
		em.getTransaction().commit();
		
	}
	
	public void removeTeam(Integer intTeam){
		Time objTeam = em.find(Time.class, intTeam);

		em.getTransaction().begin();
		em.remove(objTeam);
		em.getTransaction().commit();
	}
	
	public void queriesTeam () {
		String ql = "select t from Time t";
		TypedQuery<Time> query = em.createQuery(ql, Time.class);
		List<Time> teams = query.getResultList();
		System.out.println("Times: " + teams);
	}
	
}
