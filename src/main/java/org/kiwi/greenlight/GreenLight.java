package org.kiwi.greenlight;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class GreenLight {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        GreenParser greenParser = new GreenParser();
        List<GreenHandler> greenHandlers = greenParser.getGreenHandlers(args[0]);
        GreenRunner greenRunner = new GreenRunner();
        greenRunner.run(greenHandlers);
    }
}
