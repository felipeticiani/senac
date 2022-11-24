package util;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CadastrarUsuario {
    private WebDriver driver;
    private Select comboBox;
    private Alert alert;

    public void inicializa() {
        String chromeDriver = System.getProperty("user.dir") + "/Driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriver);

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("file:///" + System.getProperty("user.dir") + "/Driver/componentes.html");
    }

    public void fecharNavegador() {
        driver.quit();
    }

    public String getNomeNavegador() {
        return driver.toString();
    }

    public void preencherCampoNome(String nome) {
        driver.findElement(By.id("elementosForm:nome")).sendKeys(nome);
    }

    public void preencherCampoSobrenome(String sobrenome) {
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys(sobrenome);
    }

    public void preencherCampoSexo(Sexos sexo) {
        driver.findElement(By.id("elementosForm:sexo:" + sexo.getIndex())).click();
    }

    public void preencherCampoComidaFavorita(ComidasFavoritas comida) {
        driver.findElement(By.id("elementosForm:comidaFavorita:" + comida.getIndex())).click();
    }

    public void preencherCampoEscolaridade(Escolaridades escolaridade) {
        WebElement elemento = driver.findElement(By.id("elementosForm:escolaridade"));
        comboBox = new Select(elemento);
        comboBox.selectByIndex(escolaridade.getIndex());
    }

    public void preencherCampoEsporte(Esportes esporte) {
        WebElement elemento = driver.findElement(By.id("elementosForm:esportes"));
        comboBox = new Select(elemento);
        comboBox.selectByIndex(esporte.getIndex());
    }

    public void clicarEmCadastrar() {
        driver.findElement(By.id("elementosForm:cadastrar")).click();
    }

    public void verificarInformacoesCadastradas(String nome,
                                                String sobrenome,
                                                Sexos sexo,
                                                ComidasFavoritas comidaFavorita,
                                                Escolaridades escolaridade,
                                                Esportes esporte) {
        String nomeExibido = driver.findElement(By.cssSelector("#descNome > span")).getText();
        String sobrenomeExibido = driver.findElement(By.cssSelector("#descSobrenome > span")).getText();
        String sexoExibido = driver.findElement(By.cssSelector("#descSexo > span")).getText();
        String comidaExibida = driver.findElement(By.cssSelector("#descComida > span")).getText();
        String escolaridadeExibida = driver.findElement(By.cssSelector("#descEscolaridade > span")).getText();
        String esporteExibido = driver.findElement(By.cssSelector("#descEsportes > span")).getText();

        Assert.assertEquals(nome, nomeExibido);
        Assert.assertEquals(sobrenome, sobrenomeExibido);
        Assert.assertEquals(sexo.getDescricao(), sexoExibido);
        Assert.assertEquals(comidaFavorita.getDescricao(), comidaExibida);
        Assert.assertEquals(escolaridade.getDescricao(), escolaridadeExibida);
        Assert.assertEquals(esporte.getDescricao(), esporteExibido);
    }

    public void verificarAlertaCampoObrigatorio(String campo) {
        Alert alertaExibido = driver.switchTo().alert();
        Assert.assertEquals(campo + " eh obrigatorio", alertaExibido.getText());
    }
}
