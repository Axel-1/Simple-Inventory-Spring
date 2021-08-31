package fr.axel.simpleinventoryspring.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String siteName;
    private String address;
    private String zipCode;
    private String city;
    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Product> products = new ArrayList<>();

    public Site() {
    }

    public Site(Long id, String siteName, String address, String zipCode, String city, List<Product> products) {
        this.id = id;
        this.siteName = siteName;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProducts(Product product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        return "Site{" +
                "id=" + id +
                ", siteName='" + siteName + '\'' +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", products=" + products +
                '}';
    }
}
