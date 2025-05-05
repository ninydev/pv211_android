package com.itstep.firstapp.colors;

public class MyColorUtils {
    private MyColorUtils() {}
    public static int getContrastingColor(String backgroundColorHex) {
        // Parse the background color
        int backgroundColor = android.graphics.Color.parseColor(backgroundColorHex);

        // Extract RGB components
        int red = android.graphics.Color.red(backgroundColor);
        int green = android.graphics.Color.green(backgroundColor);
        int blue = android.graphics.Color.blue(backgroundColor);

        // Calculate luminance using the formula
        double luminance = (0.299 * red + 0.587 * green + 0.114 * blue) / 255;

        // Return black or white based on luminance
        return luminance > 0.5 ? android.graphics.Color.BLACK : android.graphics.Color.WHITE;
    }
}
