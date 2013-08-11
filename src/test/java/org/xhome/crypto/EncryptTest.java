package org.xhome.crypto;

import org.junit.Test;

/**
 * @project crypto
 * @author jhat
 * @email cpf624@126.com
 * @date Jan 29, 20136:13:55 PM
 */
public class EncryptTest {
	
	@Test
	public void testMD5() {
		AbstractDigest e = new MD5();
		System.out.println(e.encrypt("1"));
		AbstractDigest e1 = new SHA1();
		System.out.println(e.encrypt(e1.encrypt("adasdf")));
	}
	
	@Test
	public void testSHA() {
		AbstractDigest e = new SHA();
		System.out.println(e.encrypt("adasdf"));
	}
	
	@Test
	public void testSHA1() {
		AbstractDigest e = new SHA1();
		System.out.println(e.encrypt("adasdf"));
	}
	
	@Test
	public void testDES() {
		String key = "abc";
		AbstractCrypto e = new DES(key);
		String encrypt = e.encrypt("adasdf");
		System.out.println(e.decrypt(encrypt) + "\t" + encrypt);
	}
	
	@Test
	public void testAES() {
		String key = "0123456789123456";
		AbstractCrypto e = new AES(key);
		String encrypt = e.encrypt("adasdf");
		System.out.println(e.decrypt(encrypt) + "\t" + encrypt);
	}
	
	@Test
	public void testBase64() {
		System.out.println(Base64.encodeBytes("abc".getBytes()));
	}
	
}
