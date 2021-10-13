package guru.qa.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GoodleStart {

  private static SelenideElement search = $("[name=\"q\"]");

  public void googleEnter(String word) {
    search.setValue(word).pressEnter();
  }
}
