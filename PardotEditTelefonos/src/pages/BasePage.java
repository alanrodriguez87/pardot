package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	import Utilities.SetConnection;

	public class BasePage {
		
		
		protected  WebDriver driver;
		protected WebDriverWait wait;

		public void IniciarBrowser() 
		{
			this.driver = SetConnection.setup();
			wait = new WebDriverWait(driver, 10);
		}
		

		public static void sleep (long milisec) {
			try {
				
				Thread.sleep(milisec);			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public void waitForElementVisible(WebElement wE, int segundos) {
			WebDriverWait wait = new WebDriverWait(driver, segundos);		
			wait.until(ExpectedConditions.numberOfElementsToBe((By) wE, 1));		
		}
		
		public WebElement esperarElemento(WebDriver driver, WebElement wE, double timeAcumulated) {
			if (15 > timeAcumulated) {
				try {
					if (wE != null) return wE;
				} catch (Exception e) {
					sleep(2850);
					return esperarElemento(driver, wE, timeAcumulated + 0.250);
				}
			}
			System.out.println("ELEMENTO NO ENCONTRADO! METODO: esperarElemento." + wE );
			return null;
		}	
		

}
