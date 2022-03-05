package com.example.week3challenge.area.domain;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class City {
    private String value;

    protected City() {
    }

    public City(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(getValue(), city.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
