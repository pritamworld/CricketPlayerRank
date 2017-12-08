package com.moxdroid.cricketplayerrank;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.moxdroid.cricketplayerrank.data.db.DBPlayer;
import com.moxdroid.cricketplayerrank.data.model.Player;

import java.util.Calendar;
import java.util.Random;

public class AddPlayerActivity extends AppCompatActivity
{

    private EditText edtName;
    EditText edtBirthdate;
    private EditText edtTestMatches;
    private EditText edtOneDayMatches;
    private EditText edtCatches;
    private EditText edtRuns;
    private EditText edtWickets;
    private EditText edtStumping;
    Button btnAddPlayer;

    private RadioGroup groupGender;
    private RadioButton radioMale;
    private RadioButton radioFemale;
    private Spinner spinnerCategory;
    private Spinner spinnerCountry;
    private Button btnBirthdate;
    private DBPlayer dbPlayer;
    private int year, month, day;
    private DatePicker datePicker;
    private final DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener()
            {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3)
                {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2 + 1, arg3);
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);
        intitViews();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save)
        {
            addPlayerToDB();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected Dialog onCreateDialog(int id)
    {
        // TODO Auto-generated method stub
        if (id == 999)
        {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view)
    {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
    }

    private void showDate(int year, int month, int day)
    {
        btnBirthdate.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    private void intitViews()
    {
        btnBirthdate = (Button) findViewById(R.id.btnBirthdate);
        btnBirthdate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                showDialog(999);
            }
        });

        java.util.Calendar mCalendar = java.util.Calendar.getInstance();
        year = mCalendar.get(Calendar.YEAR);

        month = mCalendar.get(Calendar.MONTH);
        day = mCalendar.get(Calendar.DAY_OF_MONTH);

        dbPlayer = new DBPlayer(getApplicationContext());

        edtName = (EditText) findViewById(R.id.edtName);
        edtTestMatches = (EditText) findViewById(R.id.edtTestMatches);
        edtOneDayMatches = (EditText) findViewById(R.id.edtOneDayMatches);
        edtCatches = (EditText) findViewById(R.id.edtCatches);
        edtRuns = (EditText) findViewById(R.id.edtRuns);
        edtWickets = (EditText) findViewById(R.id.edtWickets);
        edtStumping = (EditText) findViewById(R.id.edtStumping);

        groupGender = (RadioGroup) findViewById(R.id.radioGender);
        radioMale = (RadioButton) findViewById(R.id.radioMale);
        radioFemale = (RadioButton) findViewById(R.id.radioFemale);

        spinnerCategory = (Spinner) findViewById(R.id.spinnerCategory);
        spinnerCountry = (Spinner) findViewById(R.id.spinnerCountry);


        String[] items = new String[]{"Batsman", "Bowler", "Wicket keeper"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinnerCategory.setAdapter(adapter);

        String[] itemsCountry = new String[]{"India", "Brazil", "Canada", "England"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsCountry);
        spinnerCountry.setAdapter(adapter1);
    }

    private void addPlayerToDB()
    {

        Random rand = new Random();
        int id = dbPlayer.getAllplayers().size() + 1;


        //get gender
        String gender = "";
        if (radioMale.isChecked())
        {
            gender = "Male";
        } else
        {
            gender = "Female";
        }

        Player player = new Player(edtName.getText().toString(),
                gender,
                btnBirthdate.getText().toString(),
                spinnerCategory.getSelectedItem().toString(),
                spinnerCountry.getSelectedItem().toString(),
                Integer.parseInt(edtTestMatches.getText().toString()),
                Integer.parseInt(edtOneDayMatches.getText().toString()),
                Integer.parseInt(edtCatches.getText().toString()),
                Integer.parseInt(edtRuns.getText().toString()),
                Integer.parseInt(edtWickets.getText().toString()),
                Integer.parseInt(edtStumping.getText().toString()));

        dbPlayer.addPlayer(player);

        //Log.i("player", "Tag Count: " + dbPlayer.getPlayersCount());

        Toast.makeText(getApplicationContext(), "Player is added successfully.", Toast.LENGTH_SHORT).show();
    }
}
