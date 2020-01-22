package main;


import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.methods;

public class execute extends BasePage{

	public methods mtd;	
	

	@BeforeMethod
	public void login() {
//	IniciarBrowser();
//	mtd = new methods(driver);
//	mtd.ingresarPardot();
//	mtd.loginPardot();
		
	
	}
	
	//@AfterMethod
	public void exit() {
		driver.close();
		driver.quit();
	}
	
	
	@Test
	public void main() {
		mtd.irAConectors();
		mtd.actionSalesForce();
		mtd.irASyncErrors();
			for(int i = 0 ; i < mtd.cantidadErrores() ;i++) {
				mtd.editarEnSalesforce();
				mtd.cambioTab(1);
					if(driver.findElement(By.id("Login")).isDisplayed()) {
						mtd.loginSalesForce();
						mtd.editarTelefonos();
						driver.close();
						mtd.cambioTab(0);
						mtd.sincroContac();
						mtd.atrasResfresh();
					}else{
						mtd.editarTelefonos();
						driver.close();
						mtd.cambioTab(0);
						mtd.sincroContac();
						mtd.atrasResfresh();
					}
			}	
	}
	

    
}
