import org.apache.ibatis.io.Resources;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

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
        try (InputStream configStream = Resources.getResourceAsStream("generator.xml")) {
            List<String> warnings = new ArrayList<>();
            ConfigurationParser parser = new ConfigurationParser(warnings);
            Configuration config = parser.parseConfiguration(configStream);
            DefaultShellCallback callback = new DefaultShellCallback(true);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (IOException e) {
            System.err.println("配置文件加载失败:" + e);
        } catch (XMLParserException e) {
            System.err.println("配置文件解析失败:" + e);
        } catch (InterruptedException e) {
            System.err.println("数据库逆向异常中断:" + e);
        } catch (InvalidConfigurationException e) {
            System.err.println("配置文件存在非法配置:" + e);
        } catch (SQLException e) {
            System.err.println("SQL语句执行失败:" + e);
        }
    }
}
