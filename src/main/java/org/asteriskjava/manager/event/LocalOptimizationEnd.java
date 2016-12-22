/**
 * 
 */
package org.asteriskjava.manager.event;

/**
 * Raised when two halves of a Local Channel end to optimize themselves out of the media path.
 * 
 * @see https://wiki.asterisk.org/wiki/display/AST/Asterisk+13+ManagerEvent_LocalOptimizationBegin
 * 
 * @author <a href="mailto:nmazzon@teleniasoftware.it">Nicolò Mazzon</a>
 * @version 1.0.0 15-dic-2016
 */
public class LocalOptimizationEnd extends AbstractLocalOptimization {
    private static final long serialVersionUID = 8941721650166010936L;

    public LocalOptimizationEnd( Object source ) {
        super( source );
    }
}
