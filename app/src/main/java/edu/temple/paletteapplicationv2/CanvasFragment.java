package edu.temple.paletteapplicationv2;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class CanvasFragment extends Fragment {


    String color;

    public static final String COLOR_KEY = "color_name";


    public CanvasFragment() {
        // Required empty public constructor
    }

    public static CanvasFragment newInstance(String color){

        CanvasFragment cf = new CanvasFragment();

        Bundle bundle = new Bundle();
        bundle.putString(COLOR_KEY,color);

        cf.setArguments(bundle);

        return cf;


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null) {
            color = getArguments().getString(COLOR_KEY);

            switch(color)
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
                default:
                    color = color;
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_canvas, container, false);

        FrameLayout canvasFrame = v.findViewById(R.id.canvasFragBack);

        if (!color.equals("clear")) {
            canvasFrame.setBackgroundColor(Color.parseColor(color));
        }



        return v;
    }

}
