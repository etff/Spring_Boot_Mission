package com.example.week3challenge.area.domain;

import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * 도, 광역시 정보.
 */
@Embeddable
public class Province {
    private String value;

    protected Province() {
    }

    public Province(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Province)) return false;
        Province province = (Province) o;
        return Objects.equals(getValue(), province.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
