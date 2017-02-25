package precipitated.will.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.*;

/**
 * Created by hl on 16-1-31.
 */
public class Main {

    private static final String URL = "http://l-trainhcs-qm1.t.cn6.qunar.com:9001/main.jsp";
    private static final int TIME_OUT = 5;

    public static void main(String[] args) throws InterruptedException {

        String inFilePath = "C:\\Users\\will.wang\\Desktop\\other.txt";
        String outFilePath = "result.txt";
        String iFrameID = "iL3NlY3JldC9zaG93Lmh0bQ";

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\will.wang\\Desktop\\chromedriver_win32\\chromedriver.exe");

        ChromeDriverService aDefault = ChromeDriverService.createDefaultService();

        WebDriver webDriver = new ChromeDriver(aDefault);
        webDriver.get(URL);

        webDriver.manage().window().maximize();

        Thread.sleep(20000);

        File inFile = new File(inFilePath);
        File outFile = new File(outFilePath);
        if(!outFile.exists()) {
            try {
                outFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        webDriver.switchTo().frame(iFrameID);
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inFile));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outFile));
            String aLine;
            while((aLine = bufferedReader.readLine()) != null) {
                String[] split = aLine.split(",");
                String orderNo = split[0];
                String username = split[1];
                webDriver.findElement(By.id("content")).sendKeys(orderNo); // 输入订单号
                webDriver.findElement(By.id("secretSubmit")).click();      // 点击执行
                WebElement webElement = webDriver.findElement(By.id("secretResult")); // 得到结果的div
                /** 对结果的div进行分析 */
                String content = webElement.getText();
                int index = content.indexOf("解密结果");
                String password = content.substring(index + 6);
                String result = orderNo + "," + username + "," + password + "\n";
                stringBuilder.append(result);
                bufferedWriter.write(stringBuilder.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

