package br.com.unicsul.projetojokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
       this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }



    public void opcaoSelecionada(String opcaoSelecionada){

        ImageView imagemResultado = findViewById(R.id.imagemResultado);
        TextView contadorResultado = findViewById(R.id.contador);
        ImageView emojiResultado = findViewById(R.id.emojiResultado);



        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp){
            case "pedra":
              imagemResultado.setImageResource(R.drawable.pedra);
                 break;

            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (opcaoApp == "tesoura" && opcaoSelecionada == "papel") ||
                        (opcaoApp == "papel" && opcaoSelecionada == "pedra") ||
                        (opcaoApp == "pedra" && opcaoSelecionada == "tesoura")
        ) {
            //textoResultado.setText("Quen Quen...");
            emojiResultado.setImageResource(R.drawable.derrota);
            contador = 0;
            contadorResultado.setText( Integer.toString(contador));
        } else if(
                (opcaoSelecionada == "tesoura"  && opcaoApp == "papel") ||
                        (opcaoSelecionada == "papel" && opcaoApp == "pedra") ||
                        (opcaoSelecionada == "pedra"  && opcaoApp == "tesoura")


        ){

            //textoResultado.setText("Winna Winna tika chinner...");
            emojiResultado.setImageResource(R.drawable.venceu);
            contador = contador + 1;
             contadorResultado.setText( Integer.toString(contador));
        } else {
            //textoResultado.setText("Empaaaattouuuuuuuuuuuuuu!!!...");
            emojiResultado.setImageResource(R.drawable.empate);
        }
    }



}