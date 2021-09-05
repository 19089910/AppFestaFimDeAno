package com.example.appfestafimdeano.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.appfestafimdeano.R;
import com.example.appfestafimdeano.constantes.FimDeAnoConstantes;
import com.example.appfestafimdeano.data.SecurityPreferences;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;//= new SecurityPreferences(this) iria dar erro
    //pois e o onCreate e que possui o contexto logo, tera ques ser feito dentro dele essa instancia

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        this.mSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.checkParticipate = findViewById(R.id.check_participate);
        this.mViewHolder.checkParticipate.setOnClickListener(this);
    }
    //LOGICA g
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.check_participate) {
            if (this.mViewHolder.checkParticipate.isChecked()) {//checkBox=true or false
                //salvar o SecurityPreferences true
                this.mSecurityPreferences.stroreString(FimDeAnoConstantes.PRESENCE_KEY, FimDeAnoConstantes.CONFIRMATION_YES);
            } else {
                //salvar false
                this.mSecurityPreferences.stroreString(FimDeAnoConstantes.PRESENCE_KEY, FimDeAnoConstantes.CONFIRMATION_NO);
            }
        }
    }


    private static class ViewHolder {
        CheckBox checkParticipate;
    }
}