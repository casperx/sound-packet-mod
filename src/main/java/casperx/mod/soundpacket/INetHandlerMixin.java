package casperx.mod.soundpacket;

import casperx.mod.soundpacket.packet.Packet253PlaySound;

public interface INetHandlerMixin {
    void soundpacket$handlePlaySound(Packet253PlaySound p);
}
