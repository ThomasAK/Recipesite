package banana.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "banana_data",schema = "banana")
public class BananaData {
    @Id
    private int waffle;
    private String tacos;
    private boolean pancakes;

    //constructor for hibernate
    private BananaData(){}
    public BananaData(int waffle, String tacos, boolean pancakes) {
        this.waffle = waffle;
        this.tacos = tacos;
        this.pancakes = pancakes;
    }

    public int getWaffle() {
        return waffle;
    }

    public void setWaffle(int waffle) {
        this.waffle = waffle;
    }


    public String getTacos() {
        return tacos;
    }

    public void setTacos(String tacos) {
        this.tacos = tacos;
    }

    public boolean isPancakes() {
        return pancakes;
    }

    public void setPancakes(boolean pancakes) {
        this.pancakes = pancakes;
    }
}
