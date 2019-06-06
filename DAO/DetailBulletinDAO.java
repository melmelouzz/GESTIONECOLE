package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.DetailBulletin;
import Model.Ecole;

public class DetailBulletinDAO extends DAO<DetailBulletin>{

	public DetailBulletinDAO(Connection connect)
	{
		super(connect);
	}

	
	public boolean create(DetailBulletin obj) {
		try
		{
			String query="INSERT INTO detailbulletin (`id_bulletin`,`id_enseignement`,`appreciation`)"
					+ " VALUES (?,?,?)";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getId_bulletin());
			pstmt.setObject(2, obj.getId_enseignement());
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

	
	public boolean delete(DetailBulletin obj) {
		try
		{
			
//			this.connect.createStatement().executeQuery("DELETE FROM ecole WHERE id_ecole="+obj.getId_ecole());
//			System.out.println("Objet bien suppr");
//			return true;
		
			String query = "DELETE FROM detailbulletin WHERE id_detailbulletin = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getId_detailbulletin());
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
	public boolean update(DetailBulletin obj) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public DetailBulletin find(int id) {
		DetailBulletin db=new DetailBulletin();
		try
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM detailbulletin WHERE id_detailbulletin = " + id);
			if(result.first())
			{
				db=new DetailBulletin(id,result.getInt(2),result.getInt(3),result.getString("appreciation"));
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return db;
	}
}
