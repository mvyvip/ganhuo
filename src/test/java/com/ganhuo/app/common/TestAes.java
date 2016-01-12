package com.ganhuo.app.common;

import org.junit.Test;

import com.ganhuo.app.common.Aes;

public class TestAes {

	String key = "362C1E982014B30D73DFCEAE0A";
	
	@Test
	public void testEncrypt() {
		//生成MySQL驱动信息
		System.out.println(Aes.parseByte2HexStr(Aes.encrypt("com.mysql.jdbc.Driver", key)));
		
		//生成本地数据库连接信息
		System.out.println(Aes.parseByte2HexStr(Aes.encrypt("jdbc:mysql:///ganhuo?useUnicode=true&characterEncoding=utf-8", key)));
		System.out.println(Aes.parseByte2HexStr(Aes.encrypt("root", key)));
		System.out.println(Aes.parseByte2HexStr(Aes.encrypt("admin", key)));
		
		//C36A87FA514DF299B8B372F4080CF710342F84277254F8A43D6AA35D80546723
		//A071761A7AB2B56358094B7A5CDED1D3A9DD45535A4075EA5B558F1196F7B8F816638FE7D72C6F15346A1B1D69C3FC6BDF45657428405D9249CC4D9D3FCBEBC3
		//8A74898D1FBC5828D005C8345912D506
		//CB17825590354BDE47397E9738FE9D9C
		
		//解密
		System.out.println(new String(Aes.decrypt(Aes.parseHexStr2Byte("C36A87FA514DF299B8B372F4080CF710342F84277254F8A43D6AA35D80546723"), key)));
		System.out.println(new String(Aes.decrypt(Aes.parseHexStr2Byte("A071761A7AB2B56358094B7A5CDED1D3A9DD45535A4075EA5B558F1196F7B8F816638FE7D72C6F15346A1B1D69C3FC6BDF45657428405D9249CC4D9D3FCBEBC3"), key)));
		System.out.println(new String(Aes.decrypt(Aes.parseHexStr2Byte("8A74898D1FBC5828D005C8345912D506"), key)));
		System.out.println(new String(Aes.decrypt(Aes.parseHexStr2Byte("CB17825590354BDE47397E9738FE9D9C"), key)));
	}
}
