package net.midget807.seamoon.entity.attribute;

import net.midget807.seamoon.SeaMoonMain;
import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModAttributes {
    public static final EntityAttribute SEAMOON_AFFECTION = registerEntityAttribute("seamoon.affection", new ClampedEntityAttribute("attribute.name.seamoon.affection", 0.0, 0.0, 10.0).setTracked(true));
    public static EntityAttribute registerEntityAttribute(String name, EntityAttribute attribute) {
        return Registry.register(Registries.ATTRIBUTE, SeaMoonMain.id(name), attribute);
    }
}
