package fil.iagl.cookorico.exception;

public class CookoricoException  extends RuntimeException {

	  private static final long serialVersionUID =  -1374905127904717607L;

	  public CookoricoException() {
	    super();
	  }

	  public CookoricoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	    super(message, cause, enableSuppression, writableStackTrace);
	  }

	  public CookoricoException(String message, Throwable cause) {
	    super(message, cause);
	  }

	  public CookoricoException(String message) {
	    super(message);
	  }

	  public CookoricoException(Throwable cause) {
	    super(cause);
	  }
}