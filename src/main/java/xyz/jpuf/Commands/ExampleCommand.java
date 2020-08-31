package xyz.jpuf.Commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import io.github.cottonmc.clientcommands.*;
import net.minecraft.text.LiteralText;

public class ExampleCommand implements ClientCommandPlugin {
    @Override
    public void registerCommands(CommandDispatcher<CottonClientCommandSource> dispatcher) {
        dispatcher.register(ArgumentBuilders.literal("get-players")
                .executes(ctx -> getplayers(ctx.getSource()))
        );
    }

    private int getplayers(CottonClientCommandSource source) {
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
