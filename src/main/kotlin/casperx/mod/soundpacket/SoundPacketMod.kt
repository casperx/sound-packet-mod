package casperx.mod.soundpacket

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

class SoundPacketMod : ModInitializer {
    companion object {
        val logger = LoggerFactory.getLogger("soundpacket")
    }

    override fun onInitialize() {
        logger.info("Sound Packet initialized.")
    }
}
