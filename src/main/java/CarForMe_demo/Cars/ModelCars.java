package CarForMe_demo.Cars;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cars")
@NoArgsConstructor
@AllArgsConstructor
public class ModelCars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "brand")
    private CarBrand brand;

    @Enumerated(EnumType.STRING)
    @Column(name = "body")
    private CarBody body;

    @Column(name = "manufactureyear")
    private int manufactureYear;

    @Column (name = "valuecar")
    private double valueCar;

    @Column(name = "consume")
    private double consume;

    @Column(name = "description")
    private String description;

    @Column(name = "imgurl")
    private String imgUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }

    public CarBody getBody() {
        return body;
    }

    public void setBody(CarBody body) {
        this.body = body;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public double getValueCar() {
        return valueCar;
    }

    public void setValueCar(double valueCar) {
        this.valueCar = valueCar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getConsume() {
        return consume;
    }

    public void setConsume(double consume) {
        this.consume = consume;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
