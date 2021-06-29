package com.example;



import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    WebDriver driver;
    
        @Before
        public void iniciar() {
            //System.setProperty("webdriver.chrome.driver", "/ChromeDriver/chromedriver.exe");
            driver = new ChromeDriver();
    
        }
    
        @After
        public void fim() {
           driver.quit();
        }
    
   
        @Test
        public void login() throws InterruptedException{
            //acessar site
            driver.get("https://opensource-demo.orangehrmlive.com/");
            //preencher campo de username
            driver.findElement(By.id("txtUsername")).sendKeys("Admin");
            //preencher campo de senha
            driver.findElement(By.id("txtPassword")).sendKeys("admin123");
            // clicar no botao de login
            driver.findElement(By.id("btnLogin")).click();
            //validar login
            assertEquals("Welcome vroeg",driver.findElement(By.id("welcome")).getText());

        }
        @Test
        public void editarPerfil() throws InterruptedException{
            login();
            //clicar em My Info
            driver.findElement(By.id("menu_pim_viewMyDetails")).click();
            //clicar em Edit
            driver.findElement(By.id("btnSave")).click();
            // alterar First Name
            //limpar campo de First Name
            driver.findElement(By.id("personal_txtEmpFirstName")).clear();
            //preencher campo de First Name
            driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Gabriel");
            //clicar em Save || salvar edicao
            driver.findElement(By.id("btnSave")).click();
            //validar que o nome foi alterado
            assertEquals("Gabriel",driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value"));
        }
        
        @Test
        public void procurarUsuario() throws InterruptedException{
            login();
            //clicar em Admin
            driver.findElement(By.id("menu_admin_viewAdminModule")).click();
            //preencher campo de Username
            driver.findElement(By.id("searchSystemUser_userName")).sendKeys("Admin");
            //pesquisar usuario
            driver.findElement(By.id("searchBtn")).click();
            //validar pesquisa
            assertEquals("Admin",driver.findElement(By.linkText("Admin")).getText());


            

        }
    
    
    }


    

