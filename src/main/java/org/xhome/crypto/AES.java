package org.xhome.crypto;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @project crypto
 * @author jhat
 * @email cpf624@126.com
 * @date Jan 29, 20136:35:52 PM
 */
public class AES extends AbstractCrypto {
	
	private Cipher			cipher;
	private IvParameterSpec	iv;
	private SecretKeySpec	spec;
	
	public AES(String key) {
		super(key);
	}
	
	@Override
	protected void init() {
		try {
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// "算法/模式/补码方式"
			iv = new IvParameterSpec("0102030405060708".getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
		} catch (Exception e) {
			throw new CryptoException(e.getMessage(), e);
		}
	}
	
	@Override
	protected void generateKey() {
		spec = new SecretKeySpec(key.getBytes(), "AES");
	}
	
	@Override
	public String encrypt(String data) {
		try {
			cipher.init(Cipher.ENCRYPT_MODE, spec, iv);
			return Base64.encodeBytes(cipher.doFinal(data.getBytes()));// 此处使用BASE64做转码功能，同时能起到2次加密的作用。
		} catch (Exception e) {
			throw new CryptoException(e.getMessage(), e);
		}
	}
	
	@Override
	public String decrypt(String data) {
		try {
			cipher.init(Cipher.DECRYPT_MODE, spec, iv);
			return new String(cipher.doFinal(Base64.decode(data)));// 先用base64解密
		} catch (Exception e) {
			throw new CryptoException(e.getMessage(), e);
		}
	}
	
	@Override
	public void updateKey(String key) {
		if (key == null || key.length() != 16) { throw new CryptoException(
				"AES key length must be 16 bytes"); }
		super.updateKey(key);
	}
	
}
