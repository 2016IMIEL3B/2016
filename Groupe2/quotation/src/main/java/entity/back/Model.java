package entity.back;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by nico on 21/03/16.
 */
@Entity
public class Model {

    /** Mark id. */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    /** Mark entitled. */
    private String entitled;

    /** Mark entitled. */
    private Mark mark;

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

    public Mark getMark() {
        return this.mark;
    }

    public void setEntitled(Mark mark) {
        this.mark = mark;
    }

}
