package xyz.jpuf.entitytesting.client.renderer;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import xyz.jpuf.entitytesting.entity.CubeEntity;
import xyz.jpuf.entitytesting.client.model.CubeEntityModel;

public class CubeEntityRenderer extends MobEntityRenderer<CubeEntity, CubeEntityModel> {
    public CubeEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new CubeEntityModel(), 0.5f);
    }

    @Override
    public Identifier getTexture(CubeEntity entity) {
        return new Identifier("jpuf_mod", "textures/entity/cube/cube.png");
    }

}
