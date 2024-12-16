package javafxapplication1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author mikebro
 */
public class JavaFXApplication1 extends Application {

	@Override
	public void start( Stage primaryStage ) {
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
		btn2.setOnAction( new EventHandler<ActionEvent>() {
			@Override
			public void handle( ActionEvent event ) {
				System.out.println( "Button2 has spoken" );
			}
		} );

		Pane root = new Pane();
		//StackPane root = new StackPane();
		root.getChildren().add( btn );
		root.getChildren().add( btn2 );
		root.getChildren().addAll(new Rectangle(100,100,Color.BLUE), new Label("Go!"));


		Scene scene = new Scene( root, 300, 500 );

		primaryStage.setTitle( "Hello World!" );
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
	 */
	public static void main( String[] args ) {
		launch( args );
	}
}
