package net.zeldak7.myfirstmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.zeldak7.myfirstmod.entity.ModEntities;
import net.zeldak7.myfirstmod.entity.client.WizardRenderer;

public class MyFirstModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.WIZARD, WizardRenderer::new);

    }
}
