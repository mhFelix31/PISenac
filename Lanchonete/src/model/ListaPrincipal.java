/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.sun.prism.paint.Color;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;

/**
 *
 * @author asdfq
 */
public class ListaPrincipal extends Pane {
    
    
    private final Button buton;
    private final ImageView imageView;
    
    public ListaPrincipal(Image img){
        //-fx-background-image: url(testecantina2/img1.jpg); -fx-border-radius: 10px;
       String imagem = String.format(" -fx-background-image: url(testecantina2/img1.jpg); -fx-background-insets:20,20,20,20;  -fx-background-radius: 10px;", img);
        buton = new Button();
        imageView = new ImageView();
        
        setMinWidth(160.0);
        setMinHeight(200.0);
        setMaxHeight(200.0);
        buton.setMaxWidth(200.0);
        prefHeight(200);
        prefWidth(200);
        //setStyle(imagem);
        
        buton.setLayoutX(2.0);
        buton.setLayoutY(165.0);
        buton.setMnemonicParsing(false);
        buton.setText("OBSERVAÇÕES");
        buton.setTextAlignment(TextAlignment.CENTER);
        buton.setStyle("-fx-min-width: 155px; fx-min-height:40px");
        
        
        
        imageView.setFitWidth(160);
        imageView.setFitHeight(195);
        imageView.setLayoutY(1.0);
        imageView.setImage(img);
        String var = Color.TRANSPARENT.toString();
        
      // imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(false);
        Rectangle clip = new Rectangle(
                imageView.getFitWidth(), imageView.getFitHeight()
            );
            clip.setArcWidth(20);
            clip.setArcHeight(20);
            imageView.setClip(clip);
           /// imageView.setClip(null);
            SnapshotParameters parameters = new SnapshotParameters();
            parameters.setFill(Paint.valueOf("blue"));
            WritableImage image = imageView.snapshot(parameters, null);
            imageView.setImage(image);
        
        
        getChildren().addAll(imageView,buton);
        
    }
}
