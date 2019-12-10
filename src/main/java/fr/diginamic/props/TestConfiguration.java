package fr.diginamic.props;
import java.util.ResourceBundle;

public class TestConfiguration {

	public static void main(String[] args) {
		ResourceBundle monFicConf = ResourceBundle.getBundle( "FichConf");
		String valParam1 = monFicConf.getString("clef1");
		System.out.println( "valParam1 : " + valParam1);
		
		String valParam = "";
		for( int i = 1 ; i < 5 ; i++) {
			valParam = monFicConf.getString("clef" + i);
			System.out.println( "valParam" + i + " : " + valParam);
			
		}
		
		for( String key : monFicConf.keySet()) {
			valParam = monFicConf.getString(key);
			System.out.println( key + " : " + valParam);
		}
	}

}
