package com.example.week3challenge.shop.post;

import com.example.week3challenge.shop.domain.ShopEntity;
import com.example.week3challenge.user.domain.UserEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shop_review")
public class ShopReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private ShopEntity shop;

    @Column(length = 100, nullable = false)
    private String title;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public ShopReviewEntity() {
    }

    public ShopReviewEntity(Long id, ShopEntity shop) {
        this.id = id;
        this.shop = shop;
    }

    public Long getId() {
        return id;
    }

    public ShopEntity getShop() {
        return shop;
    }


}
