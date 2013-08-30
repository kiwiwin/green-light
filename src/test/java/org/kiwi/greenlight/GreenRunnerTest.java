package org.kiwi.greenlight;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static com.google.common.collect.ImmutableList.of;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GreenRunnerTest {

    private GreenRunner greenRunner;

    @Before
    public void setUp() throws Exception {
        greenRunner = new GreenRunner();
    }

    @Test
    public void should_run_handler_test() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        GreenHandler mockGreenHandler = mock(GreenHandler.class);

        greenRunner.run(mockGreenHandler);

        verify(mockGreenHandler).runTest();
    }

    @Test
    public void should_run_all_handler_tests() throws InvocationTargetException, IllegalAccessException {
        GreenHandler mockGreenHandler1 = mock(GreenHandler.class);
        GreenHandler mockGreenHandler2 = mock(GreenHandler.class);

        greenRunner.run(of(mockGreenHandler1, mockGreenHandler2));

        verify(mockGreenHandler1).runTest();
        verify(mockGreenHandler2).runTest();
    }
}
