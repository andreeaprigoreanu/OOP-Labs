package lab10.commands;

import lab10.diagram.DiagramCanvas;
import lab10.diagram.DiagramComponent;

import java.lang.reflect.Field;

public class ConnectComponentsCommand implements DrawCommand {
    private final DiagramCanvas diagramCanvas;
    private int indexFirstComponent;
    private int indexSecondComponent;

    public ConnectComponentsCommand(DiagramCanvas diagramCanvas, int indexFirstComponent, int indexSecondComponent) {
        this.diagramCanvas = diagramCanvas;
        this.indexFirstComponent = indexFirstComponent;
        this.indexSecondComponent = indexSecondComponent;
    }

    @Override
    public void execute() {
        diagramCanvas.getComponent(indexFirstComponent).connectTo(String.valueOf(indexSecondComponent));
        diagramCanvas.getComponent(indexSecondComponent).connectTo(String.valueOf(indexFirstComponent));
    }

    @Override
    public void undo() {
        diagramCanvas.getComponent(indexFirstComponent).removeConnection(String.valueOf(indexSecondComponent));
        diagramCanvas.getComponent(indexSecondComponent).removeConnection(String.valueOf(indexFirstComponent));
    }

    @Override
    public String toString() {
        return "ConnectComponentsCommand{" +
                "diagramCanvas=" + diagramCanvas +
                ", indexFirstComponent=" + indexFirstComponent +
                ", indexSecondComponent=" + indexSecondComponent +
                '}';
    }
}
