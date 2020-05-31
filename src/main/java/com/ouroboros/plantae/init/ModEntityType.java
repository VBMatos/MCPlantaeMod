package com.ouroboros.plantae.init;

import com.ouroboros.plantae.Plantae;
import com.ouroboros.plantae.entities.UnicornEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityType {
	
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<EntityType<?>>(ForgeRegistries.ENTITIES, Plantae.MOD_ID);
	
	public static final RegistryObject<EntityType<UnicornEntity>> UNICORN_ENTITY = 
			ENTITY_TYPES.register("unicorn_entity", () -> 
					EntityType
					.Builder
					.<UnicornEntity>create(UnicornEntity::new, EntityClassification.CREATURE)
					.size(1.5f, 3.0f)
					.build(new ResourceLocation(Plantae.MOD_ID, "unicorn_entity").toString()));
}