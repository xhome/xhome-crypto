package org.xhome.crypto;

import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/**
 * @project crypto
 * @author jhat
 * @email cpf624@126.com
 * @date Jan 29, 20136:21:56 PM
 */
public final class DES extends AbstractCrypto {
	
	private Key		k;
	private Cipher	cipher;
	
	public DES(String key) {
		super(key);
	}
	
	@Override
	protected void init() {
		try {
			cipher = Cipher.getInstance("DES");
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	@Override
	protected void generateKey() {
		try {
			KeyGenerator g = KeyGenerator.getInstance("DES");
			g.init(new SecureRandom(key.getBytes()));
			k = g.generateKey();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	@Override
	public String encrypt(String data) {
		try {
			cipher.init(Cipher.ENCRYPT_MODE, k);
			return Base64.encodeBytes(cipher.doFinal(data.getBytes()));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	@Override
	public String decrypt(String data) {
		try {
			cipher.init(Cipher.DECRYPT_MODE, k);
			return new String(cipher.doFinal(Base64.decode(data)));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
}
