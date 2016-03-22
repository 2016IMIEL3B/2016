package entity.back;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by nico on 21/03/16.
 */
@Entity
public class HeaterType {
    /** Heater Type id. */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    /** Heater Type entitled. */
    private String entitled;

    public String getEntitled() {
        return entitled;
    }

    public void setEntitled(String entitled) {
        this.entitled = entitled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
