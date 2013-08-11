package org.xhome.crypto;

/**
 * @project crypto
 * @author jhat
 * @email cpf624@126.com
 * @date Jan 29, 20136:24:25 PM
 */
public abstract class AbstractCrypto implements Encrypt, Decrypt {
	
	protected String	key;
	
	public AbstractCrypto(String key) {
		this.init();
		this.updateKey(key);
	}
	
	/**
	 * 初始化
	 */
	protected abstract void init();
	
	/**
	 * 生成密匙
	 */
	protected abstract void generateKey();
	
	public void updateKey(String key) {
		this.key = key;
		this.generateKey();
	}
	
	public String getKey() {
		return key;
	}
	
}
