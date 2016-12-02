package com.example.aarya.eventmanager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aarya.eventmanager.R;
import com.example.aarya.eventmanager.activity.Utility;
import com.example.aarya.eventmanager.model.Guard;

import java.util.List;

public class GuardListAdapter extends RecyclerView.Adapter<GuardListAdapter.GuardViewHolder> {

    private List<Guard> guardlist;
    private Context context;

    public class GuardViewHolder extends RecyclerView.ViewHolder {
        TextView guardName;
        TextView guardToken;
        ImageView guardImage;
        LinearLayout linearLayout;
        CheckBox checkBox;

        public GuardViewHolder(View v) {
            super(v);
            guardName = (TextView) v.findViewById(R.id.guard_name);
            guardToken = (TextView) v.findViewById(R.id.guard_token);
            guardImage = (ImageView) v.findViewById(R.id.guard_img);
            linearLayout = (LinearLayout) v.findViewById(R.id.guard_list_layout);
            checkBox = (CheckBox) v.findViewById(R.id.chk_box);
        }
    }

    public GuardListAdapter(List<Guard> guards, Context context) {
        this.context = context;
        this.guardlist = guards;
    }

    @Override
    public GuardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("zia", "onCreateViewHolder is called");

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.guard_list_row,parent,false);
        return new GuardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final GuardViewHolder holder, int position) {
        Log.e("zia", "onBindViewHolder is called");

        final Guard guard=guardlist.get(position);
       // holder.guardName.setText(guard.getName().toUpperCase());
        holder.guardToken.setText(guard.getTokenNo().toUpperCase());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.e("zia", "CheckButton is checked :"+b);
                Log.e("zia", "Date time: "+ Utility.getDateTime());
               // Log.e("zia", "Imei no: "+Utility.imei);

                guard.setGuardSelected(b);
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.e("zia", "getItemCount is called");
        return guardlist.size();
    }
}
