package su.ac.th.projectmyjpbakeryth.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import su.ac.th.projectmyjpbakeryth.R;
import su.ac.th.projectmyjpbakeryth.BAKERYdb.*;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    private Context mContext;
    private int mResource;
    private List<Bakery> mBakeryList;

    public RecycleViewAdapter(Context mContext, int mResource, List<Bakery> mPlaceList) {
        this.mContext = mContext;
        this.mResource = mResource;
        this.mBakeryList = mPlaceList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Bakery bakery = mBakeryList.get(position);

        holder.bakery = bakery;
        holder.bakerynameTextView.setText(bakery.dessertname);
        holder.bakerytypeTextView.setText(bakery.desserttype);
        holder.bakerypriceTextView.setText(bakery.dessertprice);
        holder.bakeryImageView.setImageResource(bakery.imageRes);
    }

    @Override
    public int getItemCount() {
        return mBakeryList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView bakerynameTextView;
        private TextView bakerytypeTextView;
        private TextView bakerypriceTextView;
        private ImageView bakeryImageView;

        private Bakery bakery;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.bakerynameTextView = itemView.findViewById(R.id.dessertname_text_view);
            this.bakerytypeTextView = itemView.findViewById(R.id.desserttype_text_view);
            this.bakerypriceTextView = itemView.findViewById(R.id.dessertprice_text_view);
            this.bakeryImageView = itemView.findViewById(R.id.dessert_image_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //กดไม่ได้ ไม่ได้ทำให้ระบบสั่งของได้
                }
            });
        }
    }

}
