package lab10.commands;

import lab10.diagram.DiagramCanvas;
import lab10.diagram.DiagramComponent;

public class DrawRectangleCommand implements DrawCommand {
    private final DiagramCanvas diagramCanvas;
    private final DiagramComponent diagramComponent;

    public DrawRectangleCommand(DiagramCanvas diagramCanvas) {
        this.diagramCanvas = diagramCanvas;
        diagramComponent = new DiagramComponent();
    }

    @Override
    public void execute() {
        diagramCanvas.addComponent(diagramComponent);
    }

    @Override
    public void undo() {
        diagramCanvas.removeComponent(diagramComponent);
    }

    @Override
    public String toString() {
        return "DrawRectangleCommand{" +
                "diagramCanvas=" + diagramCanvas +
                '}';
    }
}
