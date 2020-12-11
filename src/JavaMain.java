import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JavaMain {
    public static void main(String... args) {
        StudentDAO studentdao = new StudentDaoImpl();
        try {

            //creating
            // studentdao.addStudent(new Student("hamza"));

            //updating
           // studentdao.updateStudent(3,new Student("newhamza"));

       /*     //index
            List list = studentdao.getAllStudent();
            for (int i = 0; i < list.size(); i++) {
                Student s = (Student) list.get(i);
                System.out.println(s.toString());
            }*/

            //deleting
          //  studentdao.deleteStudent(2);

            //selecting
            List list = studentdao.getStudent(3,"newhamza");
            for (int i = 0; i < list.size(); i++) {
                Student s = (Student) list.get(i);
                System.out.println(s.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
