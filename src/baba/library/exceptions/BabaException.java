package baba.library.exceptions;

/**
 *
 * @author Petri Koskelainen
 */
abstract public class BabaException extends Exception {
    
    private boolean canContinue = false;
    
    public BabaException (Class cClass, String sMessage) {
        super("Error in class '" + cClass.getCanonicalName() + "': "+  sMessage );
    }
    
    public void setContinue( boolean b ) { this.canContinue = b; }
    public boolean canContinue() { return this.canContinue; }
    
}
