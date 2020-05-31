package com.ouroboros.plantae.client.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.ouroboros.plantae.entities.UnicornEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

// Made with Blockbench 3.5.0
// Exported for Minecraft version 1.15
public class UnicornEntityModel<T extends UnicornEntity> extends EntityModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer tail;
	private final ModelRenderer legs;
	private final ModelRenderer back;
	private final ModelRenderer left_back;
	private final ModelRenderer left_back_leg;
	private final ModelRenderer right_back;
	private final ModelRenderer rigth_back_leg;
	private final ModelRenderer front;
	private final ModelRenderer left_front;
	private final ModelRenderer right_front;
	private final ModelRenderer head;
	private final ModelRenderer mouth_top;
	private final ModelRenderer mouth_bottom;

	public UnicornEntityModel() {//func_228303_a_
		textureWidth = 104;
		textureHeight = 93;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 8.4F, 0.0F);
		body.setTextureOffset(0, 0).func_228303_a_(-5.0F, -4.4F, -11.0F, 10.0F, 7.0F, 22.0F, 0.0F, false);
		body.setTextureOffset(0, 30).func_228303_a_(-4.0F, 2.6F, -10.0F, 8.0F, 3.0F, 20.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, -3.2F, 12.2F);
		body.addChild(tail);
		setRotationAngle(tail, -0.7854F, 0.0F, 0.0F);
		tail.setTextureOffset(77, 33).func_228303_a_(-1.5F, 0.0506F, -1.6364F, 3.0F, 4.0F, 10.0F, 0.0F, false);

		legs = new ModelRenderer(this);
		legs.setRotationPoint(0.0F, 15.6F, -6.0F);
		body.addChild(legs);
		

		back = new ModelRenderer(this);
		back.setRotationPoint(0.0F, 0.0F, 1.0F);
		legs.addChild(back);
		

		left_back = new ModelRenderer(this);
		left_back.setRotationPoint(4.0F, -13.5F, 12.75F);
		back.addChild(left_back);
		left_back.setTextureOffset(58, 36).func_228303_a_(-2.0F, 11.5F, -2.75F, 4.0F, 2.0F, 5.0F, 0.0F, false);

		left_back_leg = new ModelRenderer(this);
		left_back_leg.setRotationPoint(2.0F, 6.5F, -1.25F);
		left_back.addChild(left_back_leg);
		setRotationAngle(left_back_leg, -0.3491F, 0.0F, 0.0F);
		left_back_leg.setTextureOffset(10, 85).func_228303_a_(-3.0F, 1.0F, 2.0F, 2.0F, 4.0F, 3.0F, 0.0F, false);
		left_back_leg.setTextureOffset(75, 63).func_228303_a_(-4.0F, -3.0F, -5.0F, 4.0F, 4.0F, 10.0F, 0.0F, false);
		left_back_leg.setTextureOffset(22, 77).func_228303_a_(-4.0F, -10.0F, -5.0F, 4.0F, 7.0F, 8.0F, 0.0F, false);

		right_back = new ModelRenderer(this);
		right_back.setRotationPoint(-4.0F, -13.5F, 12.75F);
		back.addChild(right_back);
		right_back.setTextureOffset(58, 36).func_228303_a_(-2.0F, 11.5F, -2.75F, 4.0F, 2.0F, 5.0F, 0.0F, false);

		rigth_back_leg = new ModelRenderer(this);
		rigth_back_leg.setRotationPoint(2.0F, 6.5F, -1.25F);
		right_back.addChild(rigth_back_leg);
		setRotationAngle(rigth_back_leg, -0.3491F, 0.0F, 0.0F);
		rigth_back_leg.setTextureOffset(10, 85).func_228303_a_(-3.0F, 1.0F, 2.0F, 2.0F, 4.0F, 3.0F, 0.0F, false);
		rigth_back_leg.setTextureOffset(45, 56).func_228303_a_(-4.0F, -3.0F, -5.0F, 4.0F, 4.0F, 10.0F, 0.0F, false);
		rigth_back_leg.setTextureOffset(48, 77).func_228303_a_(-4.0F, -10.0F, -5.0F, 4.0F, 7.0F, 8.0F, 0.0F, false);

		front = new ModelRenderer(this);
		front.setRotationPoint(0.0F, 0.0F, 0.0F);
		legs.addChild(front);
		

		left_front = new ModelRenderer(this);
		left_front.setRotationPoint(4.0F, -14.75F, -0.375F);
		front.addChild(left_front);
		left_front.setTextureOffset(58, 36).func_228303_a_(-2.0F, 12.75F, -3.625F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		left_front.setTextureOffset(83, 0).func_228303_a_(-2.0F, -2.25F, -2.625F, 4.0F, 10.0F, 4.0F, 0.0F, false);
		left_front.setTextureOffset(10, 75).func_228303_a_(-1.0F, 7.75F, -1.625F, 2.0F, 5.0F, 3.0F, 0.0F, false);
		left_front.setTextureOffset(67, 24).func_228303_a_(-2.0F, -2.25F, 1.375F, 4.0F, 7.0F, 1.0F, 0.0F, false);

		right_front = new ModelRenderer(this);
		right_front.setRotationPoint(-4.0F, -14.75F, -0.375F);
		front.addChild(right_front);
		right_front.setTextureOffset(58, 36).func_228303_a_(-2.0F, 12.75F, -3.625F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		right_front.setTextureOffset(66, 0).func_228303_a_(-2.0F, -2.25F, -2.625F, 4.0F, 10.0F, 4.0F, 0.0F, false);
		right_front.setTextureOffset(10, 75).func_228303_a_(-1.0F, 7.75F, -1.625F, 2.0F, 5.0F, 3.0F, 0.0F, false);
		right_front.setTextureOffset(67, 15).func_228303_a_(-2.0F, -2.25F, 1.375F, 4.0F, 7.0F, 1.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -2.4962F, -7.2885F);
		body.addChild(head);
		setRotationAngle(head, 0.4363F, 0.0F, 0.0F);
		head.setTextureOffset(80, 15).func_228303_a_(-2.0F, -7.4349F, -4.7294F, 4.0F, 10.0F, 7.0F, 0.0F, false);
		head.setTextureOffset(77, 80).func_228303_a_(-3.0F, -12.4349F, -4.7294F, 6.0F, 5.0F, 7.0F, 0.0F, false);
		head.setTextureOffset(0, 75).func_228303_a_(-1.0F, -12.4349F, 2.2706F, 2.0F, 15.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(24, 59).func_228303_a_(-3.0F, -15.4349F, 1.2706F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(30, 60).func_228303_a_(-2.0F, -14.4349F, 1.2706F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(24, 54).func_228303_a_(2.0F, -15.4349F, 1.2706F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(30, 54).func_228303_a_(1.0F, -14.4349F, 1.2706F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(97, 52).func_228303_a_(-0.25F, -19.5987F, -0.962F, 0.5F, 2.0F, 0.5F, 0.0F, false);
		head.setTextureOffset(97, 54).func_228303_a_(-0.5F, -17.5987F, -1.212F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(97, 57).func_228303_a_(-0.75F, -14.5987F, -1.462F, 1.5F, 3.0F, 1.5F, 0.0F, false);

		mouth_top = new ModelRenderer(this);
		mouth_top.setRotationPoint(0.0F, -11.8412F, -7.3068F);
		head.addChild(mouth_top);
		mouth_top.setTextureOffset(74, 52).func_228303_a_(-2.0F, -0.5937F, -3.4226F, 4.0F, 3.0F, 6.0F, 0.0F, false);

		mouth_bottom = new ModelRenderer(this);
		mouth_bottom.setRotationPoint(0.0F, -9.3412F, -3.3068F);
		head.addChild(mouth_bottom);
		mouth_bottom.setTextureOffset(1, 60).func_228303_a_(-2.0F, -0.0937F, -7.4226F, 4.0F, 2.0F, 7.0F, 0.0F, false);
	}

	@Override
	public void func_225597_a_(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		
	}

	@Override
	public void func_225598_a_(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.func_228309_a_(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	}
}