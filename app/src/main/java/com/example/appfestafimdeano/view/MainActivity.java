package com.example.appfestafimdeano.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.appfestafimdeano.R;
import com.example.appfestafimdeano.constantes.FimDeAnoConstantes;
import com.example.appfestafimdeano.data.SecurityPreferences;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private viewHolder mViewHolder = new viewHolder();
    private static SimpleDateFormat SIMPLE_DATE_FORMATE = new SimpleDateFormat("dd/MM/yyyy");
    private SecurityPreferences mSecurityPreference;

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
        //DATA informa; o que dia e hj e quantos dias faltao para o fim de ano
            // informacao do toDay
        this.mViewHolder.textToday.setText(SIMPLE_DATE_FORMATE.format(Calendar.getInstance().getTime()));
            //informacao da contagem de dias para o fim do ano
        String dia = String.format("%s %s", String.valueOf(this.getDaysLeft()), getString(R.string.Dias));
        this.mViewHolder.textDaysLaft.setText(dia);
        //Butao informa; se nao confirmado ou sim ou nao, para festa:
            //instancia das chaves
        mSecurityPreference = new SecurityPreferences(this);


    }
    //cilco de vida de uma activity
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //VerifyPresence(), retorna qualquer valor associado a chave
        this.VerifyPresence();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //eventoCLick
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_confirm) {
            //instancia (context, açao)
            Intent intent = new Intent(this, DetailsActivity.class);
            //putExtra, passagem retorno do dado da key para a Details
            String Presence = this.mSecurityPreference.getStoredString(FimDeAnoConstantes.PRESENCE_KEY);
            intent.putExtra(FimDeAnoConstantes.PRESENCE_KEY, Presence);
            //abrir Activity da açao
            startActivity(intent);
        }
    }

    //DATA; Logica do quantos dias faltal par o fim do ano
    private int getDaysLeft() {
        //dia hoje
        int today = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
        //dias total do ano
        int Maxday = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_YEAR);

        return Maxday - today;
    }

    private void VerifyPresence() {
        //retorna qualquer valor associado a chave
        String Presence = this.mSecurityPreference.getStoredString(FimDeAnoConstantes.PRESENCE_KEY);
        if(Presence.equals("")){
            //verificar se ele nao confirmou
            this.mViewHolder.buttonConfirm.setText(getString(R.string.nao_confirmado));
        } else if (Presence.equals(FimDeAnoConstantes.CONFIRMATION_YES)) {
            //verificar se ele confirmou e vai
            this.mViewHolder.buttonConfirm.setText(getString(R.string.sim));
        } else {
            //verificar se ele confirmou e nao vai
            this.mViewHolder.buttonConfirm.setText(getString(R.string.nao));
        }

    }
    //ViewHolder; atrubuicao do ViewHolder aos id's para manipulacao
    private static class viewHolder {
        TextView textToday;
        TextView textDaysLaft;
        Button buttonConfirm;
    }
}