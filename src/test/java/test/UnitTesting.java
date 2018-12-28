package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.objectLocator.ObjectLocatorDataStorage;
import test.objectLocator.OrRead;
import test.objectLocator.WebObjectSearchType;
import test.utility.PropertyConfig;
import test.utility.ReadExcel;

import java.util.List;
import java.util.Map;

public class UnitTesting {

    @Test
    public void readExcelsheetTest(){
        ReadExcel readExcel = new ReadExcel("G:\\testing\\AMTDirect_NousAutomation\\Framework\\Modules\\Fasb2.xlsx");
        List<Map> records = readExcel.read("TC001_TC050");
        System.out.println(records);
    }
    @Test
    public void orReadTesting(){
        OrRead orRead  = new OrRead("OR_PI.RPRCharge.txtndLinkedForms");
        Map records = orRead.getOrFromSheet();
        System.out.println(records);
    }
    @Test
    public void objectLocatorStorageTesting(){
        ObjectLocatorDataStorage objectLocatorDataStorage = new ObjectLocatorDataStorage();
        try {
            Map record = objectLocatorDataStorage.getObjectLocator("OR_PI.RPRCharge.txtndLinkedForms");
            System.out.println(record);
             record = objectLocatorDataStorage.getObjectLocator("OR_PI.RPRCharge.cbMasterCharge");
            System.out.println(record);
            record = objectLocatorDataStorage.getObjectLocator("OR_PI.SpaceEntryForm.lnkDateMgrIgnore");
            System.out.println(record);
            record = objectLocatorDataStorage.getObjectLocator("OR_PI.SpaceEntryForm.panelDateMgrConfirmation");
            record = objectLocatorDataStorage.getObjectLocator("OR_PI.RPRCharge.txtndLinkedForms");
            System.out.println(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void webObjectTest(){
        ObjectLocatorDataStorage objectLocatorDataStorage = new ObjectLocatorDataStorage();
        try {
            WebDriver driver = null ;
            Map record = objectLocatorDataStorage.getObjectLocator("OR_PI.SpaceEntryForm.pgSpaceEntryForm");
            String objectSearchType = ( (String)record.get(PropertyConfig.OBJECT_SEARCH_KEY)).toUpperCase();
            WebObjectSearchType webObjectSearchType = WebObjectSearchType.valueOf(objectSearchType);
            WebElement webElement =  webObjectSearchType.findElement(driver,(String) record.get(PropertyConfig.OBJECT_LOCATOR));
            System.out.println(webElement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}