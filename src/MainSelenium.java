import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MainSelenium {
    public static void main(String[] args) {
        String userPath = System.getProperty("user.dir");

        // CLIENTE
        try{
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
        }catch (Exception e){
            System.out.println("e = " + e);
        }

        // IMOVEL
        try{
            System.setProperty("webdriver.gecko.driver", userPath+ "/firefoxDriver/geckodriver.exe");
            System.out.println("userPath = " + userPath+ "/firefoxDriver/geckodriver.exe");
            WebDriver driverFox = new FirefoxDriver();
            driverFox.get("file:///"+userPath + "/imobiliaria.html");
            driverFox.manage().window().maximize();

            // SELECT tipo do imóvel
            WebElement tipoImovel = driverFox.findElement(By.id("tipoImovel"));
            Select dropdownlist = new Select(tipoImovel);
            if(tipoImovel.isDisplayed()){
                dropdownlist.selectByIndex(1);
                System.out.print("Tipo Casa está selecionado: ");

                if(driverFox.findElement(By.xpath("//option[text()='Casa']")).isSelected()){
                    System.out.println("Isso é verdade");
                }else{
                    System.out.println("Parece que não");
                }

                dropdownlist.selectByVisibleText("Apartamento");
                System.out.print("Tipo Apartamento está selecionado");

                if(driverFox.findElement(By.xpath("//option[text()='Apartamento']")).isSelected()){
                    System.out.println("Isso é verdade");
                }else{
                    System.out.println("Parece que não");
                }
            }

            WebElement ruaImovel = driverFox.findElement(By.id("ruaEndereco"));
            if(ruaImovel.isDisplayed()){
                ruaImovel.sendKeys("Rua Desconhecido");
            }else{
                System.out.println("Rua está visivelmente clara");
            }

            if(ruaImovel.getAttribute("value").equals("Rua Desconhecido")){
                System.out.println("Rua foi definida");
            }else{
                System.out.println("Rua é desconhecida");
            }

            Thread.sleep(1000);
            ruaImovel.clear();
            if(ruaImovel.getAttribute("value").equals("")){
                System.out.println("Rua foi apagada");
            }else{
                System.out.println("Rua persiste desconhecida");
            }

            WebElement numeroEndereco = driverFox.findElement(By.tagName("textarea"));
            if(numeroEndereco.getAttribute("id").equals("descricaoImovel")){
                System.out.println("Existe uma descrição de imóvel como textarea");
            }
            if(numeroEndereco.isEnabled()){
                numeroEndereco.sendKeys("Descrição do imóvel");
            }

        }catch (Exception e){
            System.out.println("e = " + e);
        }
    }
}
