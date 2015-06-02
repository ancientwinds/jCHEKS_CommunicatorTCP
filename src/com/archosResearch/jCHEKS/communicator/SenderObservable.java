
package com.archosResearch.jCHEKS.communicator;

/**
 *
 * @author Thomas Lepage
 */
public interface SenderObservable {
    
    
    public void addObserver(SenderObserver observer);
    
    public void notifyMessageACK();
}
