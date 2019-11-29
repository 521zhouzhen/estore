<%@page import="com.briup.app.estore.service.OrderServiceImpl"%>
<%@page import="com.briup.app.estore.service.IOrderService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.briup.app.estore.bean.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--文件头开始-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
		<%@include file="/header.jsp" %>
	
<!--文件体开始-->


<%
Integer customerid= Integer.parseInt(""+request.getSession().getAttribute("userid"));

IOrderService is=new OrderServiceImpl();
List<Order> list=is.findAllOrderByCustomerid(customerid);
request.setAttribute("list", list);

%>


		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="middle">
                  <a href=index.jsp>杰普电子商务门户</a> →
					<img border="0" src="images/dog.gif" width="19" height="18">
					订单列表
                </td>
                </tr>
		</table>
              <br>

		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>序号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>订单编号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>订单金额</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>订单状态</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>付款方式</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>操作</b></font></td>
		</tr>
        
        
         <c:forEach items="${list}" var="order">
                     int i=1;
request.setAttribute("i", i);          
		<tr>
			<td class=tablebody2 valign=middle align=center width="">${i+1}</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="">${order.id}</a></td>
			<td class=tablebody2 valign=middle align=left width="">&nbsp;&nbsp;￥${order.cost}</td>
			<td class=tablebody1 valign=middle align=center width="">处理中</td>
			<td class=tablebody2 valign=middle align=left width="">&nbsp;&nbsp;货到付款 </td>
			<td class=tablebody1 valign=middle align=center width="">
			<input type="button" value="删除" onclick="javascript:window.location='DelOrderServlet?id=${order.id}';">&nbsp;
			<input type="button" value="明细" onclick="javascript:window.location='user/orderinfo.jsp?id=${order.id}';">
			</td>
		</tr>
		
		</c:forEach>
           
        </table><br>
        
<!--文件尾开始-->
		<%@include file="/footer.jsp" %>
	</body>
</html>