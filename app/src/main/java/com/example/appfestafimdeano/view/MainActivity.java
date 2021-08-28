package com.example.appfestafimdeano.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.appfestafimdeano.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private viewHolder mViewHolder = new viewHolder();
    private static SimpleDateFormat SIMPLE_DATE_FORMATE = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ViewHolder; atrubuicao do ViewHolder aos id's para manipulacao
        this.mViewHolder.textToday = findViewById(R.id.text_today);
        this.mViewHolder.textDaysLaft = findViewById(R.id.text_days_laft);
        this.mViewHolder.buttonConfirm = findViewById(R.id.button_confirm);
        //eventoCLick
        this.mViewHolder.buttonConfirm.setOnClickListener(this);
        //DATA;
        this.mViewHolder.textToday.setText(SIMPLE_DATE_FORMATE.format(Calendar.getInstance().getTime()));

        String dia = String.format("%s %s", String.valueOf(this.getDaysLeft()), getString(R.string.Dias));
        this.mViewHolder.textDaysLaft.setText(dia);
    }

    //eventoCLick
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_confirm) {
            Intent a = new Intent(this, DetailsActivity.class);
            startActivity(a);
        }
    }

    //DATA; Logica do quantos dias faltal par o fim do ano
    private int getDaysLeft() {
        //dia hoje
        Calendar calenderToDays = Calendar.getInstance();
        int today = calenderToDays.get(Calendar.DAY_OF_YEAR);
        //dias total do ano
        //Calendar calenderLestDay = Calendar.getInstance();
        int Maxday = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_YEAR);

        return Maxday - today;
    }

    private static class viewHolder {
        TextView textToday;
        TextView textDaysLaft;
        Button buttonConfirm;
    }
}