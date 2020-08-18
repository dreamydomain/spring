import org.apache.logging.log4j.util.Strings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class KOSSTest1 {
    public static void main(String[] args) throws Exception {
        testG1();
    }

    private static void testG1() throws Exception {
        Class.forName("org.postgresql.Driver");

        Connection conn = DriverManager.getConnection("jdbc:postgresql://c7-db.koss.leandev.cn:5432/kossadmin", "postgres", "postgres");
        Statement state = conn.createStatement();
        ResultSet rs = state.executeQuery("select id from users where serverinstance = 'g1'");
        StringBuilder inIds = new StringBuilder(Strings.EMPTY);
        while (rs.next()) {
            inIds.append(rs.getLong(1)).append(",");
        }
        String inSql = inIds.substring(0, inIds.length() - 1);
        rs.close();
        state.close();
        conn.close();

        String sql2 = "select * from (select userid,company_id,count(1) as count_num from ManagedCompanySetting GROUP BY userid,company_id) as tb where count_num > 1 and userid in (" + inSql + ")";
        for (int i = 1; i <= 400; i++) {
            String db = "koss" + i;
            Connection connDB2 = DriverManager.getConnection("jdbc:postgresql://c7-db.koss.leandev.cn:5432/" + db, "postgres", "postgres");
            Statement state2 = connDB2.createStatement();
            ResultSet rs2 = state2.executeQuery(sql2);
            int resultIndex = 0;
            while (rs2.next()) {
                if (resultIndex == 0) {
                    System.out.println("______________________________________________________");
                    System.out.println(db);
                    System.out.println("userid             | companyid          | num");
                }
                long col01 = rs2.getLong(1);
                long col02 = rs2.getLong(2);
                long col03 = rs2.getLong(3);
                System.out.println(col01 + " | " + col02 + " | " + col03);
                resultIndex++;
            }
            rs2.close();
            state2.close();
            connDB2.close();
        }
    }

    private static void testG3() throws Exception {
        Class.forName("org.postgresql.Driver");

        Connection conn = DriverManager.getConnection("jdbc:postgresql://c7-db.koss.leandev.cn:5432/kossadmin", "postgres", "postgres");
        Statement state = conn.createStatement();
        ResultSet rs = state.executeQuery("select id from users where serverinstance = 'g3'");
        StringBuilder inIds = new StringBuilder(Strings.EMPTY);
        while (rs.next()) {
            inIds.append(rs.getLong(1)).append(",");
        }
        String inSql = inIds.substring(0, inIds.length() - 1);
        rs.close();
        state.close();
        conn.close();

        String sql2 = "select * from (select userid,company_id,count(1) as count_num from ManagedCompanySetting GROUP BY userid,company_id) as tb where count_num > 1 and userid in (" + inSql + ")";
        for (int i = 201; i <= 400; i++) {
            String db = "koss" + i;
            Connection connDB2 = DriverManager.getConnection("jdbc:postgresql://c7-db2.koss.leandev.cn:5432/" + db, "postgres", "postgres");
            Statement state2 = connDB2.createStatement();
            ResultSet rs2 = state2.executeQuery(sql2);
            int resultIndex = 0;
            while (rs2.next()) {
                if (resultIndex == 0) {
                    System.out.println("______________________________________________________");
                    System.out.println(db);
                    System.out.println("userid             | companyid          | num");
                }
                long col01 = rs2.getLong(1);
                long col02 = rs2.getLong(2);
                long col03 = rs2.getLong(3);
                System.out.println(col01 + " | " + col02 + " | " + col03);
                resultIndex++;
            }
            rs2.close();
            state2.close();
            connDB2.close();
        }
    }

}
