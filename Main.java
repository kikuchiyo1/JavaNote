import java.io.File;

public class Main {
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\EODC\\AppData\\Local\\Unity");

        File[] files = dir.listFiles();

        if (files != null) {
            System.out.println(dir.getPath());
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("[文件夹] " + file.getName());
                } else {
                    System.out.println("[文件] " + file.getName());
                }
            }
        }
    }
}




