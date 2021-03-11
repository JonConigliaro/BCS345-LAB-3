//Name: Jon Conigliaro
//Date:03/11/21
//Lab 3 Assignment

package lab.pkg3;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Lab3 extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
       int shiftLeft=-20, stairSize=11;
       double rectangleX=108; 
        
       Group root = new Group();
       Scene grass = new Scene(root, 500, 450, Color.GREEN);    //creates grass
       
       Rectangle sky = new Rectangle(0,0,1000,200);             //creates sky
       sky.setFill(Color.LIGHTSKYBLUE);
       root.getChildren().add(sky);
       
       Rectangle houseBase = new Rectangle(100+shiftLeft,100,350,290);  //creates the house sqaure/base
       houseBase.setStroke(Color.BLACK);
       houseBase.setFill(Color.BROWN);
       root.getChildren().add(houseBase);
       
       Rectangle topWhiteBorder = new Rectangle(100+shiftLeft,100,350,30); // creates uppoer white border thats between the rood and the columns
       topWhiteBorder.setStroke(Color.BLACK);
       topWhiteBorder.setFill(Color.WHITE);
       root.getChildren().add(topWhiteBorder);
       
       Rectangle smallGraySqaure = new Rectangle(250+shiftLeft,150,50,40);  // creates small gray sqaure in the middle of the house
       smallGraySqaure.setStroke(Color.BLACK);
       smallGraySqaure.setFill(Color.LIGHTGRAY);
       root.getChildren().add(smallGraySqaure);
       
       Polygon roof = new Polygon();                    // creates roof
       roof.getPoints().addAll(new Double[]{
             250.0, 0.0,    //top point coordinate
             50.0, 100.0,   //left point coordinate
            460.0, 100.0 });    // right point coordinate
       roof.setStroke(Color.BLACK);
       roof.setFill(Color.WHITE);
       root.getChildren().add(roof);
       
              
       for(int i =0; i < 4; i++){    // creates four white columns.lower column box, pairs of circles
       Rectangle column = new Rectangle(rectangleX+shiftLeft,130,25,180);  // creates each column
       column.setStroke(Color.BLACK);
       column.setFill(Color.WHITE);
       root.getChildren().add(column);
  
       Rectangle lowerColumnBox = new Rectangle((rectangleX-4.5)+shiftLeft,300,35,10); // creates each lower column box
       lowerColumnBox.setStroke(Color.BLACK);
       lowerColumnBox.setFill(Color.WHITE);
       root.getChildren().add(lowerColumnBox);
       rectangleX+=103;

        double circleX=88+(i*102.9);// which each interation, adjust each piar of circles x position to the right.
        for(int j = 0; j <2; j++){      //creates a pair circles
        Circle circle = new Circle(circleX,138,8,Color.WHITE);
        circle.setStroke(Color.BLACK);
        root.getChildren().add(circle); 
        circleX+=25;// adjust the space inbetween each circle within a pair
        }
       }
        Rectangle[] stairs = new Rectangle[stairSize];
        int stp = 15;
        for(int i=0; i<stairSize; i++){     //creates stairs steps
        stairs[i]= new Rectangle(120-i*stp/2, 310+i*stp/2, 270+i*stp, 12);
        stairs[i].setStroke(Color.BLACK);
        stairs[i].setFill(Color.LIGHTGRAY);
        root.getChildren().add(stairs[i]);
        }
        
        for(int i =0; i<2;i++){ // creates the two small gray rectangles that meet the bottom of the first and last column.
        Rectangle sideGrayRect = new Rectangle(80+i*310,310,40,4);
        sideGrayRect.setStroke(Color.BLACK);
        sideGrayRect.setFill(Color.LIGHTGRAY);
        root.getChildren().add(sideGrayRect);
        }
        
        for(int i =0; i <3 ; i++){  // creates 3 doors with pairs of door windoes for each door
           if(i==1){ // its the second door, make increase the height of that door
            Rectangle door = new Rectangle(130+i*100,210,50,100); 
            door.setStroke(Color.BLACK);
            door.setFill(Color.WHITE);
            root.getChildren().add(door);  
           }else { // creates first and third door
            Rectangle door = new Rectangle(130+i*100,230,50,80);
            door.setStroke(Color.BLACK);
            door.setFill(Color.WHITE);
            root.getChildren().add(door);
           }
           
        double doorWindowX = 139+(i*100);   
        for(int j=0; j < 2; j++){ // creates 2 columns of door windows
            for(int k=0; k<5 ;k++){ // creates 5 rows of door windows
            Rectangle doorWindows = new Rectangle(doorWindowX+j*20,235+k*15,10,10);
            doorWindows.setFill(Color.BLACK);
            root.getChildren().add(doorWindows);
            }
         }
        }
       stage.setTitle("A house");
       stage.setScene(grass);
       stage.show();  
    }
}
