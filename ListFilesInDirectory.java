void main() {
    // 指定目录路径（可以改成你自己的）
    String path = "C:\\Users\\EODC\\AppData\\Local\\AMD_Common";

    listFiles(path);
}

public static void listFiles(String path) {
    File dir = new File(path);

    // 判断路径是否存在且是目录
    if (!dir.exists() || !dir.isDirectory()) {
        IO.println("路径无效或不是目录！");
        return;
    }

    // 获取当前目录下的所有文件和文件夹（不递归）
    File[] files = dir.listFiles();

    if (files == null) {
        IO.println("目录为空或无法访问！");
        return;
    }

    // 遍历并输出
    for (File file : files) {
        if (file.isDirectory()) {
            IO.println("[文件夹] " + file.getName());
        } else {
            IO.println("[文件] " + file.getName());
        }
    }
}
