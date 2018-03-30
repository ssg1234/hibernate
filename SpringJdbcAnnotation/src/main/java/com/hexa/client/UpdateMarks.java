	package com.hexa.client;
	import java.util.List;
	import java.util.Map;

	import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

	import com.hexa.dao.IDao;


	public class UpdateMarks {
		private static ApplicationContext ctx;
		static{
			
			ctx = new AnnotationConfigApplicationContext(JdbcConfig.class);
		}

		public static void main(String[] args) {
			System.out.println("inside main");
			IDao dao = ctx.getBean("mydao", IDao.class);
			int rows = dao.updateMarks(1002, 94);
			System.out.println("no of rows affected"+ rows);
			
			
			
			System.out.println("find by student Id");
			Map<String, Object> map1 =dao.getStudentAsMap(1002);
			System.out.println(map1.get("stu_id"));
			System.out.println(map1.get("stu_name"));
			System.out.println(map1.get("stu_marks"));
			System.out.println(map1.get("dept"));
			System.out.println(map1.get("stu_dob"));
			System.out.println("********************************");
			System.out.println("-------------------------------");
			
			
		}
	}


