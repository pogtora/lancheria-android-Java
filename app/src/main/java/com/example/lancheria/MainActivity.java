package com.example.lancheria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declaração dos componentes que serão acessados pelo Java no XML
    RadioButton radioXis, radioCachorro, radioXisCompleto, radioXisSalada, radioXisBacon, radioCachorroCompleto, radioCachorroCasa, radioCachorroCalabresa;
    CheckBox checkBacon, checkCebola, checkMaionese, checkOvo;
    TextView textResultado;
    RadioGroup radioGroupXis, radioGroupCachorro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //"conexão" dos componentes declarados no Java com os componente da interface gráfica (XML)
        radioXis = findViewById(R.id.radioXis);
        radioCachorro = findViewById(R.id.radioCachorro);
        radioXisCompleto = findViewById(R.id.radioXisCompleto);
        radioXisSalada = findViewById(R.id.radioXisSalada);
        radioXisBacon = findViewById(R.id.radioXisBacon);
        radioCachorroCompleto = findViewById(R.id.radioCachorroCompleto);
        radioCachorroCasa = findViewById(R.id.radioCachorroCasa);
        radioCachorroCalabresa = findViewById(R.id.radioCachorroCalabresa);

        checkBacon = findViewById(R.id.checkBacon);
        checkCebola = findViewById(R.id.checkCebola);
        checkMaionese = findViewById(R.id.checkMaionese);
        checkOvo = findViewById(R.id.checkOvo);

        textResultado = findViewById(R.id.textResultado);

        radioGroupXis = findViewById(R.id.radioGroupXis);
        radioGroupCachorro = findViewById(R.id.radioGroupCachorro);

    }

    //evento onClick do botão "Calcular"
    public void calcularClick(View view) {

        double valor = 0;
        boolean escolheuOpcao = false;

        if(radioXis.isChecked()){ //escolheu Xis
            //testa os tipos de Xis
            if(radioXisBacon.isChecked()){ //escolheu xis bacon
                valor = 25;
                escolheuOpcao = true;
            }
            else if(radioXisCompleto.isChecked()){ //escolheu xis completo
                valor = 20;
                escolheuOpcao = true;
            }
            else if(radioXisSalada.isChecked()){ //escolheu xis salada
                valor = 15;
                escolheuOpcao = true;
            }
            else{ //marcou Xis mas não escolheu o sabor do xis
                Toast.makeText(this, "Escolha um tipo de xis!!", Toast.LENGTH_SHORT).show();
            }
        }
        else if(radioCachorro.isChecked()){ //escolheu Cachorro
            if(radioCachorroCasa.isChecked()){ //escolheu cachorro da casa
                valor = 18;
                escolheuOpcao = true;
            }
            else if(radioCachorroCompleto.isChecked()){ //escolheu cachorro completo
                valor = 15;
                escolheuOpcao = true;
            }
            else if(radioCachorroCalabresa.isChecked()){ //escolheu cachorro calabresa
                valor = 20;
                escolheuOpcao = true;
            }
            else{ //marcou Cachorro mas não escolheu o sabor do cachorro
                Toast.makeText(this, "Escolha um tipo de cachorro!!", Toast.LENGTH_SHORT).show();
            }
        }
        else{ //não marcou nenhuma opção
            Toast.makeText(this, "Escolha uma opção de lanche!!", Toast.LENGTH_SHORT).show();
        }

        //verificação dos extras
        if(escolheuOpcao == true){ //só verifica os extras se o usuário escolheu alguma opção de lanche
            if(checkBacon.isChecked()){
                valor+=2;
            }
            if(checkCebola.isChecked()){
                valor+=1.5;
            }
            if(checkMaionese.isChecked()){
                valor+=1;
            }
            if(checkOvo.isChecked()){
                valor+=3;
            }

            textResultado.setText("Valor: "+valor);
        }
    }

    //evento que troca a visibilidade dos radioGroups dos tipos de lanche
    public void mostraLancheClick(View view) {
        //testa qual lanche está selecionado
        if(radioXis.isChecked()){ //xis selecionado
            radioGroupXis.setVisibility(View.VISIBLE); //mostra os sabores de xis
            radioGroupCachorro.setVisibility(View.GONE); //esconde os sabores de cachorro
        }
        else if(radioCachorro.isChecked()){ //cachorro selecionado
            radioGroupXis.setVisibility(View.GONE); //esconde os sabores de xis
            radioGroupCachorro.setVisibility(View.VISIBLE); //mostra os sabores de cachorro
        }
    }
}