package com.example.week3challenge.area.domain;

import com.example.week3challenge.common.BaseEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "area")
public class AreaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private GeometryData geometryData;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "province", nullable = false))
    private Province province;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "city", nullable = false))
    private City city;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "street", nullable = false))
    private Street street;

    protected AreaEntity() {
    }

    public AreaEntity(GeometryData geometryData, Province province, City city, Street street) {
        this.geometryData = geometryData;
        this.province = province;
        this.city = city;
        this.street = street;
    }

    public AreaEntity(Long id, GeometryData geometryData, Province province, City city, Street street) {
        this.id = id;
        this.geometryData = geometryData;
        this.province = province;
        this.city = city;
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public GeometryData getGeometryData() {
        return geometryData;
    }

    public Province getProvince() {
        return province;
    }

    public City getCity() {
        return city;
    }

    public Street getStreet() {
        return street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AreaEntity)) return false;
        AreaEntity that = (AreaEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
