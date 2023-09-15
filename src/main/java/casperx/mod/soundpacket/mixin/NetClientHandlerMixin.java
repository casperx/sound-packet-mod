package casperx.mod.soundpacket.mixin;

import casperx.mod.soundpacket.INetHandlerMixin;
import casperx.mod.soundpacket.packet.Packet253PlaySound;
import net.minecraft.client.Minecraft;
import net.minecraft.client.net.handler.NetClientHandler;
import net.minecraft.core.sound.SoundType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(
    remap = false,
    value = {
        NetClientHandler.class
    }
)
public class NetClientHandlerMixin implements INetHandlerMixin {
    @Shadow
    private Minecraft mc;

    @Unique
    public void soundpacket$handlePlaySound(Packet253PlaySound packet) {
        this
            .mc
            .theWorld
            .playSoundEffect(
                SoundType.ENTITY_SOUNDS,
                packet.x,
                packet.y,
                packet.z,
                packet.soundPath,
                packet.volume,
                packet.pitch
            );
    }
}
