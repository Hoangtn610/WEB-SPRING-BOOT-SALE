package com.example.hoang.Utils;

public class CommonFuntion {
    public static Long convertToLong(Object o){
        String stringToConvert = String.valueOf(o);
        Long convertedLong = Long.parseLong(stringToConvert);
        return convertedLong;
    }
    public static int convertLongToInt(Long value) {
        if (value != null) {
            return value.intValue();
        } else {
            // Handle the case where the Long value is null, or provide a default value if needed.
            return -1; // You can change this to another default value if necessary.
        }
    }
}
