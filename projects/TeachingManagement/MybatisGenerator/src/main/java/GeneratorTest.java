import javax.security.auth.login.Configuration;
import java.io.IOException;
import java.io.InputStream;
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
        }
    }
}
