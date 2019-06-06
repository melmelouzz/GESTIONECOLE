package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.AnneeScolaire;

public class AnneeScolaireDAO extends DAO<AnneeScolaire>{

	public AnneeScolaireDAO(Connection connect)
	{
		super(connect);
	}

	
	public boolean create(AnneeScolaire obj) 
	{
		
		try
		{
			String query="INSERT INTO annescolaire (`id_anneescolaire`) VALUES (?)";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getId_anneescolaire());
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

	
	public boolean delete(AnneeScolaire obj) {
		try
		{
			String query = "DELETE FROM anneescolaire WHERE id_annescolaire = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getId_anneescolaire());
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	
	public boolean update(AnneeScolaire obj) {
		
		return false;
	}

	
	public AnneeScolaire find(int id) {
		AnneeScolaire as=new AnneeScolaire();
		try
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM anneescolaire WHERE id_anneescolaire = " + id);
			if(result.first())
			{
				as=new AnneeScolaire(id);
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return as;
	}
}
