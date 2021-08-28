package com.example.appfestafimdeano.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SecurityPreferences {
    //instacia do "BD"
    private SharedPreferences mSharedPreferences;

    //construtor com intuito de iniciar um BD com conteudo(inicar com contexto)
    private SecurityPreferences(Context mContext) {
        this.mSharedPreferences = mContext.getSharedPreferences("FestaFimAno", Context.MODE_PRIVATE);
    }
    public void stroreString(String key, String value) {
        this.mSharedPreferences.edit().putString(key,value).apply();//.applay: salvar mudancas
    }
    public String getStoredString(String key) {
        return this.mSharedPreferences.getString(key , "");
    }

}
