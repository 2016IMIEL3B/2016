package com.groupe4.entity;

public class Quote {

    /**
     * Integer id
     */
    private Integer id;

    private Integer userId;

    private String typeQuote;
    private String guarantee;
    private Integer price;

    public Quote() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTypeQuote() {
        return typeQuote;
    }

    public void setTypeQuote(String typeQuote) {
        this.typeQuote = typeQuote;
    }

    public String getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", userId=" + userId +
                ", typeQuote='" + typeQuote + '\'' +
                ", guarantee='" + guarantee + '\'' +
                ", price=" + price +
                '}';
    }
}
