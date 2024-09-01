package cn.tyy.demo1;

/*
* TODO
*  验证Java使用双字节编码，中文字符和英文字符都占 2 个字节
* */

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo1 {
    public static void main(String[] args) {
        /*
        * TODO
        *  GBK 编码中，中文字符占 2 个字节，英文字符占 1 个字节；
           UTF-8 编码中，中文字符占 3 个字节，英文字符占 1 个字节；
           UTF-16be 编码中，中文字符和英文字符都占 2 个字节。
        * */
        // 定义一些字符
        char englishChar = 'A';
        char chineseChar = '中';

        byte[] englishBytes = toBytes(englishChar);
        byte[] chineseBytes = toBytes(chineseChar);

        // 打印字节数组
        System.out.println("English Char UTF-16BE Bytes: " + bytesToHex(englishBytes));
        System.out.println("Chinese Char UTF-16BE Bytes: " + bytesToHex(chineseBytes));
    }
    private static byte[] toBytes(char c) {
        return new byte[] {
                (byte) ((c >> 8) & 0xFF),//获得高八位
                (byte) (c & 0xFF)//获得低八位
        };
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            /*
            * TODO
            *  %：这是格式说明符的开始。
               02：这是宽度说明符，表示格式化的结果应至少包含两位数字，不足时在前面补零。
               X：这是转换符，表示将整数格式化为大写的十六进制字符串。
            * */
            sb.append(String.format("%02X ", b));
            log.debug(String.format("%02X ", b));
        }
        return sb.toString().trim();//将最终结果末尾的空格去除
    }
}
