package com.launchacademy.bakery;

public class BakeryOrder {
private String userName;
private String itemName;
private int itemQuantity;
private boolean glutenFree;
private boolean vegan;


  public BakeryOrder(){}

  public BakeryOrder(String userName, String itemName, int itemQuantity, boolean glutenFree,
      boolean vegan) {
    this.userName = userName;
    this.itemName = itemName;
    this.itemQuantity = itemQuantity;
    this.glutenFree = glutenFree;
    this.vegan = vegan;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public int getItemQuantity() {
    return itemQuantity;
  }

  public void setItemQuantity(int itemQuantity) {
    this.itemQuantity = itemQuantity;
  }

  public boolean isGlutenFree() {
    return glutenFree;
  }

  public void setGlutenFree(boolean glutenFree) {
    this.glutenFree = glutenFree;
  }

  public boolean isVegan() {
    return vegan;
  }

  public void setVegan(boolean vegan) {
    this.vegan = vegan;
  }

  @Override
  public String toString() {
    return
        "userName='" + userName + '\'' +
        ", itemName='" + itemName + '\'' +
        ", itemQuantity=" + itemQuantity +
        ", glutenFree=" + glutenFree +
        ", vegan=" + vegan;
  }
}
