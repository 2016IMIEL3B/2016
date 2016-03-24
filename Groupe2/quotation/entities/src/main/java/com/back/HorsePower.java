package com.back;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by nico on 24/03/16.
 */
@Entity
public class HorsePower {

    /** Home Type id. */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    /** HorsePower value. */
    private int value;
}
