package com.parim.model.Tiling;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Plant.class, name = "Plant")
})
public abstract class Enemy extends Tile{
    public Enemy(){}
    public Enemy(int x, int y, String directory) {
        super(x, y, directory);
    }
}
