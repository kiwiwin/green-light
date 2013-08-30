package org.kiwi.greenlight;

public class DummyTest {
    private boolean dummyTestMethodIsCalled = false;

    public boolean isDummyTestMethodIsCalled() {
        return dummyTestMethodIsCalled;
    }

    @Case
    public void testDummyTestMethod() {
        this.dummyTestMethodIsCalled = true;
    }
}
