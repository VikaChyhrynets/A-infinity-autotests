package utils;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class CommonListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        log.debug("\nTest started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.debug("Test succeed: " + result.getName() + "\n");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.debug("Test failed: " + result.getName() + "\n");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.debug("Test failed with some steps succeeded: " + result.getName() + "\n");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        log.debug("Test failed with timeout: " + result.getName() + "\n");
    }
}