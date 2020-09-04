import com.horace.spring.common.utils.StringUtil;

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
        String sql2 = "select userid,company_id,count(1) as count_num from ManagedCompanySetting GROUP BY userid,company_id having count(1) > 1";
        for (int i = 1; i <= 400; i++) {
            if (i == 25 || (i >= 57 && i <= 60)) {
                continue;
            }
            String db = "koss" + i;
            System.out.println(db);
            Connection connDB2 = DriverManager.getConnection("jdbc:postgresql://c7-db.koss.leandev.cn:5432/" + db, "postgres", "postgres");
            Statement state2 = connDB2.createStatement();
            ResultSet rs2 = state2.executeQuery(sql2);
            int resultIndex = 0;
            String inSettingIds = "";
            while (rs2.next()) {
                if (resultIndex == 0) {
                    System.out.println("userid | companyid | num ");
                }
                long col01 = rs2.getLong(1);
                long col02 = rs2.getLong(2);
                long col03 = rs2.getLong(3);
                System.out.println(col01 + " | " + col02 + " | " + col03);
                Statement stateIds = connDB2.createStatement();
                ResultSet ids = stateIds.executeQuery("select id from ManagedCompanySetting where userid = " + col01 + " and company_id = " + col02);
                int idsInt = 0;
                while (ids.next()) {
                    if (idsInt > 0) {
                        inSettingIds += (ids.getLong(1) + ",");
                    }
                    idsInt++;
                }
                ids.close();
                stateIds.close();
                resultIndex++;
            }
            if (StringUtil.isNotNullOrEmpty(inSettingIds)) {
                String delSql = "delete from ManagedCompanySetting where id in (" + inSettingIds.substring(0, inSettingIds.length() - 1) + ")";
                System.out.println(delSql);
                connDB2.createStatement().execute(delSql);
            }
            rs2.close();
            state2.close();
            connDB2.close();
            System.out.println("---------------------------------------------");
        }
    }

    private static void testG2() throws Exception {
        Class.forName("org.postgresql.Driver");
        String sql2 = "select userid,company_id,count(1) as count_num from ManagedCompanySetting GROUP BY userid,company_id having count(1) > 1";
        Connection connDB2 = DriverManager.getConnection("jdbc:postgresql://c7-db2.koss.leandev.cn:5432/koss1_os", "postgres", "postgres");
        Statement state2 = connDB2.createStatement();
        ResultSet rs2 = state2.executeQuery(sql2);
        String inSettingIds = "";
        while (rs2.next()) {
            long col01 = rs2.getLong(1);
            long col02 = rs2.getLong(2);
            long col03 = rs2.getLong(3);
            System.out.println(col01 + " | " + col02 + " | " + col03);
            Statement stateIds = connDB2.createStatement();
            ResultSet ids = stateIds.executeQuery("select id from ManagedCompanySetting where userid = " + col01 + " and company_id = " + col02);
            int idsInt = 0;
            while (ids.next()) {
                if (idsInt > 0) {
                    inSettingIds += (ids.getLong(1) + ",");
                }
                idsInt++;
            }
            ids.close();
            stateIds.close();
        }
        if (StringUtil.isNotNullOrEmpty(inSettingIds)) {
            String delSql = "delete from ManagedCompanySetting where id in (" + inSettingIds.substring(0, inSettingIds.length() - 1) + ")";
            System.out.println(delSql);
            connDB2.createStatement().execute(delSql);
        }
        rs2.close();
        state2.close();
        connDB2.close();
    }

    private static void testG3() throws Exception {
        Class.forName("org.postgresql.Driver");
        String sql2 = "select userid,company_id,count(1) as count_num from ManagedCompanySetting GROUP BY userid,company_id having count(1) > 1";
        for (int i = 201; i <= 240; i++) {
            String db = "koss" + i;
            System.out.println(db);
            Connection connDB2 = DriverManager.getConnection("jdbc:postgresql://c7-db2.koss.leandev.cn:5432/" + db, "postgres", "postgres");
            Statement state2 = connDB2.createStatement();
            ResultSet rs2 = state2.executeQuery(sql2);
            int resultIndex = 0;
            String inSettingIds = "";
            while (rs2.next()) {
                if (resultIndex == 0) {
                    System.out.println("userid | companyid | num ");
                }
                long col01 = rs2.getLong(1);
                long col02 = rs2.getLong(2);
                long col03 = rs2.getLong(3);
                System.out.println(col01 + " | " + col02 + " | " + col03);
                Statement stateIds = connDB2.createStatement();
                ResultSet ids = stateIds.executeQuery("select id from ManagedCompanySetting where userid = " + col01 + " and company_id = " + col02);
                int idsInt = 0;
                while (ids.next()) {
                    if (idsInt > 0) {
                        inSettingIds += (ids.getLong(1) + ",");
                    }
                    idsInt++;
                }
                resultIndex++;
                ids.close();
                stateIds.close();
            }
            if (StringUtil.isNotNullOrEmpty(inSettingIds)) {
                String delSql = "delete from ManagedCompanySetting where id in (" + inSettingIds.substring(0, inSettingIds.length() - 1) + ")";
                System.out.println(delSql);
                connDB2.createStatement().execute(delSql);
            }
            System.out.println("---------------------------------------------");
            rs2.close();
            state2.close();
            connDB2.close();
        }
    }

}
