
package shoppingpackage.model;

/**
 *
 * @author Duku Allan
 */
public class CustomerModel {
    private int customerID;
    private String cFname;
    private String cLname;
    private String gender;
    private String location;
    private String cEmail;
    private String cPassword;
    
    public CustomerModel(){
    }
    public CustomerModel(int customerID, String cFname, String cLname, String gender, String location, String cEmail, String cPassword){
        this.customerID = customerID;
        this.cFname = cFname;
        this.cLname = cLname;
        this.gender = gender;
        this.location = location;
        this.cEmail = cEmail;
        this.cPassword = cPassword;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getcFname() {
        return cFname;
    }

    public void setcFname(String cFname) {
        this.cFname = cFname;
    }

    public String getcLname() {
        return cLname;
    }

    public void setcLname(String cLname) {
        this.cLname = cLname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    @Override
    public String toString() {
        return "CustomerModel{" + "customerID=" + customerID + ", cFname=" + cFname + ", cLname=" + cLname + ", "
                + "gender=" + gender + ", location=" + location + ", cEmail=" + cEmail + ", cPassword=" + cPassword + '}';
    }
  
    
}
