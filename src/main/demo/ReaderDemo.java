import com.horace.spring.common.utils.StringUtil;

import java.io.*;

public class ReaderDemo {
    public static void main(String[] args) throws IOException {
        File txtFile = new File("e:/a.txt");
        InputStream is = new FileInputStream(txtFile);
        InputStreamReader reader = new InputStreamReader(is, "GBK");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String lineTxt;
        StringBuilder outString = new StringBuilder();
        while ((lineTxt = bufferedReader.readLine()) != null) {
            lineTxt = lineTxt.replace(" ", "").replace("\t", "");
            if (StringUtil.isNotNullOrEmpty(lineTxt)) {
                String[] temp = StringUtil.splitByLength(lineTxt, 30);
                for (int i = 0; i < temp.length; i++) {
                    outString.append(temp[i]);
                    outString.append("\r\n");
                }
            }
        }
        bufferedReader.close();
        reader.close();
        is.close();
        //out file
        File outFile = new File("e:/b.txt");
        if (outFile.exists()) {
            outFile.delete();
        }
        outFile.createNewFile();
        FileWriter fileWriter = new FileWriter(outFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fileWriter);
        bw.write(outString.toString());
        bw.close();
        fileWriter.close();
    }
}
