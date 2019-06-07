package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Ecole;

public class EcoleDAO extends DAO<Ecole>{

	public EcoleDAO(Connection connect)
	{
		super(connect);
	}
	
	public boolean create(Ecole obj)
	{
		try
		{
			String query="INSERT INTO ecole (`nom_ecole`) VALUES (?)";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getNom_ecole());
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

	
	
	public boolean delete(Ecole obj)
	{
		try
		{
//			this.connect.createStatement().executeQuery("DELETE FROM ecole WHERE id_ecole="+obj.getId_ecole());
//			System.out.println("Objet bien suppr");
//			return true;
		
			String query = "DELETE FROM ecole WHERE id_ecole = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getId_ecole());
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean update(Ecole obj)
	{
		
		return false;
	}
	
	public Ecole find(int id)
	{
		Ecole ecole=new Ecole();
		try
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM ecole WHERE id_ecole = " + id);
			if(result.first())
			{
				ecole=new Ecole(id,result.getString("nom_ecole"));
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return ecole;
	}
	
}
