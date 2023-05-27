package com.example.leydeenfriamientodenewton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import static java.lang.Math. *;

import java.text.DecimalFormat;

public class ley_newton_enfria extends AppCompatActivity {

    private EditText cajat1;
    private EditText cajat2;
    private EditText cajaT1;
    private EditText cajaT2;
    private EditText cajaTm;
    private EditText caja_tiem;
    private EditText caja_Tem_ideal;
    private TextView res_a;
    private TextView res_b;
    private TextView ecuacion_generada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ley_newton_enfria);

        cajat1 = (EditText) findViewById(R.id.cajat1);
        cajat2 = (EditText) findViewById(R.id.cajat2);

        cajaT1 = (EditText) findViewById(R.id.cajaT1);
        cajaT2 = (EditText) findViewById(R.id.cajaT2);

        cajaTm = (EditText) findViewById(R.id.cajaTm);

        caja_tiem = (EditText) findViewById(R.id.caja_tiem);

        caja_Tem_ideal = (EditText) findViewById(R.id.caja_Tem_ideal);
        ecuacion_generada = (TextView) findViewById(R.id.ecuacion_generada);

        res_a = (TextView) findViewById(R.id.res_a);
        res_b = (TextView) findViewById(R.id.res_b);


    }


    double t1, t2, T1, T2, Tm, Tnew, tnew  , k=0 ,e2;
    double e,TemOper,c, paso ,paso2,elim_e , add_ln;
    DecimalFormat df = new DecimalFormat("#.####");

    public void calcular(View view) {

        t1 = Float.parseFloat(cajat1.getText().toString());
        t2 = Float.parseFloat(cajat2.getText().toString());
        T1 = Float.parseFloat(cajaT1.getText().toString());
        T2 = Float.parseFloat(cajaT2.getText().toString());
        Tm = Float.parseFloat(cajaTm.getText().toString());
        tnew = Float.parseFloat(caja_tiem.getText().toString());
        Tnew = Float.parseFloat(caja_Tem_ideal.getText().toString());


        if (t1 ==0){

            //OPRECIONES PARA C
            e=Math.exp(t1*k);//euler con la multiplicacion de potencias
            TemOper=T1-Tm;//simplificacion de la Temperatura 1 con la Tempe ambiente
            c=TemOper;


            //operaciones para K

            paso=T2-Tm;//simplificacion de la Temperatura 2 con la Tempe ambiente
            paso2=paso/c;
            e2= Math.exp(t2);
            elim_e=log(e2);

            add_ln=log(paso2);

            k=(((log(paso2))/elim_e));


            ecuacion_generada.setText("T(t)= "+df.format(c)+"(e^"+df.format(k)+" t)"+Tm);


        } else if (t1 !=0 ){
            double t_deno_num, sum_expo;

            //OPRECIONES PARA C
            //e=Math.exp(t1*k);//euler con la multiplicacion de potencias
            TemOper=T1-Tm;
            t_deno_num=t1*(-1);

            //opreciones de K
            paso=T2-Tm;
            paso2=paso/TemOper;

            sum_expo=(t_deno_num+(t2));



            e2= Math.exp(sum_expo);
            elim_e=log(e2);

            add_ln=log(paso2);

            k=(((log(paso2))/elim_e));


            //VALOR DE C TENIDNDO VALOR DE K SIMPLIFICAR


            res_a.setText("a)= "+k);


            c=(TemOper*(Math.exp(t_deno_num*k)));


            ecuacion_generada.setText("T(t)= "+df.format(c)+"(e^"+df.format(k)+" t)"+Tm);




        }

        double  paso4;

        //opcion a respuesta

        paso4= c*Math.exp(((k)*(tnew)))+Tm;
        res_a.setText("a)= "+df.format(paso4));


        //OPCION B RESPUESTA
        double paso5 , sim, elim_euler,e3,add_log_sim, t;
        paso5=Tnew-Tm;
        sim=paso5/c;
        e3=Math.exp(k);

        elim_euler=Math.log(e3);
        add_log_sim=Math.log(sim);
        t=((add_log_sim)/elim_euler);

        res_b.setText("b)= "+df.format(t));

    }


    public void limpiar(View view){

    }
}