package DAO;

import java.sql.Connection;
import java.util.ArrayList;

import Model.Enseignement;
import Model.Personne;

public abstract class DAO<T> {
	
	protected Connection connect = null;
	
	public DAO(Connection connect)
	{
		this.connect=connect;
	}
	
	public abstract boolean create(T obj);
	
	public abstract boolean delete(T obj);
	
	public abstract boolean update(T obj);
	
	public abstract T find(int id);

	public abstract int findId(T obj);
	
	public abstract ArrayList<T> findAll();

	public ArrayList<Personne> findAll(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Enseignement> findAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
