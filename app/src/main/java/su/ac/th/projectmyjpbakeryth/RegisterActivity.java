package su.ac.th.projectmyjpbakeryth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import su.ac.th.projectmyjpbakeryth.USERdb.UserClass;
import su.ac.th.projectmyjpbakeryth.USERdb.USERRepository;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        onClickRegister();
    }

    private void onClickRegister(){
        Button RegisterButton = findViewById(R.id.save_button);
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView FirstName = findViewById(R.id.first_name_edit_text);
                TextView LastName = findViewById(R.id.last_name_edit_text);
                TextView Day = findViewById(R.id.day_edit_text);
                TextView Month = findViewById(R.id.month_edit_text);
                TextView Year = findViewById(R.id.year_edit_text);
                TextView UserName = findViewById(R.id.username_edit_text);
                TextView Password = findViewById(R.id.password_edit_text);

                String firstname = FirstName.getText().toString();
                String lastname = LastName.getText().toString();
                String day = Day.getText().toString();
                String month = Month.getText().toString();
                String year = Year.getText().toString();
                String username = UserName.getText().toString();
                String password = Password.getText().toString();

                if(firstname.length() == 0 || lastname.length() == 0 || (day.length() ==0 || day.length() > 2) || month.length() == 0 || year.length() == 0 || username.length() == 0 || password.length() == 0){
                    Toast.makeText(RegisterActivity.this,"All fields are required",Toast.LENGTH_LONG).show();
                }
                else{
                    UserClass NewUser = new UserClass(firstname,lastname,day,month,year,username,password);
                    InsertNewUserAdding(NewUser);
                    Toast.makeText(RegisterActivity.this,"REGISTER DONE!",Toast.LENGTH_LONG).show();
                    Intent loginview = new Intent(RegisterActivity.this,LoginPersonalActivity.class);
                    startActivity(loginview);
                }
            }
        });
    }

    private void InsertNewUserAdding(UserClass NEWUSER){
        USERRepository reportInsertion = new USERRepository(RegisterActivity.this);
        reportInsertion.insertUser(NEWUSER, new USERRepository.InsertCallback() {
            @Override
            public void onInsertSuccess() {
                finish();
            }
        });
    }
}
