package com.quinnox.formatting;

import java.text.DecimalFormat;

public class DecimalFormatExample {

	public static void main(String[] args) {
		
		DecimalFormat df = new DecimalFormat("#,###,##0.00");
        System.out.println(df.format(364565.14));
        System.out.println(df.format(364565.1454));
        
      //formatting numbers upto 3 decimal places in Java
        df = new DecimalFormat("#,###,##0.000");
        System.out.println(df.format(364565.14));
        System.out.println(df.format(364565.1454));
        
	}

}
