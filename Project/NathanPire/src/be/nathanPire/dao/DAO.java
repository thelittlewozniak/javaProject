package be.nathanPire.dao;

import java.sql.Connection;
import java.util.List;

public abstract class DAO<T> {
	
	protected Connection connect = null;
	   
	public DAO(Connection conn){
		this.connect = conn;
	}
	   
	//Function to add a T object inside the table
	//@input=Object T
	//@output=boolean
	public abstract boolean create(T obj);
	
	//Function to delete a T object inside the table
	//@input=Object T
	//@output=boolean
	public abstract boolean delete(T obj);
	
	//Function to update a T object inside the table
	//@input=Object T
	//@output=boolean
	public abstract boolean update(T obj);
	
	//Function to find a T object inside the table
	//@input=Object T
	//@output=T
	public abstract T find(int id);
	
	//Function to get a list of T object inside the table
	//@input=Object T
	//@output=List<T>
	public abstract List<T> getAll();

}
  
