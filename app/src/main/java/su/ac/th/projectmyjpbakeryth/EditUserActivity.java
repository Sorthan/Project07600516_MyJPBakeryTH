package su.ac.th.projectmyjpbakeryth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import su.ac.th.projectmyjpbakeryth.USERdb.USERRepository;
import su.ac.th.projectmyjpbakeryth.USERdb.UserClass;

public class EditUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        Intent recieveToEdit = getIntent();
        String oldUsername = recieveToEdit.getStringExtra("OldUsername");
        String oldPassword = recieveToEdit.getStringExtra("OldPassword");

        TextView newusername = findViewById(R.id.username_edit_text);
        TextView newpassword = findViewById(R.id.password_edit_text);
        String newUsername = newusername.getText().toString();
        String newPassword = newpassword.getText().toString();
        if(newUsername.length() == 0 || newPassword.length() == 0){
            Toast.makeText(EditUserActivity.this,"ERROR PLEASE FIELD ALL DATA",Toast.LENGTH_LONG).show();
        }
        onClickSave(oldUsername, oldPassword, newUsername, newPassword);
    }

    private void CheckUserUpdate(final String username, final String password, final String newUsername, final String newPassword){
        final String[] user_firstname = {""};
        final String[] user_lastname = {""};
        final String[] user_birthdate = {""};
        final String[] user_birthmonth = {""};
        final String[] user_birthyear = {""};
        USERRepository dataSearching = new USERRepository(EditUserActivity.this);
        dataSearching.getUser(new USERRepository.Callback() {
            @Override
            public void onGetLedger(List<UserClass> userList) {
                boolean checkTrue = false;

                for(UserClass userRun : userList){
                    if(username.equals(userRun.username) && password.equals(userRun.password)){
                        userRun.username = newUsername;
                        userRun.password = newPassword;
                        user_firstname[0] = userRun.firstname;
                        user_lastname[0] = userRun.lastname;
                        user_birthdate[0] = userRun.day;
                        user_birthmonth[0] = userRun.mount;
                        user_birthyear[0] = userRun.year;
                        checkTrue = true;
                        break;
                    }
                    else{
                        continue;
                    }
                }

                if(checkTrue){
                    Toast.makeText(EditUserActivity.this,"EDIT DONE ! >",Toast.LENGTH_LONG).show();
                    Intent personface = new Intent(EditUserActivity.this,PersonalInterfaceActivity.class);
                    personface.putExtra("keyUsername",newUsername);
                    personface.putExtra("keyPassword",newPassword);
                    personface.putExtra("keyName",user_firstname[0]);
                    personface.putExtra("keyLastname",user_lastname[0]);
                    personface.putExtra("keyDay",user_birthdate[0]);
                    personface.putExtra("keyMonth",user_birthmonth[0]);
                    personface.putExtra("keyYear",user_birthyear[0]);
                    startActivity(personface);
                    finish();
                }
            }
        });
    }

    private void onClickSave(final String username, final String password, final String newUsername, final String newPassword){
        Button savebutton = findViewById(R.id.save_button);
        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckUserUpdate(username, password, newUsername, newPassword);
            }
        });
    }
}
