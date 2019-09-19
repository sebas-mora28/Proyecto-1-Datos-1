package Compuertas;

import GUI.Painter;
import Logica.DragAndDrop;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class CompuertaOR extends Compuerta {


    public CompuertaOR(Pane gridPane) {
        createOR(gridPane);

    }
    private void  createOR(Pane gridPane){
        logicGateGroup = new Group();
        Image image = new Image("Compuerta3.png");
        Rectangle logicGate = Painter.insertImage(image);
        logicGateGroup.getChildren().add(logicGate);
        DragAndDrop.setStartDragAndDrop(gridPane, logicGateGroup);
        gridPane.getChildren().add(logicGateGroup);
        Painter.crearEntradasSalidas(logicGateGroup);
        Painter.enumeration(logicGateGroup);

    }

    @Override
    public void operar() {

        System.out.println("Compuerta OR");
        System.out.println("Conexiones a otras compuertas");
        for(int i = 0; i<= outputs.size()-1; i++){
            Compuerta compuerta = outputs.getElement(i);
            compuerta.operar();
            System.out.println(compuerta.output.value);
            inputs.add(compuerta.output.value);
            //compuerta.output.value = output.value;
        }
        System.out.println("--------------------------------------------------------");
        output.value = (Boolean)inputs.getElement(0);
        for(int i=1; i<= inputs.size()-1; i++){
            boolean res = (Boolean)inputs.getElement(i);
            output.value = output.value || res;
            System.out.println("OR" + output.value);
        }

        System.out.println("Salidas de la compuerts OR: " + output.value);

        System.out.println("----------------------------------------------------------");
        System.out.println();
        System.out.println("----------------------------------------------------------");







    }
}
