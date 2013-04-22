package org.xhome.crypto;

/**
 * @project crypto
 * @author jhat
 * @email cpf624@126.com
 * @date Jan 29, 20136:10:20 PM
 */
public final class MD5 extends AbstractDigest {
	
	/**
	 * MD5加密 加密后的字符窜（32位）
	 */
	public MD5() {
		super("MD5");
	}
	
	@Override
	public String encrypt(String data) {
		return bytes2Hex(digest.digest(data.getBytes()));
	}
	
	/**
	 * 将二进制窜转化为字符窜
	 * 
	 * @param bytes
	 * @return
	 */
	private String bytes2Hex(byte[] bytes) {
		StringBuffer result = new StringBuffer();
		String temp = "";
		for (byte b : bytes) {
			temp = Integer.toHexString(b & 0xff);
			if (temp.length() == 1) result.append("0");
			result.append(temp);
		}
		return result.toString().toUpperCase();
	}
	
}
