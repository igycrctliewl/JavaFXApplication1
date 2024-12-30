package com.mikebro.myappp.main;


import com.mikebro.myappp.javafx.JavaFXApplication1;
import com.mikebro.myappp.service.AppService;
import com.mikebro.nhl.json.Schedule;
import com.mikebro.nhl.service.NHLService;

import javafx.application.Application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 *
 * @author mikebro
 */
public class MainApp {

	public static NHLService nhlService;


	public static void main( String[] args ) {
		System.out.println( ">>>> MainApp.main()" );
		AbstractApplicationContext context = new AnnotationConfigApplicationContext( "com.mikebro.nhl.service.*" );

		nhlService = null;
		try {
			nhlService = (NHLService) context.getBean( NHLService.class );
		} catch ( Exception e ) {
			System.out.println( e.getMessage() );
		}

		Application.launch(JavaFXApplication1.class, args);

//		context.close();
	}
}
