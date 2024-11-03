package es.agora.pokemoncardcreator;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FragmentGenerar extends Fragment {

    private Button botonGenerar;
    private HashMap<Integer,Pokemon> pokedex;
    private HashMap<Integer,Pokemon> equipo;
    public FragmentGenerar() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            equipo = (HashMap<Integer, Pokemon>) getArguments().getSerializable("equipo");
            pokedex =  (HashMap<Integer, Pokemon>) getArguments().getSerializable("pokedex");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_generar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        botonGenerar = view.findViewById(R.id.boton_generar);
        botonGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int indice = (int)((Math.random()*(pokedex.size()-1)+1));
                if(! equipo.containsKey(indice)){
                    equipo.put(indice,pokedex.get(indice));

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("equipoPokemon", equipo);
                    FragmentEquipo fragmentEquipo = new FragmentEquipo();
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, fragmentEquipo)
                            .commit();
                }else{
                    Toast.makeText(view.getContext(),"El pokemon generado ya está en tu equipo",Toast.LENGTH_LONG);
                }
            }
        });
    }
}