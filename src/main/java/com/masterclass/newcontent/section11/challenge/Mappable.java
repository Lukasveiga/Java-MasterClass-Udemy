package com.masterclass.newcontent.section11.challenge;

public interface Mappable {

    String JSON_PROPERTY = """
            "properties":{%s}""";

    String getLabel();

    String getGeometry();

    String getMaker();

    default String toJSON() {
        return """
                "type": "%s", "label": "%s", "marker": "%s"
                """.formatted(getGeometry(), getLabel(), getMaker());
    }

    static void showProperties(Mappable mappable) {
        System.out.printf((JSON_PROPERTY) + "%n", mappable.toJSON());
    }
}
