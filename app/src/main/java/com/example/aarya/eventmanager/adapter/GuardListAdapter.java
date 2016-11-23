package com.example.aarya.eventmanager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aarya.eventmanager.R;
import com.example.aarya.eventmanager.model.Guards;

import java.security.Guard;
import java.util.List;

public class GuardListAdapter extends RecyclerView.Adapter<GuardListAdapter.GuardViewHolder> {

    private List<Guards> guardlist;
    private int rowLayout;
    private Context context;

    public class GuardViewHolder extends RecyclerView.ViewHolder {
        TextView guardName;
        TextView guardToken;
        ImageView guardImage;
        LinearLayout linearLayout;

        public GuardViewHolder(View v) {
            super(v);
            guardName = (TextView) v.findViewById(R.id.guard_name);
            guardToken = (TextView) v.findViewById(R.id.guard_token);
            guardImage = (ImageView) v.findViewById(R.id.guard_img);
            linearLayout = (LinearLayout) v.findViewById(R.id.guard_list_layout);
        }
    }

    public GuardListAdapter(List<Guards> guards, int rowLayout, Context context) {
        this.context = context;
        this.rowLayout = rowLayout;
        this.guardlist = guards;
    }

    @Override
    public GuardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.guard_list_row,parent,false);
        return new GuardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GuardViewHolder holder, int position) {
        Guards guards=guardlist.get(position);
        holder.guardName.setText(guards.getName().toUpperCase());
        holder.guardToken.setText(guards.getTokenNo().toUpperCase());
    }

    @Override
    public int getItemCount() {
        return guardlist.size();
    }
}
