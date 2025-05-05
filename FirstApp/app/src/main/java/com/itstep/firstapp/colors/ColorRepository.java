package com.itstep.firstapp.colors;

public class ColorRepository {

    private static ColorRepository instance;
    public static ColorRepository getInstance() {;
        if (instance == null) {
            instance = new ColorRepository();
        }
        return instance;
    }

    private Color[] colors;

    private ColorRepository() {
        colors = new Color[]{
                new Color("Red", "#FF0000"),
                new Color("Green", "#00FF00"),
                new Color("Blue", "#0000FF"),
                new Color("Yellow", "#FFFF00"),
                new Color("Cyan", "#00FFFF"),
                new Color("Magenta", "#FF00FF"),
                new Color("Black", "#000000"),
                new Color("White", "#FFFFFF"),
                new Color("Orange", "#FFA500"),
                new Color("Purple", "#800080"),
                new Color("Pink", "#FFC0CB"),
                new Color("Brown", "#A52A2A"),
                new Color("Gray", "#808080"),
                new Color("Lime", "#00FF00"),
                new Color("Teal", "#008080"),
                new Color("Navy", "#000080"),
                new Color("Gold", "#FFD700"),
                new Color("Silver", "#C0C0C0")
        };
    }

    public Color[] getColors() {
        return colors;
    }
}
