package org.teamvoided.dusk_autumns_worldgen.init.worldgen

import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.world.gen.feature.PlacedFeature
import org.teamvoided.dusk_autumns_worldgen.DuskAutumnsWorldgen

object DuskPlacedFeatures {

    val SWAMP_VILLAGE_ROCK = create("structures/mossy_cobblestone_rock")
    val SWAMP_VILLAGE_OAK = create("structures/swamp_oak")
    val SWAMP_VILLAGE_MANGROVE = create("structures/mangrove")
    val SWAMP_VILLAGE_FLOWERS = create("structures/blue_orchid_patch")
    val COBBLESTONE_ROCK = create("cobblestone_rock")
    val TREES_COLD_FOREST = create("tree/trees_cold_forest")
    val TREES_COLD_PLAINS = create("tree/trees_cold_plains")
    val TREES_WARM_FOREST = create("tree/trees_warm_forest")
    val TREES_WARM_PLAINS = create("tree/trees_warm_plains")
    val TREES_WINDSWEPT_BIRCH = create("tree/trees_windswept_birch")
    val MANGROVE_FROZEN_CHECKED = create("tree/mangrove_frozen_checked")
    val TALL_MANGROVE_FROZEN_CHECKED = create("tree/tall_mangrove_frozen_checked")
    val TREES_MANGROVE_FROZEN = create("tree/trees_mangrove_frozen")
    val TREES_WINDSWEPT_MANGROVE_FROZEN = create("tree/trees_windswept_mangrove_frozen")
    val TREES_WINDSWEPT_MANGROVE = create("tree/trees_windswept_mangrove")
    val TREES_OLD_GROWTH_SWAMP = create("tree/trees_old_growth_swamp")
    val CHERRY_ON_SNOW = create("tree/cherry_on_snow")
    val CHERRY_ON_SNOW_BEES = create("tree/cherry_on_snow_bees")
    val TREES_SNOWY_CHERRY_GROVE = create("tree/trees_snowy_cherry_grove")
    val FLOWER_SNOWY_CHERRY = create("flower_snowy_cherry")
    val MUSHROOM_GROVE_VEGETATION = create("mushroom_grove_vegetation")
    val CAVE_DEAD_BUSH = create("cave/dead_bush")
    val CAVE_GLOW_LICHEN_EXTRA = create("cave/glow_lichen_extra")
    val ORE_COARSE_DIRT = create("cave/ore_coarse_dirt")
    val MUSHROOM_CAVE_VEGETATION = create("cave/mushroom/vegetation")
    val MUSHROOM_CAVE_MUSHROOMS = create("cave/mushroom/mushrooms")
    val MUSHROOM_CAVE_SURFACE = create("cave/mushroom/surface")
    val ICE_CAVE_PILLAR = create("cave/frozen_cavern/ice_cave_pillar")
    val ICE_SPIKE_FLOOR = create("cave/frozen_cavern/ice_spike_floor")
    val ICE_SPIKE_CEILING = create("cave/frozen_cavern/ice_spike_ceiling")
    val ORE_ICE = create("cave/frozen_cavern/ore_ice")
    val ORE_BLUE_ICE = create("cave/frozen_cavern/ore_blue_ice")
    val ICE_CAVE_FOSSIL = create("cave/frozen/frozen_fossil")
    val SAND_CAVE_PILLAR = create("cave/sand/sand_cave_pillar")
    val SAND_CACTUS = create("cave/sand/cactus")
    val ORE_SAND = create("cave/sand/ore_sand")
    val ORE_RED_SAND = create("cave/sand/ore_red_sand")
    val SAND_SPIKES = create("cave/sand/sandstone_spikes")
    val SAND_SPIKES_ROOF = create("cave/sand/sandstone_roof_spikes")
    val RED_SAND_CAVE_PILLAR = create("cave/sand/red_sand_cave_pillar")
    val RED_SAND_SPIKES = create("cave/sand/red_sandstone_spikes")
    val RED_SAND_SPIKES_ROOF = create("cave/sand/red_sandstone_roof_spikes")
    val SAND_CAVE_VINES = create("cave/sand/cave_vines")
    val SAND_CAVE_CORAL = create("cave/sand/cave_coral")
    val SAND_CAVE_SEAGRASS = create("cave/sand/cave_seagrass")
    val SAND_CAVE_PICKLE = create("cave/sand/cave_pickle")

    val DEEP_MONSTER_ROOM = create("monster_room/deep_monster_room")
    val FROZEN_MONSTER_ROOM = create("monster_room/frozen_monster_room")
    val DEEP_FROZEN_MONSTER_ROOM = create("monster_room/deep_frozen_monster_room")
    val LUSH_MONSTER_ROOM = create("monster_room/lush_monster_room")
    val DEEP_LUSH_MONSTER_ROOM = create("monster_room/deep_lush_monster_room")
    val SAND_MONSTER_ROOM = create("monster_room/sand_monster_room")
    val DEEP_SAND_MONSTER_ROOM = create("monster_room/deep_sand_monster_room")
    val RED_SAND_MONSTER_ROOM = create("monster_room/red_sand_monster_room")
    val DEEP_RED_SAND_MONSTER_ROOM = create("monster_room/deep_red_sand_monster_room")

    val DESERT_WELL = create("structure/desert_well")
    val RED_DESERT_WELL = create("structure/red_desert_well")
    val CAVE_DESERT_WELL = create("structure/cave_desert_well")
    val CAVE_RED_DESERT_WELL = create("structure/cave_red_desert_well")

    fun init() {}
    fun create(id: String): RegistryKey<PlacedFeature> = RegistryKey.of(RegistryKeys.PLACED_FEATURE, DuskAutumnsWorldgen.id(id))
}