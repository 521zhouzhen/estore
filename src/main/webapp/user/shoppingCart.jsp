<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.briup.app.estore.service.*" %>
    <%@ page import="com.briup.app.estore.bean.*" %>
 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--文件头开始-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
		

<!--文件体开始-->


		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="middle">
                  <a href=index.jsp>杰普电子商务门户</a> →
					<img border="0" src="images/dog.gif" width="19" height="18">

                </td>
                </tr>
		</table>
              <br>

		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>序号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>产品名称</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>价格</b></font></td>

		</tr>
       
       <%
      
       
       Integer bookid = Integer.parseInt( request.getParameter("bookid"));
       IBookService bookservice=new BookServiceImpl();
       Book book=bookservice.findBookById(bookid);
       request.setAttribute("book", book); 

       %>
     
        
			<form method="get" action="/estore/AddOrderlineServlet" >
			<input type="hidden" name="bookid" value="${book.id}">

			商品号：<td class=tablebody2 valign=middle align=center width="10">${book.id}</td>
			商品名称:<td class=tablebody1 valign=middle align=center width="">${book.name}</td>
		</tr>
		<tr>
			
			<tr><td>购买数量:</td>
				<td><input type="text" name="num"onblur="javascript:if(this.value<1){alert('对不起，产品数量不能小于 1 ');
			this.focus();}else{number.value=this.value;}"/></td>
		
			<td class=tablebody2 valign=middle align=left width="">&nbsp;&nbsp;价格：${book.price}</td>
			<td class=tablebody1 valign=middle align=center width="">
			</tr>
			<tr>
				<input type="submit" value="确认添加">
			</tr>
			</form>

		
                
		<tr>
			<td class=tablebody2 valign=middle align=center colspan="6">

			<br>
			<br>
			<br>
			<input type="button" value="取消" onclick="javascript:window.location='/estore/index.jsp';"> 
		</tr>
                </table><br>
<!--文件尾开始-->
		<%@include file="/footer.jsp" %>
	</body>
</html>
