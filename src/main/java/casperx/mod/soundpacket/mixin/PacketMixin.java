package casperx.mod.soundpacket.mixin;

import casperx.mod.soundpacket.packet.Packet253PlaySound;
import net.minecraft.core.net.packet.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(
    remap = false,
    value = {
        Packet.class
    }
)
public abstract class PacketMixin {
    @Shadow
    static void addIdClassMapping(int id, boolean clientPacket, boolean serverPacket, Class<? extends Packet> packetClass) {}

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void packetMixinInit(CallbackInfo ci) {
        addIdClassMapping(253, true, true, Packet253PlaySound.class);
    }
}
