package com.example.suvp.test;

/**
 * Created by suvp on 1/8/2016.
 */
public class Product
{
    String name_;
    float hp_;
    String type_;

    public Product()
    {}

    public Product(String aInName, float aInHp, String aInype)
    {
        name_ = aInName;
        hp_ = aInHp;
        type_ = aInype;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public float getHp_() {
        return hp_;
    }

    public void setHp_(float hp_) {
        this.hp_ = hp_;
    }

    public String getType_() {
        return type_;
    }

    public void setType_(String type_) {
        this.type_ = type_;
    }

    public String toString()
    {
        return name_+hp_+type_;
    }


}
