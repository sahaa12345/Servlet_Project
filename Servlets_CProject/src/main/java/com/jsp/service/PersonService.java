package com.jsp.service;

import java.util.List;

import com.jsp.dao.PersonDao;
import com.jsp.dto.Person;

public class PersonService {
	PersonDao pD=new PersonDao();
	public Person savePersonService(Person person) {
		return pD.savePerson(person);
	}
	public List<Person> getAllPersonService(){
		return pD.getAllPerson();
	}
	public Person getPersonByIdService(int id) {
		return pD.getPersonById(id);
	}
	public Person updatePersonService(Person person) {
		return pD.updatePerson(person);
	}
	public Person deletePersonService(int id) {
		return pD.deletePerson(id);
	}

}
