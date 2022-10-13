package com.example.coinflip;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button fejgomb;
    private Button irasgomb;
    private ImageView kep;
    private TextView dobasok;
    private TextView gyozelem;
    private TextView vereseg;
    private int szam = 0;
    private int gyozelemszam = 0;
    private int veresegszam = 0;
    private Toast toast;
    private AlertDialog.Builder alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addListeners();
        if (szam == 6) {
            if (gyozelemszam > veresegszam) {
                alert = new AlertDialog.Builder(MainActivity.this)

                        .setTitle("Győzelem")
                        .setMessage("Szeretnél új játékot játszani?")

                        .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                szam = 0;
                            }
                        })

                        .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
                if (gyozelemszam < veresegszam) {
                    alert = new AlertDialog.Builder(MainActivity.this)

                            .setTitle("Vereség")
                            .setMessage("Szeretnél új játékot játszani?")

                            .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    szam = 0;
                                    gyozelemszam = 0;
                                    veresegszam = 0;
                                }
                            })

                            .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            });
                }
            }

        }
        //0 - fej
        //1 - írás
    }

    private void addListeners() {
        szam++;

        fejgomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                szam++;
                    dobasok.setText("Dobasok: " + szam);
                    if (Math.random() * 2 + 1 == 1) {
                        kep.setImageResource(R.drawable.heads);
                        gyozelemszam++;
                        gyozelem.setText("Győzelem: " + gyozelemszam);
                        toast.setText("Győzelem!");
                    }
                    else if (Math.random() * 2 + 1 == 1){
                        kep.setImageResource(R.drawable.tails);
                        veresegszam++;
                        vereseg.setText("Vereség: " + veresegszam);
                        toast.setText("Vereség!");
                    }
                }
        });

        irasgomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                szam++;
                dobasok.setText("Dobasok: " + szam);

                if (Math.random() == 1) {
                    kep.setImageResource(R.drawable.heads);
                    gyozelemszam++;
                    gyozelem.setText("Győzelem: " + gyozelemszam);
                    toast.setText("Győzelem!");
                }
                else if (Math.random() == 0){
                    kep.setImageResource(R.drawable.tails);
                    veresegszam++;
                    vereseg.setText("Vereség: " + veresegszam);
                    toast.setText("Vereség!");
                }

            }
        });
    }

    private void init() {
        fejgomb = findViewById(R.id.fejgomb);
        irasgomb = findViewById(R.id.irasgomb);
        kep = findViewById(R.id.kep);
        dobasok = findViewById(R.id.dobasok);
        gyozelem = findViewById(R.id.gyozelem);
        vereseg = findViewById(R.id.vereseg);

    }
}