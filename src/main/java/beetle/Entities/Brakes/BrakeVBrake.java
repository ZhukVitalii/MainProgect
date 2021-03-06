package beetle.Entities.Brakes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 26.06.2017.
 */
@Entity
@Table(name="BrakeVBrakes")
@NoArgsConstructor
@Getter
@Setter
public class BrakeVBrake {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="maker_id")
    private BrakeMaker maker;
    private Long article;
    private String url;
    private String name;
    @ManyToOne
    @JoinColumn(name="loc_id")
    private Location location;
    private String material;
    private String color;
    @Column(name = "description", length = 10000)
    private String description;
    private Double price;
    private String way;

    public BrakeVBrake(BrakeMaker maker,Long article,String url, String name, Location location, String material,
                 String color, String description, Double price,  String way) {
        this.maker = maker;
        this.article = article;
        this.url = url;
        this.name = name;
        this.location = location;
        this.material = material;
        this.color = color;
        this.description = description;
        this.price = price;
        this.way = way;
    }
    public Double getPrice(){
        return price;
    }

    public BrakeMaker getMaker() {
        return maker;
    }

}