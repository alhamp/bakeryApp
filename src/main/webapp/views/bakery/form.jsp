<%@page import="com.launchacademy.bakery.*"%>

<%  BakeryOrder bakeryOrder = (BakeryOrder)request.getAttribute("bakeryOrder");%>

<h1>Bakery Form</h1>

<% if(request.getAttribute("bakeryOrder") != null){ %>

  <h2><strong> Welcome: <%= bakeryOrder.getUserName() %></strong></h2>

  <a href="/bakeries/cancel"> Not Me </a>
  <br>

<%}
else{ %>
<p>Make a new order</p>
<%}%>

<form action="/bakeries" method="POST">
  <div>
    <label for="userName">User Name</label>
    <input type="text" id="userName" name="userName" value="" required="required" />
  </div>
  <div>
    <label for="itemName">Item Name</label>
    <input type="text" id="itemName" name="itemName" value="" required="required" />
  </div>

  <div>
      <label for="itemQuantity">Item Quantity</label>
      <input type="number" id="itemQuantity" name="itemQuantity" value="" required="required" />
   </div>

  <div>
    <input type="checkbox" name="glutenFree" id="glutenFree" value="1" />
    <label for="glutenFree">Click Box if you want item to be Gluten Free</label>
  </div>

  <div>
    <input type="checkbox" name="vegan" id="vegan" value="1" />
    <label for="vegan">Click Box if you want item to be Vegan</label>
  </div>

  <div>
    <input type="submit" value="Add" />
  </div>


</form>