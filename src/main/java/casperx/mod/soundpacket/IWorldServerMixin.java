package casperx.mod.soundpacket;

import net.minecraft.core.entity.Entity;

public interface IWorldServerMixin {
    void soundpacket$playSoundAtEntityClient(Entity entity, String soundPath, float volume, float pitch);
}
