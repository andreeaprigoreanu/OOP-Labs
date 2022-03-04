package lab10.commands;

import lab10.diagram.DiagramCanvas;
import lab10.diagram.DiagramComponent;

public class ResizeCommand implements DrawCommand {
    private final DiagramCanvas diagramCanvas;
    private int index;
    private int percentage;

    public ResizeCommand(DiagramCanvas diagramCanvas, int index, int percentage) {
        this.diagramCanvas = diagramCanvas;
        this.index = index;
        this.percentage = percentage;
    }

    @Override
    public void execute() {
        DiagramComponent diagramComponent = diagramCanvas.getComponent(index);
        diagramComponent.setHeight((100 - percentage) * diagramComponent.getHeight() / 100);
        diagramComponent.setWeight((100 - percentage) * diagramComponent.getWeight() / 100);
    }

    @Override
    public void undo() {
        DiagramComponent diagramComponent = diagramCanvas.getComponent(index);
        diagramComponent.setHeight(100 * diagramComponent.getHeight() / (100 - percentage));
        diagramComponent.setWeight(100 * diagramComponent.getWeight() / (100 - percentage));
    }
}
