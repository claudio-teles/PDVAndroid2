package com.francisco_claudio.pdvandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FormaPagamentoAdapter extends RecyclerView.Adapter<FormaPagamentoAdapter.ViewHolder> {

    private ArrayList<FormaDePagemento> formasDePagamento;
    private Context context;

    public FormaPagamentoAdapter(ArrayList<FormaDePagemento> formasDePagamento, Context context) {
        this.formasDePagamento = formasDePagamento;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Set logo to ImageView
        holder.imageView.setImageResource(formasDePagamento.get(position).getLangLogo());
        // Set name to TextView
        holder.textView.setText(formasDePagamento.get(position).getLangName());
    }

    @Override
    public int getItemCount() {
        return formasDePagamento.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Initialize Variable
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Assign Variable
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);
        }
    }
}
