package com.example.recyclerview;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by Shrey on 30/04/2017.
 */

class Data
{
    String bank,funds,cValue;
    String wAmount;
    int logo,color;

    public Data(String bank, String funds, String cValue, int logo, int color)
    {
        this.bank = bank;
        this.funds = funds;
        this.cValue = cValue;
        this.logo = logo;
        this.color = color;
    }

    //bank name
    public String getBank()
    {
        return bank;
    }

    //funds
    public String getFunds()
    {
        return funds;
    }

    //cValue
    public String getcValue()
    {
        return cValue;
    }

    //logo
    public int getLogo()
    {
        return logo;
    }

    //color
    public int getColor()
    {
        return color;
    }
}
