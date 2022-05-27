public int getCount() throws SQLException {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        con = dataSource.getConnection();
        ps = con.prerpareStatement("SELECT COUNT(*) FROM USERS");
        
        rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1);

    } catch (SQLException e) {
        throw e;

    } finally {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
            }
        }
         if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    }
}
