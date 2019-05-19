package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CalculatorSite {
    private WebDriver oWebDriver;

    public CalculatorSite(WebDriver oWebDriver) {
        this.oWebDriver = oWebDriver;
    }

    public void calculate(String chatId, List<String> list, Map<String, List<String>> calculatorAccess, SendMessage sendMessage) {
        String typeOfCalculator = list.get(0);
        if (typeOfCalculator.equals("Электроэнергия")) {
            oWebDriver.findElement(By.xpath("//*[@id=\"type1\"]")).click();
        }
        if (typeOfCalculator.equals("Газ")) {
            oWebDriver.findElement(By.xpath("//*[@id=\"type2\"]")).click();
        }

        WebElement element1 = oWebDriver.findElement(By.xpath("//*[@id=\"counter_begin\"]"));
        element1.clear();
        element1.sendKeys(list.get(1));
        WebElement element2 = oWebDriver.findElement(By.xpath("//*[@id=\"counter_end\"]"));
        element2.clear();
        element2.sendKeys(list.get(2));
        oWebDriver.findElement(By.xpath("//*[@id=\"calc_btn\"]")).click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        String result = oWebDriver.findElement(By.xpath("//*[@id=\"calc_form\"]/div[8]/h3")).getText();
        sendMessage.setText(result);
        //todo: получить данные
        calculatorAccess.replace(chatId, new ArrayList<>());
    }
}
