package com.example.vetcription;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.vetcription.Database.Veterinary_DataModel;

import java.util.List;

public class VetDataShowAdapter_saiful extends RecyclerView.Adapter<VetDataShowAdapter_saiful.WordViewHolder> {

    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView trade_name,trade_dos,company,composition;
        ImageView img;

        private WordViewHolder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.medicine_img);
            trade_name = itemView.findViewById(R.id.trae_name);
            trade_dos= itemView.findViewById(R.id.trade_dos);
            company=itemView.findViewById(R.id.company);
            composition=itemView.findViewById(R.id.composition);

        }
    }

    private final LayoutInflater mInflater;
    private List<Veterinary_DataModel> Data; // Cached copy of words

    VetDataShowAdapter_saiful(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.medicne_row, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if (Data != null) {
            Veterinary_DataModel current = Data.get(position);
            holder.img.setImageAlpha(R.drawable.heart);
            holder.trade_name.setText(current.getTrade_name());
            holder.composition.setText(current.getComposition());
            holder.trade_dos.setText(current.getTrade_dose());
            holder.company.setText(current.getCompany());

        } else {
            // Covers the case of data not being ready yet.
            holder.trade_name.setText("No Word");
        }
    }

    void setWords(List<Veterinary_DataModel> words){
        Data = words;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (Data != null)
            return Data.size();
        else return 0;
    }
}
