package com.example.recyclerview;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

import static android.R.attr.data;
import static android.os.Build.VERSION_CODES.M;
import static com.example.recyclerview.R.id.switch1;
import static com.example.recyclerview.R.id.wAmount;

/**
 * Created by Shrey on 30/04/2017.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder>
{
    LinearLayout linearLayout;
    GradientDrawable gd;

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView bank,funds,cValue;
        EditText wAmount;
        ImageView logo;
        Switch aSwitch;


        public MyViewHolder(View itemView)
        {
            super(itemView);

            bank=(TextView)itemView.findViewById(R.id.bank);
            funds=(TextView)itemView.findViewById(R.id.funds);
            cValue=(TextView)itemView.findViewById(R.id.cValue);
            wAmount=(EditText)itemView.findViewById(R.id.wAmount);
            aSwitch=(Switch)itemView.findViewById(R.id.switch1);

            linearLayout=(LinearLayout)itemView.findViewById(R.id.linearlayout);
            gd = (GradientDrawable)itemView.getBackground();
        }
    }

    List<Data> dataList;

    public RvAdapter( List<Data> dataList)
    {
        this.dataList = dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dummy, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position)
    {
        Data data= dataList.get(position);
        holder.bank.setText(data.getBank());
        holder.funds.setText(data.getFunds());
        holder.cValue.setText(data.getcValue());

        gd.setStroke(13,data.getColor());
        linearLayout.setBackgroundDrawable(gd);

        holder.aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                    holder.wAmount.setText(holder.cValue.getText());

            }
        });

        holder.wAmount.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                int v=0,w=0;
                try
                {
                    v= Integer.parseInt(holder.cValue.getText().toString());
                    w=Integer.parseInt(s.toString());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }



                if(w>v)
                    holder.wAmount.setError("cannot be more than Current Value");

                else if(w==v)
                    holder.aSwitch.setChecked(true);

                else
                    holder.aSwitch.setChecked(false);

            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
    }


    @Override
    public int getItemCount()
    {
        return dataList.size();
    }

}
