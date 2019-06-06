package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Trimestre;

public class TrimestreDAO extends DAO<Trimestre>{

	public TrimestreDAO(Connection connect)
	{
		super(connect);
	}
	
	public boolean create(Trimestre obj)
	{
		try
		{
			String query="INSERT INTO trimestre (`numero`, `debut`, `fin`,`id_anneescolaire`) VALUES (?,?,?,?)";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getNumero());
			pstmt.setObject(2, obj.getDebut());
			pstmt.setObject(3, obj.getFin());
			pstmt.setObject(4, obj.getId_anneescolaire());
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
	
	public boolean delete(Trimestre obj)
	{
		try
		{
			String query = "DELETE FROM trimestre WHERE id_trimestre = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getId_trimestre());
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean update(Trimestre obj)
	{
		
		return false;
	}
	
	public Trimestre find(int id)
	{
		Trimestre trim=new Trimestre();
		try
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM trimestre WHERE id_trimestre = " + id);
			if(result.first())
			{
				trim=new Trimestre(id,result.getInt(2), result.getString(3), result.getString(4), result.getInt(5));

			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return trim;
	}
	
}
