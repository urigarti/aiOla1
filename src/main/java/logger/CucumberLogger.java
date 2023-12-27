package logger;

import io.cucumber.java.Scenario;

public class CucumberLogger implements Logger {

    Scenario scenario;

    CucumberLogger(Scenario scenario) {
        this.scenario = scenario;
    }

    public static CucumberLogger getInstance(Scenario scenario) {
        return new CucumberLogger(scenario);
    }

    @Override
    public void updateScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Override
    public void log(String message) {
        this.scenario.log(message);
    }

    @Override
    public void warning(String message) {
        this.scenario.log("TBD - Not Implemented");
    }

    @Override
    public void fail(String message) {
        this.scenario.log("TBD - Not Implemented");
    }
}
