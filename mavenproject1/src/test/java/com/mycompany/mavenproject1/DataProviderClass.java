package com.mycompany.mavenproject1;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;
public class DataProviderClass {

    public String logInUserName() {
        String userName = "Admin";
        return userName;
    }

    public String logInPassward() {
        String passward = "admin123";
        return passward;
    }

    public String localPageAdmin() {
        String localPageAdmin = "admin Collings";
        return localPageAdmin;
    }

    public String adminName() {
        String adminName = "MohamedElockly15";
        return adminName;
    }

    public String adminPassward() {
        String adminPassward = "Mohamed123#";
        return adminPassward;
    }

    public String editableAdminName() {
        String editableName = "MohamedMahmoudElockly01";
        return editableName;
    }
       @DataProvider(name = "login")
    public Object[][]dataSet1()
    {
        return new Object[][]
        {
            {"Admin","admin123"}
        };
        
    }
     @DataProvider(name = "adminInf")
    public Object[][]dataSet2()
    {
        return new Object[][]
        {
            {"MohamedElocklyMohamed","Mohamed123#"}
        };
        
    }
     @DataProvider(name="editableName")
    public Object[][] dp(Method method)
    {
        String userName="Mahmoud888Elockly";
        if(method.getName().equalsIgnoreCase("testSearch"))
            return new Object[][]
        {
            {userName,"Mohamed123#"}
        };
        else if(method.getName().equalsIgnoreCase("editUser"))
              return new Object[][]
        {
            {userName,"AlaaElockly"}
        };
        else
            return new Object[][]{{"default"}};
    }
    
    
}
