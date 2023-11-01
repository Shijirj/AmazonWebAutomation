package com.shijir.utilities;

public class World {
    private static CartEntryInfo cartEntryInfo;

    public World() {
    }

    public static void saveCartEntryInfo(CartEntryInfo cartEntryInfo) {
        World.cartEntryInfo = cartEntryInfo;
    }

    public static CartEntryInfo getCartEntryInfo() {
        return cartEntryInfo;
    }
}