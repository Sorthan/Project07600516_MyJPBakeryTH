package su.ac.th.projectmyjpbakeryth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import su.ac.th.projectmyjpbakeryth.R;

public class PersonalInterfaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_interface);
        Intent receiveIntent = getIntent();
        String idUsername = receiveIntent.getStringExtra("keyUsername");
        String idPassword = receiveIntent.getStringExtra("keyPassword");
        String username = receiveIntent.getStringExtra("keyName");
        String userlastname = receiveIntent.getStringExtra("keyLastname");
        String userbirthdate = receiveIntent.getStringExtra("keyDay");
        String userbirthmonth = receiveIntent.getStringExtra("keyMonth");
        String userbirthyear = receiveIntent.getStringExtra("keyYear");//หลอกตาไม่แสดงเพราะ อายุ คือข้อมูลสำคัญ
        switch(userbirthmonth){
            case "1" : userbirthmonth = getString(R.string.Jan);break;
            case "2" : userbirthmonth = getString(R.string.Feb);break;
            case "3" : userbirthmonth = getString(R.string.Mar);break;
            case "4" : userbirthmonth = getString(R.string.Apr);break;
            case "5" : userbirthmonth = getString(R.string.May);break;
            case "6" : userbirthmonth = getString(R.string.Jun);break;
            case "7" : userbirthmonth = getString(R.string.Jul);break;
            case "8" : userbirthmonth = getString(R.string.Aug);break;
            case "9" : userbirthmonth = getString(R.string.Sep);break;
            case "10" : userbirthmonth = getString(R.string.Oct);break;
            case "11" : userbirthmonth = getString(R.string.Nov);break;
            case "12" : userbirthmonth = getString(R.string.Feb);break;
            default:break;
        }
        TextView name = findViewById(R.id.nameInput_text);
        name.setText(username);
        TextView lastname = findViewById(R.id.lastnameInput_text);
        lastname.setText(userlastname);
        TextView date = findViewById(R.id.dayInput_text);
        date.setText(userbirthdate);
        TextView month = findViewById(R.id.monthinput_text);
        month.setText(userbirthmonth);

        onClickViewMenu(idUsername, idPassword);
        onClickEdit(idUsername, idPassword);
        onClickLogout();
    }

    private void onClickViewMenu(final String Username, final String Password){
        Button menuview = findViewById(R.id.view_bakery_button);
        menuview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Menupopup = new Intent(PersonalInterfaceActivity.this,BakeryActivity.class);
                Menupopup.putExtra("Username",Username);
                Menupopup.putExtra("Password",Password);
                startActivity(Menupopup);
                finish();
            }
        });
    }

    private void onClickEdit(final String oldUsername, final String oldPassword){
        Button edit = findViewById(R.id.edit_user_button);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editpopup = new Intent(PersonalInterfaceActivity.this,EditUserActivity.class);
                editpopup.putExtra("OldUsername",oldUsername);
                editpopup.putExtra("OldPassword",oldPassword);
                startActivity(editpopup);
                finish();
            }
        });
    }

    private void onClickLogout(){
        Button logout = findViewById(R.id.logout_user_button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginReturn = new Intent(PersonalInterfaceActivity.this,LoginPersonalActivity.class);
                startActivity(loginReturn);
                finish();
            }
        });
    }
}
