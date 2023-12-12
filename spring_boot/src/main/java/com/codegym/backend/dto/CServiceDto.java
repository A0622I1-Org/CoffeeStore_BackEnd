package com.codegym.backend.dto;


public class CServiceDto {
    Integer id;
    String name;
    Double price;
    Integer typeId;
    String enableFlag;
    String createdDate;
    String imgUrl;
    String describe;

    public CServiceDto(Integer id, String name, Double price, Integer typeId, String enableFlag, String createdDate, String imgUrl, String describe) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.typeId = typeId;
        this.enableFlag = enableFlag;
        this.createdDate = createdDate;
        this.imgUrl = imgUrl;
        this.describe = describe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
