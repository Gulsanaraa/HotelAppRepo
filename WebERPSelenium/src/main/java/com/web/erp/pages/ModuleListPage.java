package com.web.erp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.erp.base.TestBase;

public class ModuleListPage extends TestBase{
	

	@FindBy(linkText = "Receivables")
	WebElement linkReceivables;

	@FindBy(linkText = "Purchases")
	WebElement linkPurchases;

	@FindBy(linkText = "Payables")
	WebElement linkPayables;

	@FindBy(linkText = "Inventory")
	WebElement linkInventory;

	@FindBy(linkText = "Manufacturing")
	WebElement linkManufacturing;

	@FindBy(linkText = "General Ledger")
	WebElement linkGeneralLedger;

	@FindBy(linkText = "Petty Cash")
	WebElement linkPettyCash;

	@FindBy(linkText = "Setup")
	WebElement linkSetup;

	@FindBy(linkText = "Asset Manager")
	WebElement linkAssetManager;

	@FindBy(linkText = "Utilities")
	WebElement linkUtilities;

	@FindBy(linkText = "Sales")
	WebElement linkSales;
	
	@FindBy(xpath = "//li[@class='ModuleSelected']")
	WebElement moduleSelected;


	//Initializing the Page Objects:
	public ModuleListPage() {
			PageFactory. initElements(driver, this);
	}

	public ReceivablesPage clickOnReceivablesLink(){
		linkReceivables.click();
		return new ReceivablesPage();
	}
	
	public PurchasesPage clickOnPurchasesLink(){
		linkPurchases.click();
		return new PurchasesPage();
	}
	
	public PayablesPage clickOnPayablesLink(){
		linkPayables.click();
		return new PayablesPage();
	}
	
	public InventoryPage clickOnInventoryLink(){
		linkInventory.click();
		return new InventoryPage();
	}
	
	public ManufacturingPage clickOnManufacturingLink(){
		linkManufacturing.click();
		return new ManufacturingPage();
	}
	
	public GeneralLedgerPage clickOnGeneralLedgerLink(){
		linkGeneralLedger.click();
		return new GeneralLedgerPage();
	}
	
	public PettyCashPage clickOnPettyCashLink(){
		linkPettyCash.click();
		return new PettyCashPage();
	}
	
	public SetupPage clickOnSetupLink(){
		linkSetup.click();
		return new SetupPage();
	}
	
	public AssetManagerPage clickOnAssetManagerLink(){
		linkAssetManager.click();
		return new AssetManagerPage();
	}
	
	public UtilitiesPage clickOnUtilitiesLink(){
		linkUtilities.click();
		return new UtilitiesPage();
	}
	
	public SalesPage clickOnSalesLink(){
		linkSales.click();
		return new SalesPage();
	}
	
	public String moduleSelectedPage(){
		return moduleSelected.getText();
	}
}
