package br.com.excalibur.excaliburmod;

import com.mojang.authlib.GameProfile;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Excalibur_Mod.MOD_ID)
public class Excalibur_Mod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "excalibur_mod";
    public static final String MOD_NAME = "Excalibur";
    public static final String LOG_TAG = '[' + MOD_NAME + ']';
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final GameProfile gameProfile = new GameProfile(UUID.nameUUIDFromBytes("excalibur.common".getBytes(StandardCharsets.UTF_8)), Excalibur_Mod.LOG_TAG);

    public Excalibur_Mod(){

        IEventBus modEventBus= FMLJavaModLoadingContext.get().getModEventBus();


        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){

        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event){
        LOGGER.info("Server starting");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvent{
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){
            LOGGER.info("CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

        }
    }
}
