package sample;

public class Employee extends Controller {

  private String name;
  private String username;
  private String password;
  private String email;

  @Override
  public String toString() {
    return "Employee Details\n"
        + "Name : "
        + name
        + "\n"
        + "UserName : "
        + username
        + "\n"
        + "Email : "
        + email
        + "\n"
        + "Initial Password : "
        + password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  /**
   * Constructor for the employee class.
   *
   * @param name - variable used for the name of the employee
   * @param password - variable used for the password
   */
  public Employee(String name, String password) {

    this.password = password;
    this.name = name.toString();

    if (checkName(name)) {
      setUsername(username);
      setEmail(email);
    } else if (!checkName(name)) {
      setUsername(username);
      setEmail(email);
    }

    if (isValidPassword(password) && checkName(name)) {
      this.password = password;
    } else if (!isValidPassword(password)) {
      this.password = "pw";
    }
  }

  private void setUsername(String username) {

    this.username = username;
    if (checkName(name)) {
      int space = name.indexOf(' ');
      String firstInitial = name.substring(0, 1);
      String lastName = name.substring(space + 1);
      this.username = firstInitial.toLowerCase() + lastName.toLowerCase();
    } else {
      this.username = "default";
    }
  }

  private boolean checkName(String name) {
    this.name = name.toString();

    String test = name.toString();

    if (test.contains(" ")) {
      return true;
    } else {
      return false;
    }
  }

  private boolean isValidPassword(String password) {
    this.password = password;
    boolean upper = false;
    boolean lower = false;
    boolean specialC = false;

    for (char c : password.toCharArray()) {

      if (Character.isUpperCase(c)) {
        upper = true;
      } else if (Character.isLowerCase(c)) {
        lower = true;
      }
    }
    if ((upper && lower)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Method created to set the email of the employee.
   *
   * @param email - variable for the email of the employee.
   */
  public void setEmail(String email) {
    this.email = email;
    if (checkName(name)) {
      int space = name.indexOf(' ');

      String firstName = name.substring(0, 1).toUpperCase() + name.substring(1, space);
      String lastName = name.substring(space + 1);
      String address = "@oracleacademy.Test";
      email = firstName.toLowerCase() + "." + lastName.toLowerCase() + address;
      this.email = email;
    } else {
      this.email = "user@oracleacademy.Test";
    }
  }
}
