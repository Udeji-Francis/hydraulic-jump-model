/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hydraulicjumpmodel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainWindow {

    private final BorderPane rootPane ; // or any other kind of pane, or  Group...
    private Button btn = new Button("boutpowef");
    
    HBox menuContainer;
    MenuBar menuBar;
    Menu regular, iregular;
    MenuItem neww, close, print, circle, square, rectangle, triangle;
    //SubMenuItem subm;
    Menu shapesMenu, fileMenu;
    
    VBox container;
    
    public MainWindow() {

        rootPane = new BorderPane();
        
        circle = new MenuItem("Circle");
        square = new MenuItem("Square");
        rectangle = new MenuItem("Rectangle");
        triangle = new MenuItem("Triangle");
        
        regular = new Menu("Regular");
        regular.getItems().addAll(circle, square, rectangle, triangle);
        iregular = new Menu("Iregular");
        
        neww = new MenuItem("New");
        close = new MenuItem("Close");
        print = new MenuItem("Print");
        
        
        
        shapesMenu = new Menu("Shapes");
        shapesMenu.getItems().addAll(regular, iregular);
        fileMenu = new Menu("File");
        fileMenu.getItems().addAll(neww, close, print);
        
        menuBar = new MenuBar();
        menuBar.getMenus().addAll(shapesMenu, fileMenu);
        
        rootPane.setTop(menuBar);

        // events
        rectangle.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                // System.out.println("Hello World!");
                handleRectangle();
            }
        });
    }

    public Pane getRootPane() {
        return rootPane;
    }
    
    public void handleRectangle() {
        rootPane.setCenter(rectUI());
    }
    
    private Pane rectUI() {
        container = new VBox();
        
        VBox left = new VBox(10);
        HBox first, second, third, fourth, fifth, sixth;
        
        
        first = new HBox(10);
        second = new HBox(10);
        third = new HBox(10);
        fourth = new HBox(10);
        fifth = new HBox(10);
        sixth = new HBox(2);
        
        Button compute, exit, clear;
        compute = new Button("Compute");
        exit = new Button("Exit");
        clear = new Button("Clear");
        
        final TextField v, woc, doc, twot, dis;
        v = new TextField();
        woc = new TextField();
        doc = new TextField();
        twot = new TextField();
        dis = new TextField();
        
        first.getChildren().addAll(new Label("VELOCITY (M^-1)"), v);
        second.getChildren().addAll(new Label("WIDTH OD CHANNEL (M)"), woc);
        //second.setPrefWidth(200);
        third.getChildren().addAll(new Label("DEPTH OF CHANNEL (M)"), doc);
        //third.setPrefWidth(200);
        
        left.getChildren().addAll(first, second, third);
                
        VBox center = new VBox(10);
        
        fourth.getChildren().addAll(new Label("TOP WIDTH OF T (M)"), twot);
        fifth.getChildren().addAll(new Label("DISCHARGE"), dis);
        sixth.getChildren().addAll(compute, exit, clear);
        
        center.getChildren().addAll(fourth, fifth, sixth);
        
        //VBox right = new VBox(10);
        //right.getChildfren().addAll()
        
        container.setPadding(new Insets(15, 15, 15, 15));
        container.getChildren().addAll(left, center);
        container.setAlignment(Pos.CENTER);
        
        compute.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(v.getText() +
                        "===" + woc.getText() +
                        "===" + doc.getText() + 
                        "===" + twot.getText()+
                        "===" + dis.getText()
                );
            }
        });
        
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                v.clear();
                woc.clear();
                doc.clear();
                twot.clear();
                dis.clear();
            }
        });
        
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //HydraulicJumpModel hjm = new HydraulicJumpModel();
                //window.getScene().setRoot(hjm.getRootPane());
                //hjm.show();
                System.exit(0);
            }
        });
        
        return container;
    }

 

    

}