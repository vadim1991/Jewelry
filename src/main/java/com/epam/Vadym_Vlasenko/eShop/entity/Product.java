package com.epam.Vadym_Vlasenko.eShop.entity;

import java.io.Serializable;

/**
 * Created by Вадим on 22.03.2015.
 */
public class Product implements Serializable {

    private int id;
    private String title;
    private int price;
    private String description;
    private Image image;
    private Material material;
    private Insert insert;
    private Category category;
    private double size;
    private double weight;

    public Product() {
        super();
    }

    public Product(String title, int price, String description, Image image, Material material, Insert insert, Category category, double size, double weight) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;
        this.material = material;
        this.insert = insert;
        this.category = category;
        this.size = size;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Insert getInsert() {
        return insert;
    }

    public void setInsert(Insert insert) {
        this.insert = insert;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (price != product.price) return false;
        if (Double.compare(product.size, size) != 0) return false;
        if (Double.compare(product.weight, weight) != 0) return false;
        if (category != null ? !category.equals(product.category) : product.category != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (image != null ? !image.equals(product.image) : product.image != null) return false;
        if (insert != null ? !insert.equals(product.insert) : product.insert != null) return false;
        if (material != null ? !material.equals(product.material) : product.material != null) return false;
        if (title != null ? !title.equals(product.title) : product.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (insert != null ? insert.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        temp = Double.doubleToLongBits(size);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", image=" + image +
                ", material=" + material +
                ", insert=" + insert +
                ", category=" + category +
                ", size=" + size +
                ", weight=" + weight +
                '}';
    }
}

