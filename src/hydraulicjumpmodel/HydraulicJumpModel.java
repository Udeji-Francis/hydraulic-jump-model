package hydraulicjumpmodel;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HydraulicJumpModel extends Application {
    private TextField username;
    private PasswordField password;
    private Button loginButton;
    private Label label;
    
    private static final String USERNAME = "ADMIN";
    private static final String PASSWORD = "ADMIN";
    
    private Text text;
    
    Scene scene1, scene2;
    final int WIDTH = 300;
    final int HEIGHT = 250;

    Stage window;
    @Override
    public void start(Stage primaryStage) {
        
        window = new Stage();
        window = primaryStage;
        
        text = new Text("Invalid Username or Password");
        text.setVisible(false);
        
        username = new TextField();
        username.setText(USERNAME);
        username.setPromptText("Enter Username");
        
        password = new PasswordField();
        password.setText(PASSWORD);
        password.setPromptText("Enter Password");
        
        
        loginButton = new Button("Log In");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                // System.out.println("Hello World!");
                handleLogin();
            }
        });
        
        VBox root = new VBox(20);
        HBox hBox = new HBox();
        hBox.getChildren().add(root);
        hBox.setAlignment(Pos.CENTER);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(text, username, password, loginButton);
        
        scene1 = new Scene(hBox, WIDTH, HEIGHT);
        
        window.setTitle("Admin Login Form");
        window.setScene(scene1);
        window.show();
    }

    public void handleLogin() {
        String inputUsername = username.getText();
        String inputPassword = password.getText();
        //System.out.println(inputUsername.toUpperCase() +"--"+ inputPassword.toUpperCase());
        
        //System.out.println(inputUsername + "===" + inputPassword);
         if (inputUsername.toUpperCase().equals(USERNAME) && inputPassword.toUpperCase().equals(PASSWORD)) {
            System.out.println("Success");
            text.setVisible(false);
            MainWindow mainWindow = new MainWindow();
            window.getScene().setRoot(mainWindow.getRootPane());
            window.setWidth(800);
            window.setHeight(600);
            window.setTitle("Main Window");
        } else {
            text.setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    void show() {
        window.setScene(scene1);
    }
    
}
