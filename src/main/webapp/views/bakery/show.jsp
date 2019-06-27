<%@page import="com.launchacademy.bakery.*"%>

<%
  BakeryOrder bakeryOrder = (BakeryOrder)request.getAttribute("bakeryOrder");
%>

<p><strong><%= bakeryOrder %></strong></p>



