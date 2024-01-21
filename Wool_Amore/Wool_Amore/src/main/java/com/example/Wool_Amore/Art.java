package com.example.Wool_Amore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
//import org.springframework.boot.autoconfigure.domain.EntityScan;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Art {

    private long id;
    private String name;
    private String price;

    // Getters
    public long getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    // Setters
    public void setID(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price= String.valueOf(price);
    }

    public void delete(WoolRepository WoolRepository) {
        WoolRepository.deleteArt(this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Art art = (Art) o;
        return id == art.id &&
                Objects.equals(name, art.name) &&
                Objects.equals(price, art.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }


}