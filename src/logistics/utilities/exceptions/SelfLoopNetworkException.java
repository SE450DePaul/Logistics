package logistics.utilities.exceptions;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public class SelfLoopNetworkException extends Exception 
{
    public SelfLoopNetworkException() {super();}
    public SelfLoopNetworkException(String message)
    {
        super(message);
    }
}
