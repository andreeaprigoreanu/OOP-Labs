package lab10.commands;

import lab10.diagram.DiagramCanvas;
import lab10.diagram.DiagramComponent;

public class ChangeColorCommand implements DrawCommand {
    private final DiagramCanvas diagramCanvas;
    private int index;
    private String prevColor;
    private String nextColor;

    public ChangeColorCommand(DiagramCanvas diagramCanvas, int index, String color) {
        this.diagramCanvas = diagramCanvas;
        this.index = index;
        this.nextColor = color;
    }

    @Override
    public void execute() {
        DiagramComponent diagramComponent = diagramCanvas.getComponent(index);
        prevColor = diagramComponent.getColor();
        diagramComponent.setColor(nextColor);
    }

    @Override
    public void undo() {
        DiagramComponent diagramComponent = diagramCanvas.getComponent(index);
        String newPrevColor = diagramComponent.getColor();
        diagramComponent.setColor(prevColor);
        prevColor = newPrevColor;
    }

    @Override
    public String toString() {
        return "ChangeColorCommand{" +
                "diagramCanvas=" + diagramCanvas +
                ", index=" + index +

                ", color='" + nextColor + '\'' +
                '}';
    }
}
