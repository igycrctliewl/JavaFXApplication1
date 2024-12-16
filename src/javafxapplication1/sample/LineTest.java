package javafxapplication1.sample;

import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @see https://stackoverflow.com/a/43814198/230513
 */
public class LineTest extends Application {

    @Override
    public void start(Stage Stage) {
        Stage.setTitle("LineTest");
        LinePane linePane = new LinePane();
        Button button = new Button("Button");
        LinePane.setAlignment(button, Pos.TOP_LEFT);
        LinePane.setMargin(button, new Insets(50));
        linePane.getChildren().add(button);
        Scene scene = new Scene(linePane, 320, 240);
        Stage.setScene(scene);
        Stage.show();
    }

    private static class LinePane extends StackPane {

        private static final String URL = "https://i.sstatic.net/bqXKK.png";
        private final Image lines = new Image(URL);
        private final Rectangle rectangle = new Rectangle();

        public LinePane() {
            rectangle.setFill(new ImagePattern(lines, 8, 22, 34, 34, false));
            //rectangle.setFill( Color.AZURE );
            getChildren().add(rectangle);
        }

        @Override
        protected void layoutChildren() {
            super.layoutChildren();
            final double x = snappedLeftInset();
            final double y = snappedTopInset();
            final double w = snapSize(getWidth()) - x - snappedRightInset();
            final double h = snapSize(getHeight()) - y - snappedBottomInset();
            rectangle.setLayoutX(x);
            rectangle.setLayoutY(y);
            rectangle.setWidth(w);
            rectangle.setHeight(h);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}