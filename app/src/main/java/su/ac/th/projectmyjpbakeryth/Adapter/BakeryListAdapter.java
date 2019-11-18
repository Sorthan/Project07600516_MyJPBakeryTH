package su.ac.th.projectmyjpbakeryth.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import su.ac.th.projectmyjpbakeryth.BAKERYdb.Bakery;
import su.ac.th.projectmyjpbakeryth.R;

public class BakeryListAdapter extends ArrayAdapter<Bakery> {
    private Context mContext;
    private int mResource;
    private List<Bakery> mBakeryList;
    public BakeryListAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Bakery> bakeryList) {
        super(context, resource, textViewResourceId, bakeryList);
        this.mContext = context;
        this.mResource = resource;
        this.mBakeryList = bakeryList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //View v = inflater.inflate(mResource,parent,false);
        View v = convertView;
        if(v == null){
            v = inflater.inflate(mResource,parent,false);
        }

        // เข้าถึง position ที่ ListView ขอมา
        Bakery bakery = mBakeryList.get(position);

        // กำหนดชื่อ สถานที่ ลง TextView (place_name_text_view)
        TextView placeNameTextView = v.findViewById(R.id.dessertname_text_view);
        placeNameTextView.setText(bakery.dessertname);

        // กำหนดชื่อ อำเถอ ลง TextView (district_text_view)
        TextView TypeNameTextView = v.findViewById(R.id.desserttype_text_view);
        TypeNameTextView.setText(bakery.desserttype);

        TextView PriceTextView = v.findViewById(R.id.dessertprice_text_view);
        PriceTextView.setText(bakery.dessertprice);

        ImageView logoImageView = v.findViewById(R.id.dessert_image_view);
        logoImageView.setImageResource(bakery.imageRes);

        return v;
    }
}
