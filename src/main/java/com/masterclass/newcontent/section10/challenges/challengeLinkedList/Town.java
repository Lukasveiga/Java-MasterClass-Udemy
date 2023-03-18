package com.masterclass.newcontent.section10.challenges.challengeLinkedList;

import org.jetbrains.annotations.NotNull;

public class Town implements Comparable<Town>{

    private String name;
    private double distanceReferencePoint;

    public Town() {}

    public Town(String name) {
        this.name = name;
    }

    public Town(String name, double distanceReferencePoint) {
        this.name = name;
        this.distanceReferencePoint = distanceReferencePoint;
    }
    public static Town createReferencePoint(String name){
        return new Town(name, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistanceReferencePoint() {
        return distanceReferencePoint;
    }

    public void setDistanceReferencePoint(double distanceReferencePoint) {
        this.distanceReferencePoint = distanceReferencePoint;
    }


    @Override
    public int compareTo(@NotNull Town o) {
        return Double.compare(distanceReferencePoint, o.distanceReferencePoint);
    }

    @Override
    public String toString() {
        if (distanceReferencePoint == 0){
            return "[Reference Town: " + name + "]";
        } else {
            return "[Town: " + name + ", Distance to reference: " + distanceReferencePoint + " km]";
        }

    }
}
