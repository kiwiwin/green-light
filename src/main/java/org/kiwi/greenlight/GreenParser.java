package org.kiwi.greenlight;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GreenParser {
    public List<GreenHandler> getGreenHandlers(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName(className);
        List<GreenHandler> greenHandlers = new ArrayList<GreenHandler>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Case.class)) {
                greenHandlers.add(new GreenHandler(clazz.newInstance(), method));
            }
        }
        return greenHandlers;
    }


    public GreenHandler getGreenHandler(String className, String testMethodName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName(className);
        return new GreenHandler(clazz.newInstance(), clazz.getDeclaredMethod(testMethodName));
    }
}
