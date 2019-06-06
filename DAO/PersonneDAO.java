package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Personne;

public class PersonneDAO extends DAO<Personne>{

	public PersonneDAO(Connection connect)
	{
		super(connect);
	}
	
	public boolean create(Personne obj)
	{
		try
		{
			String query="INSERT INTO personne (`nom_personne`, `prenom_personne`, `type`) VALUES (?,?,?)";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getNom_personne());
			pstmt.setObject(2, obj.getPrenom_personne());
			pstmt.setObject(3, obj.getType());
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
	
	public boolean delete(Personne obj)
	{
		try
		{
			String query = "DELETE FROM personne WHERE id_personne = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getId_personne());
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean update(Personne obj)
	{
		
		return false;
	}
	
	public Personne find(int id)
	{
		Personne pers=new Personne();
		try
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM personne WHERE id_personne = " + id);
			if(result.first())
			{
				pers=new Personne(id,result.getString(2), result.getString(3), result.getString(4));

			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return pers;
	}
	
}
