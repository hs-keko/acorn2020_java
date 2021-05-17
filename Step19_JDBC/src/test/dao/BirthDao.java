package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.BirthDto;
import test.util.DBConnect;

public class BirthDao {
	// 2. 자신의 참조값을 저장할  static 필드 정의
	private static BirthDao dao;
	
	// 1. 외부에서 객체 생성하지 못하도록
	private BirthDao() {}
	
	// 3. 자신의 참조값을 리턴해주는 공개 static 메소드
	public static BirthDao getInstance() {
		// 최초 호출될 때는 dao 가  null 이므로
		if(dao==null) {
			// 객체를 생성해서 static 필드에 저장해놓는다.
			dao=new BirthDao();	// 클래스 안에서는 private 접근지정자로 된 생성자 호출가능
		}
		return dao;
	} 
	
	// 생일 정보를 저장하는 메소드 (작업성공 여부는 boolean 으로 리턴)
	public boolean insert(BirthDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			//실행할 sql(INSERT OR UPDATE OR DELETE) 문 작성
			String sql = "INSERT INTO birth"
					+ " (num, name, birthday)"
					+ " VALUES(birth_seq.NEXTVAL, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩할 내용이 있으면 여기서 한다.
			// 1번째 ? 에 BirthDto 객체에 있는 이름을 불러와서 바인딩
			pstmt.setString(1, dto.getName());
			// 2번째 ? 에 BirthDto 객체에 있는 생일을 불러와서 바인딩
			pstmt.setString(2, dto.getBirthday());
			// PreparedStatement 객체의 메소드를 이용해서 sql 문을 실행하고 수정된 row 의 갯수를 리턴한다.
			flag = pstmt.executeUpdate();	// 1개의 row 가 추가 되었으므로 1을 리턴하게 된다.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (flag > 0) {	// flag 값이 0보다 크면 작업 성공이므로
			return true;	// true 를 리턴한다.
		} else {
			return false;
		}
	}
	
	// 생일 정보를 수정하는 메소드
	public boolean update(BirthDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			//실행할 sql(INSERT OR UPDATE OR DELETE) 문 작성
			String sql = "UPDATE birth"
					+ " SET name=?,birthday=?"
					+ " WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩할 내용이 있으면 여기서 한다.
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBirthday());
			pstmt.setInt(3, dto.getNum());
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// 생일 정보를 삭제하는 메소드
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			//실행할 sql(INSERT OR UPDATE OR DELETE) 문 작성
			String sql = "DELETE FROM birth"
					+ " WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩할 내용이 있으면 여기서 한다.
			pstmt.setInt(1, num);
			// 삭제된 row 의 갯수가 리턴된다.
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// 한 명의 생일 정보를 리턴하는 메소드
	public BirthDto getData(int num) {
		// BirthDto 객체의 참조값을 담을 지역 변수 선언
		BirthDto dto=null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnect().getConn();
			//실행할 SELECT 문
			String sql = "SELECT num, name, birthday"
					+ " FROM birth"
					+ " FROM num=?";
			pstmt = conn.prepareStatement(sql);
			//? 에 바인딩할 내용은 여기서 바인딩한다.
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			// 만일 select 된 row 가 있다면 (while 써도 되는데, 1번밖에 안돌므로 의미상 if 를 쓰는게 자연스러움)
			if (rs.next()) {
				//SELECT 된 결과를 여기서 추출해서 객체에 담는다. 
				String name=rs.getString("name");
				String birthday=rs.getString("birthday");
				// 미리 만들어진 지역 변수에 BirthDto 객체의 참조값을 담는다.
				dto=new BirthDto(num, name, birthday);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		// BirthDto 객체의 참조값을 리턴해준다.
		return dto;
	}
	
	//모든 생일 정보를 리턴하는 메소드
	public List<BirthDto> getList(){
		List<BirthDto> list=new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnect().getConn();
			//실행할 SELECT 문
			String sql = "SELECT num, name, birthday"
					+ " FROM birth"
					+ " ORDER BY num ASC";
			pstmt = conn.prepareStatement(sql);
			//? 에 바인딩할 내용은 여기서 바인딩한다. (없음)

			rs = pstmt.executeQuery();
			while (rs.next()) {
				//SELECT 된 결과를 여기서 추출해서 객체에 담는다. 
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String birthday=rs.getString("birthday");
				// BirthDto 객체에 한명의 생일 정보를 담고
				BirthDto dto=new BirthDto(num, name, birthday);
				// List 에 누적 시킨다.
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return list;
	}
}
