package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Classe;
import Model.Ecole;

public class ClasseDAO extends DAO<Classe>{
	
	public ClasseDAO(Connection connect)
	{
		super(connect);
	}

	
	public boolean create(Classe obj) {
		try
		{
			String query="INSERT INTO classe (`nom_classe`,`id_ecole`,`id_niveau`,`id_anneescolaire`) "
					+ "VALUES (?,?,?,?)";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getNom_classe());
			pstmt.setObject(2, obj.getId_ecole());
			pstmt.setObject(3, obj.getId_niveau());
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

	
	public boolean delete(Classe obj) {
		try
		{
			
//			this.connect.createStatement().executeQuery("DELETE FROM ecole WHERE id_ecole="+obj.getId_ecole());
//			System.out.println("Objet bien suppr");
//			return true;
		
			String query = "DELETE FROM classe WHERE id_classe = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getId_classe());
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
	public boolean update(Classe obj) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Classe find(int id) {
		Classe classe = new Classe();
		try
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM classe WHERE id_classe = " + id);
			if(result.first())
			{
				classe=new Classe(id,result.getString("nom_classe"),result.getInt(3),result.getInt(4),result.getInt(5));
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return classe;
	}
	
	

}
