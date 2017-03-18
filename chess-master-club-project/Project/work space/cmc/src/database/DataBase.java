package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dao.AdminDao;
import Dao.FQueryDao;
import Dao.FunPlayerDao;
import Dao.QueryDao;
import Dao.TourDao;
import Dao.TournamentDao;
import Dao.VideoDao;

public class DataBase {

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public Connection connect() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cmc_db","root","root");
			System.out.println("Connected");
			
			}catch (Exception e) {

				System.out.println("Not Connected");
				e.printStackTrace();
			}
			return con;
		}

	
	public void disconnect() {
		try {
			con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public List<AdminDao> adminLogin() {
		List<AdminDao> l = new ArrayList<AdminDao>();
		try {
			con = connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from admin");

			while (rs.next()) {
				AdminDao dao = new AdminDao();
				dao.setUsername(rs.getString(1));
				dao.setPassword(rs.getString(2));
				l.add(dao);
			}
			disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	
	public int AdminAdd(String a, String b, String c, String d) {
		int i = 0;
		try {
			connect();
			stmt = con.createStatement();
			// int i=stmt.executeUpdate("update add set name='"+a+
			// "','"+b+"', '"+c+"' ,'"+d +"'  ");
			i = stmt.executeUpdate("insert into add values('" + a + "','" + b
					+ "', '" + c + "' ,'" + d + "')");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int addTournamentPlayer(String emailid,String name,String password,String age,String gender) throws SQLException
	{
		int i=0;
		Connection con=null;
        PreparedStatement statement = null;
       
        try {
            con=connect();
            statement = con.prepareStatement("insert into tournamentplayer values(?,?,?,?,?,?,?)");
            statement.setString(1, emailid);
            statement.setString(2, name);
            statement.setString(3, password);
            statement.setInt(4, Integer.parseInt(age));
            statement.setString(5, gender);
            statement.setString(6, "x");
            statement.setInt(7, 0);
            
            
            i = statement.executeUpdate();
            
        } finally {
            
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (con != null) try { con.close(); disconnect(); } catch (SQLException ignore) {}
        }
		
		
		return i;
	}
	
	public int addTournament(String tid, String tname, String date, String venu) throws SQLException
	{
		int i=0;
		Connection con=null;
        PreparedStatement statement = null;
        System.out.println(tid);
        System.out.println(tname);
        System.out.println(date);
        System.out.println(venu);
        try {
            con=connect();
            statement = con.prepareStatement("insert into tournament values(?,?,?,?)");
            statement.setString(1, tid);
            statement.setString(2, tname);
            statement.setString(3, date);
            statement.setString(4, venu);
            
            
            
            i = statement.executeUpdate();
           
        } finally {
            
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (con != null) try { con.close(); disconnect(); } catch (SQLException ignore) {}
        }
		
		
		return i;
	}
	
	public int updateTournament(String tid,String tname,String date,String venu) throws SQLException
	{
		int i=0;
		Connection con=null;
        PreparedStatement statement = null;
        try {
            con=connect();
            statement = con.prepareStatement("UPDATE tournament SET t_name=?, t_date=?, t_venu=? WHERE t_id = ?");
            
            statement.setString(1, tname);
            statement.setString(2, date);
            statement.setString(3, venu);
            statement.setString(4, tid);
            
            
            
            
            i = statement.executeUpdate();
            
            System.out.println(i+tname+date+venu+tid); 
        } finally {
            
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (con != null) try { con.close(); disconnect(); } catch (SQLException ignore) {}
        }
    	
		return i;
	}
	
	
	public int deleteTournament(String tid) throws SQLException
	{
		int i=0;
		System.out.println(tid);
		Connection con=null;
        PreparedStatement statement = null;
        try {
            con=connect();
            statement = con.prepareStatement("delete from tournament  WHERE t_id = ?");
            
           statement.setString(1, tid);
            
            
            
            
            i = statement.executeUpdate();
           
        } finally {
            
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (con != null) try { con.close(); disconnect(); } catch (SQLException ignore) {}
        }
    	
		return i;
	}
	
	
	public List<TournamentDao> tLogin(String emailid) {
		List<TournamentDao> l = new ArrayList<TournamentDao>();
		try {
			con = connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select emailid, password from tournamentplayer where emailid='"+emailid+"'");

			while (rs.next()) {
				TournamentDao dao = new TournamentDao();
				dao.setEmailID(rs.getString(1));
				dao.setPassword(rs.getString(2));
				l.add(dao);
			}
			disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	
	public List<TourDao> listTournament() throws SQLException {
    	Connection con=null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<TourDao> categories = new ArrayList<TourDao>();

        try {
            con=connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tournament");
            while (resultSet.next()) {
            	TourDao category = new TourDao();
                category.setTid(resultSet.getString(1));
                category.setTname(resultSet.getString(2));
                category.setDate(resultSet.getString(3));
                category.setVenu(resultSet.getString(4));
             
                categories.add(category);
            }
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (con != null) try { con.close(); disconnect(); } catch (SQLException ignore) {}
        }

        return categories;
    }

	public List<FunPlayerDao> listOfFunPlayers() throws SQLException {
    	Connection con=null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<FunPlayerDao> categories = new ArrayList<FunPlayerDao>();

        try {
            con=connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT emailid,address FROM funplayer");
            while (resultSet.next()) {
            	FunPlayerDao category = new FunPlayerDao();
                category.setEmailid(resultSet.getString(1));
                
                category.setAddress(resultSet.getString(2));
                categories.add(category);
            }
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (con != null) try { con.close(); disconnect(); } catch (SQLException ignore) {}
        }

        return categories;
    }
		
	public List<TournamentDao> listTournamentForApproval(String status) throws SQLException {
    	Connection con=null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<TournamentDao> categories = new ArrayList<TournamentDao>();

        try {
            con=connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT emailid,name,age,gender FROM tournamentplayer where status='"+status+"'");
            while (resultSet.next()) {
            	TournamentDao category = new TournamentDao();
                category.setEmailID(resultSet.getString(1));
                category.setName(resultSet.getString(2));
                category.setAge(String.valueOf(resultSet.getInt(3)));
                category.setGender(resultSet.getString(4));
                categories.add(category);
            }
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (con != null) try { con.close(); disconnect(); } catch (SQLException ignore) {}
        }

        return categories;
    }
	
	
	public List<FQueryDao> listfQuery() throws SQLException {
    	Connection con=null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<FQueryDao> categories = new ArrayList<FQueryDao>();

        try {
            con=connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM fqueries");
            while (resultSet.next()) {
            	FQueryDao category = new FQueryDao();
            	category.setFqID(resultSet.getInt(1));
            	category.setFqName(resultSet.getString(2));
            	category.setFqEmail(resultSet.getString(3));
            	category.setFqSubject(resultSet.getString(4));
                category.setFqQuestion(resultSet.getString(5));
                category.setFqAnswer(resultSet.getString(6));
                
               
                categories.add(category);
            }
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (con != null) try { con.close(); disconnect(); } catch (SQLException ignore) {}
        }

        return categories;
    }
	
	
	public List<QueryDao> listQuery() throws SQLException {
    	Connection con=null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<QueryDao> categories = new ArrayList<QueryDao>();

        try {
            con=connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM queries");
            while (resultSet.next()) {
            	QueryDao category = new QueryDao();
            	category.setqID(resultSet.getInt(1));
                category.setqSubject(resultSet.getString(2));
                category.setqQuestion(resultSet.getString(3));
                category.setqAnswer(resultSet.getString(4));
                
               
                categories.add(category);
            }
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (con != null) try { con.close(); disconnect(); } catch (SQLException ignore) {}
        }

        return categories;
    }
	
	public List<TourDao> getResultTournamentID(String tid) throws SQLException {
    	Connection con=null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<TourDao> categories = new ArrayList<TourDao>();

        try {
            con=connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tournament where t_id='"+tid+"'");
            while (resultSet.next()) {
            	TourDao category = new TourDao();
                category.setTid(resultSet.getString(1));
                category.setTname(resultSet.getString(2));
                category.setDate(resultSet.getString(3));
                category.setVenu(resultSet.getString(4));
             
                categories.add(category);
            }
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (con != null) try { con.close(); disconnect(); } catch (SQLException ignore) {}
        }

        return categories;
    }
	
	
	public List<TournamentDao> getResultTournamentPlayerID(String tid) throws SQLException {
    	Connection con=null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<TournamentDao> categories = new ArrayList<TournamentDao>();

        try {
            con=connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT emailid,name,age, gender, rank FROM tournamentplayer where emailid='"+tid+"'");
            while (resultSet.next()) {
            	TournamentDao category = new TournamentDao();
                category.setEmailID(resultSet.getString(1));
                category.setName(resultSet.getString(2));
                category.setAge(String.valueOf(resultSet.getInt(3)));
                category.setGender(resultSet.getString(4));
                category.setRank(resultSet.getString(5));
             
                categories.add(category);
            }
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (con != null) try { con.close(); disconnect(); } catch (SQLException ignore) {}
        }

        return categories;
    }
	
	public boolean checkTournamentPlayerEmailID(String emailid) throws SQLException
	{
		Connection con=null;
        Statement statement = null;
        ResultSet resultSet = null;
        boolean flag=false;

        try {
            con=connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT emailid FROM tournamentplayer where emailid='"+emailid+"'");
            if(rs!=null)
            {
            	flag =true;
            }
            else
            {
            	flag=false;
            }
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (con != null) try { con.close(); disconnect(); } catch (SQLException ignore) {}
        }

        return flag;
        
	}
	
	
	public int addQuery(String sub,String query) throws SQLException
	{
		int i=0;
		Connection con=null;
        PreparedStatement statement = null;
        System.out.println(sub);
        System.out.println(query);
        try {
            con=connect();
            statement = con.prepareStatement("insert into queries(q_subject,q_question,q_answer) values(?,?,?)");
            statement.setString(1, sub);
            statement.setString(2, query);
            statement.setString(3, "x");
                        
            
            i = statement.executeUpdate();
           
        } finally {
            
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (con != null) try { con.close(); disconnect(); } catch (SQLException ignore) {}
        }
		
		
		return i;
	}
	

	public int addFQuery(String name,String email,String sub,String query) throws SQLException
	{
		int i=0;
		Connection con=null;
        PreparedStatement statement = null;
        System.out.println(name);
        System.out.println(email);
        System.out.println(sub);
        System.out.println(query);
        try {
            con=connect();
            statement = con.prepareStatement("insert into fqueries(fq_name,fq_email,fq_subject,fq_question,fq_answer) values(?,?,?,?,?)");
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, sub);
            statement.setString(4, query);
            statement.setString(5, "x");
                        
            
            i = statement.executeUpdate();
           
        } finally {
            
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (con != null) try { con.close(); disconnect(); } catch (SQLException ignore) {}
        }
		
		
		return i;
	}
	
	public List<VideoDao> searchVideo(String keyword) {
		System.out.println(keyword);
		List<VideoDao> ls = new ArrayList<VideoDao>();
		try {
			connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from video where keyword like '%"+ keyword + "%'");
			
			while (rs.next()) {
				System.out.println(rs.getString(2));
				VideoDao v = new VideoDao();
				v.setId(rs.getInt(1));
				v.setName(rs.getString(2));
				v.setLink(rs.getString(3));
				ls.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disconnect();
		return ls;
	}
	
	
}
