package su.ac.th.projectmyjpbakeryth.USERdb;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM userdata")
    List<UserClass> getAllUser();

    @Insert
    void insertUser(UserClass user);
}
