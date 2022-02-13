package com.pz.cheeseria.domains;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class CheeseVO {

    private String uuid;

    private String name;

    private List<String> imageUrls;

    private BigDecimal price;

    private String color;

    public CheeseVO() {
    }

    public CheeseVO(String uuid, String name, List<String> imageUrls, BigDecimal price, String color) {
        this.uuid = uuid;
        this.name = name;
        this.imageUrls = imageUrls;
        this.price = price;
        this.color = color;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheeseVO cheeseVO = (CheeseVO) o;
        return Objects.equals(uuid, cheeseVO.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
