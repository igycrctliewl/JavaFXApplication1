package com.mikebro.myappp.javafx;

import java.util.Date;

import javax.swing.Timer;

import org.springframework.beans.factory.annotation.Autowired;

import com.mikebro.myappp.main.MainApp;
import com.mikebro.nhl.json.Schedule;
import com.mikebro.nhl.service.NHLService;
import com.mikebro.nhl.service.impl.NHLServiceImpl;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author mikebro
 */
public class JavaFXApplication1 extends Application {

	private NHLService nhlService;
	private CustomControl cc;
	private Stage mainStage;

	@Override
	public void start( Stage primaryStage ) {
		mainStage = primaryStage;
		nhlService = MainApp.nhlService;

		Label lblPrevious = new Label();
		lblPrevious.setText( "<-- Prev" );
		lblPrevious.setFont( new Font( "Verdana", 14.0 ) );
		lblPrevious.setLayoutX( 10 );
		lblPrevious.setLayoutY( 20 );
		lblPrevious.setOnMouseClicked( ev -> actionPreviousClicked() );

		Label lblNext = new Label();
		lblNext.setText( "Next -->" );
		lblNext.setFont( new Font( "Verdana", 14.0 ) );
		lblNext.setLayoutX( 150 );
		lblNext.setLayoutY( 20 );
		lblNext.setOnMouseClicked( ev -> actionNextClicked() );


		Button btn = new Button();
		btn.setText( "Say 'Hello World'" );
		btn.setLayoutX( 10 );
		btn.setLayoutY( 100 );
		btn.setOnAction( new EventHandler<ActionEvent>() {
			@Override
			public void handle( ActionEvent event ) {
				System.out.println( "Hello World!" );
			}
		} );

		Button btn2 = new Button();
		btn2.setText( "Oh, just have text" );
		btn2.setLayoutX( 150 );
		btn2.setLayoutY( 100 );
		btn2.setOnAction( ev -> recreateStage() );

		cc = new CustomControl();
		cc.setLayoutX(20);
		cc.setLayoutY(300);

		CustomControl cc2 = new CustomControl( "my second" );
		cc2.setLayoutX(20);
		cc2.setLayoutY(350);

		Pane root = new Pane();
		//StackPane root = new StackPane();
		root.getChildren().add( lblPrevious );
		root.getChildren().add( lblNext );
		root.getChildren().add( btn );
		root.getChildren().add( btn2 );
		root.getChildren().add( cc );
		root.getChildren().add( cc2 );

		Schedule schedule = nhlService.getTodaySchedule();
		cc2.setText( String.format( "found %s games", schedule.getGames().size() ) );

		Scene scene = new Scene( root, 300, 500 );

		primaryStage.setTitle( "JavaFX Labs 1.0" );
		primaryStage.setScene( scene );
		primaryStage.show();
	}

	/**
	 * The main() method is ignored in correctly deployed JavaFX application.
	 * main() serves only as fallback in case the application can not be launched
	 * through deployment artifacts, e.g., in IDEs with limited FX support.
	 * NetBeans ignores main().
	 *
	 * @param args the command line arguments
	public static void main( String[] args ) {
		launch( args );
	}
	 */


	private void recreateStage() {
		Button btn = new Button();
		btn.setText( "Presto!" );
		btn.setLayoutX( 10 );
		btn.setLayoutY( 100 );
		btn.setOnAction( ev -> System.out.println( "New stage magic" ) );

		StackPane root = new StackPane();
		root.getChildren().add( btn );
		Scene scene = new Scene( root, 150, 250 );
		mainStage.setScene( scene );
	}

	private void actionPreviousClicked() {
		cc.setText( "prev" );
	}
	
	private void actionNextClicked() {
		cc.setText( "next" );
	}
	


	public class CustomControl extends HBox {
		private TextField textField;
		private Button button;

		private Insets padding = new Insets(0, 3, 0, 3);

		public CustomControl( String customString ) {
			super(5);
			createText( customString );
			createButton( customString );
			this.getChildren().addAll( textField, button );
		}

		public CustomControl() {
			super(5);
			createText( "custom" );
			createButton( "custom" );
			this.getChildren().addAll( textField, button );
		}

		public void setText( String newText ) {
			textField.setText( newText );
		}


		private void createText( String textString ) {
			textField = new TextField();
			textField.setText( textString.concat( " text" ) );
			textField.setFont( new Font( "Verdana", 14.0 ) );
			textField.setPrefHeight( 25.0 );
			textField.setPrefWidth( 150.0 );
			System.out.printf( "textfield height: %s  width: %s%n", textField.getHeight(), textField.getWidth() );
			//this.textField.setPadding( padding );
		}

		private void createButton( String textString ) {
			button = new Button();
			button.setText( textString.concat( " button" ) );
			button.setPrefHeight( 25.0 );
			button.setPrefWidth( 115.0 );
			System.out.printf( "button height: %s  width: %s%n", button.getHeight(), button.getWidth() );
			//this.button.setPadding( padding );
			button.setOnAction( event -> System.out.println( "cc message: ".concat( textField.getText() ) ) );
		}
	}
}
