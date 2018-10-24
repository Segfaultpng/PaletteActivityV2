package edu.temple.paletteapplicationv2;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PaletteActivity extends AppCompatActivity implements PaletteFragment.GetColorInterface {

    FragmentManager fm;

    Boolean singlePane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        singlePane = findViewById(R.id.container_2) == null;

        fm = getSupportFragmentManager();

        fm.beginTransaction().replace(R.id.container_1,new PaletteFragment()).commit();



    }

    @Override
    public void colorSelected(String colorname) {

        String color = colorname;
        switch(colorname)
        {
            case "seleccionar":
                color = "clear";
                break;
            case "GRIS":
                color = "GRAY";
                break;
            case "azul":
                color = "blue";
                break;
            case "amarillo":
                color = "yellow";
                break;
            case "magenta":
                color = "magenta";
                break;
            case "cian":
                color = "cyan";
                break;
            case "rojo":
                color = "red";
                break;
            case "select":
                color = "clear";
                break;
            default:
                color = colorname;
        }

        if(!color.equals("clear")){

        CanvasFragment cf = CanvasFragment.newInstance(color);


            if(!singlePane) {
                fm.beginTransaction().replace(R.id.container_2, cf).addToBackStack(null).commit();
            }else{
                fm.beginTransaction().replace(R.id.container_1, cf).addToBackStack(null).commit();
            }
        }


    }
}
