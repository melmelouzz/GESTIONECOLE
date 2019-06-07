package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.DetailBulletin;
import Model.Enseignement;

public class EnseignementDAO extends DAO<Enseignement> {

    public EnseignementDAO(Connection connect)
	{
		super(connect);
	}
	
	public boolean create(Enseignement obj)
	{
		try
		{
			String query="INSERT INTO enseignement (`id_classe`,`id_discipline`,`id_personne`) VALUES (?, ?, ?)";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getId_classe());
			pstmt.setObject(2, obj.getId_discipline());
            pstmt.setObject(3, obj.getId_personne());
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

	
	public boolean delete(Enseignement obj) {
	try
	{
//		this.connect.createStatement().executeQuery("DELETE FROM ecole WHERE id_ecole="+obj.getId_ecole());
//		System.out.println("Objet bien suppr");
//		return true;
	
		String query = "DELETE FROM enseigement WHERE id_enseignement = ?";
		PreparedStatement pstmt = connect.prepareStatement(query);
		pstmt.setObject(1, obj.getId_enseignement());
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
	public boolean update(Enseignement obj) {
		return false;
	}

	
	public Enseignement find(int id) {
		
		Enseignement ens=new Enseignement();
		try
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM enseignement WHERE id_enseignement = " + id);
			if(result.first())
			{
				ens=new Enseignement(id,result.getInt(2),result.getInt(3),result.getInt(4));
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return ens;
	}
    
}
