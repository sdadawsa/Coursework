/*
11/10/2022
C3327794
Jake whamond
*/

public class Product
{
    //private variables 
    private double weight;
    private String name;
    private double price;
    private int quantity;

    //defines products
    public Product()
    {
        name = "";
        weight = 0;
        price = 0;
        quantity = 0;
    }

    // setters and getters

    public void setPrice(double newPrice){
        price = newPrice;
    }

    public double getProductPrice(){
        return price;
    }

      public void setName(String newName)
    {
        name = newName;
    }

    public String getProductName()
    {
        return name;
    }
    
    public void setWeight(double newWeight){
        weight = newWeight;
    }

    public double getProductWeight(){
        return weight;
    }

    public void setQuantity(int newQuantity){
        quantity = newQuantity;
    }

    public int getProductQuantity(){
        return quantity;
    }    
}
