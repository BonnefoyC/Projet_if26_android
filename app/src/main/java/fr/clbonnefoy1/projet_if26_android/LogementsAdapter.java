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

            row.setTag(holder);
        }
        else
        {
            holder = (LogementHolder)row.getTag();
        }

        Logement logement = logements.get(position);

        //holder.im_logement.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.bbfond));

        holder.tv_label_logement.setText(String.format("%s", logement.getLabel()));

        holder.tv_prix_logement.setText(String.format("Prix : %d",logement.getPrix()));

        //TODO Arrange ça !

        return row;
    }

    static class LogementHolder
    {
        ImageView im_logement;
        TextView tv_label_logement;
        TextView tv_prix_logement;
    }


}
