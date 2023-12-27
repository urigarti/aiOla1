package logger;

import io.cucumber.java.Scenario;

public interface Logger {

    void updateScenario(Scenario scenario);
    void log(String message);
    void warning(String message);
    void fail(String message);
}
