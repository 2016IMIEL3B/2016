package com.front;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by kevin on 23/03/16.
 */
@Entity
public class TypeQuotation {

    /**
     * TypeQuotation id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * TypeQuotation entitled.
     */
    private String entitled;

    public int getId() {  return id;  }

    public void setId(int id) { this.id = id;  }

    public String getEntitled() { return entitled;  }

    public void setEntitled(String entitled) { this.entitled = entitled;  }
}
