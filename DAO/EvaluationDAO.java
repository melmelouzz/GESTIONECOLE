package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Evaluation;

public class EvaluationDAO extends DAO<Evaluation>{

	public EvaluationDAO(Connection connect)
	{
		super(connect);
	}
	
	public boolean create(Evaluation obj)
	{
		try
		{
			String query="INSERT INTO evaluation (`id_detailbulletin`, `note`, `appreciation`) VALUES (?,?,?)";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getId_detailbulletin());
			pstmt.setObject(2, obj.getNote());
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
	
	public boolean delete(Evaluation obj)
	{
		try
		{
			String query = "DELETE FROM evaluation WHERE id_evaluation = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setObject(1, obj.getId_evaluation());
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean update(Evaluation obj)
	{
		
		return false;
	}
	
	public Evaluation find(int id)
	{
		Evaluation eval=new Evaluation();
		try
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM evaluation WHERE id_evaluation = " + id);
			if(result.first())
			{
				eval=new Evaluation(id,result.getInt(2), result.getDouble(3), result.getString(4));

			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return eval;
	}
	
}
