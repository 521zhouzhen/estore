<%@page import="com.briup.app.estore.service.ICustomerService"%>
<%@page import="com.briup.app.estore.service.CustomerServiceImpl"%>
<%@page import="com.briup.app.estore.bean.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--文件头开始-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
		<%@include file="/header.jsp" %>

<!--文件体开始-->

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="middle">
                  <a href=index.html>杰普电子商务门户</a> →
			
                </td>
                </tr>
		</table>
              <br>

              
            <%
            Integer id= Integer.parseInt(request.getParameter("id"));
            String name=request.getParameter("name");
    		String password=request.getParameter("password");
    		String zip=request.getParameter("zip");
    		String address=request.getParameter("address");
    		String telephone=request.getParameter("telephone");	
    		String email=request.getParameter("email");
    		Customer customer= new Customer(id,name,password,zip,address,telephone,email);
    		
    		ICustomerService  CustomerService=new CustomerServiceImpl();
    		
    			CustomerService.CustomerUpdate(customer);
    			 response.getWriter().write("修改成功");
    			 request.getRequestDispatcher("userinfo.jsp").forward(request, response);
    			
    		
    	
            
            
            
            
            
            
            
            %>  
              
              
              
              
              
              
              
              
              
              
              
          <br>

		<%@include file="/footer.jsp" %>
	</body>
</html>    
          
              