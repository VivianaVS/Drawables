package com.example.drawable

import android.R.attr.button
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


private var sharedPreferences: SharedPreferences? = null;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constraintLayout = findViewById<ConstraintLayout>(R.id.main)
        val animationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(1000)
        animationDrawable.setExitFadeDuration(2000)
        animationDrawable.start()


        val bar = supportActionBar
        bar!!.setBackgroundDrawable(resources.getDrawable(R.drawable.gradient))
        val btn =  findViewById<Button>(R.id.start)
        btn.setOnClickListener {
                change();
          }



    }



    private fun change() {

       var i= cargar();
        val btn =  findViewById<Button>(R.id.start);
        val txt =  findViewById<Button>(R.id.nine);

        if(i==1) {
            btn.setBackgroundResource(R.drawable.custome_button2);
            txt.setText(R.string.t1)
            guardar(2)
        }
        else if(i==2){
            btn.setBackgroundResource(R.drawable.custome_button3);
          //  btn.setTextColor(Color.parseColor("#812BF0"));
            btn.setText(R.string.start);
            txt.setText(R.string.t2)
            guardar(3)
        }
        else if(i==3){
            btn.setBackgroundResource(R.drawable.custome_button4);
            btn.setTextColor(Color.parseColor("#ffffff"));
            txt.setText(R.string.t1)
            guardar(4)
        }
        else if(i==4){
            btn.setBackgroundResource(R.drawable.custome_button5);
            btn.setText(R.string.again);

            txt.setText(R.string.t2)

            guardar(5)
        }
        else if(i==5){
            btn.setBackgroundResource(R.drawable.custome_button1);
            btn.setText(R.string.start);
            txt.setText(R.string.t1)
            guardar(6)
        }


    }


    private fun guardar(i : Int){
        val sharedPreferences = getPreferences(MODE_PRIVATE)
        var editor = sharedPreferences?.edit();
        editor!!.remove("actual").apply();
        if(i>5) {
            editor!!.putInt ("actual",1);
        }else {
            editor!!.putInt("actual",i);
        }
        editor!!.commit();

    }


    private fun cargar(): Int{
        val sharedPreferences = getPreferences(MODE_PRIVATE)
        var actual: Int? = sharedPreferences?.getInt("actual",1);
        if(actual!! >5) actual=1;
        return actual!!;
    }

}