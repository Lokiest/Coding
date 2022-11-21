<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, common.util.*" %>
<% 
	//response.setHeader("Cache-Control", "no-cache");

	String phone = request.getParameter("phone");

	Connection con = DBUtil.getCon();
	
	String sql = "select * from pizza_user where phone=?";
	
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, phone);
	
	ResultSet rs = ps.executeQuery();
	String idx="0", name="", addr="";
	while(rs.next()) {
		idx = rs.getString("idx");
		name = rs.getString("name");
		addr = rs.getString("addr");
	}
	if(rs!=null) rs.close();
	if(ps!=null) ps.close();
	if(con!=null) con.close();
%>
<result>
	<idx><%=idx %></idx>
	<name><%=name %></name>
	<addr><%=addr %></addr>
</result>