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

    private static boolean isbn10(String isbn) {
        int n = Integer.parseInt(isbn);
        int sum = 0;
        int i;

        System.out.print(" El ISBN es: " + isbn);
        
        for (i = 2; i <= 10; i++) {
            int digit = n % 10;
            sum = sum + i * digit;
            n = n / 10;
        }
                
        if (sum % 11 == 1) {
            System.out.println("-X   " + sum);
        } else if (sum % 11 == 0) {
            System.out.println("-0"  + sum);
        } else {
            System.out.println(11 - (sum % 11) + sum);
        }
        return (sum % 11 == 1);
    }


 
    private static boolean isbn13(String isbn) {

        int mcd13;
        int suma = 0;
        int d;

        for (d = 0; d < 13; d++) {
            mcd13 = Integer.parseInt(isbn.substring(d, d + 1));
            if (d % 2 == 0) {
                suma += mcd13 * 1;
            } else {
                suma += mcd13 * 3;
            }
        }
        return (suma % 13 == 0);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String isbn;

        System.out.println(" Ingresa un ISBN");
        isbn = sc.nextLine();
        sc.close();

        isbn = isbn.replaceAll("( |-)", "");

        boolean isValid = false;

        if (isbn.length() == 10) {
            isValid = isbn10(isbn);
        } else if (isbn.length() == 13) {
            isValid = isbn13(isbn);
        } else {
            isValid = false;
        }

        if (isValid) {
            System.out.println("\n El ISBN: " + isbn + " si es un ISBN valido.");
        } else {
            System.out.println("\n El ISBN: " + isbn + " no es un ISBN valido.");
        }
    }
}

*/
