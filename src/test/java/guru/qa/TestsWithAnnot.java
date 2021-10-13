package guru.qa;

import com.codeborne.selenide.Configuration;
import guru.qa.page.GoodleStart;
import guru.qa.page.GoogleResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestsWithAnnot {

  TestBase testBase = new TestBase();
  GoodleStart goodleStart = new GoodleStart();
  GoogleResult googleResult = new GoogleResult();

  @ValueSource( strings = {
          "лыжи",
          "ролики",
          "машины",
          "самокаты"
  })
  @Execution(value = ExecutionMode.SAME_THREAD)
  @ParameterizedTest
  void thingsTest (String searchThings, TestInfo testInfo) {
    Configuration.startMaximized = true;
    testBase.beforeAll();
    goodleStart.googleEnter(searchThings);
    googleResult.googleResults(searchThings);
    testBase.afterAll(searchThings);
    System.out.println("Config for test: "
            + testInfo.getDisplayName()
            + " "
            + Configuration.startMaximized);
  }

  @ResourceLock("SelenideConfig")
  @Test
  void secondTest(TestInfo testInfo) {
    Configuration.startMaximized = false;
    testBase.beforeAll();
    System.out.println("Config for test: "
            + testInfo.getDisplayName()
            + " "
            + Configuration.startMaximized);
  }
}
