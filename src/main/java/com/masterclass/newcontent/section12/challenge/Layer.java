package com.masterclass.newcontent.section12.challenge;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Layer<T extends Mappable> {

    private final List<T> layers;

    public Layer() {
        this.layers = new ArrayList<>();
    }

    public Layer(List<T> layers) {
        this.layers = layers;
    }

    public void addLayer(@NotNull T layer) {
        layers.add(layer);
    }

    public void renderLayer(){
        for(T layer : layers){
            layer.render();
        }
    }
}
