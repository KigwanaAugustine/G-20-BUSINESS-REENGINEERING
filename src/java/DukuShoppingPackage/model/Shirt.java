
package DukuShoppingPackage.model;

import lombok.Data;

/**
 *
 * @author Duku Allan
 */
@Data
public class Shirt {

    
    private int shirtID;
    private double price;
    private String image;
    private String shirtCategoryName;
    private String description;
    private int productionLineID;
        
    public Shirt() {
    }

    public Shirt(int shirtID, double price, String image, String shirtCategoryName, String description, int productionLineID) {
        this.shirtID = shirtID;
        this.price = price;
        this.image = image;
        this.shirtCategoryName = shirtCategoryName;
        this.description = description;
        this.productionLineID = productionLineID;
    }
    


        
        
}
