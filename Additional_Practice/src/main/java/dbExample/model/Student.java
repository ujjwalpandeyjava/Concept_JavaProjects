package dbExample.model;

public class Student {

  private int id;
  private String name;
  private int fee;
  private String course;

  public Student() {
    super();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getFee() {
    return fee;
  }

  public void setFee(int fee) {
    this.fee = fee;
  }

  public String getCourse() {
    return course;
  }

  public void setCourse(String course) {
    this.course = course;
  }

  public Student(int id, String name, int fee, String course) {
    super();
    this.id = id;
    this.name = name;
    this.fee = fee;
    this.course = course;
  }
}
