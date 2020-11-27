package bookstore.shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;





public class MemberDAO {
	
		//----------------------------------------------------------------------------------------------
		// StoreBookDAO 인스턴스를 생성한다.
		//----------------------------------------------------------------------------------------------
		private static MemberDAO instance = new MemberDAO();

		//----------------------------------------------------------------------------------------------
		// 생성한 인스턴스의 정보를 알려준다.
		//----------------------------------------------------------------------------------------------
		public static MemberDAO getInstance() {
			return instance;
		} // End - public static StoreBookDAO getInstance()
		//----------------------------------------------------------------------------------------------
		// 커넥션 풀로 부터 커넥션 객체를 얻어내는 메서드
		//----------------------------------------------------------------------------------------------
		private MemberDAO() {}
		private Connection getConnection() throws Exception {
			Context	initCtx = new InitialContext();
			Context envCtx  = (Context)	 initCtx.lookup("java:comp/env");
			DataSource ds	= (DataSource)envCtx.lookup("jdbc/bookstoredb");
			return ds.getConnection();
		} // End - private Connection getConnection()
		//----------------------------------------------------------------------------------------------
		// 회원인증을 위한 메서드
		//----------------------------------------------------------------------------------------------
		
		public int  userCheck(String id,String passwd) throws Exception{
			Connection			conn		= null;
			PreparedStatement	pstmt		= null;
			ResultSet			rs			= null;
			String				sql			= "";
			String				dbpasswd	= "";
			int					rtnVal		= -1;
			
			try {
				conn  = getConnection();
				
				sql   = "SELECT passwd FROM member WHERE id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setNString(1, id);
				rs    = pstmt.executeQuery();
				
				if(rs.next()) { //id에 해당하는 자료가 있다면
					//찾은 비밀번호를 가지고 전페이지에서 넘겨준 비밀번호와 비교한다.
					dbpasswd = rs.getString("passwd");
					
					if(dbpasswd.equals(passwd)) { //비밀번호가 일치하면
						rtnVal = 1;	//인증에 성공
					} else {
						rtnVal = 0; //비밀번호가 일치하지 않는다.
					}
				} else { //id에 해당하는 자료가 없다면 => 해당 아이디 자체가 존재하지 않는다.
					rtnVal = -1;
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				if(rs    != null) try {rs.close(); 	  } catch(SQLException ex) {}
				if(pstmt != null) try {pstmt.close(); } catch(SQLException ex) {}
				if(conn  != null) try {conn.close();  } catch(SQLException ex) {}
			}
			return rtnVal;
		} // End - public int managerCheck(String id, String passwd)
		//----------------------------------------------------------------------------------------------
		// 회원가입을 위한 메서드
		//----------------------------------------------------------------------------------------------
		
		public void insertMember(MemberDTO member) throws Exception{
			Connection			conn		= null;
			PreparedStatement	pstmt		= null;
			String				sql			= "";
			
			
			try {
				conn = getConnection();
				sql = "INSERT INTO member values(?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getPasswd());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, member.getReg_date());
				pstmt.setString(5, member.getTel());
				pstmt.setString(6, member.getAddress());
				
				pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(pstmt != null) try {pstmt.close(); } catch(SQLException ex) {}
				if(conn  != null) try {conn.close();  } catch(SQLException ex) {}
			}
			
		}
		//----------------------------------------------------------------------------------------------
		// 아이디중복확인을 위한 메서드
		//----------------------------------------------------------------------------------------------
		public int confirmId(String id) throws Exception{
			Connection			conn		= null;
			PreparedStatement	pstmt		= null;
			ResultSet rs = null;
			String				sql			= "";
			int rtnVal=0;
			try {
				conn = getConnection();
				sql = "SELECT id FROM member WHERE id = ?";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
			
				if(rs.next()) {
					rtnVal=1;//회원가입인증 성공
				}else {
					rtnVal=-1;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(rs != null) try {rs.close(); } catch(SQLException ex) {}
				if(pstmt != null) try {pstmt.close(); } catch(SQLException ex) {}
				if(conn  != null) try {conn.close();  } catch(SQLException ex) {}
				
			}
			return rtnVal;
		}
		//----------------------------------------------------------------------------------------------
		// 회원 id에 해당하는 회원정보를 추출한다.(수정을 하기 위한 메서드)
		//----------------------------------------------------------------------------------------------
		public MemberDTO getMember(String id) throws Exception{
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "";
			MemberDTO member = null;
			
			try {
				
				conn = getConnection();
				sql = "SELECT * FROM member WHERE id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					member = new MemberDTO();
					
					member.setId(rs.getString("id"));
					member.setPasswd(rs.getString("passwd"));
					member.setName(rs.getString("name"));
					member.setReg_date(rs.getTimestamp("reg_date"));
					member.setTel(rs.getString("tel"));
					member.setAddress(rs.getString("address"));
					
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(rs != null) try {rs.close(); } catch(SQLException ex) {}
				if(pstmt != null) try {pstmt.close(); } catch(SQLException ex) {}
				if(conn  != null) try {conn.close();  } catch(SQLException ex) {}
			}
			return member;
			
		}
		//----------------------------------------------------------------------------------------------
		//회원정보수정
		//----------------------------------------------------------------------------------------------
		public void updateMember(MemberDTO member) throws Exception{
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "";
			
			try {
				conn = getConnection();
				sql = "UPDATE member SET passwd=?,name=?, tel=?, address=?" +  "WHERE id=?";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1,member.getPasswd());
				pstmt.setString(2, member.getName());
				pstmt.setString(3, member.getTel());
				pstmt.setString(4, member.getAddress());
				pstmt.setString(5, member.getId());
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(pstmt != null) try {pstmt.close(); } catch(SQLException ex) {}
				if(conn  != null) try {conn.close();  } catch(SQLException ex) {}
			}
			
		}
		public void deleteMember(String id,String passwd) throws Exception{
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String dbpasswd="";
			int x=-1;
			try {
				conn = getConnection();
				
				pstmt = conn.prepareStatement("select passwd from member where id=?");
				
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				
				if(rs.next()){
					 dbpasswd= rs.getString("passwd"); 
					 if(dbpasswd.equals(passwd)){
						 pstmt = conn.prepareStatement("delete from member where id=?");
	                     pstmt.setString(1, id);
	                     pstmt.executeUpdate();
						 x= 1;
					 }else
						 x= 0; 
				 }
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(pstmt != null) try {pstmt.close(); } catch(SQLException ex) {}
				if(conn  != null) try {conn.close();  } catch(SQLException ex) {}
			}
			
		}
}



