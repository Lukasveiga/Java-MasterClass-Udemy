package com.masterclass.newcontent.section12.challenge;

public class Main {

    public static void main(String[] args) {

        Point point = new Point("Loc1", -35.000, 84.000);

        Line line = new Line("Loc2Line");
        line.addLineCoordinates(-22.00, 35.00);
        line.addLineCoordinates(44.000, -35.232);

        Layer<Mappable> layer = new Layer<>();
        layer.addLayer(point);
        layer.addLayer(line);

        layer.renderLayer();
    }
}
