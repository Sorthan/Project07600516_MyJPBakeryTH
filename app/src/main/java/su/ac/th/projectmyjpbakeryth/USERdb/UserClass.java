package su.ac.th.projectmyjpbakeryth.USERdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "userdata")
public class UserClass {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "firstname")
    public String firstname;

    @ColumnInfo(name = "lastname")
    public String lastname;

    @ColumnInfo(name = "birthdate")
    public String day;

    @ColumnInfo(name = "birthmonth")
    public String mount;

    @ColumnInfo(name = "yearbirth")
    public String year;

    @ColumnInfo(name = "user or email")
    public String username;

    @ColumnInfo(name = "password")
    public String password;

    public UserClass(String firstname, String lastname, String day, String mount, String year, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.day = day;
        this.mount = mount;
        this.year = year;
        this.username = username;
        this.password = password;
    }
}
