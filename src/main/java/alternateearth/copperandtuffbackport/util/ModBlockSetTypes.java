package alternateearth.copperandtuffbackport.util;

import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.minecraft.block.BlockSetType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import alternateearth.copperandtuffbackport.Initialise;

public record ModBlockSetTypes() {

    public static final BlockSetType COPPER = new BlockSetTypeBuilder()
            .openableByHand(true)
            .soundGroup(BlockSoundGroup.COPPER)
            .doorCloseSound(ModSounds.BLOCK_COPPER_DOOR_CLOSE)
            .trapdoorCloseSound(ModSounds.BLOCK_COPPER_TRAPDOOR_CLOSE)
            .doorOpenSound(ModSounds.BLOCK_COPPER_DOOR_OPEN)
            .trapdoorOpenSound(ModSounds.BLOCK_COPPER_TRAPDOOR_OPEN)
            .pressurePlateClickOffSound(SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_OFF)
            .pressurePlateClickOnSound(SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_ON)
            .buttonClickOffSound(SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF)
            .buttonClickOnSound(SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON)
            .register(new Identifier(Initialise.MOD_ID, "copper"));

}