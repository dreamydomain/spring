import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class KOSSTest1 {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://c7-db2.koss.leandev.cn:5432/";
        String userName = "postgres";
        String password = "postgres";
        String sql = "select * from (select userid,company_id,count(1) as count_num from ManagedCompanySetting GROUP BY userid,company_id) as tb where count_num > 1";
        for (int i = 1; i <= 400; i++) {
            String db = "koss" + i;
            test1(url, db, userName, password, sql);
        }
    }

    private static void test1(String url, String db, String userName, String password, String sql) throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(url + db, userName, password);
        Statement state = conn.createStatement();
        ResultSet rs = state.executeQuery(sql);
        System.out.println(db);
        while (rs.next()) {
            long col01 = rs.getLong(1);
            long col02 = rs.getLong(2);
            long col03 = rs.getLong(3);
            System.out.println(col01 + " | " + col02 + " | " + col03);
        }
        System.out.println("______________________________________________________");
        rs.close();
        state.close();
        conn.close();
    }
}
