package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(
            name = "getAllStocks",
            query = "SELECT m FROM SmartphoneList AS m ORDER BY m.id DESC"
            )
})

@Table(name = "stocks")
public class SmartphoneList {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "manufacturing_company", length = 15, nullable = false)
    private String manufacturing_company;

    @Column(name = "product_name", length = 15, nullable = false)
    private String product_name;

    @Column(name = "release_date", length = 15, nullable = false)
    private String release_date;

    @Column(name = "stock", length = 15, nullable = false)
    private String stock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManufacturing_company() {
        return manufacturing_company;
    }

    public void setManufacturing_company(String manufacturing_company) {
        this.manufacturing_company = manufacturing_company;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;


    }

}
