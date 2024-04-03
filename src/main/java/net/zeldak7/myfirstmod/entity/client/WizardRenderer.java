package net.zeldak7.myfirstmod.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.zeldak7.myfirstmod.MyFirstMod;
import net.zeldak7.myfirstmod.entity.custom.WizardEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WizardRenderer extends GeoEntityRenderer<WizardEntity> {
    public WizardRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager,new WizardModel());
    }


    @Override
    public Identifier getTextureLocation(WizardEntity animatable) {
        return new Identifier(MyFirstMod.MOD_ID, "textures/entity/wizard.png");
    }


    @Override
    public void render(WizardEntity entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()){
            poseStack.scale(0.2f,0.2f,0.2f);  //scale baby down
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
