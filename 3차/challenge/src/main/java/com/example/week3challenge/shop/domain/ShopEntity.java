package com.example.week3challenge.shop.domain;

import com.example.week3challenge.area.domain.AreaEntity;
import com.example.week3challenge.common.BaseEntity;
import com.example.week3challenge.shop.category.CategoryEntity;
import com.example.week3challenge.shop.post.ShopPostEntity;
import com.example.week3challenge.shop.post.ShopReviewEntity;
import com.example.week3challenge.user.domain.UserEntity;
import org.hibernate.annotations.Fetch;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.awt.geom.Area;
import java.util.List;
import java.util.Objects;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "shop")
public class ShopEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    private List<CategoryEntity> categories;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(fetch = FetchType.LAZY)
    private List<UserEntity> limitedUsers;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name="area_id")
    private AreaEntity area;

    @OneToMany(mappedBy = "shop")
    private List<ShopPostEntity> posts;

    @OneToMany(mappedBy = "shop")
    private List<ShopReviewEntity> reviews;

    public ShopEntity() {
    }

    public Long getId() {
        return id;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public UserEntity getUser() {
        return user;
    }

    public AreaEntity getArea() {
        return area;
    }

    public List<ShopPostEntity> getPosts() {
        return posts;
    }

    public List<ShopReviewEntity> getReviews() {
        return reviews;
    }

    public List<UserEntity> getLimitedUsers() {
        return limitedUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShopEntity)) return false;
        ShopEntity that = (ShopEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
