package com.github.javamentorship.category.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_created", nullable = false)
    private Date dateCreated = new Date();
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    @Column(name = "goods_id", nullable = false)
    private Integer goodsId;
    @Column(name = "amount", nullable = false)
    private Double amount;

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}

