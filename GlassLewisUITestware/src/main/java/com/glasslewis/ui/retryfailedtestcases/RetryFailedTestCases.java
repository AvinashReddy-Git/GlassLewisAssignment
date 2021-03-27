package com.glasslewis.ui.retryfailedtestcases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer {
    private static final Logger logger = LoggerFactory.getLogger(RetryFailedTestCases.class);
    private static final long RETRY_LIMIT = 2;
    private int counter = 1;

    @Override
    public boolean retry(ITestResult result) {

        if (counter <= RETRY_LIMIT) {
            logger.debug("Retrying '{} : {}'  {} time  ", result.getTestContext().getName(), result.getMethod().getDescription(), counter);
            counter++;
            return true;
        }
        counter = 1;
        return false;
    }

}
