package org.kiwi.greenlight;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

public class GreenParserTest {
    private GreenParser greenParser;

    @Before
    public void setUp() throws Exception {
        greenParser = new GreenParser();
    }

    @Test
    public void should_get_all_test_handlers() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        List<GreenHandler> greenHandlers = greenParser.getGreenHandlers("org.kiwi.greenlight.DummyTest");
        assertThat(greenHandlers.size(), is(1));
        assertThat(greenHandlers.get(0).getTestCase(), is(instanceOf(DummyTest.class)));
        assertThat(greenHandlers.get(0).getTestMethod().getName(), is("testDummyTestMethod"));
    }

    @Test
    public void should_get_test_handler() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        GreenHandler greenHandler = greenParser.getGreenHandler("org.kiwi.greenlight.DummyTest", "testDummyTestMethod");
        assertThat(greenHandler.getTestCase(), is(instanceOf(DummyTest.class)));
        assertThat(greenHandler.getTestMethod().getName(), is("testDummyTestMethod"));
    }
}
