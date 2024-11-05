package es.agora.pokemoncardcreator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FragmentEquipo extends Fragment {

    private RecyclerView recyclerView;
    private HashMap<Integer, Pokemon> equipo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            equipo = (HashMap<Integer, Pokemon>) getArguments().getSerializable("equipoPokemon");
        } else {
            equipo = new HashMap<>();
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_equipo, container, false);
    }

    @Override

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view,savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_equipo);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        HashMap<Integer, Pokemon> equipo = PokemonRepository.getInstance().getEquipo();
        System.out.println("Tamaño del equipo: " + equipo.size());

        // Convertir el HashMap a una lista para el adaptador
        List<Pokemon> equipoList = new ArrayList<>(equipo.values());
        Adapter adapter = new Adapter(equipoList);
        recyclerView.setAdapter(adapter);
    }

}