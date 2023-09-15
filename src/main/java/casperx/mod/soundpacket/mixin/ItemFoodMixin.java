package casperx.mod.soundpacket.mixin;

import casperx.mod.soundpacket.IWorldServerMixin;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * API usage demo.
 */
@Mixin(
    remap = false,
    value = {
        ItemFood.class
    }
)
public abstract class ItemFoodMixin {
    @Inject(
        method = {
            "onItemRightClick"
        },
        at = {
            @At("HEAD")
        }
    )
    void hookOnItemRightClick(
        ItemStack itemStack,
        World world,
        EntityPlayer entityPlayer,
        CallbackInfoReturnable<ItemStack> flow
    ) {
        IWorldServerMixin worldServer = (IWorldServerMixin) world;
        worldServer.soundpacket$playSoundAtEntityClient(entityPlayer, "mob.sheep", 1.0f, 1.0f);
    }
}
