package Compuertas;

import GUI.Painter;
import LinkedList.LinkedList;
import Logica.DragAndDrop;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class CompuertaXOR extends Compuerta {
    double posX, posY;
    LinkedList<Boolean> inputs = new LinkedList<>();



    public CompuertaXOR(Pane gridPane) {
        createXOR(gridPane);

    }

    private void  createXOR(Pane gridPane){
        logicGateGroup = new Group();
        Image image = new Image("Compuerta6.png");
        Rectangle logicGate = Painter.insertImage(image);
        logicGateGroup.getChildren().add(logicGate);
        DragAndDrop.setStartDragAndDrop(gridPane, logicGateGroup);
        gridPane.getChildren().add(logicGateGroup);
        Painter.crearEntradasSalidas(logicGateGroup);
        Painter.enumeration(logicGateGroup);

    }

    @Override
    public void operar() {

        for(int i = 0; i<= outputs.size()-1; i++){
            Compuerta compuerta = outputs.getElement(i);
            compuerta.operar();
            inputs.add(compuerta.output.value);
            //compuerta.output.value = output.value;
        }

        for(int i=1; i<= inputs.size()-1; i++){
            System.out.println("entra operar inputs");
            if(output.value != inputs.getElement(0)){
                output.value = true;
            }else{
                output.value = false;
            }
        }





    }
}

