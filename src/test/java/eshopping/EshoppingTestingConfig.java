package eshopping;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.config.MysqldConfig;
import com.wix.mysql.distribution.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Arrays;

import static com.wix.mysql.ScriptResolver.classPathFile;

@EnableAutoConfiguration
@EnableTransactionManagement
@ComponentScan("eshopping.*")
@Configuration
//@ImportResource({"file:**/WEB-INF/applicationContext.xml","/applicationContextTest.xml"})
public class EshoppingTestingConfig {
//    @Bean
//    @Primary
//    DataSource dataSourceFromEmbededDB() throws IOException {
//        MysqldConfig config = startEmbeddedMySql();
//
//        MysqlDataSource mysqlDS = new MysqlDataSource();
//        mysqlDS.setPort(config.getPort());
//        mysqlDS.setUser(config.getUsername());
//        mysqlDS.setPassword(config.getPassword());
//        mysqlDS.setDatabaseName("eshoopingtest");
//
//        return mysqlDS;
//    }
//
//    private MysqldConfig startEmbeddedMySql() throws IOException {
//        MysqldConfig mysqldConfig = MysqldConfig.aMysqldConfig(Version.v5_6_latest)
//                .withPort(2215)
//                .withUser("minhsang", "admin")
//                .build();
//
//        EmbeddedMysql embeddedMysql = EmbeddedMysql.anEmbeddedMysql(mysqldConfig)
//                .addSchema("eshoopingtest", classPathFile("create.sql"))
//                .start();
//
//        return embeddedMysql.getConfig();
//    }
}
