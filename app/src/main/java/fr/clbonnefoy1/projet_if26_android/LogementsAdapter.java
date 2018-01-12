package fr.clbonnefoy1.projet_if26_android;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Clément on 21/11/2017.
 */

public class LogementsAdapter extends ArrayAdapter<Logement>{

    private Context context;

    private List<Logement> logements;

    private int ressourceID;

    private boolean color_switch = true;

    private int gris = Color.rgb(245,245,245);
    private int bleu = Color.rgb(225,225,255);

    public LogementsAdapter(Context context, int resource, List<Logement> logements) {
        super(context, resource, logements);

        this.context = context;
        this.logements = logements;
        this.ressourceID = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LogementHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(ressourceID, parent, false);

            holder = new LogementHolder();

            holder.im_logement = (ImageView)row.findViewById(R.id.im_logement);

            holder.tv_label_logement = (TextView)row.findViewById(R.id.tv_label_logement);

            holder.tv_prix_logement = (TextView)row.findViewById(R.id.tv_prix_logement);

            holder.lv_item_linearlayout = (LinearLayout)row.findViewById(R.id.lv_item_linearlayout);

            row.setTag(holder);
        }
        else
        {
            holder = (LogementHolder)row.getTag();
        }

        Logement logement = logements.get(position);

        //holder.im_logement.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), Logement.getRessourceImageId()));

        holder.im_logement.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), logement.getImage_uri()));

        holder.tv_label_logement.setText(String.format("%s", logement.getLabel()));

        holder.tv_prix_logement.setText(String.format("Prix : %d",logement.getPrix()));

        if(color_switch) {
            holder.lv_item_linearlayout.setBackgroundColor(gris);
            color_switch = false;
        } else {
            holder.lv_item_linearlayout.setBackgroundColor(bleu);
            color_switch = true;
        }

        return row;
    }

    static class LogementHolder
    {
        ImageView im_logement;
        TextView tv_label_logement;
        TextView tv_prix_logement;
        LinearLayout lv_item_linearlayout;
    }


}
