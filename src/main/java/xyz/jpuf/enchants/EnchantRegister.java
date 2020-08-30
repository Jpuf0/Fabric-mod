package xyz.jpuf.enchants;

import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.jpuf.enchants.FrostEnchant;

public class EnchantRegister implements ModInitializer {

    private static Enchantment FROST = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier("jpuf_mod", "frost"),
            new FrostEnchant()
    );

    @Override
    public void onInitialize() {
    }
}
