package com.ouroboros.plantae.client.entity.render;

import com.ouroboros.plantae.Plantae;
import com.ouroboros.plantae.client.entity.model.UnicornEntityModel;
import com.ouroboros.plantae.entities.UnicornEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class UnicornEntityRender extends MobRenderer<UnicornEntity, UnicornEntityModel<UnicornEntity>>{
	
	protected static final ResourceLocation TEXTURE = new ResourceLocation(Plantae.MOD_ID, "textures/entity/unicorn_texture.png");

	public UnicornEntityRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new UnicornEntityModel<UnicornEntity>(), 0.5f);
	}
	
	@Override
	public ResourceLocation getEntityTexture(UnicornEntity entity) {		
		return TEXTURE;
	}
}
