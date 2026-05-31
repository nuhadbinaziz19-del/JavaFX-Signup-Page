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
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
 *
 * @author Nuhad
 */
public class SignupPage extends Application {
    @Override
    public void start(Stage stage) {
        Label icon = new Label("👤");
        icon.setFont(new Font(50));
        Label title = new Label("Create Account");
        title.setFont(new Font("Arial", 28));
        title.setStyle("-fx-font-weight: bold;");
        Label subtitle = new Label("Fill in the details to sign up");
        subtitle.setTextFill(Color.GRAY);
        Label fullNameLabel = new Label("Full Name");
        TextField fullNameField = new TextField();
        fullNameField.setPromptText("Enter your full name");
        fullNameField.setPrefHeight(40);
        Label emailLabel = new Label("Username / Email");
        TextField emailField = new TextField();
        emailField.setPromptText("Enter username or email");
        emailField.setPrefHeight(40);
        Label passLabel = new Label("Password");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter password");
        passwordField.setPrefHeight(40);
        Label confirmLabel = new Label("Confirm Password");
        PasswordField confirmField = new PasswordField();
        confirmField.setPromptText("Confirm password");
        confirmField.setPrefHeight(40);
        Button signupBtn = new Button("SIGN UP");
        signupBtn.setPrefWidth(350);
        signupBtn.setPrefHeight(45);
        signupBtn.setStyle(
                "-fx-background-color: linear-gradient(to right, #8E2DE2, #C56CF0);" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 8;"
        );
        Label loginText = new Label("Already have an account?");
        Hyperlink loginLink = new Hyperlink("Login");
        HBox loginBox = new HBox(5, loginText, loginLink);
        loginBox.setAlignment(Pos.CENTER);
        VBox featuresBox = new VBox(5);
        Label featureTitle = new Label("Features");
        featureTitle.setStyle("-fx-font-weight: bold; -fx-text-fill: #8E2DE2;");
        Label f1 = new Label("• User can create a new account");
        Label f2 = new Label("• Password and confirm password must match");
        Label f3 = new Label("• Validation for empty fields");
        Label f4 = new Label("• Navigate back to Login page");

        featuresBox.getChildren().addAll(featureTitle, f1, f2, f3, f4);

        featuresBox.setPadding(new Insets(15));
        featuresBox.setStyle(
                "-fx-border-color: #dddddd;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;"
        );

        // ===== MAIN LAYOUT =====
        VBox root = new VBox(12);

        root.getChildren().addAll(
                icon,
                title,
                subtitle,

                fullNameLabel,
                fullNameField,

                emailLabel,
                emailField,

                passLabel,
                passwordField,

                confirmLabel,
                confirmField,

                signupBtn,
                loginBox,
                featuresBox
        );

        root.setPadding(new Insets(25));
        root.setAlignment(Pos.TOP_CENTER);

        // ===== BUTTON ACTION =====
        signupBtn.setOnAction(e -> {

            String name = fullNameField.getText();
            String email = emailField.getText();
            String pass = passwordField.getText();
            String confirm = confirmField.getText();

            if(name.isEmpty() || email.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {

                showAlert("Error", "Please fill all fields!");

            } else if(!pass.equals(confirm)) {

                showAlert("Error", "Passwords do not match!");

            } else {

                showAlert("Success", "Account Created Successfully!");

            }

        });

        // ===== SCENE =====
        Scene scene = new Scene(root, 420, 700);

        stage.setTitle("Signup");
        stage.setScene(scene);
        stage.show();
    }

    // ===== ALERT METHOD =====
    private void showAlert(String title, String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}