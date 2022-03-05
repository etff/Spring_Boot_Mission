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
@Table(name = "shop_post")
public class ShopPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private ShopEntity shop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(length = 100, nullable = false)
    private String title;

    @Lob
    private String content;

    public ShopPostEntity(UserEntity writer, String title, String content) {
        validate(writer);
        this.title = title;
        this.content = content;
    }

    private void validate(UserEntity writer) {
        if(!this.shop.getLimitedUsers().contains(writer)) {
            throw new IllegalArgumentException();
        }
    }
}
