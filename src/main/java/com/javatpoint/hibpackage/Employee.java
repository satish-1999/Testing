package com.javatpoint.hibpackage;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;

@Table
@Entity(name="EmplCol")
public class Employee {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="First_Name")
	private String firstName;
	@Column(name="Last_Name")
	private String lastName;
	
	@ElementCollection(fetch= FetchType.EAGER)
	@JoinTable(name="EmplCol_address")
	private Collection<Address> listOfAddresses=new ArrayList<Address>();
	
	//private Set<Address> listOfAddresses=new HashSet();
	
	
	
	public int getId() {
		return id;
	}
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	} 
	  
}
