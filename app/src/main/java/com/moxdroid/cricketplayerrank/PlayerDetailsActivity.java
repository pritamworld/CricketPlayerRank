package com.moxdroid.cricketplayerrank;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.moxdroid.cricketplayerrank.adapter.PlayerDetailsAdapter;
import com.moxdroid.cricketplayerrank.data.model.Player;

import java.util.HashMap;

public class PlayerDetailsActivity extends AppCompatActivity
{

    private ListView lstPlayerDetails;
    private HashMap<String, String> playerData;
    private Player mPlayer;
    private PlayerDetailsAdapter playerDetailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_details);


        mPlayer = (Player) getIntent().getSerializableExtra(ListPlayerActivity.PARAM_PLAYER);

        lstPlayerDetails = (ListView) findViewById(R.id.lstPlayersDetails);

        playerData = new HashMap<>();
        playerData.put("Player ID", String.valueOf(mPlayer.get_id()));
        playerData.put("Player Name", String.valueOf(mPlayer.getPlayerName()));
        playerData.put("Gender", String.valueOf(mPlayer.getGender()));
        playerData.put("Birth Date", String.valueOf(mPlayer.getBirthDate()));
        playerData.put("Category", String.valueOf(mPlayer.getPlayerCategory()));
        playerData.put("Country", String.valueOf(mPlayer.getTeamCountry()));
        playerData.put("No. Of Test Match", String.valueOf(mPlayer.getNoOfTestMatch()));
        playerData.put("No. Of ODI", String.valueOf(mPlayer.getNoOfOneDayMatch()));
        playerData.put("No. Of Catches", String.valueOf(mPlayer.getNoOfCatches()));
        playerData.put("No. Of Runs", String.valueOf(mPlayer.getNoOfRuns()));
        playerData.put("No. Of Wickets", String.valueOf(mPlayer.getNoOfWickets()));
        playerData.put("No. Of Stumpings", String.valueOf(mPlayer.getNoOfStumpings()));
        playerData.put("Total Points", String.valueOf(mPlayer.getTotalPoints()));

        playerDetailsAdapter = new PlayerDetailsAdapter(playerData);
        lstPlayerDetails.setAdapter(playerDetailsAdapter);
    }
}
