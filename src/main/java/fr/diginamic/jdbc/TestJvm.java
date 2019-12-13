package fr.diginamic.jdbc;

import java.util.ArrayList;
import java.util.List;

public class TestJvm {

	public static void main(String[] args) {
		List<String> lst = new ArrayList<String>();
		int count = 0;
		do {
			lst.add( "0123456789");
			count++;
			if(  Math.floorMod(count, 10000) == 0) {
				System.out.println( lst.size());
			}
		}while( true);
			

	}

}
