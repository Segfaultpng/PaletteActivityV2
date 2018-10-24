package edu.temple.paletteapplicationv2;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaletteFragment extends Fragment {

    Spinner colorspinner;
    Context parent;
    String previousColor = null;


    public PaletteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_palette, container, false);

        colorspinner = (Spinner) v.findViewById(R.id.colorpalette);
        PaletteAdapter colorAdapter = new PaletteAdapter(parent,R.layout.palette_adapter,parent.getResources().getStringArray(R.array.grid_array));
        colorspinner.setAdapter(colorAdapter);


        colorspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View view, int position, long id) {
                String colorName = (String) parentView.getItemAtPosition(position);

                if(!colorName.equals("clear") && !colorName.equals(previousColor)) {
                    ((GetColorInterface) parent).colorSelected(colorName);
                    previousColor = colorName;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.parent = context;
    }

    interface GetColorInterface{
        public void colorSelected(String colorname);
    }
}
