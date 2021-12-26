import com.jd.JdApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author lms
 * @date 2021-11-04 - 21:53
 */

@SpringBootTest(classes = JdApplication.class)
public class BootSqlApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {

        //查看默认数据源 class com.zaxxer.hikari.HikariDataSource
        System.out.println(dataSource.getClass());

        // pom导入Druid，配置文件加入type: com.alibaba.druid.pool.DruidDataSource
        // 数据源就改变了 ：class com.alibaba.druid.pool.DruidDataSource

        //获取数据库连接
        System.out.println(dataSource.getConnection());
        System.out.println(dataSource);
    }
}
