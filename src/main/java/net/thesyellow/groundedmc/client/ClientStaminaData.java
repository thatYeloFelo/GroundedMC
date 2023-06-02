package net.thesyellow.groundedmc.client;

public class ClientStaminaData {
    private static int playerStamina;

    public static void set(int stamina) {
        ClientStaminaData.playerStamina = stamina;
    }

    public static int getPlayerStamina() {
        return playerStamina;
    }
}