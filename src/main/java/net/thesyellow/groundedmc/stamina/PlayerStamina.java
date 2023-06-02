package net.thesyellow.groundedmc.stamina;

import net.minecraft.nbt.CompoundTag;

public class PlayerStamina {
    private int stamina;
    private final int MIN_STAMINA = 0;
    private final int MAX_STAMINA = 100;

    public int getStamina() {
        return stamina;
    }

    public void addStamina(int add) {
        this.stamina = Math.min(stamina + add, MAX_STAMINA);
    }

    public void subStamina(int sub) {
        this.stamina = Math.max(stamina - sub, MIN_STAMINA);
    }

    public void copyFrom(PlayerStamina source) {
        this.stamina = source.stamina;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("stamina", stamina);
    }

    public void loadNBTData(CompoundTag nbt) {
        stamina = nbt.getInt("stamina");
    }
}