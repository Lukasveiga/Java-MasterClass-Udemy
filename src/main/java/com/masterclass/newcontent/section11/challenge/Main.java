package com.masterclass.newcontent.section11.challenge;

import com.masterclass.newcontent.section11.challenge.enums.Usage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Mappable> builds = new ArrayList<>(
                Arrays.asList(
                        new Building("Sydney Town Hall", Usage.GOVERNMENT),
                        new Building("Sydney Church Catholic", Usage.ENTERTAIMENT),
                        new Building("Stadium Sydney Soccer", Usage.SPORTS)
                )
        );

        for (Mappable build : builds){
            Mappable.showProperties(build);
        }
    }
}