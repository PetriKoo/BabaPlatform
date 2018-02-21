package baba.library.gui.frames;

import javax.swing.JFrame;

/**
 *
 * @author petri
 */
public class MainFrame extends JFrame {
    
    private static MainFrame INSTANCE = null;
    private boolean bIsInitialized = false;
    
    private MainFrame() {
        if (!bIsInitialized) init();
    }
    
    private void init() {
        
        this.bIsInitialized = true;
    }
    
    public static MainFrame getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MainFrame();
        }
        return INSTANCE;
    }
}
