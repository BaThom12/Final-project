package com.vmo.nopcommerce.helper;

import com.vmo.nopcommerce.common.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

public class TestNGListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        System.out.println("--onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        System.out.println("--onTestSuccess");
        Object testClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();
        saveScreenShot(webDriver);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        System.out.println("--onTestFailure");
        Object testClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();
        saveScreenShot(webDriver);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        System.out.println("--onTestSkipped");
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        System.out.println("--onStart");
    }

    //@Override
//    public void onFinish(ITestContext context) {
//        ITestListener.super.onFinish(context);
//        System.out.println("--onFinish");
//    }

    @Attachment()
    public static byte[] saveScreenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


//    @Override
//    public void onFinish(ITestResult result) {
//        Log.info("---------- " + result.getName() + " FAILED test ----------");
//        Object testClass = result.getInstance();
//        WebDriver webDriver = ((BaseTest) testClass).getDriver();
//        saveScreenShot(webDriver);
//    }
}
