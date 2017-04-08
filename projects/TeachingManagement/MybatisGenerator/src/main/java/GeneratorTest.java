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
 * 数据库逆向测试
 *
 * Created by lws on 2017/4/7.
 */
public class GeneratorTest {
    public static void main(String[] args) {
        GeneratorTest generatorTest = new GeneratorTest();
        generatorTest.generate();
    }

    private void generate() {
        try (InputStream configStream = this.getClass().getClassLoader().getResourceAsStream("generatorConfig.xml")) {
            List<String> warnings = new ArrayList<>();
            ConfigurationParser parser = new ConfigurationParser(warnings);
            Configuration config = parser.parseConfiguration(configStream);
            DefaultShellCallback callback = new DefaultShellCallback(true);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (IOException e) {
            System.out.println("加载配置文件失败");
        } catch (XMLParserException e) {
            System.out.println("配置文件解析失败");
        } catch (InterruptedException e) {
            System.out.println("进程被异常中断");
        } catch (InvalidConfigurationException e) {
            System.out.println("存在不合法配置");
        } catch (SQLException e) {
            System.out.println("SQL语句执行异常");
        }
    }
}
