package pandey.ujjwal.concepts.dbExample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pandey.ujjwal.concepts.dbExample.conn.MyConnection;
import pandey.ujjwal.concepts.dbExample.model.Student;

public class StudentDaoImpl implements StudentDao {

  Connection con;
  PreparedStatement ps;
  ResultSet rs;
  Statement st;
  List<Student> ob;

  @Override
  public void create(Student ob) throws Exception {
    con = MyConnection.createConnection();
    ps = con.prepareStatement("insert into Student values(?,?,?,?)");
    ps.setInt(1, ob.getId());
    ps.setString(2, ob.getName());
    ps.setInt(3, ob.getFee());
    ps.setString(4, ob.getCourse());
    ps.executeUpdate();
  }

  @Override
  public void delete(int id) throws Exception {
    con = MyConnection.createConnection();
    ps = con.prepareStatement("delete from Student where id = ?");
    ps.setInt(1, id);
    ps.executeUpdate();
  }

  @Override
  public List<Student> displayAll() throws Exception {
    ArrayList<Student> data = new ArrayList<Student>();
    con = MyConnection.createConnection();
    st = con.createStatement();
    rs = st.executeQuery("select * from Student");
    while (rs.next()) {
      data.add(
        new Student(
          rs.getInt(1),
          rs.getString(2),
          rs.getInt(3),
          rs.getString(4)
        )
      );
    }
    return data;
  }

  @Override
  public Student getStudentById(int id) throws Exception {
    con = MyConnection.createConnection();
    ob = new ArrayList<Student>();
    ob = displayAll();
    Student info = null;
    for (Student s : ob) {
      if (s.getId() == id) info =
        new Student(s.getId(), s.getName(), s.getFee(), s.getCourse());
    }
    return info;
  }

  @Override
  public void update(Student ob) throws Exception {
    con = MyConnection.createConnection();
    ps =
      con.prepareStatement(
        "update Student set name =? , fee = ? , course = ? where id = ?"
      );
    ps.setString(1, ob.getName());
    ps.setInt(2, ob.getFee());
    ps.setString(3, ob.getCourse());
    ps.setInt(4, ob.getId());
    ps.executeUpdate();
  }
}
