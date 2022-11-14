package ba.unsa.etf.rpr;

/**
 * Exception that is thrown when a processor is unknown
 */
public class UnknownProcessorException extends Exception {
    public UnknownProcessorException(String processor){
        super(processor + "does not exist");
    }
}
