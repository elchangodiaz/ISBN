package com.example.javier.isbn;

import android.content.Context;
import android.media.MediaCodec;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

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

        public static final int ISBN13 = 13;

        public static final int ISBN10 = 10;

        public boolean validar(String isbn){
            if (isbn == null)
                Toast.makeText(getApplicationContext(), "Ingrese un ISBN valido", Toast.LENGTH_SHORT);
            //if (!Pattern.matches("^$d}%&()//*?!@¡", isbn )) return false;


            if (isbn.length() == 13) return ISBN13Valido();
           // else if (isbn.length() == 10) return ISBN10Valido ();
            else Toast.makeText(getApplicationContext(), "ISBN invalido", Toast.LENGTH_SHORT);
            return false;

        }

     public boolean ISBN13Valido(String numero){
         if (numero == null)
             Toast.makeText(getApplicationContext(), "ISBN no valido", Toast.LENGTH_SHORT);
         if (!Pattern.matches("^\\d{" + ISBN13 + "}$", numero)) throw new IllegalArgumentException();
         char [] digits = numero.toCharArray();
         final int miDigito = calcularISBN13CheckDigito (digits);
         int checkDigito = digits[ISBN13 - 1] - '0';
         return miDigito == 10 && checkDigito == 0 || miDigito == checkDigito;
     }

        public int calcularISBN13CheckDigito(char[] digits) {
            if (digits == null) throw new NullPointerException();
            if (digits.length != ISBN13 && digits.length != ISBN13 - 1) throw new IllegalArgumentException();
            for (char c : digits) {
                if (c < '0' || '9' < c) throw new IllegalArgumentException();
            }

            int[] multip = {1, 3};
            int suma = 0;
            for (int i = 0; i < ISBN13 - 1; ++i) {
                suma += (digits[i] - '0') * multip[i % 2];
            }
            return 10 - suma % 10;
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
