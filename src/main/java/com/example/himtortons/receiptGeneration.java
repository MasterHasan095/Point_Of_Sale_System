package com.example.himtortons;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.List;

public class receiptGeneration {
    static VBox receipt = new VBox();
    public static void ButtonListGeneration(String orderLine){
        Button orderLineButton = new Button();
        orderLineButton.setText(orderLine);
        POSMain.removeFromCartButtons.add(orderLineButton);
    }

    public static VBox receiptGenerated(List<Button> buttonList){
        receipt.getChildren().clear();
        for (Button button : buttonList){
            button.setOnAction(e->{
                System.out.println("Checkpoint 2");
                POSMain.removeFromCartButtons.remove(button);
                System.out.println(POSMain.removeFromCartButtons);
                POSMain.orderPane.setContent(receiptGeneration.receiptGenerated(POSMain.removeFromCartButtons));

            });
            receipt.getChildren().add(button);
        }
        return receipt;
    };

}
