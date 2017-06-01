package com.example.javier.isbn;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnValidar;
    private EditText txtCodigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnValidar = (Button) findViewById(R.id.btnValidar);
        txtCodigo = (EditText) findViewById(R.id.txtCodigo);

        btnValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //se aplica el metodo para que al presionarse el boton se haga la compriobacion.

            }
        });
    }

    public class ISBN {

        private boolean isbn10(String isbn) {

            String mcdD10;
            int suma = 0;

            for (int d = 0; d < 10; d++) {
                mcdD10 = isbn.substring(d, d + 1);
                if (d < 9 || mcdD10 != "X") {
                    suma += Integer.parseInt(mcdD10) * (10 - d);
                } else {
                    suma += 10;
                }
            }
            return (suma % 11 == 0);
        }


    }
}










/*
public class ISBN {


    private static boolean isbn10(String isbn){
            
            String mcdD10;
            int suma = 0;
            
            for (int d = 0; d < 10; d++){
                mcdD10 = isbn.substring(d, d+1);
                if(d < 9 || mcdD10 != "X"){
                    suma += Integer.parseInt(mcdD10)* (10 - d);                    
                }else {
                    suma += 10;
                }                
            }            
            return (suma % 11 == 0);
        }
        
    private static boolean isbn13(String isbn){
            
            int mcdD13;
            int suma = 0;
            
            for (int d = 0; d < 13; d++){
                mcdD13 = Integer.parseInt(isbn.substring(d, d+1));
                if (d % 2 == 0){
                    suma += mcdD13 *1;                    
                }else {
                    suma += mcdD13 *3;
                }
            }            
            return (suma % 11 == 0);
        }
        
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String isbn;
        
        System.out.println("Ingresa un ISBN");
        isbn = sc.nextLine();
        sc.close();
        
        isbn = isbn.replaceAll("( |-)", "");
        
        
        boolean isValid = false;
        if(isbn.length() == 10){
            isValid = isbn10(isbn);                        
        }else if(isbn.length() == 13){
            isValid = isbn13(isbn);            
        }else {
            isValid = false;
        }
        
        if(isValid){
            System.out.println(isbn + ": Es un ISBN Valido!");
        }else {
            System.out.println(isbn + ": No es un isbn Valido");            
        }
    }                    
}    

*/
