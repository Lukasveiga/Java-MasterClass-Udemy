package com.masterclass.newcontent.section12.challenge;

import java.util.ArrayList;
import java.util.List;

public class Line implements Mappable{

    private String name;

    List<Coordinate> coordinates;

    public Line(String name) {
        this.name = name;
        this.coordinates = new ArrayList<>();
    }

    public void addLineCoordinates(double x, double y){
        coordinates.add(new Coordinate(x,y));
    }

    @Override
    public void render() {
        StringBuilder st = new StringBuilder("%s as LINE ([".formatted(name));
        for (int i = 0; i < coordinates.size() - 1; i++){
            st.append("[%s, %s], ".formatted(coordinates.get(i).getX(), coordinates.get(i).getY()));
        }
        st.append("[%s, %s]])".formatted(coordinates.get(coordinates.size() - 1).getX(),
                                             coordinates.get(coordinates.size() - 1).getY()));
        System.out.println(st);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }
}
