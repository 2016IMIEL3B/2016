package com.back;

import javax.persistence.*;

/**
 * Created by nico on 21/03/16.
 */
@Entity
public class Model {

    /** Model id. */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    /** Model entitled. */
    private String entitled;

    /** Model Mark. */
    @ManyToOne
    @JoinColumn(name = "markId")
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

    public Mark getMark() { return mark; }

    public void setMark(Mark mark) { this.mark = mark; }
}
