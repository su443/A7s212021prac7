package mx.edu.tesoem.isc.svj.a7s212021prac7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    TextView txtnombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnombre = findViewById(R.id.txtnombre);
        if(verificaArchivo(this))Toast.makeText(this,"el archivo existe",Toast.LENGTH_LONG).show();
        else Toast.makeText(this."el archivo no existe",Toast.LENGTH_LONG).show();
    }

    public void procesoGaba(View v){
        Context context = this;
        try{
            OutputStreamWriter archivo =new OutputStreamWriter(context.openFileOutput("g7s21txt.txt", Activity.MODE_PRIVATE));
            archivo.write(txtnombre.getText().toString());
    } catch(Exception ex){
            Toast.makeText(this,"no se pudo crear el archivo", Toast.LENGTH_SHORT).show();
        }
    }

    public void procesoLeer(View v){
        Context context = this;
        try{
            InputStreamReader archivo = new InputStreamReader(context.openFileInput("g7s21txt.txt"));
            BufferedReader br = new BufferedReader(archivo);
            String lineatexto = "";
            while((lineatexto =br.readLine()) != null){
                Toast.makeText(this,"informacion",Toast.LENGTH_SHORT).show();
            }
        } catch (Exception ex){
            Toast.makeText(this,"no se pudo leer la informacion del archivo",Toast.LENGTH_SHORT).show();
        }
    }

    public boolean verificaArchivo(Context context){
        String[]  archivos = context.fileList();
        for (String archivo : archivos)
            if (archivos.equals("g7s21txt.txt")) return true;
      return false;
    }
}