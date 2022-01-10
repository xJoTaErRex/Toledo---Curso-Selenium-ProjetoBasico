package br.ce.wcjunior.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.ce.wcjunior.core.Propriedades.TipoExecucao;

public class DriverFactory {

	// static private WebDriver driver;

	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
		@Override
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};

	private DriverFactory() {
	}

	public static WebDriver getDriver() {
		return threadDriver.get();
	}

	public static WebDriver initDriver() {
        WebDriver driver = null;
        if(Propriedades.TIPO_EXECUCAO == TipoExecucao.LOCAL) {
        	switch (Propriedades.browser) {
    		case FIREFOX:
    			driver = new FirefoxDriver();
    			break;
    		case CHROME:
    			driver = new ChromeDriver();
    		}
        }
        if(Propriedades.TIPO_EXECUCAO == TipoExecucao.GRID) {
        	DesiredCapabilities cap = null;
        	switch (Propriedades.browser) {
    		case FIREFOX:
    			cap = DesiredCapabilities.firefox();
    			break;
    		case CHROME:
    			cap = DesiredCapabilities.chrome();
    		}
        	try {
				driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"),cap);
			} catch (MalformedURLException e) {
				System.err.println("Erro ao conectar ao GRID");
				e.printStackTrace();
			}
        }
        if(Propriedades.TIPO_EXECUCAO == TipoExecucao.NUVEM) {
        	DesiredCapabilities cap = null;
        	switch (Propriedades.browser) {
    		case FIREFOX:
    			cap = DesiredCapabilities.firefox();
    			break;
    		case CHROME:
    			cap = DesiredCapabilities.chrome();
    		case IE:
    			cap = DesiredCapabilities.internetExplorer();
    			cap.setCapability("platform", "Windows 10");
    			cap.setCapability("version", "11");
    		}
            
          	try {
				driver = new RemoteWebDriver(new URL("https://oauth-junior.freitas.jr17-098d1:3f1919b8-e2e1-40c3-96fc-0ec95882e0a5@ondemand.us-west-1.saucelabs.com:443/wd/hub"),cap);
			} catch (MalformedURLException e) {
				System.err.println("Erro ao conectar ao GRID");
				e.printStackTrace();
			}
        }
        
		driver.manage().window().maximize();
		return driver;

	}

	public static void killDriver() {
		WebDriver driver = getDriver();
		if (driver != null) {
			driver.quit();
			driver = null;
		}
		if(threadDriver != null) {
			threadDriver.remove();
		}

	}

}
