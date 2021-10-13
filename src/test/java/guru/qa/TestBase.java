package guru.qa;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

  public static String url = "https://www.google.com";
  @BeforeAll
  public void beforeAll() {
    open(url);
  }

  @AfterAll
  public void afterAll (String name) {
    System.out.println(name+" : tests passed");
  }
}
