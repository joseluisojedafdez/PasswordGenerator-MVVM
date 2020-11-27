package com.i4bchile.passwordgenerator.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.i4bchile.passwordgenerator.model.Generator;

public class GeneratorViewModel extends ViewModel {

    private static final String TAG = "GeneratorViewModel";
    private Generator generator;
    private MutableLiveData<String> pwd;

    public GeneratorViewModel(){
        this.pwd=new MutableLiveData<>();
    }

    public LiveData<String> getPwd() {
        return pwd;
    }

    public void generateratePassword(int pLength) {
        generator=new Generator();
        Log.d(TAG, "llamado generatePassword() de ViewModel ");
        String password = generator.generatePassword(pLength);
        pwd.setValue(password);


    }
}
