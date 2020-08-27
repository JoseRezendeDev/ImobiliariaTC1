import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MainSelenium {
    public static void main(String[] args) {
        String userPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", userPath + "/chromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(userPath + "/imobiliaria.html");
        driver.findElement(By.id("nome")).sendKeys("José Vitor Rezende");
        driver.findElement(By.id("cpf")).sendKeys("111.222.333-44");
        driver.findElement(By.id("dataNascimento")).sendKeys("12/04/1999");
        driver.findElement(By.id("sexoMasculino")).click();
        Select select = new Select(driver.findElement(By.id("salario")));
        select.selectByIndex(4);
        driver.findElement(By.id("emails")).sendKeys("jose@gmail.com; felipe@gmail.com");
        driver.findElement(By.id("telefones")).sendKeys("16 99988-7766; 16 99122-3344");
    }
}
