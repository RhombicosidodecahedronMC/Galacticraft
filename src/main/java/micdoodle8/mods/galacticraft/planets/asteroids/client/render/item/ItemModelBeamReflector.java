package micdoodle8.mods.galacticraft.planets.asteroids.client.render.item;

import micdoodle8.mods.galacticraft.core.wrappers.ModelTransformWrapper;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraftforge.common.model.TRSRTransformation;

import javax.vecmath.Matrix4f;
import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;

public class ItemModelBeamReflector extends ModelTransformWrapper
{
    public ItemModelBeamReflector(IBakedModel modelToWrap)
    {
        super(modelToWrap);
    }

    @Override
    protected Matrix4f getTransformForPerspective(TransformType cameraTransformType)
    {
        if (cameraTransformType == TransformType.GUI)
        {
            Matrix4f ret = new Matrix4f();
            ret.setIdentity();
            Matrix4f mul = new Matrix4f();
            mul.setIdentity();
            mul.setTranslation(new Vector3f(-0.42F, -0.05F, 0.24F));
            ret.mul(mul);
            mul.setIdentity();
            mul.setScale(0.6F);
            ret.mul(mul);
            return ret;
        }

        if (cameraTransformType == TransformType.FIRST_PERSON_RIGHT_HAND)
        {
            Matrix4f ret = new Matrix4f();
            ret.setIdentity();
            Matrix4f mul = new Matrix4f();
            mul.setIdentity();
            Quat4f rot = TRSRTransformation.quatFromXYZDegrees(new Vector3f(0, 180, 0));
            mul.setRotation(rot);
            ret.mul(mul);
            mul.setIdentity();
            mul.rotY((float) (Math.PI));
            ret.mul(mul);
            mul.setIdentity();
            mul.setTranslation(new Vector3f(0.0F, 0.1F, -0.6F));
            ret.mul(mul);
            return ret;
        }

        if (cameraTransformType == TransformType.THIRD_PERSON_RIGHT_HAND)
        {
            Matrix4f ret = new Matrix4f();
            ret.setIdentity();
            Matrix4f mul = new Matrix4f();
            mul.setIdentity();
            mul.setScale(0.5F);
            ret.mul(mul);
            mul.setIdentity();
            mul.rotX((float) (-Math.PI / 2.0F));
            ret.mul(mul);
            mul.setIdentity();
            mul.setTranslation(new Vector3f(0.3F, 0.4F, 0.3F));
            ret.mul(mul);
            return ret;
        }

        return null;
    }
}