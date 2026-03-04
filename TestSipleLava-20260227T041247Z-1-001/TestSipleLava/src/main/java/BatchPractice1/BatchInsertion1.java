package BatchPractice1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class Student {
    int idss;
    String namess;
    int agess;
    Student(int idss,String namess,int agess){
        this.idss=idss;
        this.namess=namess;
        this.agess=agess;
    }
}

public class BatchInsertion1 {

    public static void main(String[] args) throws Exception {

        List<Student> list = new ArrayList<>();
        list.add(new Student(1,"vishwa",24));
        list.add(new Student(2,"ram",29));
        list.add(new Student(3,"tom",33));
        list.add(new Student(4,"jhon",44));
        list.add(new Student(5,"tim",60));
        list.add(new Student(6,"heny",30));
        list.add(new Student(7,"ben",34));
        list.add(new Student(8,"bhen",55));
        list.add(new Student(9,"jeo",77));
        list.add(new Student(10,"zim",80));
        list.add(new Student(11,"keny",39));

        Connection conn = Database.getConnection();

        if (conn == null) {
            throw new RuntimeException("DB connection is NULL");
        }

        conn.setAutoCommit(false);

        PreparedStatement ps =
                conn.prepareStatement("INSERT INTO tablebt VALUES (?, ?, ?)");

        int count = 0;
        int BATCH_SIZE = 2;

        try {
            for (Student l : list) {

                ps.setInt(1, l.idss);
                ps.setString(2, l.namess);
                ps.setInt(3, l.agess);
                ps.addBatch();

                count++;

                if (count % BATCH_SIZE == 0) {
                    ps.executeBatch();
                    conn.commit();
                }
            }

            // insert remaining execution
            ps.executeBatch();
            conn.commit();

            System.out.println("Batch insert completed successfully");

        } catch (Exception e) {
            conn.rollback();
            throw e;
        }
    }
}
