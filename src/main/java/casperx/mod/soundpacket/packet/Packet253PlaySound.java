package casperx.mod.soundpacket.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import casperx.mod.soundpacket.INetHandlerMixin;
import net.minecraft.core.net.handler.NetHandler;
import net.minecraft.core.net.packet.Packet;

public class Packet253PlaySound extends Packet {
    public String soundPath;
    public float volume;
    public float pitch;
    public int x;
    public int y;
    public int z;

    public Packet253PlaySound() {}

    public Packet253PlaySound(int x, int y, int z, String p, float v, float f) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.soundPath = p;
        this.volume = v;
        this.pitch = f;
    }

    @Override
    public void readPacketData(DataInputStream dis) throws IOException {
        x = dis.readInt();
        y = dis.readInt();
        z = dis.readInt();
        
        volume = dis.readFloat();
        pitch = dis.readFloat();
        
        int soundPathBytesLen = dis.readByte();
        
        byte[] soundPathByte = new byte[soundPathBytesLen];
        dis.read(soundPathByte);

        soundPath = new String(soundPathByte);
    }

    @Override
    public void writePacketData(DataOutputStream dos) throws IOException {
        dos.writeInt(x);
        dos.writeInt(y);
        dos.writeInt(z);

        dos.writeFloat(volume);
        dos.writeFloat(pitch);

        byte[] soundPathByte = soundPath.getBytes();

        dos.writeByte(soundPathByte.length);
        dos.write(soundPathByte);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        INetHandlerMixin mixin = (INetHandlerMixin) netHandler;
        mixin.soundpacket$handlePlaySound(this);
    }

    @Override
    public int getPacketSize() {
        byte[] soundPathByte = soundPath.getBytes();
        return 22 + soundPathByte.length;
    }
}

