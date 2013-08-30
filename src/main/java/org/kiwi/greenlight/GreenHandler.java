package org.kiwi.greenlight;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GreenHandler {
    private Object testCase;
    private Method testMethod;

    public GreenHandler(Object testCase, Method testMethod) {
        this.testCase = testCase;
        this.testMethod = testMethod;
    }

    public Object getTestCase() {
        return testCase;
    }

    public Method getTestMethod() {
        return testMethod;
    }

    public void runTest() throws InvocationTargetException, IllegalAccessException {
        testMethod.invoke(testCase);
    }
}
