package org.rnm.rnmcplugins.minigames;

import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.rnm.rnmcplugins.RnMC_Plugins;

import java.util.Objects;

public enum MinigameMetaValue implements MetadataValue {

    PARKOURTAG(0),NONE(-1);


    Integer integerValue;
    MinigameMetaValue(int i) {
        this.integerValue = i;
    }

    @Override
    public @Nullable Object value() {
        return this.asInt();
    }

    @Override
    public int asInt() {
        return integerValue;
    }

    @Override
    public float asFloat() {
        return (float) integerValue;
    }

    @Override
    public double asDouble() {
        return (double) integerValue;
    }

    @Override
    public long asLong() {
        return (long) integerValue;
    }

    @Override
    public short asShort() {
        return Short.parseShort(String.valueOf(integerValue));
    }

    @Override
    public byte asByte() {
        return Byte.parseByte(String.valueOf(integerValue));
    }

    @Override
    public boolean asBoolean() {
        return integerValue > 0;
    }

    @Override
    public @NotNull String asString() {
        return String.valueOf(integerValue);
    }

    @Override
    public @Nullable Plugin getOwningPlugin() {
        return RnMC_Plugins.getProvidingPlugin(RnMC_Plugins.class);
    }

    @Override
    public void invalidate() {
        this.integerValue = -1;
    }

    public boolean equals(MinigameMetaValue other){
        return Objects.equals(this.integerValue, other.integerValue);
    }

}
