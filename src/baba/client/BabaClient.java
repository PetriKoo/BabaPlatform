package baba.client;

import baba.library.gui.frames.MainFrame;
import java.util.Properties;

/**
 *
 * @author petri
 */
public class BabaClient {

    public BabaClient(Properties props) {
        init();
    }
    
    private void init() {
        initGui();
    }
    
    private void initGui() {
        MainFrame mainFrame = MainFrame.getInstance();
        mainFrame.setVisible( true );
    }
}
