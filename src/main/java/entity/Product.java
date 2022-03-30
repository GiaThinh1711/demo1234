package entity;

import java.util.HashMap;

public class Product {
    private int id;
    private String name;
    private String thumbnail;
    private double price;
    private int status;

    public Product() {
    }

    public Product(String name, String thumbnail, double price) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.price = price;
    }

    public Product(int id, String name, String thumbnail, double price, int status) {
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
        this.price = price;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private  HashMap<String,String> error;
    private void checkValid(){
        this.error = new HashMap<>();
        if (this.name == null || this.name.length() == 0){
            this.error.put("name","Name is required!");
        }
        if (this.thumbnail == null || this.thumbnail.length() == 0){
            this.error.put("thumbnail","Thumbnail is required!");
        }
        if (this.price == 0 ){
            this.error.put("price","Price is required!");
        }
    }

    public HashMap<String,String> getErrors() {
        checkValid();
        return error;
    }
    public boolean isValid() {
        checkValid();
        return error == null || error.size() == 0;
    }
}
