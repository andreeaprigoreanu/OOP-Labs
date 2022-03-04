package lab10.commands;

import lab10.diagram.DiagramCanvas;
import lab10.diagram.DiagramComponent;

public class ChangeTextCommand implements DrawCommand {
    private final DiagramCanvas diagramCanvas;
    private int index;
    private String prevText;
    private String newText;

    public ChangeTextCommand(DiagramCanvas diagramCanvas, int index, String newText) {
        this.diagramCanvas = diagramCanvas;
        this.index = index;
        this.newText = newText;
    }

    @Override
    public void execute() {
        DiagramComponent diagramComponent = diagramCanvas.getComponent(index);
        prevText = diagramComponent.getText();
        diagramComponent.setText(newText);
    }

    @Override
    public void undo() {
        DiagramComponent diagramComponent = diagramCanvas.getComponent(index);
        String newPrevText = diagramComponent.getText();
        diagramComponent.setText(prevText);
        prevText = newPrevText;
    }

    @Override
    public String toString() {
        return "ChangeTextCommand{" +
                "diagramCanvas=" + diagramCanvas +
                ", index=" + index +
                ", text='" + newText + '\'' +
                '}';
    }
}
