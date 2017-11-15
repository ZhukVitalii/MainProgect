package beetle.Wheels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import beetle.Forks.BrakesType;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 19.06.2017.
 */
@Entity
@Table(name="BackHubs")
@NoArgsConstructor
@Getter
@Setter
public class BackHub {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="maker_id")
    private WheelMaker wheelMaker;
    private Long article;
    private String url;
    private String name;
    @ManyToOne
    @JoinColumn(name="fix_type_id")
    private HubFixType hubFixType;
    @ManyToOne
    @JoinColumn(name="bearing_type_id")
    private  BearingType bearingType;
    private String material;
    @ManyToOne
    @JoinColumn(name="axis_length_id")
    private  AxisLength axisLength;
    @ManyToOne
    @JoinColumn(name="axis_diam_id")
    private  AxisDiam axisDiam;
    @ManyToOne
    @JoinColumn(name="brakes_type_id")
    private BrakesType brakesType;
    @ManyToOne
    @JoinColumn(name="rot_fix_id")
    private  RotorFixType rotorFixType;
    @ManyToOne
    @JoinColumn(name="spoke_num_id")
    private SpokeNumber spokeNumber;
    @ManyToOne
    @JoinColumn(name="spr_type_id")
    private  BackSprocketType backSprocketType;
    @ManyToOne
    @JoinColumn(name="spr_num_id")
    private  BackSprocketNumber backSprocketNumber;
    private String weight;
    private String color;
    @Column(name = "description", length = 10000)
    private String description;
    private Double price;
    private String way;

    public BackHub (WheelMaker wheelMaker,Long article, String url, String name, HubFixType hubFixType,BearingType bearingType, String material,
                     AxisLength axisLength,AxisDiam axisDiam, BrakesType brakesType, RotorFixType rotorFixType,SpokeNumber spokeNumber,
                    BackSprocketType backSprocketType,BackSprocketNumber backSprocketNumber, String weight, String color, String description, Double price,  String way) {
        this.wheelMaker = wheelMaker;
        this.article = article;
        this.url = url;
        this.name = name;
        this.hubFixType = hubFixType;
        this.bearingType = bearingType;
        this.material = material;
        this.brakesType = brakesType;
        this.rotorFixType = rotorFixType;
        this.axisLength = axisLength;
        this.axisDiam = axisDiam;
        this.brakesType = brakesType;
        this.spokeNumber = spokeNumber;
        this.backSprocketType = backSprocketType;
        this.backSprocketNumber = backSprocketNumber;
        this.weight = weight;
        this.color = color;
        this.description = description;
        this.price = price;
        this.way = way;
    }
    public Double getPrice(){
        return price;
    }
}
