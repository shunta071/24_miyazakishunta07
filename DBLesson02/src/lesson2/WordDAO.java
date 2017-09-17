package lesson2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WordDAO {

	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public int registWord(List<Word> lists){

		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/testdb?"
					+ "useUnicode=true&characterEncoding=utf8","root","" );
			String SQL = "INSERT INTO dictionary VALUES(?,?)";

			for(Word wd : lists){
				st = con.prepareStatement(SQL);
				st.setString(1, wd.getEnglish());
				st.setString(2, wd.getJapanese());

				result = result + st.executeUpdate();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if ( st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if ( con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public List<Word> getWords() {
		List<Word> words = new ArrayList<>();

		int result2 = 0;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/testdb?"
					+ "useUnicode=true&characterEncoding=utf8","root","" );

			if(con != null){
				String SQL = "SELECT english, japanese From dictionary";
				st = con.prepareStatement(SQL);
				rs = st.executeQuery();

			}
			while(rs.next()) {
				Word lists = new Word(rs.getString("english"),rs.getString("japanese"));
				words.add(lists);
			}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if ( st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if ( con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			return words;
		}
	}
}
