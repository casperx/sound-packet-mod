package casperx.mod.soundpacket.mixin;

import casperx.mod.soundpacket.INetHandlerMixin;
import casperx.mod.soundpacket.Util;
import casperx.mod.soundpacket.packet.Packet253PlaySound;
import net.minecraft.core.net.handler.NetHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(
    remap = false,
    value = {
        NetHandler.class
    }
)
public abstract class NetHandlerMixin implements INetHandlerMixin {
    @Unique
    public void soundpacket$handlePlaySound(Packet253PlaySound p) {
        NetHandler self = Util.forceCast(this);
        self.handleInvalidPacket(p);
    }
}
