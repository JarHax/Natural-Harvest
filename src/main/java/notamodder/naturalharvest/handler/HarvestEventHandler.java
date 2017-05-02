package notamodder.naturalharvest.handler;

import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import notamodder.naturalharvest.data.HarvestItems;
import notamodder.notalib.world.loot.functions.SetColor;

@EventBusSubscriber
public class HarvestEventHandler {

    @SubscribeEvent
    public void onTableLoad (LootTableLoadEvent event) {

        if (event.getName().equals(LootTableList.GAMEPLAY_FISHING_FISH)) {

            final LootPool pool = event.getTable().getPool("main");

            if (pool != null)
                pool.addEntry(new LootEntryItem(HarvestItems.JELLYFISH, 2, 0, new LootFunction[] { new SetColor(new LootCondition[] {}) }, new LootCondition[] {}, "modid:jellyfish"));
        }
    }
}
