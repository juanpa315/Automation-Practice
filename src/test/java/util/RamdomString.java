package util;

import java.util.Random;

public class RamdomString {

    public static String generateRandomEmail(int length) {

        final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        StringBuilder stringBuilder = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            stringBuilder.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        String createdEmail = stringBuilder.toString()+"@gmail.com";
        return createdEmail;
    }

}
