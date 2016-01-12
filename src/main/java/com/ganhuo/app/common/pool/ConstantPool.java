package com.ganhuo.app.common.pool;

/**
 * <h2>自定义常量属性池</h2>
 * <dl>
 * <dt>功能描述</dt>
 * <dd>无</dd>
 * <dt>本系统中所用到的常量值都统一在这里进行配置</dt>
 * <dt>使用规范</dt>
 * <dd>在此配置的常量属性值应该是静态不可修改的，如果不符合这两个条件那么请将到resources/config-pool.properties中配置你要的
 * 属性。在程序中反复使用且二次变动性较小的常量属性可以在本类中配置，从而可以避免重复命名提高程序可维护性</dd>
 * </dl>
 * @version V1.0
 * @date 2016年1月11日 下午2:49:38 
 * @author lt
 */
public class ConstantPool {
	
	 /**
     * 系统配置文件所在相对路径名称
     */
	public static final String KEY_WORD_FILE_NAME = "keyword-pool.txt";
	
	/**
     * 替换字符，用来在检测到敏感字符后进行替换
     */
    public static final String REPLACEMENT_CHARACTER = "*";

    /**
     * 在客户端请求中的令牌标识
     */
    public final static String REQUEST_TOKEN = "request_token";
    
	/**
	 * 在session中的token值
	 */
	public static final String SESSION_TOKEN = "session_token";
}
