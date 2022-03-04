package lab9.storage;

import java.awt.image.ImageObserver;
import java.util.Observable;
import java.util.Observer;

public class ServerCommunicationController implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("New data record was added to data repository");
    }
}
