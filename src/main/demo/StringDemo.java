public class StringDemo {
    public static void main(String[] args) {
        String s = "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈晗哈哈哈哈哈哈哈哈哈哈哈晗哈哈哈哈哈哈哈晗哈哈哈哈哈哈哈哈哈晗哈哈哈哈哈哈哈哈哈晗哈哈哈哈哈哈哈哈晗哈哈哈哈哈哈哈哈哈哈晗哈哈哈哈哈哈哈哈哈哈哈晗哈哈哈哈哈哈哈哈哈哈哈哈哈";
        char[] sArray = s.toCharArray();
        boolean all = true;
        for (int i = 0; i < sArray.length; i++) {
            char ha = '哈';
            if (ha != sArray[i]) {
                System.out.println("第" + i + "个字不是哈，是" + sArray[i]);
                all = false;
            }
        }
        if (all) System.out.println("没有不同，你逗我呢？！");
    }
}
