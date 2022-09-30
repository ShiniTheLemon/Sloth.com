package sloth.helper.DAO;
import sloth.helper.login.*;
import sloth.helper.randomizer.Randomizer;
import sloth.helper.user.signup.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sloth.helper.JDBC.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sloth.create.deck.*;
import sloth.show.deck.*;

public class SlothHelperDAOImp implements SlothHelperDAO{

	@Override
	public SlothLogin SlothLogin(String user_name, String user_password) {
		// TODO Auto-generated method stub
		SlothLogin SlothLogin= null;
		
		
		
		try {
			Connection con=SlothHelperJDBC.getConnection();
			String query="Select * from user_info where user_name='"+user_name+"'and user_password='"+user_password+"'";
			//String query= "Select * from user_info where user_name=? and user_password=?";
			//PreparedStatement ps=con.prepareStatement(query);
			Statement stmt= con.createStatement();
			ResultSet  rs = stmt.executeQuery(query);
			//ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				SlothLogin=new SlothLogin();
				SlothLogin.setUser_name(rs.getString(1));
				SlothLogin.setUser_password(rs.getString(2));
			}
			SlothHelperJDBC.close(rs, stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 	SlothLogin;

	}

	@Override
	public boolean SlothSignUp(SlothSignUp SlothSignUp) {
		// TODO Auto-generated method stub
		boolean tag= false;
		try {
			Connection con=SlothHelperJDBC.getConnection();
			String insert="insert into user_info(email,user_name,user_password) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(insert);
			ps.setString(1, SlothSignUp.getEmail());
			ps.setString(2,SlothSignUp.getUser_name() );
			ps.setString(3, SlothSignUp.getUser_password());
			int i= ps.executeUpdate();
			if(i==1) {
				System.out.println("Insertion completed successfully");
				tag=true;
			}
			SlothHelperJDBC.close(ps, con);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return tag;
	
		
	}

	@Override
	public boolean SlothCreateDeck(CreateDeck CreateDeck) {
		// TODO Auto-generated method stub
		boolean tag=false;
		try {
			Connection con=SlothHelperJDBC.getConnection();
			String insert="insert into deck(deck_word,deck_meaning) values(?,?)";
			PreparedStatement ps=con.prepareStatement(insert);
			ps.setString(1,CreateDeck.getDeck_word());
			ps.setString(2,CreateDeck.getDeck_meaning());
			
			int i=ps.executeUpdate();
			
			if(i==1) {
				System.out.println("Deck was created successfully created");
				tag=true;
			}
			SlothHelperJDBC.close(ps, con);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return tag;
	}

	@Override
	public List<ShowDeck> ShowDeck() {
		// TODO Auto-generated method stub
		List<ShowDeck> ShowDeck=null;
		try {
			Connection con=SlothHelperJDBC.getConnection();
			String query="select * from deck";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			ShowDeck= new ArrayList<ShowDeck>();
			
			while(rs.next()) {
				ShowDeck DeckObject= new ShowDeck();
				DeckObject.setDeck_id(rs.getInt(1));
				DeckObject.setDeck_word(rs.getString(2));
				DeckObject.setDeck_meaning(rs.getString(3));
				
				ShowDeck.add(DeckObject);
				
			}
			SlothHelperJDBC.close(rs, ps, con);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return ShowDeck;
	}

	@Override
	public boolean DeleteWord(int deck_id) {
		boolean tag=false;
		try {
		Connection con=SlothHelperJDBC.getConnection();
		String delete="delete  from deck where deck_id=?";
		PreparedStatement ps=con.prepareStatement(delete);
		ps.setInt(1, deck_id);
		int i=ps.executeUpdate();
		
		if(i==1) {
			System.out.println("Item has been deleted from the database");
			tag=true;
		}
		
			SlothHelperJDBC.close(ps, con);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return tag;
	}

	@Override
	public boolean EditWord(ShowDeck EditDeck) {
		boolean tag=false;
		try {
			Connection con= SlothHelperJDBC.getConnection();
			String edit="update deck set deck_word=?,deck_meaning=? where deck_id=?";
			PreparedStatement ps= con.prepareStatement(edit);
			
			ps.setString(1, EditDeck.getDeck_word());
			ps.setString(2, EditDeck.getDeck_meaning());
			ps.setInt(3, EditDeck.getDeck_id());
			
			int i=ps.executeUpdate();
			
			if(i==1) {
				System.out.println("Edit was successfull");
				tag=false;
			}
			SlothHelperJDBC.close( ps, con);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Randomizer Quiz() {
		// TODO Auto-generated method stub
		Map<String,String>DAOMap= new HashMap<String,String>();
		
		try {
			
			Connection con= SlothHelperJDBC.getConnection();
			String query="Select * from deck";
			PreparedStatement ps;
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Randomizer RandomObj= new Randomizer();
			    RandomObj.setDeck_word(rs.getNString(2));
				RandomObj.setDeck_meaning(rs.getNString(3));

				
			    RandomObj.setContainerMap((Map<String, String>) RandomObj);
			}
			SlothHelperJDBC.close(rs, ps, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Map<Randomizer, Randomizer> Quiz2() {
		// TODO Auto-generated method stub
		Map<Randomizer,Randomizer>DAOMap=null;
		
		try {
			Connection con=SlothHelperJDBC.getConnection();
			String query="select * from deck";
			PreparedStatement ps= con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			DAOMap= new HashMap<Randomizer,Randomizer>();
			while(rs.next()) {
				Randomizer RandomObj= new Randomizer();
				RandomObj.setDeck_word(rs.getNString(2));
				RandomObj.setDeck_meaning(rs.getNString(3));
	
				DAOMap.putAll((Map<? extends Randomizer, ? extends Randomizer>) RandomObj);
			}
			SlothHelperJDBC.close(rs, ps, con);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return DAOMap;
	}

	@Override
	public Map<String, String> Quiz3() {
		// TODO Auto-generated method stub
		Map<String,String>DAOMap=null;
		

		try {
			Connection con=SlothHelperJDBC.getConnection();
			String query="select * from deck";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs= ps.executeQuery();
			
			DAOMap= new HashMap();
			while(rs.next()) {
				String key1=rs.getString(2);
				String value1=rs.getString(3);
				
				DAOMap.put(key1, value1);
				
		
			}
			
			System.out.println(DAOMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return DAOMap;
	}

	@Override
	public Map<String, String> Quiz4() {
		// TODO Auto-generated method stub
Map<String,String>DAOMap=null;
		

		try {
			Connection con=SlothHelperJDBC.getConnection();
			String query="select * from deck order by rand() limit 1";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs= ps.executeQuery();
			
			DAOMap= new HashMap();
			while(rs.next()) {
				String key1=rs.getString(2);
				String value1=rs.getString(3);
				
				DAOMap.put(key1, value1);
				
		
			}
			
			System.out.println(DAOMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return DAOMap;
	}

}
