
<h1>Bakery Form</h1>

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