package com.masterclass.newcontent.section11.challenge;

import com.masterclass.newcontent.section11.challenge.enums.GeometryType;
import com.masterclass.newcontent.section11.challenge.enums.Marker;
import com.masterclass.newcontent.section11.challenge.enums.Usage;

public class Building implements Mappable {

    private final String name;
    private final String usage;

    private Marker marker;

    private final GeometryType geometry;

    public Building(String name, Usage usage) {
        this.name = name;
        this.usage = usage.getName();
        this.geometry = GeometryType.POINT;

        switch (usage) {
            case GOVERNMENT -> this.marker = Marker.BLACK_DOT;
            case ENTERTAIMENT -> this.marker = Marker.GRAY_DOT;
            case SPORTS -> this.marker = Marker.RED_DOT;
        }

    }

    @Override
    public String getLabel() {
        return "%s (%s)".formatted(this.name, this.usage);
    }

    @Override
    public String getGeometry() {
        return this.geometry.getName();
    }

    @Override
    public String getMaker() {
        return this.marker.getName();
    }

    @Override
    public String toJSON() {
        String extraFields = """
                "name": "%s", "usage": "%s"
                """.formatted(this.name, this.usage);
        return Mappable.super.toJSON() + extraFields;
    }
}
