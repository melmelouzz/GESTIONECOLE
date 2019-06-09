package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Niveau;
import Model.Personne;

public class NiveauDAO extends DAO<Niveau>{

	public NiveauDAO(Connection connect)
	{
		super(connect);
	}
	
	public boolean create(Niveau obj)
	{
		try
		{
			String query="INSERT INTO niveau (`nom_niveau`) VALUES (?)";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getNom_niveau());
			pstmt.executeUpdate();
			System.out.println("classe créée");
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}

	}
	
	public boolean delete(Niveau obj)
	{
		try
		{
			String query = "DELETE FROM niveau WHERE id_niveau = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getId_niveau());
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean update(Niveau obj)
	{
		
		return false;
	}
	
	public Niveau find(int id)
	{
		Niveau niv=new Niveau();
		try
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM niveau WHERE id_niveau = '" + id+"'");
			if(result.first())
			{
				niv=new Niveau(id,result.getString(2));

			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return niv;
	}

	@Override
	public int findId(Niveau obj) {
		Niveau niv=new Niveau();
		try
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM niveau WHERE nom_niveau = '"+obj.getNom_niveau()+"'");
			if(result.first())
			{
				niv=new Niveau(result.getInt(1),result.getString(2));
			}
			
			return niv.getId_niveau();
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public ArrayList<Niveau> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
