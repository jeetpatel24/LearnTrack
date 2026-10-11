package com.airtribe.learntrack.util;

import com.airtribe.learntrack.exception.InvalidInputException;

public class InputValidator {

    private InputValidator() {}

    public static int parseInt(String input, String fieldName) throws InvalidInputException {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new InvalidInputException(fieldName + " must be a whole number, but got: '" + input + "'");
        }
    }

    public static String requireNonBlank(String input, String fieldName) throws InvalidInputException {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInputException(fieldName + " cannot be empty");
        }
        return input.trim();
    }

    public static int requirePositive(int value, String fieldName) throws InvalidInputException {
        if (value <= 0) {
            throw new InvalidInputException(fieldName + " must be greater than 0, but got: " + value);
        }
        return value;
    }

    public static String requireValidEmail(String input) throws InvalidInputException {
        String email = requireNonBlank(input, "Email");
        int atIndex = email.indexOf('@');
        int lastDotIndex = email.lastIndexOf('.');

        boolean isValid = atIndex > 0
                && atIndex == email.lastIndexOf('@')
                && lastDotIndex > atIndex + 1
                && lastDotIndex < email.length() - 1
                && !email.contains(" ");

        if (!isValid) {
            throw new InvalidInputException("Email is not valid: '" + email + "'");
        }
        return email;
    }
}
