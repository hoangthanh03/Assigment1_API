package com.example.assigment_ph40777.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assigment_ph40777.Model.MotorModel;
import com.example.assigment_ph40777.R;

import java.util.List;

public class MotorAdapter extends BaseAdapter {
    List<MotorModel> list;
    Context context;

    public MotorAdapter(List<MotorModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size() ;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_motor,parent,false);

        //ánh xạ

        TextView txtId = view.findViewById(R.id.txtId);
        ImageView imgMotor = view.findViewById(R.id.imgAvatatr);
        TextView txtmotoName = view.findViewById(R.id.txtmotoName);
        TextView txtDate = view.findViewById(R.id.txtDate);
        TextView txtTheFirm = view.findViewById(R.id.txtTheFirm);
        TextView txtPrice = view.findViewById(R.id.txtPrice);
        Button btnUpdate = view.findViewById(R.id.btnUpdate);
        Button btnDelete = view.findViewById(R.id.btnDelete);

        txtmotoName.setText("Name: "+list.get(position).getMotoName());
        txtDate.setText("Date: "+list.get(position).getDate());
        txtTheFirm.setText("The Firm"+list.get(position).getTheFirm());
        txtPrice.setText("Price:"+list.get(position).getPrice());

        return view;
    }
}
