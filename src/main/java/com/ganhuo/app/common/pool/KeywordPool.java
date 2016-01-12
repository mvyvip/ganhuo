package com.ganhuo.app.common.pool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * <h2>特殊敏感字符读取池</h2>
 * <dl>
 * <dt>功能描述</dt>
 * <dd>从keyword-pool.txt文件中缓存数据</dd>
 * <dt>使用规范</dt>
 * <dd>无</dd>
 * </dl>
 * @version V1.0
 * @date 2016年1月11日 下午2:22:04 
 * @author lt
 */
public class KeywordPool {
	public static List<String> keys = new ArrayList<>();
	
	private KeywordPool() {}
	
	static {
		String path = KeywordPool.class.getClassLoader().getResource(ConstantPool.KEY_WORD_FILE_NAME).getFile();
		try {
			keys = FileUtils.readLines(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
