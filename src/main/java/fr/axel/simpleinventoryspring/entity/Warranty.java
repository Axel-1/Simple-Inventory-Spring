package fr.axel.simpleinventoryspring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Warranty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String warrantyName;
    private LocalDate expirationDate;
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @JsonBackReference
    private Product product;

    public Warranty() {
    }

    public Warranty(Long id, String warrantyName, LocalDate expirationDate, Product product) {
        this.id = id;
        this.warrantyName = warrantyName;
        this.expirationDate = expirationDate;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWarrantyName() {
        return warrantyName;
    }

    public void setWarrantyName(String productName) {
        this.warrantyName = productName;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Warranty{" +
                "id=" + id +
                ", productName='" + warrantyName + '\'' +
                ", expirationDate=" + expirationDate +
                ", product=" + product +
                '}';
    }
}
