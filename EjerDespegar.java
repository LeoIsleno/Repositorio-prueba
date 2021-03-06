import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;  import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import EjerDespegarMaven.EjerDespegarMaven.Drivers;

public class EjerDespegar {

@Test(description = "Validar que las busquedas en Despegar funcionan")
public void ValidarDespegar() throws Exception {
	String url = "https://www.despegar.com.ar";
	String Browser = "CHROME";
	
	WebDriver driver = Drivers.LevantarBrowser(Browser,url);
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		//Define un nuevo webElement llamado "DespegarAlojamiento" por css y con su respectiva validacion  
		WebElement DespegarAlojamiento = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".header-products-container [href='//www.despegar.com.ar/hoteles/']"))));
		Assert.assertTrue(DespegarAlojamiento.isDisplayed(),"Error, no accede a la pagina");
		DespegarAlojamiento.click();
		
		//Define un nuevo webElement llamado "Origen" por xpath y con su respectiva validacion
		WebElement origen =  wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='sbox-places-destination--1xd0k']//div[@class='input-container']//input[@class='input-tag']"))));
		//WebElement origen = origenes.get(0);
		Assert.assertTrue(origen.isDisplayed(),"Error, no accede al apartado Origen");
		
		//Envia el texto "Cordoba" para ingresar
		origen.sendKeys("San Carlos de Bariloche");
		Thread.sleep(1000);
		//Oprime el boton Control para que salgan las diversas opciones
	    origen.sendKeys(Keys.CONTROL);
	    Thread.sleep(1000);
	    //Oprime el boton Enter para ingresar solo a la primera opcion 
	    origen.sendKeys(Keys.ENTER);
	    //Define el elemento "entrada" y luego ingresa en el mismo
	    //
	    WebElement entrada = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//input[@placeholder='Entrada']"))));
	    Assert.assertTrue(entrada.isDisplayed(),"Error, no accede a la fecha de entrada");
	    entrada.click();
	    
		//Eliminamos el anuncio de las cookies
	  	WebElement anuncio =  wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("a.lgpd-banner--button.eva-3-btn.-white.-md .btn-text"))));
	    Assert.assertTrue(anuncio.isDisplayed(),"Error, no elimina el anuncio");
	    Thread.sleep(1000);
	    
	    //Definimos la fecha de hoy
	    WebElement hoy = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened .sbox5-monthgrid.sbox5-compact-view .sbox5-monthgrid-datenumber.-today"))));
	    Assert.assertTrue(hoy.isDisplayed(),"Error, no selecciona la fecha de hoy");
	    hoy.click();
	    
	    //Definimos la fecha de Salida
	    WebElement fechasalida = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened .sbox5-monthgrid.sbox5-compact-view .sbox5-monthgrid-dates.sbox5-monthgrid-dates-31 .sbox5-monthgrid-datenumber"))));
	    Assert.assertTrue(fechasalida.isDisplayed(),"Error, no accede a la fecha de salida");
	    fechasalida.click();
	    
	    //Definimos el boton aplicar y lo oprimimos
	    WebElement botonAplicar = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//button[@class='sbox5-3-btn -primary -md']//em[@class='btn-text']"))));
	    Assert.assertTrue(botonAplicar.isDisplayed(),"Error, no accede a la boton Aplicar");
	    botonAplicar.click();
	    
	    //Definimos y seleccionamos el apartado habitacion
	    WebElement habitaciones = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("div.sbox5-3-distribution-passengers.sbox5-3-validation.-top-right .sbox5-3-second-input-wrapper"))));
	    Assert.assertTrue(habitaciones.isDisplayed(),"Error, no accede al apartado de habitaciones");
	    habitaciones.click();

	    //Cantidad adultos + 1
	    WebElement cantAdultos = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("button.steppers-icon-right.stepper__icon"))));
	    Assert.assertTrue(cantAdultos.isDisplayed(),"Error, no aumenta la cantidad de adultos");
	    cantAdultos.click();
	    Thread.sleep(1000);
	    
	    //Cantidad Ni??os + 1 creando una lista y seleccionado la segunda opcion
	    List<WebElement> cantNi??os = driver.findElements(By.xpath("//div[@class='stepper__room']//button[@class='steppers-icon-right stepper__icon']"));
	    WebElement ni??os = cantNi??os.get(1);
	    Assert.assertTrue(ni??os.isDisplayed(),"Error, no aumenta la cantidad de Ni??os");
	    ni??os.click();
	    Thread.sleep(1000);
	    
	    //Definimos la edad del ni??o que se va a utilizar
	    WebElement edad = driver.findElement(By.xpath("//select[@class='select']"));
	    Assert.assertTrue(edad.isDisplayed(),"Error, no define la edad del ni??o");
	    edad.click();
	    Thread.sleep(1000);
	    WebElement edadNi??o = driver.findElement(By.xpath("//select[@class='select']//option[@class='select-option'][5]"));
	    Assert.assertTrue(edadNi??o.isDisplayed(),"Error, no define la edad del ni??o");
	    edadNi??o.click();
	    Thread.sleep(1000);
	  
	    //Segundo boton aplicar 
	    List<WebElement> botonaplicar2 = driver.findElements(By.xpath("//a[@class='sbox5-3-btn -md -primary']"));
	    WebElement aplicar2 = botonaplicar2.get(1);
	    Assert.assertTrue(aplicar2.isDisplayed(),"Error, no accede al 2do boton Aplicar");
	    aplicar2.click();
	    Thread.sleep(1000);
	    
	    //Boton Buscar
	    WebElement botonBuscar = driver.findElement(By.xpath("//button[@class='sbox5-box-button-ovr sbox5-3-btn -secondary -icon -lg']"));
	    Assert.assertTrue(botonBuscar.isDisplayed(),"Error, no accede a el boton BUSCAR");
	    botonBuscar.click();
	    Thread.sleep(1000);
	    
	    //Seleccionamos la primera opcion de alojamiento
	    WebElement opcion1 = driver.findElement(By.xpath("//button[@class='eva-3-btn -md -primary -eva-3-fwidth']"));
	    Assert.assertTrue(opcion1.isDisplayed(),"Error, no accede a la primera opcion de alojamiento");
	    opcion1.click();
	    Thread.sleep(1000);
	    
	    //Cierra la pagina
		driver.close();
}
}