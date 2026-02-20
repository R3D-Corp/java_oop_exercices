package labs.labo1;

import io.Console;

public class ConversionsTemperature {
	
	
	
	public static void main(String[] args) {
		double tCelsius, tKelvin, tFarhenheit;
		tCelsius = 0;
		tKelvin = 0;
		tFarhenheit = 0;
		
		String from = Console.lireString("Quel est votre type de température ? ");
		double value = Console.lireDouble("Quelle température ? ");
		switch(from) {
			case "celsius":
				tCelsius = value;
				tKelvin = tCelsius + 273.15f;
				tFarhenheit = 9.0 / 5 * tCelsius + 32;
				break;
			case "kelvin":
				tKelvin = value;
				tCelsius = tKelvin - 273.1585f;
				tFarhenheit = (9 / 5) * tCelsius + 32;
				break;
			case "farhenheit": 
				tFarhenheit = value;
				tCelsius = (tFarhenheit - 32) * 5.0 / 9;
				tKelvin = tCelsius + 273.15f;
				break;
		}
		System.out.printf("%s °C \n", tCelsius);
		System.out.printf("%s °K \n", tKelvin);
		System.out.printf("%s °F \n", tFarhenheit);
	}
}