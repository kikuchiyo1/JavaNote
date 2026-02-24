package 集合;

public class Properties相关 {
}

/*
Properties是Java中专门用来处理配置文件的类，以键值对的形式存储数据。
Java默认配置文件以.properties为扩展名，每行以key=value表示，以#课开头的是注释，一个典型的配置文件如下：
# setting.properties

last_open_file=/data/hello.txt
auto_save_interval=60

1.创建Properties对象
Properties props = new Properties();
2.加载配置文件
props.load(new FileInputStream("setting.properties"));
或者props.load(new java.io.FileInputStream(f));
注意：load()方法默认以ISO-8859-1编码读取文件，如果配置文件包含非ASCII字符（如中文），需要使用InputStreamReader指定编码：
prors.load(new FileReader("setting.properties", StandardCharsets.UTF_8));
3.获取属性值
String lastOpenFile = props.getProperty("last_open_file");
String autoSaveInterval = props.getProperty("auto_save_interval");
调用getProperty()方法获取value时，如果key不存在，则返回null。可以提供一个默认值：
String autoSaveInterval = props.getProperty("auto_save_interval", "30");
4.设置属性值与写入配置文件
props.setProperty("last_open_file", "/data/newfile.txt");
props.setProperty("auto_save_interval", "120");
props.store(new FileOutputStream("setting.properties"), "Updated settings");
先用setProperty()方法设置属性值，然后调用store()方法将修改后的属性写入配置文件。第二个参数是对配置文件的描述，会作为注释写入文件开头。
 */