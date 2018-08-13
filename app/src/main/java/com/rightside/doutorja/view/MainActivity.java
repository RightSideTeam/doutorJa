package com.rightside.doutorja.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.rightside.doutorja.R;
import com.rightside.doutorja.fragment.DomicilioFragment;
import com.rightside.doutorja.fragment.EspecialidadeFragment;
import com.rightside.doutorja.fragment.MinhasConsultasFragment;
import com.rightside.doutorja.fragment.PerfilFragment;
import com.rightside.doutorja.utils.BottomNavigationViewHelper;
import com.rightside.doutorja.utils.FragmentoUtils;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_inicio:
                    FragmentoUtils.replace(MainActivity.this, new EspecialidadeFragment());
                    return true;
                case R.id.navigation_minhas_consultas:
                    FragmentoUtils.replace(MainActivity.this, new MinhasConsultasFragment());
                    return true;
                case R.id.navigation_perfil:
                    FragmentoUtils.replace(MainActivity.this, new PerfilFragment());
                    return true;
                case R.id.navigation_domicilio:
                    FragmentoUtils.replace(MainActivity.this,new DomicilioFragment());
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        FragmentoUtils.replace(MainActivity.this, new EspecialidadeFragment());
    }

}