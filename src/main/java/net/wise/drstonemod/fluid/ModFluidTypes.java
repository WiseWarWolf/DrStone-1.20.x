package net.wise.drstonemod.fluid;

import cech12.bucketlib.api.BucketLibApi;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.HoneyBottleItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.wise.drstonemod.DrStoneMod;
import net.wise.drstonemod.item.ModItems;
import org.joml.Vector3f;

import java.util.List;
import java.util.Map;

public class ModFluidTypes {
    public  static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WINE_OVERLAY_RL = new ResourceLocation(DrStoneMod.MOD_ID, "misc/in_wine");
    public static final ResourceLocation BAT_OVERLAY_RL = new ResourceLocation(DrStoneMod.MOD_ID, "misc/in_bat");
    public static final ResourceLocation ETH_OVERLAY_RL = new ResourceLocation(DrStoneMod.MOD_ID, "misc/in_eth");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, DrStoneMod.MOD_ID);

    // Register Wine Fluid
    public static final RegistryObject<FluidType> WINE_FLUID_TYPE = register(
            "wine_fluid",
            0xA1781335, // Tint color (ARGB)
            new Vector3f(120f / 255f, 1f / 255f, 53f / 255f), // Fog color (RGB)
            FluidType.Properties.create().lightLevel(10).density(15).viscosity(5).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)
    );

    // Register Bat Fluid
    public static final RegistryObject<FluidType> BAT_FLUID_TYPE = register(
            "bat_fluid",
            0xA18d742d, // Different tint color
            new Vector3f(87f / 255f, 116f / 255f, 45f / 255f), // Different fog color
            FluidType.Properties.create().lightLevel(5).density(20).viscosity(10).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)
    );

    // Register Bat Fluid
    public static final RegistryObject<FluidType> ETH_FLUID_TYPE = register(
            "eth_fluid",
            0xA1912f53, // Different tint color
            new Vector3f(145f / 255f, 47f / 255f, 83f / 255f), // Different fog color
            FluidType.Properties.create().lightLevel(15).density(10).viscosity(15).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)
    );


    private static RegistryObject<FluidType> register(String name, int tintColor, Vector3f fogColor, FluidType.Properties properties) {
        ResourceLocation overlayTexture;

        if (name.equals("bat_fluid")) {
            overlayTexture = BAT_OVERLAY_RL;
        } else if (name.equals("eth_fluid")) {
            overlayTexture = ETH_OVERLAY_RL;
        } else {
            overlayTexture = WINE_OVERLAY_RL;
        }

        return FLUID_TYPES.register(name, () -> new BaseFluidTypes(WATER_STILL_RL, WATER_FLOWING_RL, overlayTexture,
                tintColor, fogColor, properties));
    }




    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
