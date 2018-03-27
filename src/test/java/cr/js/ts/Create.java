package cr.js.ts;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

import cr.mapper.T_MALL_CLASS_1_mapper;
import cr.pojo.T_MALL_CLASS_1;

class Create {

	@Test
	void test() throws IOException {

		// 获取sqlSessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 获取session
		SqlSession session = sqlSessionFactory.openSession();
		// 获取mapper
		T_MALL_CLASS_1_mapper class_1_mapper = session.getMapper(T_MALL_CLASS_1_mapper.class);
		// 操作获取数据
		List<T_MALL_CLASS_1> class1list = class_1_mapper.getList();
		System.out.println(class1list.size());
		// 创建gson对象
		Gson gson = new Gson();
		// 转json
		String class1str = gson.toJson(class1list);

		// 生成静态文件
		FileOutputStream out = new FileOutputStream("e:/class_1.js");
		out.write(class1str.getBytes());
		out.close();
	}

}
