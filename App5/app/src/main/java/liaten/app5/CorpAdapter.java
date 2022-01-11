package liaten.app5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CorpAdapter extends RecyclerView.Adapter<CorpAdapter.ViewHolder> {

    private Context context;
    private ArrayList corpID, corpName, corpFounders, corpProducts, corpPrice, corpCategory;

    CorpAdapter(Context context, ArrayList corpID, ArrayList corpName, ArrayList corpFounders, ArrayList corpProducts, ArrayList corpPrice, ArrayList corpCategory){
        this.context = context;
        this.corpID = corpID;
        this.corpName = corpName;
        this.corpFounders = corpFounders;
        this.corpProducts = corpProducts;
        this.corpPrice = corpPrice;
        this.corpCategory = corpCategory;
    }

    @NonNull
    @Override
    public CorpAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CorpAdapter.ViewHolder holder, int position) {
        holder.corpID_txt.setText(String.valueOf(corpID.get(position)));
        holder.corpName_txt.setText(String.valueOf(corpName.get(position)));
        holder.corpFounders_txt.setText(String.valueOf(corpFounders.get(position)));
        holder.corpProducts_txt.setText(String.valueOf(corpProducts.get(position)));
        holder.corpPrice_txt.setText(String.valueOf(corpPrice.get(position)));
        holder.corpCategory_txt.setText(String.valueOf(corpCategory.get(position)));


        holder.mainLayout.setOnClickListener(view -> {
            Intent intent = new Intent(context, UpdateActivity.class);
            intent.putExtra("id", String.valueOf(corpID.get(position)));
            intent.putExtra("corp_name", String.valueOf(corpName.get(position)));
            intent.putExtra("corp_founders", String.valueOf(corpFounders.get(position)));
            intent.putExtra("corp_products", String.valueOf(corpProducts.get(position)));
            intent.putExtra("corp_price", String.valueOf(corpPrice.get(position)));
            intent.putExtra("corp_category", String.valueOf(corpCategory.get(position)));
            ((Activity) context).startActivityForResult(intent,1);
        });
    }

    @Override
    public int getItemCount()
    {
        return corpID.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView corpID_txt, corpName_txt, corpFounders_txt, corpProducts_txt, corpPrice_txt, corpCategory_txt;
        LinearLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            corpID_txt = itemView.findViewById(R.id.corpID_txt);
            corpName_txt = itemView.findViewById(R.id.corpName_txt);
            corpFounders_txt = itemView.findViewById(R.id.corpFounders_txt);
            corpProducts_txt = itemView.findViewById(R.id.corpProducts_txt);
            corpPrice_txt = itemView.findViewById(R.id.corpPrice_txt);
            corpCategory_txt = itemView.findViewById(R.id.corpCategory_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
