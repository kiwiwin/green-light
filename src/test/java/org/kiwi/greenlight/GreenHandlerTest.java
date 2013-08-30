package org.kiwi.greenlight;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GreenHandlerTest {

    private DummyTest dummyTest;

    @Before
    public void setUp() throws Exception {
        dummyTest = new DummyTest();
    }

    @Test
    public void should_execute_the_test_method() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = dummyTest.getClass().getDeclaredMethod("testDummyTestMethod");
        GreenHandler greenHandler = new GreenHandler(dummyTest, method);

        greenHandler.runTest();

        assertThat(dummyTest.isDummyTestMethodIsCalled(), is(true));
    }

}
