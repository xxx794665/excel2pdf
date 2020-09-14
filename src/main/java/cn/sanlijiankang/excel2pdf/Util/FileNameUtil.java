package cn.sanlijiankang.excel2pdf.Util;

/**
 * Created by xxeNt
 * On 2020-09-14
 * Description:获取文件名前缀/后缀
 */
public class FileNameUtil {
    /**
     * 获取文件名前缀
     *
     * @param fileName 文件目录
     * @return String 文件名前缀
     */
    public static String getFilePrefix(String fileName) {
        if (fileName == null || "".equals(fileName)) {
            return null;
        }
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    /**
     * 获取文件名后缀
     *
     * @param fileName 文件目录
     * @return String 文件名后缀
     */
    public static String getFileSufix(String fileName) {
        if(fileName == null || "".equals(fileName)){
            return null;
        }
        return fileName.substring(fileName.lastIndexOf(".")+1);//从最后一个点之后截取字符串
    }
}
