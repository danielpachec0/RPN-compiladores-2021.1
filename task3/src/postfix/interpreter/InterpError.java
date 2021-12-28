package postfix.interpreter;

public class InterpError extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public InterpError(String msg) {
		super(msg);
	}
}
