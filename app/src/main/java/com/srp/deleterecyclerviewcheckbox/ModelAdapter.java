package com.srp.deleterecyclerviewcheckbox;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ModelViewHolder> {

    private List<Model> mList;
    private Context mContext;

    ModelAdapter(@NonNull Context context, List<Model> modelList) {
        mList = modelList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new ModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelViewHolder holder, int position) {
        Model model = mList.get(position);
        holder.item_name.setText(model.getItemName());
        holder.chkSelected.setChecked(model.isSelected());
        holder.chkSelected.setTag(model);
        Glide.with(mContext).load(R.drawable.ic_remove).into(holder.btn_delete);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    // confirmation dialog box to delete an unit
    private void deleteItemFromList(View v, final int position) {

        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

        //builder.setTitle("Delete ");
        builder.setMessage("Delete " + mList.get(position).getItemName())
                .setCancelable(false)
                .setPositiveButton("CONFIRM",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                mList.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {


                    }
                });

        builder.show();

    }

    class ModelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView item_name;
        private ImageView btn_delete;
        private CheckBox chkSelected;

        ModelViewHolder(@NonNull View itemLayoutView) {
            super(itemLayoutView);
            item_name = itemLayoutView.findViewById(R.id.txt_Name);
            btn_delete = itemLayoutView.findViewById(R.id.btn_delete_unit);
            chkSelected = itemLayoutView.findViewById(R.id.chk_selected);
            chkSelected.setOnClickListener(this);
            btn_delete.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.equals(btn_delete)){
                deleteItemFromList(view,getAdapterPosition());
            } else {
                CheckBox cb = (CheckBox) view;
//                Model model = (Model) cb.getTag();
//                model.setSelected(cb.isChecked());
                mList.get(getAdapterPosition()).setSelected(cb.isChecked());
            }
        }
    }
}
