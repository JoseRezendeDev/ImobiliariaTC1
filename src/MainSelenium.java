import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MainSelenium {
    public static void main(String[] args) throws InterruptedException {
        String userPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", userPath + "/chromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(userPath + "/imobiliaria.html");

        Thread.sleep(1000);

        driver.findElement(By.linkText("1. Página de clientes")).click();
        driver.findElement(By.id("nome")).sendKeys("José Vitor Rezende");
        driver.findElement(By.id("cpf")).sendKeys("111.222.333-44");
        driver.findElement(By.id("dataNascimento")).sendKeys("12/04/1999");
        driver.findElement(By.id("sexoMasculino")).click();
        Select select = new Select(driver.findElement(By.id("salario")));
        select.selectByIndex(4);
        driver.findElement(By.id("emails")).sendKeys("jose@gmail.com; felipe@gmail.com");
        driver.findElement(By.id("telefones")).sendKeys("16 99988-7766; 16 99122-3344");

        Thread.sleep(3000);

        driver.navigate().back();

        Thread.sleep(1000);

        driver.findElement(By.linkText("2. Página de imóveis")).click();
        WebElement tipoImovel = driver.findElement(By.id("tipoImovel"));
        Select dropdownlist = new Select(tipoImovel);
        if (tipoImovel.isDisplayed()) {
            dropdownlist.selectByIndex(1);
            System.out.print("Tipo Casa está selecionado: ");

            if (driver.findElement(By.xpath("//option[text()='Casa']")).isSelected()) {
                System.out.println("Isso é verdade");
            } else {
                System.out.println("Parece que não");
            }

            dropdownlist.selectByVisibleText("Apartamento");
            System.out.print("Tipo Apartamento está selecionado");

            if (driver.findElement(By.xpath("//option[text()='Apartamento']")).isSelected()) {
                System.out.println("Isso é verdade");
            } else {
                System.out.println("Parece que não");
            }
        }

        WebElement ruaImovel = driver.findElement(By.id("ruaEndereco"));
        if (ruaImovel.isDisplayed()) {
            ruaImovel.sendKeys("Rua Desconhecido");
        } else {
            System.out.println("Rua está visivelmente clara");
        }

        if (ruaImovel.getAttribute("value").equals("Rua Desconhecido")) {
            System.out.println("Rua foi definida");
        } else {
            System.out.println("Rua é desconhecida");
        }

        Thread.sleep(1000);
        if (ruaImovel.getAttribute("value").equals("")) {
            System.out.println("Rua foi apagada");
        } else {
            System.out.println("Rua persiste desconhecida");
        }

        WebElement numeroEndereco = driver.findElement(By.tagName("textarea"));
        if (numeroEndereco.getAttribute("id").equals("descricaoImovel")) {
            System.out.println("Existe uma descrição de imóvel como textarea");
        }
        if (numeroEndereco.isEnabled()) {
            numeroEndereco.sendKeys("Descrição do imóvel");
        }

        ruaImovel.clear();
        ruaImovel.sendKeys("Rua Idamazia Ferreira Nascimento");
        driver.findElement(By.id("numeroEndereco")).sendKeys("32");
        driver.findElement(By.id("bairroEndereco")).sendKeys("Vicent Quaranta");
        driver.findElement(By.id("CEPEndereco")).sendKeys("14150-110");
        driver.findElement(By.id("cidadeEndereco")).sendKeys("Sertão");
        driver.findElement(By.id("estadoEndereco")).sendKeys("SP");
        driver.findElement(By.id("paisEndereco")).sendKeys("Brasil");
        driver.findElement(By.id("aluguelEndereco")).sendKeys("Brasil");

        Thread.sleep(3000);

        driver.navigate().back();

        Thread.sleep(1000);

        driver.findElement(By.linkText("Sair")).click();
    }
}
