package kr.or.ddit.ibatis.config;

import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {

	private static SqlMapClient smc;

	static {
		try {
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);

			Reader rd = Resources
					.getResourceAsReader("kr/or/ddit/ibatis/config/sqlMapConfig.xml");

			smc = SqlMapClientBuilder.buildSqlMapClient(rd);

			rd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlMapClient getClient() {
		return smc;
	}

}
