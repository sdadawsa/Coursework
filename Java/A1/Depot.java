/*
Jake Whamond
C3339952
*/
public class Depot
{
    private String name;
    private Product p1, p2, p3;
     /*
     getters and setters
     */
    public Depot()
    {
        p1 = new Product();
        p2 = new Product();
        p3 = new Product();
    }
    public String getName(){
            return name;
    }
    public void setName(String newName)
    {
		name = newName;
    }
    public Product getP1(){
                return p1;
    }
    public void setP1(Product newp1)
    {
		p1 = newp1;
    }
    public Product getP2(){
                return p2;
    }
    public void setP2(Product newp2)
    {
		p2 = newp2;
    }
    public void setP3(Product newp3)
    {
		p2 = newp3;
    }
    public Product getP3(){
                return p2;
    }
    public void addData(int option, String newName, Double newPrice,Double newWeight)
    {
        if (option==1) setData1(p1,newName,newPrice,newWeight);
        else           setData1(p2,newName,newPrice,newWeight);
                       setData1(p3,newName,newPrice,newWeight);
    }
    private void setData1(Product p, String name, Double price,Double weight)
    {
            p.setName(name);
            p.setPrice(price);
            p.setWeight(weight);
    }
}