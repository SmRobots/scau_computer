package cn.net.smrobot;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 分析源文件的控制层代码
 * @author smrobot
 */
public class Controller {

    /**
     * 保存读取结果
     */
    private static StringBuffer resultString;

    /**
     * 所有的行数
     */
    private static int totalLines;

    /**
     * 所有的空行
     */
    private static int totalBlank;

    /**
     * 所有的字节数
     */
    private static int totalBytes;

    /**
     * 所有的源文件的数量
     */
    private static int totalSourceFile;

    /**
     * 每一行的空格数
     */
    private static int tabCount;


    /**
     * 分析目录中的所有源程序中的内容
     * @param path 目录在磁盘中的路径
     * @return 如果该目录不存在则返回false，否则分析完结果后返回true
     */
    public static boolean analysisDirectory(String path) {
        // 每次统计文件则初始化化数据
        resultString = new StringBuffer();
        totalLines = 0;
        totalBlank = 0;
        totalSourceFile = 0;
        totalBytes = 0;
        tabCount = 0;

        File file = new File(path);
        if (!file.exists() || !file.isDirectory()) {
            // 如果不是目录或者目录不存在则返回false
            return false;
        }
        File[] files = file.listFiles();
        resultString.append("[").append(file.getAbsolutePath()).append("] Result\n\n");
        resultString.append("Files Detail:\n");
        resultString.append("+").append(file.getName()).append("\n");
        analysisSearch(files);
        resultString.append("\nTotal:\n");
        resultString.append("\t").append(totalSourceFile).append(" Java File\n");
        resultString.append("\t").append(totalLines).append(" lines in files\n");
        resultString.append("\t").append(totalBlank).append(" blank lines\n");
        resultString.append("\t").append(totalBytes).append(" bytes\n");
        writeAnalysis(file.getName());
        return true;
    }

    /**
     * 递归遍历所有目录
     */
    private static void analysisSearch(File[] files) {
        // 先将文件进行排序
        sort(files);
        tabCount++;
        for (File file : files ) {
            if (file.isDirectory()) {
                String tabs = "";
                // 目录则进行递归遍历
                for (int i = 0; i < tabCount; i++) {
                    tabs += "\t";
                }
                resultString.append(tabs).append("+").append(file.getName()).append("\n");
                analysisSearch(file.listFiles());
            }
            // 如果是文件则判断是否是java的源文件
            if (file.getName().endsWith(".java")) {
                String resultItem = analysisSourceFile(file);
                resultString.append(resultItem);
            }
        }
        tabCount--;

    }

    /**
     * 将文件进行排序，文件夹在前，文件在后面，升序排序
     * @param files
     */
    private static void sort(File[] files) {
        List<File> directoryList = new ArrayList<>();
        List<File> fileList = new ArrayList<>();
        for (File file : files) {
            if (file.isDirectory()) {
                directoryList.add(file);
            }
            if (file.isFile()) {
                fileList.add(file);
            }
        }
        directoryList.sort(((o1, o2) -> o1.getName().compareTo(o2.getName())));
        fileList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        directoryList.addAll(fileList);
        directoryList.toArray(files);
    }

    /**
     * 分析源文件
     * @param file
     * @return 返回分析结果的字符串
     */
    private static String analysisSourceFile(File file) {
        totalSourceFile++;
        int lines = 0;
        int blanks = 0;
        int bytes = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            while (bufferedReader.ready()) {
                // 读取一行数据
                String line = bufferedReader.readLine();
                lines++;
                totalLines++;
                if (line.equals("")) {
                    // 空白行
                    blanks++;
                    totalBlank++;
                }
                // 字节数将最后的换行给加上
                bytes += line.getBytes().length + 1;
                totalBytes += line.getBytes().length + 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 计算tab位置
        String tabs = "";
        for (int i = 0; i < tabCount; i++) {
            tabs += "\t";
        }
        String resultItem =  tabs + "-" + file.getName();
        resultItem += "\tTotal:\t" + lines + ",Blank:\t" + blanks + ",\t" + bytes + "bytes\n";
        return resultItem;
    }

    /**
     * 讲文件分析结果写入文件中
     */
    private static void writeAnalysis(String directoryName) {
        String path = "result/" + directoryName + ".txt";
        File file =  new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 将内容写入文件中
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            String result = resultString.toString();
            bufferedWriter.write(result);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断是否有分析结果
     * @return
     */
    public static boolean hasResult() throws FileNotFoundException {
        File file = new File("result");
        if (!file.exists()) {
            throw new FileNotFoundException("result文件目录不存在");
        }
        if (file.listFiles().length == 0) {
            return false;
        }
        return true;
    }

    /**
     * 获取文件所有的分析结果
     * @return
     */
    public static File[] getAllAnalysis() throws FileNotFoundException {
        File file = new File("result");
        if (!file.exists()) {
            throw new FileNotFoundException("result文件目录不存在");
        }
        return file.listFiles();
    }

    /**
     * 显示文件结果
     * @param file
     */
    public static String showAnalysis(File file) {
        StringBuffer result = new StringBuffer();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.ready()) {
                result.append(bufferedReader.readLine());
                result.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
