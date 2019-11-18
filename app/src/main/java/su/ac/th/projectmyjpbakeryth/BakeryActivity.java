package su.ac.th.projectmyjpbakeryth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import su.ac.th.projectmyjpbakeryth.Adapter.BakeryListAdapter;
import su.ac.th.projectmyjpbakeryth.BAKERYdb.Bakery;
import su.ac.th.projectmyjpbakeryth.USERdb.AppDatabase;
import su.ac.th.projectmyjpbakeryth.USERdb.USERRepository;
import su.ac.th.projectmyjpbakeryth.USERdb.UserClass;
import su.ac.th.projectmyjpbakeryth.BAKERYdb.*;
import su.ac.th.projectmyjpbakeryth.Adapter.RecycleViewAdapter;

public class BakeryActivity extends AppCompatActivity {

    private List<Bakery> mBakeryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bakery_window);

        reloadBakeryData();

        Intent getIntentMenu = getIntent();
        String username = getIntentMenu.getStringExtra("Username");
        String password = getIntentMenu.getStringExtra("Password");
        onClickReturn(username, password);
    }

    private void reloadBakeryData(){
        generateData();
        ListView BakeryListView = findViewById(R.id.listview);
        BakeryListAdapter adapter = new BakeryListAdapter(
                BakeryActivity.this,
                R.layout.bakery_item,
                R.id.dessertname_text_view,
                mBakeryList
        );
        BakeryListView.setAdapter(adapter);
    }

    private void generateData(){
        Bakery bakery = new Bakery(1,"เอสเพสโซ่ปั่น","เครื่องดื่มของหวาน","45",R.drawable.espressocoffee);
        mBakeryList.add(bakery);
        bakery = new Bakery(2,"chocolate cake","เค้ก","150",R.drawable.cakeke);
        mBakeryList.add(bakery);
        bakery = new Bakery(3,"Cookie","ขนมหวาน","25",R.drawable.cookie);
        mBakeryList.add(bakery);
        bakery = new Bakery(4,"โดรายากิ","ขนมหวาน","30",R.drawable.dorayaki);
        mBakeryList.add(bakery);
        bakery = new Bakery(5,"ขนมโมจิ","ขนมหวาน","35",R.drawable.moji);
        mBakeryList.add(bakery);
    }

    private void onClickReturn(final String Username, final String Password){
        Button returnB = findViewById(R.id.return_button);
        returnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] user_firstname = {""};
                final String[] user_lastname = {""};
                final String[] user_birthdate = {""};
                final String[] user_birthmonth = {""};
                final String[] user_birthyear = {""};
                USERRepository dataSearching = new USERRepository(BakeryActivity.this);
                dataSearching.getUser(new USERRepository.Callback() {
                    @Override
                    public void onGetLedger(List<UserClass> userList) {
                        boolean checkTrue = false;

                        for(UserClass userRun : userList){
                            if(Username.equals(userRun.username) && Password.equals(userRun.password)){
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
                            Intent personface = new Intent(BakeryActivity.this,PersonalInterfaceActivity.class);
                            personface.putExtra("keyUsername",Username);
                            personface.putExtra("keyPassword",Password);
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
        });
    }
}
