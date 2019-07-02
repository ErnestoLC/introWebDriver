package classExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuscarPelicula {

	public static void main(String[] args) {
		//Arrancar el navegador
		WebDriver driver;
		driver = new ChromeDriver();
		
		
		//Ir a la url imdb.com
		driver.get("https:/www.imdb.com");
		//Buscar la película
		//busco el elemento de la caja de busqueda  id="navbar-query", name= "q"
		WebElement searchBox = driver.findElement(By.id("navbar-query"));
		//busco el elemento del boton de busqueda id="navbar-query"
		WebElement searchButton = driver.findElement(By.id("navbar-submit-button"));
		//ingreso el texto
		searchBox.sendKeys("E.T.");
		//doy click al boton de busqueda.
		searchButton.click();
		//Verificar que hay peliculas en la lista.  y que por lo menos una tiene el texto 'E.T.'000000
		WebElement linkPelicula = driver.findElement(By.partialLinkText("E.T."));
		
		if(linkPelicula != null && linkPelicula.isDisplayed()) {
			System.out.println("El link de la pelicula es visible");
		} else {
			//exit the test
			System.out.println("El link de la pelicula NO es visible");
			driver.quit();
			System.exit(-1);
		}
		//Dar clic a la primer pelicula linkText = "E.T. the Extra-Terrestrial"
		//encontramos el elemento 
		
		// le damos click
		linkPelicula.click();
		//verificar que el titulo de la pelicula contiene el nombre 'E.T.'
		//busco el elemento cuyo xpath es //h1[contains(text(), 'E.T.')]
		WebElement tituloPelicula = driver.findElement(By.xpath("//h1[contains(text(), 'E.T.')]"));
		String textTitulo = tituloPelicula.getText();
		if(textTitulo.contains("E.T.")) {
			System.out.println("El titulo de la pelicula es correcto");
		} else {
			System.out.println("El titulo de la pelicula NO es correcto");
		}
		
		driver.quit();
	

	}

}
