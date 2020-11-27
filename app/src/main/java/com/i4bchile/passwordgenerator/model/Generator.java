package com.i4bchile.passwordgenerator.model;

import android.util.Log;

import java.util.Random;

public class Generator {

    private static final String TAG = "Generator";

    public String generatePassword(int stringLength) {

        int leftLimit = 32; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = stringLength;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        Log.d(TAG, "llamado generatePassword() de Generator" + generatedString);

        return generatedString;


    }


}
