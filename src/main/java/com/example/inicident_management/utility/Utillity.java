package com.example.inicident_management.utility;

import java.time.Year;
import java.util.Random;

public class Utillity {
    public static String generateIncidentNumber(){
        Random r = new Random( System.currentTimeMillis());
        int fiveDigitRandom = 10000 + r.nextInt(20000);
        return "RMG"+fiveDigitRandom + Year.now().getValue();

    }
}
