import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;

/**
 * Mybatis数据库逆向
 *
 * Created by lws on 2017/4/8.
 */
public class MybatisGenerator {
    public static void main(String[] args) {
        try (InputStream configStream = Resources.getResourceAsStream("generator.xml")) {
            System.out.println(configStream);
        } catch (IOException e) {
            System.out.println("配置文件加载失败");
        }
    }
}
