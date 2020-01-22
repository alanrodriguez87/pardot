package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class methods extends objects{
	
	
	public static String urlPardot = "http://pi.pardot.com";
	public static String urlSalesForce = "https://www.salesforce.com";
	protected WebDriver driver;	
	public methods(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	static String telefono = "+541123456789";
	static String celular  = "+54111523456789";
	String copyTel = null;
	String copyCel = null;
	
	
	public void ingresarPardot() {
		driver.get(urlPardot);
		
				
	}
	
	public void loginPardot() {
		esperarElemento(driver, mailPardot,10);
		mailPardot.sendKeys("matias.fernandez@xappia.com");
		passwordPardot.sendKeys("P1p4rd0t!");
		botonLoginPardot.click();
	}
	
	public void irAConectors() {
		adminIcon.click();
		esperarElemento(driver, subMenuesAdmin,10);
		List <WebElement> subMenues = subMenuesAdmin.findElements(By.tagName("a"));
			for (WebElement s : subMenues) {
				if(s.getText().contains("Connectors")) {
					s.click();
					break;
				}
			}
		
	}
			
	public void actionSalesForce() {
		esperarElemento(driver , lineaSalesForceEnTabla, 10);
		if(lineaSalesForceEnTabla.findElement(By.className("first")).getText().contains("Salesforce")) {
			lineaSalesForceEnTabla.findElement(By.cssSelector(".actions-menu-wrapper")).click();
		}
	}
	
	public void irASyncErrors() {
		List <WebElement> options = subMenuActions.findElements(By.tagName("li"));
		for(WebElement o : options) {
			if(o.getText().toLowerCase().contains("sync errors")) {
				o.click();
				break;
			}
		}
		sleep(3000);
	}
	
	public int cantidadErrores() {
		//waitForElementVisible(errores, 15);
		String e = errores.getText();
		String errors = e.replace(",", "");
		int error = Integer.parseInt(errors);
		System.out.println(error);
		return error;
	}
	
	public void editarEnSalesforce() {
		esperarElemento(driver , contactoTablaPardot, 10);
			for(WebElement n  : botonASalesforce) {
				n.click();
				break;
			}
		
	}
	
	public void cambioTab(int tab) {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tab));
		sleep(5000);
	}
	

	
	public void loginSalesForce() {
		mailSalesForce.sendKeys("matias.fernandez@xappia.com");
		passwordSalesForce.sendKeys("bN1cola%");
		botonLoginSF.click();
		esperarElemento(driver,botonSaveCodeVerify ,10);
		String codigoVerificacion = JOptionPane.showInputDialog(null,"Ingrese su codigo de verificacion que se le ha enviado a su casilla de mail");
		codeVerify.sendKeys(codigoVerificacion);
		botonSaveCodeVerify.click();
		sleep(5000);		
	}
		
		public void guardarTelefono() {
			copyTel = campoEdit.get(0).findElement(By.tagName("input")).getAttribute("value");
			System.out.println("Copia Tel guardado: " + copyTel);
			campoEdit.get(0).findElement(By.tagName("input")).clear();
			
		}
	
		public void guardarMovil() {
			copyCel = campoEdit.get(1).findElement(By.tagName("input")).getAttribute("value");
			System.out.println("Copia Cel guardado: " + copyCel);
			campoEdit.get(1).findElement(By.tagName("input")).clear();		
		}
		
		
	public void editarTelefonos() {
		//driver.switchTo().frame(driver.findElement((By) botonEditar));
		esperarElemento(driver , botonEditar , 20);
		botonEditar.click();
		guardarTelefono();
		sleep(1000);
		guardarMovil();
		sleep(1000);
		campoEdit.get(0).findElement(By.tagName("input")).sendKeys(telefono);
		campoEdit.get(1).findElement(By.tagName("input")).sendKeys(celular);
		campoEdit.get(2).findElement(By.tagName("input")).sendKeys(copyTel);
		campoEdit.get(3).findElement(By.tagName("input")).sendKeys(copyCel);		
	}
		
	public void guardarCambios() {
		botonGuardar.click();
	}
	
	public void sincroContac() {
		nombreContacto.click();
		esperarElemento(driver,botonParaSincronizar, 10);
		botonParaSincronizar.click();
		esperarElemento(driver,sincronizarConCRM,10);
		sincronizarConCRM.click();
		
	}
	
	public void atrasResfresh() {
		driver.navigate().back();
		driver.navigate().refresh();
		esperarElemento(driver , contactoTablaPardot, 10);
	}
	
}
