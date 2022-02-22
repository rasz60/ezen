package solo;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class df {

	public ProductDTO selectProductByCode(String code) {
		String sql = "SELECT * FROM product WHERE code=?";
		ProductDTO pDto;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, code);
				rs = pstmt.executeQuery();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return pDto;
	}
	
}
