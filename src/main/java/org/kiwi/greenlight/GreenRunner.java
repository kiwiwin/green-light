package org.kiwi.greenlight;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class GreenRunner {
    public void run(GreenHandler greenHandler) throws InvocationTargetException, IllegalAccessException {
        greenHandler.runTest();
    }

    public void run(List<GreenHandler> greenHandlers) throws InvocationTargetException, IllegalAccessException {
        for (GreenHandler greenHandler : greenHandlers) {
            run(greenHandler);
        }
    }
}
