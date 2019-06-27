<%@page import="com.launchacademy.bakery.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<h1> Items ordered: </h1>
<%
  List<BakeryOrder> previousOrders = (List<BakeryOrder>)request.getAttribute("allOrders");

  for(BakeryOrder order : previousOrders) {
%>
  <p> <a href="/bakeries/order?orderId=<%= previousOrders.indexOf(order) + 1 %>"><%= order.getItemName() %></a> </p>

<% } %>
<a href="/bakeries/new">Submit a new order</a>