package com.sk.yandex.taxi.models;


import javax.persistence.*;

/**
 * Created by Sanchir on 6/21/2017.
 */

@Entity
@Table(name="Cars")
public class Car {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "driversName")
    private String driversName;

    @Column(name = "level")
    private int level;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriversName() {
        return driversName;
    }

    public void setDriversName(String driversName) {
        this.driversName = driversName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
