package org.teamvoided.dusk_autumns_worldgen.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.registry.Holder;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.chunk.BlockColumn;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.teamvoided.dusk_autumns_worldgen.data.DuskBiomeTags;

//@Debug(export = true)
@Mixin(SurfaceBuilder.class)
public abstract class SurfaceBuilderMixin {
    @Final
    @Shadow
    private DoublePerlinNoiseSampler badlandsSurfaceNoise;
    @Final
    @Shadow
    private DoublePerlinNoiseSampler badlandsPillarNoise;
    @Final
    @Shadow
    private DoublePerlinNoiseSampler badlandsPillarRootNoise;
    @Final
    @Shadow
    private BlockState defaultBlock;
    @Final
    @Shadow
    private int seaLevel;


    @Redirect(method = "buildSurface", at = @At(value = "INVOKE", target = "Lnet/minecraft/registry/Holder;isRegistryKey(Lnet/minecraft/registry/RegistryKey;)Z"))
    private boolean unHardCodedErodedBadlands(Holder<Biome> instance, RegistryKey<Biome> tRegistryKey) {
        if (tRegistryKey == Biomes.ERODED_BADLANDS) return instance.isIn(DuskBiomeTags.HAS_ERODED_PILLAR);
        else return instance.isRegistryKey(tRegistryKey);
    }

    @Inject(method = "buildErodedBadlandsSpecificSurface", at = @At("HEAD"), cancellable = true)
    private void replaceVanilla(BlockColumn chunkBlockColumn, int x, int z, int surfaceY, HeightLimitView chunk, CallbackInfo ci) {
        int y = ((Chunk) chunk).sampleHeightmap(Heightmap.Type.OCEAN_FLOOR_WG, x % 16, z % 16) + 1;
        double sn = this.badlandsSurfaceNoise.sample(x, 0.0, z);
        double pn = this.badlandsPillarNoise.sample(x * 0.2, 0.0, z * 0.2);
        double e = Math.min(Math.abs(sn * 8.25), pn * 15.0);
        if (!(e <= 0.0)) {
            double h = Math.abs(this.badlandsPillarRootNoise.sample((double) x * 0.75, 0.0, (double) z * 0.75) * 1.5);
            int j = MathHelper
                    .floor(64.0 + Math.min(e * e * 2.5, Math.ceil(h * 50.0) + 24.0)) - Math.max(seaLevel - y, 0);
            if (y <= j) {
                for (int k = j; k >= chunk.getBottomY() && chunkBlockColumn.getState(k).isIn(BlockTags.REPLACEABLE); --k) {
                    chunkBlockColumn.setState(k, this.defaultBlock);
                }
            }
        }
        ci.cancel();
    }
}