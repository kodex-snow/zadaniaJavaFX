package kot.kotsnow.konwerter;

public class TemperatureValidator implements Deegrees{

	public static boolean SUCCEED = true;
	public static boolean FAIL = false;

	public static boolean validateKelvin(double kelvinTemp){
		if(kelvinTemp>=0){
			return SUCCEED;
		} else{
			return FAIL;
		}
	}

	public static boolean validateCelsjus(double celsjusTemp){
		if(celsjusTemp>=-273.15){
			return SUCCEED;
		} else{
			return FAIL;
		}
	}
	public static boolean validateFahrenheit(double fahrenheitTemp){
		if(fahrenheitTemp>=-459.67){
			return SUCCEED;
		} else{
			return FAIL;
		}
	}

}
