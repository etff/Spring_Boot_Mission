package com.example.week3challenge.area.domain;

import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * 동,면,읍
 */
@Embeddable
public class Street {
    private String value;

    public Street() {
    }

    public Street(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Street)) return false;
        Street street = (Street) o;
        return Objects.equals(getValue(), street.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
