package xyz.jpuf.Commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.api.ModInitializer;
import io.github.cottonmc.clientcommands.*;
import net.minecraft.entity.Entity;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

public class ExampleCommand implements ClientCommandPlugin {
    PlayerManager player;
    @Override
    public void registerCommands(CommandDispatcher<CottonClientCommandSource> dispatcher) {
        dispatcher.register(ArgumentBuilders.literal("get-players")
                .executes(ctx -> get_players(ctx.getSource()))
        );
    }

    private int get_players(CottonClientCommandSource source) {
        source.sendFeedback(new LiteralText(String.valueOf(source.getPlayerNames().size())));
        for(int i = 0; i < source.getPlayerNames().size(); i++){
            Object[] _player = source.getPlayerNames().toArray();
            System.out.println(_player[i]);
            String _Pname = _player[i].toString();
            source.sendFeedback(new LiteralText(_Pname));
        }
        return Command.SINGLE_SUCCESS;
    }
}
