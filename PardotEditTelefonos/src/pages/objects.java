package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class objects extends BasePage{

	////////////////////// Elementos de Pardot ////////////////////////
	@FindBy(how = How.ID, using = "email_address")
	protected  WebElement mailPardot;

	@FindBy(how = How.ID, using = "password")
	protected WebElement passwordPardot;
	
	@FindBy(how = How.CSS, using = ".btn.btn-primary.btn-block")
	protected WebElement botonLoginPardot;
	
	@FindBy(how = How.ID, using = "admin-tog")
	protected WebElement adminIcon;
	
	@FindBy(how = How.ID, using = "dropmenu-admin")
	protected WebElement subMenuesAdmin;
	
	@FindBy(how = How.ID, using = "connector_row_a0")
	protected WebElement lineaSalesForceEnTabla;
	
	@FindBy(how = How.CSS, using = ".dropdown-menu.pull-right")
	protected WebElement subMenuActions;
	
	@FindBy(how = How.ID, using = "prospectSyncError_row_a0W")
	protected WebElement contactoTablaPardot;
	
	@FindAll({ @FindBy(css = "[id = 'prospectSyncError_table'] tbody tr a img") })
	protected List<WebElement> botonASalesforce;  
		
	@FindBy(how = How.CSS, using ="[class='inline pull-right'] strong" )
	protected WebElement errores; 
	
	@FindBy(how = How.CSS, using = "[id= 'prospectSyncError_row_a0'] td + td +td a")
	protected WebElement nombreContacto;
	
	@FindBy(how = How.CSS, using = "[class='btn btn-default dropdown-toggle']" )
	protected WebElement botonParaSincronizar;
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Sync with CRM')]")
	protected WebElement sincronizarConCRM;
	
	///////////////////////  Elementos SalesForce  ///////////////////////////////////
	
	@FindBy(how = How.ID, using = "username")
	protected  WebElement mailSalesForce;
	
	@FindBy(how = How.ID, using = "password")
	protected  WebElement passwordSalesForce;
	
	@FindBy(how = How.ID, using = "Login")
	protected  WebElement botonLoginSF;
	
	@FindBy(how = How.ID, using = "flexipage_tabset")
	protected  WebElement tablaDatosContactos;
	
	@FindBy(how = How.ID, using = "emc")
	protected  WebElement codeVerify;
	
	@FindBy(how = How.ID, using = "save")
	protected  WebElement botonSaveCodeVerify;
	
	//////////////////////////////// Detalle del contacto //////////////////////////////
	
	@FindAll({ @FindBy (css = "slds-form-element slds-form-element_readonly slds-form-element_edit slds-grow slds-hint-parent override--slds-form-element")})
	protected List <WebElement> campo;
	
	@FindBy(how = How.CSS, using = "[class='slds-button slds-button_icon test-id__inline-edit-trigger slds-button_icon slds-button_icon-small slds-shrink-none inline-edit-trigger slds-button_icon-container']")
	protected WebElement botonEditar;	
		
	@FindAll({ @FindBy(css = "[class='uiInput uiInputPhone uiInput--default uiInput--input']")})
	public List<WebElement> campoEdit;            
	
	@FindBy(how = How.CSS, using = "[class='slds-button slds-button--neutral uiButton--brand uiButton forceActionButton']")
	protected WebElement botonGuardar;
	
	
}
