package com.parim.model.Tiling;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = OrdinaryBlock.class, name = "OrdinaryBlock"),
        @JsonSubTypes.Type(value = PowerUpBlock.class, name = "PowerUpBlock")
})
public abstract class Block extends Tile{
    public Block(){}
    public Block(int x, int y, String directory) {
        super(x, y, directory);
    }
}
