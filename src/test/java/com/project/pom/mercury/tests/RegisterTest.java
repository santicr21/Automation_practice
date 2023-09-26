package com.project.pom.mercury.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
    @Test
    public void testRegisterUser () {
        registerPage.registerUser();
        Assert.assertEquals(registerPage.registeredMessage(), "Note: Your user name is santicr.", "Register failed");
        signInPage = registerPage.goToSignInPage();
    }
}
