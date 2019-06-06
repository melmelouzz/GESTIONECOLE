package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Bulletin;
import Model.Ecole;

public class BulletinDAO extends DAO<Bulletin>{

	public BulletinDAO(Connection connect)
	{
		super(connect);
	}

	@Override
	public boolean create(Bulletin obj) {
		// TODO Auto-generated method stub
		
		try
		{
			String query="INSERT INTO bulletin (`id_trimestre`,`id_inscription`,`appreciation`) "
					+ "VALUES (?,?,?)";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getId_trimestre());
			pstmt.setObject(2, obj.getId_inscription());
			pstmt.setObject(3, obj.getAppreciation());
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

	@Override
	public boolean delete(Bulletin obj) {
		try
		{
			
//			this.connect.createStatement().executeQuery("DELETE FROM ecole WHERE id_ecole="+obj.getId_ecole());
//			System.out.println("Objet bien suppr");
//			return true;
		
			String query = "DELETE FROM bulletin WHERE id_bulletin = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getId_bulletin());
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Bulletin obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Bulletin find(int id) {
		Bulletin bulletin = new Bulletin();
		try
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM bulletin WHERE id_bulletin = " + id);
			if(result.first())
			{
				bulletin=new Bulletin(id,result.getInt(2),result.getInt(3),result.getString("appreciation"));
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return bulletin;
	}
}
