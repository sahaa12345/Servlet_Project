package com.jsp.dao;


import java.util.List;


import com.jsp.dto.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;


public class PersonDao{
	EntityManagerFactory eMF=Persistence.createEntityManagerFactory("sana");
	public Person savePerson(Person person) {
		 EntityManager eM=eMF.createEntityManager();
		 EntityTransaction eT=eM.getTransaction();
		 if(person!=null) {
			 eT.begin();
			 eM.persist(person);
			 eT.commit();
		 }
		 return person;
		 
	 }
public List<Person> getAllPerson(){
	EntityManager eM=eMF.createEntityManager();
	Query query=eM.createQuery("select a from Person a");
	return query.getResultList();
}
public Person getPersonById(int id) {
	EntityManager eM=eMF.createEntityManager();
	return eM.find(Person.class,id);
}
public Person updatePerson(Person person) {
	EntityManager eM=eMF.createEntityManager();
	EntityTransaction eT=eM.getTransaction();
	Person person2=eM.find(Person.class,person.getId());
	if(person2!=null) {
		eT.begin();
		eM.merge(person);
		eT.commit();
	}
	return person2;
}
public Person deletePerson(int id) {
	EntityManager eM=eMF.createEntityManager();
	EntityTransaction eT=eM.getTransaction();
	Person person=eM.find(Person.class,id);
	if(person!=null) {
		eT.begin();
		eM.remove(person);
		eT.commit();
	}
	return person;
  }
}

