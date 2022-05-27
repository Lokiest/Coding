public void deleteAll() throws SQLException {
    Connection con = null;
    PreparedStatement ps = null;

    try {
        con = dataSource.getConnection();
        ps = con.prerpareStatement("DELETE * FROM USERS");
        ps.executeUpdate();
    } catch (SQLException e) {
        throw e;
    } finally {
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
