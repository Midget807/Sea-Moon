package net.midget807.seamoon.util;

import net.minecraft.sound.SoundCategory;

public interface Extractable {
    void extracted(SoundCategory extractedSoundCategory);
    boolean isExtractable();
}
