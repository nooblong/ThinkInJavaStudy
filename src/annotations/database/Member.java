package annotations.database;

@DBTable(name = "MEMBER1")
public class Member {
    @SQLString(30) String firstName;
    @SQLString(50) String lastName;
    @SQLInteger Integer age;
    @SQLString(value = 30, constraints = @Constraints(primaryKey = true)) String handle;

//    @SQLTinyInt(value = 9, name = "FUCK")
//    Integer fuck;

    static int memberCount;

    public String getHandle() {
        return handle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return handle;
    }

    public Integer getAge() {
        return age;
    }
}
