package dbExample;

import dbExample.dao.StudentDao;
import dbExample.dao.StudentDaoImpl;
import dbExample.model.Student;
import java.util.List;
import java.util.Scanner;

public class TestDrive {

  public static void main(String[] args) throws Exception {
    StudentDao studentDAO = new StudentDaoImpl();
    int ch;
    try (Scanner scanner = new Scanner(System.in)) {
      while (true) {
        System.out.println(
          "1.Create\n2.Display \n3.Update \n4.Delete \n0.Exit"
        );
        System.out.println("Enter ur choice ::: ");
        ch = scanner.nextInt();
        switch (ch) {
          case 1:
            System.out.println("Enter id ::: ");
            int id = scanner.nextInt();

            System.out.println("Enter Name ::: ");
            String name = scanner.next();

            System.out.println("Enter fee ::: ");
            int fee = scanner.nextInt();

            System.out.println("Enter Course ::: ");
            String crs = scanner.next();
            Student ob = new Student(id, name, fee, crs);
            studentDAO.create(ob);
            System.out.println("Record inserted... ");
            break;
          case 2:
            List<Student> data = studentDAO.displayAll();
            for (Student s : data) {
              System.out.println(
                s.getId() +
                "\t" +
                s.getName() +
                "\t" +
                s.getFee() +
                "\t" +
                s.getCourse()
              );
            }

            break;
          case 3:
            System.out.println("Enter id to be updated ::: ");
            id = scanner.nextInt();
            Student ss = studentDAO.getStudentById(id);
            System.out.println(
              ss.getId() +
              "\t" +
              ss.getName() +
              "\t" +
              ss.getFee() +
              "\t" +
              ss.getCourse()
            );
            System.out.println("Enter the below to be updated :- ");
            System.out.println("1. Name \n2.Fee \n3.Course ");
            System.out.println("Enter ur choice :::: ");
            int c = scanner.nextInt();
            if (c == 1) {
              System.out.println("Enter Name ::: ");
              name = scanner.next();
              ss.setName(name);
            } else if (c == 2) {
              System.out.println("Enter Fee ::: ");
              fee = scanner.nextInt();
              ss.setFee(fee);
            } else if (c == 3) {
              System.out.println("Enter Course ::: ");
              crs = scanner.next();
              ss.setCourse(crs);
            }

            studentDAO.update(ss);
            System.out.println("Record updated... ");

            break;
          case 4:
            System.out.println("Enter id to be deleted ::: ");
            id = scanner.nextInt();
            studentDAO.delete(id);
            System.out.println("Record deleted.... ");
            break;
          case 0:
            System.exit(0);
        }
      }
      //---------  Retrieve from table/database --------------
      /*Statement st;
		ResultSet  rs;
		
		st = con.createStatement();
		rs = st.executeQuery( "select * from Student");
		while(rs.next())
		{	
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(4)+"\t"+rs.getInt(3));
			
		}
		con.close();
		System.out.println("Records displayed..... ");*/

      // --------------- Inserting record ----------------------

      /*PreparedStatement ps;
		ps = con.prepareStatement("insert into Student values(?,?,?,?)");
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter id ::: ");
		int id = scanner.nextInt();
		
		System.out.println("Enter Name ::: ");
		String name = scanner.next();
		
		System.out.println("Enter fee ::: ");
		int fee = scanner.nextInt();
		
		System.out.println("Enter Course ::: ");
		String crs = scanner.next();
		
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, fee);
		ps.setString(4, crs);
		ps.executeUpdate();
		
		con.close();
		System.out.println("Record Inserted... "); */

      //-------------- Deleting Record ----------------------

      /*PreparedStatement ps;
		ps = con.prepareStatement("delete from Student where id = ?");
		
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter id ::: ");
		int id = scanner.nextInt();
		
		ps.setInt(1, id);
		ps.executeUpdate();
		System.out.println("Record deleted........... ");*/

      // ------------- Update Record ---------------------
      /*PreparedStatement ps;
		ps = con.prepareStatement("update Student set name = ? where id = ?");
		
		Scanner scanner =new Scanner(System.in);
		
		System.out.println("Enter id ::: ");
		int id = scanner.nextInt();
		
		System.out.println("Enter name ::: ");
		String name = scanner.next();
		
		ps.setString(1, name);
		ps.setInt(2, id);
		ps.executeUpdate();
		System.out.println("Record updated............ "); */
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.getStackTrace();
    }
  }
}
