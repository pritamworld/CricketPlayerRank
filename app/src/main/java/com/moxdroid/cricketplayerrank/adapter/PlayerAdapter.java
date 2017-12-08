package com.moxdroid.cricketplayerrank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.moxdroid.cricketplayerrank.R;
import com.moxdroid.cricketplayerrank.data.model.Player;

import java.util.ArrayList;


public class PlayerAdapter extends ArrayAdapter<Player>
{

    public PlayerAdapter(Context context, ArrayList<Player> contactArrayList)
    {
        super(context, 0, contactArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Get the data item for this position
        Player mPlayer = getItem(position);
        ViewHolder viewHolder;

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_player, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Populate the data into the template view using the data object
        if (mPlayer != null)
        {
            viewHolder.tvPlayerName.setText(mPlayer.getPlayerName());
        } else
        {
            viewHolder.tvPlayerName.setText("NO NAME FOUND");
        }

        return convertView;
    }

    private class ViewHolder
    {
        final TextView tvPlayerName;

        ViewHolder(View convertView)
        {
            tvPlayerName = (TextView) convertView.findViewById(R.id.txtPlayerName);
        }
    }
}
