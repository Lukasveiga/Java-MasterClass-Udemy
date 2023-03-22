package com.masterclass.newcontent.section12.challenge;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Coordinate {
    private double x;
    private double y;

    DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("en"));
    DecimalFormat format = new DecimalFormat("#.000", dfs);

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String getX() {
        return format.format(x);
    }

    public void setX(double x) {
        this.x = x;
    }

    public String getY() {
        return format.format(y);
    }

    public void setY(double y) {
        this.y = y;
    }
}
