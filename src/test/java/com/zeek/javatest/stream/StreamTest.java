import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        // 生成Stream中用来遍历的5个测试数据
        Stream<String> stream = Stream.of("Java", "Python", "C++", "JavaScript", "Go");
        stream.map(String::toUpperCase) // 将每个字符串转换为大写
                .peek(e -> System.out.println("map peek=====>" + e))
                .sorted()
                .forEach(e -> System.out.println("foreach -->" + e)); // 遍历并打印每个元素
    }
}