
package shoppingpackage.model;

/**
 *
 * @author Duku Allan
 */
public class Order extends Shirt{
    private int OrderID;
    private int customerID;
    private int quantity;
    private String date;
   
    public Order(){
    }

    public Order(int OrderID, int customerID, int quantity, String date) {
        this.OrderID = OrderID;
        this.customerID = customerID;
        this.quantity = quantity;
        this.date = date;
    }

    public Order(int customerID, int quantity, String date) {
        this.customerID = customerID;
        this.quantity = quantity;
        this.date = date;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" + "OrderID=" + OrderID + ", customerID=" + customerID + ", quantity=" + quantity + ", date=" + date + '}';
    }
    
    
    
}
