package lab10.main;

public class Test {
    public static void main(String[] args) {
        Client client = new Client();

        // Execute various tests

        testDraw(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testTextAndColor(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testResize(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testConnect(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testAllCommands(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testSimpleUndoRedo(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testComplexUndoRedo(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));
    }

    private static void testDraw(Client client) {
        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");

        client.showDiagram();
    }

    private static void testTextAndColor(Client client) {
        testDraw(client);
        client.executeAction("change color", "0", "RED");
        client.executeAction("change color", "1", "BLUE");
        client.executeAction("draw rectangle");
        client.executeAction("change text", "0", "MyClass1");
        client.executeAction("change text", "5", "MyClass2");
        client.showDiagram();
    }

    private static void testConnect(Client client) {
        // TODO
        testDraw(client);
        client.executeAction("connect", "0", "1");
        client.executeAction("connect", "2", "4");
        client.executeAction("connect", "3", "2");
        client.executeAction("connect", "0", "4");
        client.showDiagram();
    }

    private static void testResize(Client client) {
        // TODO
        testDraw(client);
        client.executeAction("resize", "2", "20");
        client.executeAction("resize", "3", "15");
        client.showDiagram();
    }

    private static void testAllCommands(Client client) {
        // TODO
        testDraw(client);
        client.executeAction("draw rectangle");
        client.executeAction("change color", "2", "RED");
        client.executeAction("change color", "5", "PINK");

        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("change text", "2", "Hello1");
        client.executeAction("change text", "7", "Hello2");
        client.executeAction("change color", "6", "BLUE");

        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("connect", "1", "6");
        client.executeAction("connect", "2", "4");
        client.executeAction("connect", "3", "6");
        client.executeAction("connect", "7", "5");

        client.executeAction("resize", "1", "20");
        client.executeAction("resize", "3", "15");
        client.executeAction("resize", "7", "25");

        client.showDiagram();
    }

    private static void testSimpleUndoRedo(Client client) {
        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("change color", "0", "ORANGE");
        client.showDiagram();

        client.executeAction("draw rectangle");
        client.showDiagram();

        client.undo();
        client.showDiagram();

        client.redo();
        client.showDiagram();
    }

    private static void testComplexUndoRedo(Client client) {
        // TODO
        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.showDiagram();

        client.undo();
        client.undo();
        client.showDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("change color", "0", "RED");
        client.executeAction("change color", "2", "GREEN");
        client.showDiagram();

        client.undo();
        client.showDiagram();
        client.redo();
        client.showDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("change text", "2", "Hello1");
        client.executeAction("change text", "6", "Hello2");
        client.undo();
        client.showDiagram();
        client.redo();
        client.showDiagram();

        client.executeAction("connect", "2", "4");
        client.executeAction("connect", "3", "2");
        client.executeAction("connect", "0", "4");
        client.showDiagram();
        client.undo();
        client.undo();
        client.redo();
        client.showDiagram();
    }
}
