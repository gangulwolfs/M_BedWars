package net.mc.gaul.m_bedwars.API.Enum;

public enum Gen {
    IRON("철"),GOLD("금"),DIAMOND("다이아몬드"),EMERALD("에메랄드");

    private final String name;

    Gen(String generator) {
        this.name = generator;
    }

    public String getName() {
        return name;
    }
}
