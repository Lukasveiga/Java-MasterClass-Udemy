package com.masterclass.newcontent.section12.challenge;

public class Point implements Mappable{

    private String name;
    Coordinate coordinate;

    public Point(String name, double x, double y) {
        this.name = name;
        this.coordinate = new Coordinate(x, y);
    }

    @Override
    public void render() {
        System.out.printf("%s as POINT ([%s, %s])%n", this.name,
                          this.coordinate.getX(), this.coordinate.getY());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(double x, double y) {
        this.coordinate = new Coordinate(x, y);
    }
}
