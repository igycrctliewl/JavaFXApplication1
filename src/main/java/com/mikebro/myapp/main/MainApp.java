package com.mikebro.myapp.main;

import com.mikebro.myapp.service.AppService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 *
 * @author mikebro
 */
public class MainApp {

	public static void main( String[] args ) {
		System.out.println( "myapp.MainApp.main()" );
		AbstractApplicationContext context = new AnnotationConfigApplicationContext( "com.mikebro.myapp.*" );

		AppService service = null;
		try {
			service = (AppService) context.getBean( AppService.class );
		} catch ( Exception e ) {
			System.out.println( e.getMessage() );
		}

		System.out.println( "myapp started" );
		if( service == null ) {
			System.out.println( "No service found in context." );
		} else {
			System.out.println( service.serviceMethodA() );
			System.out.println( service.serviceMethodB() );
			System.out.println( service.serviceMethodC() );
		}
		context.close();
	}
}
