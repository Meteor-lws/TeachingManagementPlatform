import java.io.IOException;
import java.io.InputStream;

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
        try (InputStream resourceStream = this.getClass().getClassLoader().getResourceAsStream("generatorConfig.xml")) {
            System.out.println(resourceStream);
        } catch (IOException e) {
            System.out.println("加载配置文件失败");
        }
    }
}
