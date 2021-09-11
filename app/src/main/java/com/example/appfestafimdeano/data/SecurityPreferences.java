package com.example.appfestafimdeano.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SecurityPreferences {
    //variavel tipo SharedPreferences
    private SharedPreferences mSharedPreferences;

    //construtor com intuito de iniciar o BD com Contexto se ele sera visivel fora do app
    public SecurityPreferences(Context mContext) {
        this.mSharedPreferences = mContext.getSharedPreferences("FestaFimAno", Context.MODE_PRIVATE);
    }

    //salvar, seu funcionamento se da em uma chave atrelada a um valor
    public void stroreString(String key, String value) {
        this.mSharedPreferences.edit().putString(key, value).apply();//.applay: salvar mudancas
    }

    //consutar
    public String getStoredString(String key) {
        return this.mSharedPreferences.getString(key, "");
    }

}
