package su.ac.th.projectmyjpbakeryth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import su.ac.th.projectmyjpbakeryth.USERdb.USERRepository;
import su.ac.th.projectmyjpbakeryth.USERdb.UserClass;

import static java.lang.System.exit;

public class LoginPersonalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_personal);
        onClickRegister();
        onClickLogin();
        onClickCloseAppication();
    }

    private void onClickRegister(){
        final Button registerbutton = findViewById(R.id.save_button);
        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginPersonalActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
    }

    private void onClickLogin(){
        final Button loginbutton = findViewById(R.id.login_button);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView UserInput = findViewById(R.id.email_or_username_edit_text);
                TextView Password = findViewById(R.id.password_edit_text);

                String username = UserInput.getText().toString();
                String password = Password.getText().toString();
                CheckUserLogin(username, password);
            }
        });
    }

    private void CheckUserLogin(final String username, final String password){
        final String[] user_firstname = {""};
        final String[] user_lastname = {""};
        final String[] user_birthdate = {""};
        final String[] user_birthmonth = {""};
        final String[] user_birthyear = {""};
        USERRepository dataSearching = new USERRepository(LoginPersonalActivity.this);
        dataSearching.getUser(new USERRepository.Callback() {
            @Override
            public void onGetLedger(List<UserClass> userList) {
                boolean checkTrue = false;

                for(UserClass userRun : userList){
                    if(username.equals(userRun.username) && password.equals(userRun.password)){
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
                    Toast.makeText(LoginPersonalActivity.this,"WELCOME < "+user_firstname[0]+" "+user_lastname[0]+" >",Toast.LENGTH_LONG).show();
                    Intent personface = new Intent(LoginPersonalActivity.this,PersonalInterfaceActivity.class);
                    personface.putExtra("keyUsername",username);
                    personface.putExtra("keyPassword",password);
                    personface.putExtra("keyName",user_firstname[0]);
                    personface.putExtra("keyLastname",user_lastname[0]);
                    personface.putExtra("keyDay",user_birthdate[0]);
                    personface.putExtra("keyMonth",user_birthmonth[0]);
                    personface.putExtra("keyYear",user_birthyear[0]);
                    startActivity(personface);
                    finish();
                }
                else{
                    Toast.makeText(LoginPersonalActivity.this,"Invalid username or password, Please try agian !",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void onClickCloseAppication(){
        Button closeButton = findViewById(R.id.close_button);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit(0);
                finish();
            }
        });
    }
}
