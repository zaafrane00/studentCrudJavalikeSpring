import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StudentDaoImpl implements StudentDAO {

    private DataBaseManager base = new DataBaseManager(0);

    @Override
    public List getAllStudent() throws SQLException {
        List<Student> tabStudents = new ArrayList<Student>();
        String sql = "select * from student";
        System.out.println(sql);
        List list = base.select(sql);
        for (int i = 0; i < list.size(); i++) {
            Object[] t = (Object[]) list.get(i);
            Student std = new Student(t[1].toString());
            std.setId(Integer.parseInt(t[0].toString()));
            tabStudents.add(std);
        }
        return tabStudents;
    }


    @Override
    public void addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO student VALUES(DEFAULT, '" + student.getName() + "')";
        System.out.println(sql);
        base.update(sql);
    }

    @Override
    public void updateStudent(int id,Student student) throws SQLException {
        String sql = "update student set name='"+student.getName()+"'where id="+id;
        base.update(sql);
    }

    @Override
    public void deleteStudent(int id) throws SQLException {
        String sql = "delete from student where id='"+id+"'";
        base.update(sql);
        System.out.println("Delete Successful");
    }

    @Override
    public List getStudent(int id,String name) throws SQLException {
        String sql = "select * from student where id='"+id+"'and name='"+name+"'";
        List<Student> tabStudents = new ArrayList<Student>();
        List list = base.select(sql);
        for (int i = 0; i < list.size(); i++) {
            Object[] t = (Object[]) list.get(i);
            Student std = new Student(t[1].toString());
            std.setId(Integer.parseInt(t[0].toString()));
            tabStudents.add(std);
        }
        return tabStudents;
    }
}
