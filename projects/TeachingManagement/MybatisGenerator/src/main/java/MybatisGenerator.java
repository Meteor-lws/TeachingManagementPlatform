import org.apache.ibatis.io.Resources;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Mybatis数据库逆向
 *
 * Created by lws on 2017/4/8.
 */
public class MybatisGenerator {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("MybatisGenerator");
        try (InputStream configStream = Resources.getResourceAsStream("generator.xml")) {
            List<String> warnings = new ArrayList<>();
            ConfigurationParser parser = new ConfigurationParser(warnings);
            Configuration config = parser.parseConfiguration(configStream);
            DefaultShellCallback callback = new DefaultShellCallback(true);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            System.out.println(configStream);
        } catch (IOException e) {
            logger.error("配置文件加载失败");
        } catch (XMLParserException e) {
            logger.error("配置文件解析失败");
        } catch (InterruptedException e) {
            logger.error("数据库逆向异常中断");
        } catch (InvalidConfigurationException e) {
            logger.error("配置文件存在非法配置");
        } catch (SQLException e) {
            logger.error("SQL语句执行失败");
        }
    }
}
