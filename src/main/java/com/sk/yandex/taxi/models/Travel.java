package com.sk.yandex.taxi.models;

import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

/**
 * Created by Sanchir on 6/21/2017.
 */
@Entity
@Table(name="Travels")
public class Travel {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @ManyToOne
    private Point pointFrom;

    @ManyToOne
    private Point pointTo;

    @ManyToOne
    private Point currentPoint;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Point getPointFrom() {
        return pointFrom;
    }

    public void setPointFrom(Point pointFrom) {
        this.pointFrom = pointFrom;
    }

    public Point getPointTo() {
        return pointTo;
    }

    public void setPointTo(Point pointTo) {
        this.pointTo = pointTo;
    }

    public Point getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(Point currentPoint) {
        this.currentPoint = currentPoint;
    }
}
