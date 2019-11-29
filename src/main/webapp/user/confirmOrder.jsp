<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.briup.app.estore.service.ICustomerService"%>
<%@page import="com.briup.app.estore.service.CustomerServiceImpl"%>
<%@page import="com.briup.app.estore.bean.Customer"%>
<%@page import="com.briup.app.estore.shoppingcart.*"%>
 <%@page import="java.util.*" %>
   <%@page import="java.util.Map" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--文件头开始-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	
		<%@include file="/header.jsp" %>
<!--文件体开始-->
<%
Integer id=Integer.parseInt(""+request.getSession().getAttribute("userid"));
ICustomerService is=new CustomerServiceImpl();
Customer customer=is.CustomerDetil(id);
request.setAttribute("customer", customer);

ShoppingCart shopcart=(ShoppingCart)request.getSession().getAttribute("shopcart");
Map map=shopcart.getMap();
request.setAttribute("map", map);
out.println(map);

double cost=shopcart.getCost();
 request.setAttribute("cost", cost);
%>
		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="middle">
                  <a href=index.jsp>杰普电子商务门户</a> →
					<img border="0" src="images/dog.gif" width="19" height="18">
					确认定单
                </td>
                </tr>
		</table>
              <br>
              
              
  

		<form name="order" method="post" action="/estore/ConfirmServlet">
		<table cellpadding="3" cellspacing="1" align="center" class="tableborder1" id="table1">
		<tr>
			<td valign="middle" colspan="2" align="center" height="25" background="images/bg2.gif">
			<font color="#ffffff"><b>用户信息</b></font><input type="button" value="修改" onclick="javascript:window.location='user/userinfo.jsp';"></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody2" align="right"><b>用户名</b>：</td>
			<td width="60%" class="tablebody1">${customer.name}</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>联系地址</b>：</td>
			<td class="tablebody1">${customer.address}</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>邮编</b>：</td>
			<td class="tablebody1">${customer.zip }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>手机</b>：</td>
			<td class="tablebody1">${customer.telephone }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>Email地址</b>：</td>
			<td class="tablebody1">${customer.email }</td>
		</tr>
	</table>
<br>
<!--文件尾开始-->



		<table cellpadding="3" cellspacing="1" align="center" class="tableborder1" id="table2">
		<tr>
			<td valign="middle" colspan="2" align="center" height="25" background="images/bg2.gif">
			<font color="#FFFFFF"><b>付款方式</b></font></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody2" align="right">　</td>
			<td width="60%" class="tablebody1">
				  <select name="payway">
							<option value="1">货到付款</option>
				  </select>
			</td>
		</tr>
		</table>
		<br>
		<table cellpadding=3 cellspacing=1 align=center class=tableborder1 id="table3">
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" colspan="5">
			<font color="#ffffff"><b>商品购物清单</b></font><input type="button" value="修改" onclick="javascript:window.location='user/shopcart.jsp';"></td>
		</tr>
         <c:forEach items="${map}" var="entry">
		<tr>
			<td class=tablebody2 valign=middle align=center width="">${entry.key}</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="user/productDetail?id=1" target="_blank">${entry.value.book.name}</a></td>
			<td class=tablebody2 valign=middle align=center width="">价格：${entry.value.book.price}</td>
			<td class=tablebody1 valign=middle align=center width="">数量：${entry.value.num}</td>
			<td class=tablebody2 valign=middle align=left width="">小计：￥${entry.value.book.price*entry.value.num}</td>
		</tr>
         </c:forEach>  
                
		<tr>
			<td class=tablebody1 valign=middle align=center colspan="4">　</td>
			<td class=tablebody1 valign=middle align=left width="">合计：<font color="#ff0000"><b>￥${cost}</b></font></td>
		</tr>
		        </table>
		        <p align="center">请认真检查以上订单信息，确认无误后，点击 → <a onclick="javascript:document.order.submit();" style="cursor:pointer;"><img src="images/submit.gif"></a></p>
		</form>


		<%@include file="/footer.jsp" %>
	</body>
</html>
