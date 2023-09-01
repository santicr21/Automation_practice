package com.project.pom.mercury.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {
    @Test
    public void testSignInUser () {
        signInPage.signInUser();
        Assert.assertEquals(signInPage.successSignIn(), "Login Successfully", "Login failed");
    }
}
