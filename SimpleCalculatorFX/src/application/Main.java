package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    private TextField num1Field;
    private TextField num2Field;
    private Label resultLabel;
   
    @Override
    public void start(Stage primaryStage) {
        // Create UI components
        num1Field = new TextField();
        num2Field = new TextField();
        resultLabel = new Label("Result: ");
        
        Button addButton = new Button("+");
        Button subtractButton = new Button("-");
        Button multiplyButton = new Button("*");
        Button divideButton = new Button("/");

        // Set button actions
        addButton.setOnAction(e -> calculate('+'));
        subtractButton.setOnAction(e -> calculate('-'));
        multiplyButton.setOnAction(e -> calculate('*'));
        divideButton.setOnAction(e -> calculate('/'));

        // Create layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        // Add components to layout
        gridPane.add(new Label("First Number:"), 0, 0);
        gridPane.add(num1Field, 1, 0);
        gridPane.add(new Label("Second Number:"), 0, 1);
        gridPane.add(num2Field, 1, 1);
        
        gridPane.add(addButton, 0, 2);
        gridPane.add(subtractButton, 1, 2);
        gridPane.add(multiplyButton, 0, 3);
        gridPane.add(divideButton, 1, 3);
        
        gridPane.add(resultLabel, 0, 4, 2, 1);

        // Set up the scene and stage
        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculate(char operator) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        resultLabel.setText("Error: Division by zero!");
                        return;
                    }
                    break;
                default:
                    resultLabel.setText("Invalid operator!");
                    return;
            }
            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Error: Invalid input!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
