package phonebook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import phonebook.vo.PhoneBookVo;

public class PhoneBookDaoImpl implements PhoneBookDao {
	private Connection getConnection() throws SQLException{
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
					"C##BITUSER", 
					"bituser");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패!");
			e.printStackTrace();
		}

		return conn;
	}

	@Override
	public List<PhoneBookVo> getList() {
		List<PhoneBookVo> list = new ArrayList<>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();

			String sql = "SELECT no, name, phonenum, tel " + 
			" FROM phonebook ORDER BY no DESC";

			
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				
				Long no = rs.getLong(1);
				String Name = rs.getString(2);
				String PhoneNum = rs.getString(3);
				String Tel = rs.getString(4);
				
				
				PhoneBookVo vo = new PhoneBookVo();
				vo.setNo(no);
				vo.setName(Name);
				vo.setPhoneNum(PhoneNum);
				vo.setTel(Tel);

				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public int insert(PhoneBookVo vo) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			
			String sql = "INSERT INTO phonebook (no, name, phonenum, tel) " +
					" VALUES(seq_phonebook_pk.NEXTVAL, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhoneNum());
			pstmt.setString(3, vo.getTel());
			
			
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	@Override
	public int delete(Long pk) {
		int deletedCount = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "DELETE FROM phonebook WHERE no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, pk);
			
			
			deletedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return deletedCount;
	}

}