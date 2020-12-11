import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {
    public List getAllStudent() throws SQLException;

    public void addStudent(Student student) throws SQLException;

    public void updateStudent(int id,Student student) throws SQLException;

    public void deleteStudent(int id) throws SQLException;

    public List getStudent(int id,String name) throws SQLException;

}
