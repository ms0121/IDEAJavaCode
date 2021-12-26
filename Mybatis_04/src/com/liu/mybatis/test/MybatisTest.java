package com.liu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.liu.mybatis.bean.Employee;
import com.liu.mybatis.dao.EmployeeMapper;
import org.junit.Test;

import javax.xml.bind.annotation.XmlAnyAttribute;

public class MybatisTest {

	 // ֱ�ӷ���һ��session����
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        // ����xml�����ļ�(ȫ�������ļ�)����һ��SqlSessionFactory����
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }	
    
    /*
     * http://dist.springsource.com/release/TOOLS/update/e4.4/
     * �������棺
     * 		һ�����棨���ػ��棩��SQLSession����Ļ��棬һ��������һֱ������
     * 		�����ݿ�ͬ��ʻỰ�ڼ��ѯ�������ݻ���ڱ��ػ�����
     * 		�Ժ����Ҫ��ȡ��ͬ�����ݣ�ֱ�Ӵӻ�������ȡ��û��Ҫ��ȥ��ѯ���ݿ�
     * 
     * 		һ������ʧЧ�������û��ʹ��һ������������Ч�����ǣ�����Ҫ�������ݿⷢ����ѯ��Ϣ
     * 			1. SQLSession��ͬ
     * 			2. SQLSession��ͬ����ѯ������ͬ����ǰ��һ��������û��������ݣ�
     * 			3. SQLSession��ͬ�����β�ѯ֮��ִ������ɾ�Ĳ�Ĳ�������ε���ɾ�Ĳ�Ե�ǰ������Ӱ��
     * 			4. SQLSession��ͬ�������ֶ��������һ�����棨���汻��գ�
     * 
     * 		�������棨ȫ�ֻ��棩������namespace����Ļ��棬һ��namespace��Ӧ��һ����������
     * 		�������ƣ�
     * 			1. һ���Ự����ѯһ��������Ϣ������������ľͻᱻ���ڵ�ǰ�Ự��һ��������
     * 			2. ����Ự�رգ�һ�������е����ݾͻᱻ���浽���������У��µĻỰ��ѯ��Ϣ���Ϳ��Բ��ն����������
     * 			3.SQLSession == EmployeeMapper  == Employee
     * 			��ͬ��namespace��������ݻ�����Լ���Ӧ�Ļ�����
     * 		Ч�������ݻ�Ӷ��������н��л�ȡ
     * 			��������ݶ��ᱻĬ���ȷ���һ��������
     * 			ֻ�лỰ�ύ���߹ر�֮��һ�������е����ݲŻ�ת�Ƶ�����������
     * 			
     * 	ʹ�ã�
     * 		1.����������������<cache eviction="FIFO" flushInterval="60000"></cache>
     * 		2. ȥMapper.xml������ʹ��
     * 		3. ���ǵ�pojo��Ҫʵ�����л��ӿ�
     */

    // ʵ����������Ĳ���
    @Test
    public void testBatch() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // ��ȡ������SQLSession����
        SqlSession openSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        openSession.close();
//        long start = System.currentTimeMillis();
//        try {
//            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
//            mapper.addEmp(new Employee("zhansgan", 'w',"8983@qq.om"));
//            System.out.println("����ɹ�");
//        } finally {
//            openSession.close();
//        }

    }



    // ʵ�ַ�ҳ�Ĺ���
    @Test
    public void testPage() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            // ʵ�ַ�ҳ�Ĺ��ܣ�ʹ��pageHeader,�����ֱ��ǣ���ʼҳ��ÿҳ������
            Page<Object> page = PageHelper.startPage(3, 1);

            // ��������Ա����Ϣ
            List<Employee> empList = mapper.getEmpList();
            // ����ȡ�����ݽ��з�װ
//            PageInfo<Employee> info = new PageInfo<>(empList);

            // ����Ҫ������ʾ��ҳ
            // ʵ�ָ��õķ�ҳ�߼�
            PageInfo<Employee> info = new PageInfo<>(empList, 3);

            for (Employee employee : empList) {
                System.out.println("employee = " + employee);
            }

//            System.out.println("��ǰҳ���� = " + page.getPageNum());
//            System.out.println("�ܼ�¼�� = " + page.getTotal());
//            System.out.println("ÿҳ�ļ�¼�� = " + page.getPageSize());
//            System.out.println("��ҳ�� = " + page.getPages());

            System.out.println("��ǰҳ���� = " + info.getPageNum());
            System.out.println("�ܼ�¼�� = " + info.getTotal());
            System.out.println("ÿҳ�ļ�¼�� = " + info.getPageSize());
            System.out.println("��ҳ�� = " + info.getPages());
            System.out.println("�Ƿ��ǵ�һҳ = " + info.isIsFirstPage());

            System.out.println("========��ҳ�߼�========");
            int[] nums = info.getNavigatepageNums();
            for (int num : nums) {
                System.out.println("num = " + num);
            }

        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void test1() throws IOException {
        // ֱ�ӻ�ȡһ��sqlSessionFactory����
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2.��ȡSQLSession����,û�в���������������Զ��ύ������Ϣ
        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println("sqlSession = " + sqlSession);

        // ��ȡ�ӿڵ�ʵ�������
        try {
            // ��Ϊ�ӿ��Զ��Ĵ���һ��������󣬴������(��������EmployeeDao��ʵ����)ȥִ����ɾ�Ĳ�ķ���
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            // ʵ����ȥ���ò������ݵķ���
            // ��ѯԱ��
            Employee employee = mapper.getEmpById(2);
            System.out.println("employee = " + employee);
            Employee employee2 = mapper.getEmpById(2);
            System.out.println(employee2);
            System.out.println(employee==employee2);

        } finally{
        	sqlSession.close();
        }
    }
    
}
