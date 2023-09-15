package casperx.mod.soundpacket.mixin;

import casperx.mod.soundpacket.IWorldServerMixin;
import casperx.mod.soundpacket.Util;
import casperx.mod.soundpacket.packet.Packet253PlaySound;
import net.minecraft.core.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.WorldServer;
import net.minecraft.core.net.packet.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(
    remap = false,
    value = {
        WorldServer.class
    }
)
public class WorldServerMixin implements IWorldServerMixin {
    @Shadow
    private MinecraftServer mcServer;

    @Unique
    public void soundpacket$playSoundAtEntityClient(Entity entity, String soundPath, float volume, float pitch) {
        Packet packet = new Packet253PlaySound(
            (int) entity.x,
            (int) entity.y,
            (int) entity.z,
            soundPath,
            volume,
            pitch
        );

        WorldServer self = Util.forceCast(this);

        this
            .mcServer
            .configManager
            .sendPacketToPlayersAroundPoint(
                entity.x,
                entity.y,
                entity.z,
                64.0,
                self.dimension.id,
                packet
            );
    }
}
