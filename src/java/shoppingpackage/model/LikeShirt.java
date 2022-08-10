
package shoppingpackage.model;

/**
 *
 * @author Duku Allan
 */
public class LikeShirt {
    private int likeID;
    private int customerID;
    private int shirtID;


    public LikeShirt(int likeID, int customerID, int shirtID) {
        this.likeID = likeID;
        this.customerID = customerID;
        this.shirtID = shirtID;

    }

    public LikeShirt() {
    }
    

    public int getLikeID() {
        return likeID;
    }

    public void setLikeID(int likeID) {
        this.likeID = likeID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getShirtID() {
        return shirtID;
    }

    public void setShirtID(int shirtID) {
        this.shirtID = shirtID;
    }



    @Override
    public String toString() {
        return "LikeShirt{" + "likeID=" + likeID + ", customerID=" + customerID + ", shirtID=" + shirtID + '}';
    }
    
    
}
