<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- foot.jsp -->
<%
	String myctx = request.getContextPath();
%>
            </article>
        <!-- 사이드 영역 -------------------------------->
        <aside>
            <!-- 사이드 -->
            <nav>
                <ul>
                    <li><a href="<%=myctx %>/example/ex06.jsp>">성적 계산</a></li>
                    <li><a href="<%=myctx %>">Menu2</a></li>
                    <li><a href="<%=myctx %>">Menu3</a></li>
                    <li><a href="<%=myctx %>">Menu4</a></li>

                </ul>
            </nav>
    
        </aside>
        <div class="clear"></div>
        <!-- 푸터 영역 ------------------------------>
        <footer>
            <!-- footer ----------------------->
            &copy;Copyright/회사소개
        </footer>
            
    </div>
    <!-- div#wrap. container end -->
</body>
</html>