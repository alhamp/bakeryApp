<%@page import="com.launchacademy.bakery.*"%>

<%
  BakeryOrder bakeryOrder = (BakeryOrder)request.getAttribute("bakeryOrder");
%>

<p><strong> Username: <%= bakeryOrder.getUserName() %></strong></p>

<p><strong> <%= bakeryOrder.getItemName() %> X <%= bakeryOrder.getItemQuantity() %> </strong></p>


<%
  if(bakeryOrder.isVegan()){
%>
  <p> V </p>
<%
  }
%>
<%
if(bakeryOrder.isGlutenFree()) {
%>
  <p> GF</p>
<%
  }
%>
<%
if(!bakeryOrder.isGlutenFree() && !bakeryOrder.isVegan()) {
%>
  <p> NONE </p>
<%
  }
%>

<a href="/bakeries/cancel">Cancel order</a>
