package com.greg.client.data;

public class Location {
    private Long x; //Поле не может быть null
    private Integer y; //Поле не может быть null
    private float z;

    public Location() {

    }

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public Location(Long x, Integer y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Location(Long x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public boolean vallidateInput(){
        return x!=null & y!=null;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
