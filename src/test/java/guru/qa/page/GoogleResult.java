package guru.qa.page;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class GoogleResult {

  private static SelenideElement answ = $("[class=\"v7W49e\"]");

  public void googleResults(String name) {
    answ.shouldHave(text(name));
  }
}
