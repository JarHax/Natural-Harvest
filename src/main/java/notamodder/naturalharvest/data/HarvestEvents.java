package notamodder.naturalharvest.data;

import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import notamodder.notalib.world.loot.functions.SetColor;

public class HarvestEvents {
    
    @SubscribeEvent
    public void onTableLoad(LootTableLoadEvent event) {
        
        if(event.getName().equals(LootTableList.GAMEPLAY_FISHING_FISH)) {
            
            final LootPool pool = event.getTable().getPool("main");
            
            if(pool != null)
                pool.addEntry(new LootEntryItem(HarvestItems.JELLYFISH, 2, 0, new LootFunction[]{new SetColor(new LootCondition[]{})}, new LootCondition[]{}, "modid:jellyfish"));
        }
    }
}
