/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package signup;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Nuhad
 */
public class SignupPage extends Application{
    public void start(Stage stage) {
        Label nameLabel = new Label("Full Name");
        TextField nameField = new TextField();
        nameField.setPromptText("Enter full name");
        Label emailLabel = new Label("Email");
        TextField emailField = new TextField();
        emailField.setPromptText("Enter email");
        Label passLabel = new Label("Password");
        PasswordField passField = new PasswordField();
        passField.setPromptText("Enter password");
        Label confirmLabel = new Label("Confirm Password");
        PasswordField confirmField = new PasswordField();
        confirmField.setPromptText("Confirm password");
        Button signupBtn = new Button("SIGN UP");
        signupBtn.setOnAction(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String pass = passField.getText();
            String confirm = confirmField.getText();
            if(name.isEmpty() || email.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please fill all fields");
                alert.show();
            } 
            else if(!pass.equals(confirm)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Password does not match");
                alert.show();
            } 
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Signup Successful");
                alert.show();
            }});
        VBox root = new VBox(10);
        root.getChildren().addAll(nameLabel,nameField,emailLabel,emailField,passLabel,passField,confirmLabel,confirmField,signupBtn);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 350, 400);
        stage.setTitle("Signup Page");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}