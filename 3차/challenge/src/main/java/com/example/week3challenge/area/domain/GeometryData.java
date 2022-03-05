package com.example.week3challenge.area.domain;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class GeometryData {
    private Long latitude;
    private Long longitude;

    protected GeometryData() {
    }

    public GeometryData(Long latitude, Long longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getLatitude() {
        return latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GeometryData)) return false;
        GeometryData that = (GeometryData) o;
        return Objects.equals(getLatitude(), that.getLatitude()) && Objects.equals(getLongitude(), that.getLongitude());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLatitude(), getLongitude());
    }
}
