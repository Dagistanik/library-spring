package com.library.project.random;

import java.util.Random;

public class MonthRandom {
    public static MothsOfYear randomMonth() {
        int pick = new Random().nextInt(MothsOfYear.values().length);
        return MothsOfYear.values()[pick];
    }
}
