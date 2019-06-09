package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Inscription;
import Model.Niveau;

public class InscriptionDAO extends DAO<Inscription>{

	public InscriptionDAO(Connection connect)
	{
		super(connect);
	}
	
	public boolean create(Inscription obj)
	{
		try
		{
			String query="INSERT INTO Inscription (`id_classe`, `id_personne`) VALUES (?,?)";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getId_classe());
			pstmt.setObject(2, obj.getId_personne());
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
	
	public boolean delete(Inscription obj)
	{
		try
		{
			String query = "DELETE FROM inscription WHERE id_inscription = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getId_inscription());
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean update(Inscription obj)
	{
		
		return false;
	}
	
	public Inscription find(int id)
	{
		Inscription inscription=new Inscription();
		try
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM inscription WHERE id_inscription = " + id);
			if(result.first())
			{
				inscription=new Inscription(id,result.getInt(2), result.getInt(3));

			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return inscription;
	}

	@Override
	public int findId(Inscription obj) {
		Inscription ins=new Inscription();
		try
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM inscription WHERE id_personne = '"+obj.getId_personne()+"'");
			if(result.first())
			{
				ins=new Inscription(result.getInt(1),result.getInt(2),result.getInt(3));
			}
			
			return ins.getId_inscription();
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public ArrayList<Inscription> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
