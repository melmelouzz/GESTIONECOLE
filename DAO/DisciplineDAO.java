package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.DetailBulletin;
import Model.Discipline;

public class DisciplineDAO extends DAO<Discipline>{

	public DisciplineDAO(Connection connect)
	{
		super(connect);
	}

	
	public boolean create(Discipline obj) {
		try
		{
			String query="INSERT INTO discipline (`nom_discipline`) VALUES (?)";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getNom_discipline());
			pstmt.executeUpdate();
			System.out.println("classe cr��e");
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	
	public boolean delete(Discipline obj) {
		try
		{
			
//			this.connect.createStatement().executeQuery("DELETE FROM ecole WHERE id_ecole="+obj.getId_ecole());
//			System.out.println("Objet bien suppr");
//			return true;
		
			String query = "DELETE FROM discipline WHERE id_discipline = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getId_discipline());
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
	public boolean update(Discipline obj) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Discipline find(int id) {
		Discipline disc=new Discipline();
		try
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM discipline WHERE id_discipline = " + id);
			if(result.first())
			{
				disc=new Discipline(id,result.getString("nom_discipline"));
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return disc;
	}
	
	
}
