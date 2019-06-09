package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		try
		{
			String query = "UPDATE personne SET nom_personne=?,prenom_personne=? WHERE id_personne=?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getNom_personne());
			pstmt.setObject(2, obj.getPrenom_personne());
			pstmt.setObject(3, obj.getId_personne());
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
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
	
	public int findId(Personne obj)
	{
		Personne pers=new Personne();
		try
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM personne WHERE nom_personne = '"+obj.getNom_personne()
					+"' and prenom_personne='"+obj.getPrenom_personne()+"'");
			if(result.first())
			{
				pers=new Personne(result.getInt(1),result.getString(2), result.getString(3), result.getString(4));
			}
			System.out.println(pers.getId_personne());
			return pers.getId_personne();
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	
	public ArrayList<Personne> findAll(String type)
	{
		ArrayList<Personne> list = new ArrayList<Personne>();
		try
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM personne WHERE type='"+type+"'");
			while(result.next())
			{
				list.add(new Personne(result.getInt(1),result.getString(2), result.getString(3), result.getString(4)));
			}
			return list;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return list;
		}
		
	}

	@Override
	public ArrayList<Personne> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
