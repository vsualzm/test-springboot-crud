package id.ilham.learn.eurekaaccountservice.model;


import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    private String productName;

    private String price;

    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
