import javax.annotation.concurrent.Immutable;

@Immutable
public class Employee {
  private final int id;
  private final String name;
  private final String address;
  private final String number;

  public Employee(int id, String name, String address, String number) {
    this.name = name;
    this.address = address;
    this.number = number;
    this.id = id;
  }
}