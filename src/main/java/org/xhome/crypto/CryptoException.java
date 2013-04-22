package org.xhome.crypto;

/**
 * @project crypto
 * @author jhat
 * @email cpf624@126.com
 * @date Jan 29, 20135:44:47 PM
 */
public class CryptoException extends RuntimeException {
	
	private static final long	serialVersionUID	= -2050498475123167672L;
	
	public CryptoException() {
		super();
	}
	
	public CryptoException(String message) {
		super(message);
	}
	
	public CryptoException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CryptoException(Throwable cause) {
		super(cause);
	}
}
