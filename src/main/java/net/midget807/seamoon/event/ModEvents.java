package net.midget807.seamoon.event;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.event.GameEvent;

public class ModEvents {
    public static final GameEvent EXTRACT = registerGameEvent("extract");

    private static GameEvent registerGameEvent(String id) {
        return registerGameEvent(id, 16);
    }
    private static GameEvent registerGameEvent(String id, int range) {
        return Registry.register(Registries.GAME_EVENT, id, new GameEvent(range));
    }
}
