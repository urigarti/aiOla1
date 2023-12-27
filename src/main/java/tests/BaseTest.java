package tests;

import io.cucumber.java.Scenario;
import logger.CucumberLogger;
import logger.LoggerManager;

abstract public class BaseTest {

    BaseTest() {

    }
    protected void updateLoggerManager(Scenario scenario) {
        LoggerManager.createInstanceUpdatedLogger(CucumberLogger.getInstance(scenario));
    }

}
