package com.example.week3challenge.user.domain;



import com.example.week3challenge.area.domain.AreaEntity;
import com.example.week3challenge.common.BaseEntity;
import com.example.week3challenge.shop.domain.ShopEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String userId;

    @Column(nullable = false, length = 20)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<ShopEntity> shops = new ArrayList<>();

    private Boolean shopOwner;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name="area_id")
    private AreaEntity area;

    protected UserEntity() {
    }

    public UserEntity(String userId) {
        this.userId = userId;
    }

    public UserEntity(Long id, String userId) {
        this.id = id;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getShopOwner() {
        return shopOwner;
    }

    public AreaEntity getArea() {
        return area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        UserEntity user = (UserEntity) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
