package com.ouroboros.plantae.entities;

import com.ouroboros.plantae.init.ModEntityType;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.EatGrassGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class UnicornEntity extends AnimalEntity{

	private EatGrassGoal eatGrassGoal;
	private int timer;
	
	public UnicornEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		UnicornEntity unicorn = new UnicornEntity(ModEntityType.UNICORN_ENTITY.get(), this.world);
		
		unicorn.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(unicorn)), 
				SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		
		return unicorn;
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();
		
		this.eatGrassGoal = new EatGrassGoal(this);
		
		int i = 0;
		
		this.goalSelector.addGoal(i++, new SwimGoal(this));
		this.goalSelector.addGoal(i++, new BreedGoal(this, 1.0d));
		this.goalSelector.addGoal(i++, new TemptGoal(this, 1.1d, Ingredient.fromItems(Items.GOLDEN_APPLE), false));
		this.goalSelector.addGoal(i++, new FollowParentGoal(this, 1.1d));
		this.goalSelector.addGoal(i++, this.eatGrassGoal);
		this.goalSelector.addGoal(i++, new WaterAvoidingRandomWalkingGoal(this, 1.0d));
		this.goalSelector.addGoal(i++, new LookAtGoal(this, PlayerEntity.class, 6.0f));
		this.goalSelector.addGoal(i++, new LookRandomlyGoal(this));
	}
	
	@Override
	protected void updateAITasks() {
		this.timer = this.eatGrassGoal.getEatingGrassTimer();
		
		super.updateAITasks();
	}
	
	@Override
	public void livingTick() {
		if(this.world.isRemote)
			this.timer = Math.max(0, this.timer - 1);
		
		super.livingTick();
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();

		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0d);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2d);
	}

   /**
    * Handler for {@link World#setEntityState}
    */
   @OnlyIn(Dist.CLIENT)
   public void handleStatusUpdate(byte id) {
      if (id == 10) {
         this.timer = 40;
      } else {
         super.handleStatusUpdate(id);
      }

   }

   @OnlyIn(Dist.CLIENT)
   public float getHeadRotationPointY(float p_70894_1_) {
      if (this.timer <= 0) {
         return 0.0F;
      } else if (this.timer >= 4 && this.timer <= 36) {
         return 1.0F;
      } else {
         return this.timer < 4 ? ((float)this.timer - p_70894_1_) / 4.0F : -((float)(this.timer - 40) - p_70894_1_) / 4.0F;
      }
   }

   @OnlyIn(Dist.CLIENT)
   public float getHeadRotationAngleX(float p_70890_1_) {
      if (this.timer > 4 && this.timer <= 36) {
         float f = ((float)(this.timer - 4) - p_70890_1_) / 32.0F;
         return ((float)Math.PI / 5F) + 0.21991149F * MathHelper.sin(f * 28.7F);
      } else {
         return this.timer > 0 ? ((float)Math.PI / 5F) : this.rotationPitch * ((float)Math.PI / 180F);
      }
   }
   
   /**
    * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
    * the animal type)
    */
   @Override
   public boolean isBreedingItem(ItemStack stack) {
      return stack.getItem() == Items.GOLDEN_APPLE;
   }
   
   @Override
   protected SoundEvent getAmbientSound() {
      return SoundEvents.ENTITY_HORSE_AMBIENT;
   }

   @Override
   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.ENTITY_HORSE_HURT;
   }

   @Override
   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_HORSE_DEATH;
   }
   
   @Override
   protected void playStepSound(BlockPos pos, BlockState blockIn) {
      this.playSound(SoundEvents.ENTITY_HORSE_STEP, 0.15F, 1.0F);
   }
}









