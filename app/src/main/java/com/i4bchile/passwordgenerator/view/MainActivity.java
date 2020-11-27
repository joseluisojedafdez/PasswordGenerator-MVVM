package com.i4bchile.passwordgenerator.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.app.Instrumentation;
import android.os.Bundle;
import android.view.View;

import com.i4bchile.passwordgenerator.R;
import com.i4bchile.passwordgenerator.databinding.ActivityMainBinding;
import com.i4bchile.passwordgenerator.model.Generator;
import com.i4bchile.passwordgenerator.viewmodel.GeneratorViewModel;

public class MainActivity extends AppCompatActivity {
/* TODO

    [x] importar dependencias en build graddle y/o actualizar funcionalidades
    [X] Generar Layout
    [X] Generar clase GeneratePassword
    [x] Generar ViewModel
    [] Enlazar ViewModel con MainActivity
*/
public GeneratorViewModel model;
private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        model=new ViewModelProvider(this).get(GeneratorViewModel.class);

        binding.btGeneratePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numCaracter=Integer.parseInt(binding.etNumcat.getText().toString());
                model.generateratePassword(numCaracter);
            }
        });

        model.getPwd().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvResultado.setText(s);
            }
        });
    }
}