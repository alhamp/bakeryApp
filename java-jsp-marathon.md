## Getting Started

```no-highlight
et get java-jsp-marathon
cd java-jsp-marathon
createdb my_bakery
idea .
```

## Cookies come from Bakeries!

Having spent part of the week learning about Cookies and the role they play in the modern web you decide that it's high time to create a bakery ordering platform.

## Core User Stories

### Order baked goods

```no-highlight
As a hungry student
I want to fill out a form
So that I can order baked goods
```

Acceptance Criteria:

- When I navigate to `/bakeries/new` I am presented with a form to place an order.
- The form should contain the following fields
  - Username
  - Item Name
  - Item Quantity (greater than 0 and less than or equal to 24)
  - Gluten Free (y/n)
  - Vegan (y/n)
- I must provide values for each or I am presented with an error message

### Display Order

```no-highlight
As a hungry student
I want to see my order
So that I can ensure it's correct
```

Acceptance Criteria:

- When I complete an order I am redirected to `/bakeries/order` I am presented with my most recent order via a Cookie.
- The user should see
  - Order for `username`
  - `Item Name` x `Item qty`
  - Options: display "GF" if `gluten free` is `y`, "V" if `vegan` is `y`, "NONE" if both are `n`.
- I am presented with a button which links to `/bakeries/cancel` which will clear my Cookies (effectively deleting my order) and reroute me to the order form.

**For this section all persistence should be via sessions and cookies.**

### Viewing Order

```no-highlight
As a hungry student
I want to see my open orders
So I can anticipate the delicious treats!
```

Acceptance Criteria:

- When I visit `/bakeries` I should see the item name for any orders I have made during this session
- Each of the item names should be a link to `/bakeries/order?orderId=<primarykey>` where `<primarykey>` is a unique identifier for the order
- The `/bakeries` page should have a link to the order form which takes the user to `/bakeries/new`

### Placing additional orders

```no-highlight
As a user
I want to be remembered when placing another order
So I can feel like a valued customer
```

- On the `/bakeries/new` page the user should be greeted by name if there is a username in the session object
- There should be a button for "Not me!" next to their name which resets the session and shows the form with the username field.

### Removing Order

```no-highlight
As a hungry student
I want to cancel an accepted orders
So that I can admit my eyes were bigger than my stomach
```

- The show page for each order should only display the order if the username in the current session matches the username on the order
- The show page a button to cancel the order which links to `bakeries/order/cancel?orderId=<primarykey>` and removes that order from the session.

## Non-Core User Stories

### Persist Order to Database

```no-highlight
As a baker
I want to store orders in a database
So that I can more easily manage them
```

Acceptance Criteria:

- The bakery has a postgres DB called `my_bakery`
- Pending orders which are cancelled are not store in the database.
- Confirmed orders are stored in a database table.

### Remove orders from Database

```no-highlight
As a baker
I want to remove cancelled orders
So that I don't make items no one wants
```

Acceptance Critera:

- When a user visits `/bakeries/order/cancel?orderId=<primarykey>` the corresponding record is deleted from the database in addition to being removed from their session.

### Change order status

```no-highlight
As a baker
I want my orders to have a status
So I can track their progress
```

Acceptance Critera:

- The bakery order table is updated to include a status field
- The status can be updated by navigating to `bakeries/order?orderId=<primarykey>/update`
- The order update page should display the order information as read only
- The order update page should have a status input (field, DDL, or checkboxes) that accepts the following values
  - Confirmed
  - In progress
  - Completed
  - Cancelled
- When submitted the status should update in the database for that order.
