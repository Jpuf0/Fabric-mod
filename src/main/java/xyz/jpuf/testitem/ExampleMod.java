package xyz.jpuf.testitem;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import java.util.List;

public class ExampleMod implements ModInitializer {

	public final TestItem TEST_ITEM = new TestItem(new Item.Settings().group(ExampleMod.ITEM_GROUP));

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier("jpuf_mod", "general"),
			() -> new ItemStack(Blocks.COBBLESTONE)
	);

	public static class TestItem extends Item {

		public TestItem(Settings settings) {
			super(settings);
		}

		@Override
		public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
			playerEntity.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0F, 1.0F);
			return new TypedActionResult<>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
		}

		@Override
		public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
			tooltip.add(new TranslatableText("item.jpuf_mod.testitem.tooltip", "fuck", "yall"));
		}
	}



	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("jpuf_mod", "testitem"), TEST_ITEM);

	}
}
