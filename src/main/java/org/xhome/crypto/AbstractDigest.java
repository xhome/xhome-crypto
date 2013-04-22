package org.xhome.crypto;

import java.security.MessageDigest;

/**
 * @project crypto
 * @author jhat
 * @email cpf624@126.com
 * @date Jan 29, 20135:51:30 PM
 */
public abstract class AbstractDigest implements Encrypt {
	
	protected MessageDigest	digest;
	
	protected AbstractDigest(String algorithm) {
		try {
			digest = MessageDigest.getInstance(algorithm);
		} catch (Exception e) {
			throw new CryptoException("unknown encrypt algorithm " + algorithm);
		}
	}
	
	@Override
	public String encrypt(String data) {
		return Base64.encodeBytes(digest.digest(data.getBytes()));
	}
	
}
