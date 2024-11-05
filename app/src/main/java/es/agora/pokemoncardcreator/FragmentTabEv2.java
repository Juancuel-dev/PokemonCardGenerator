package es.agora.pokemoncardcreator;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import es.agora.pokemoncardcreator.databinding.FragmentTabEv2Binding;

public class FragmentTabEv2 extends Fragment {
    private FragmentTabEv2Binding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentTabEv2Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        binding.recyclerViewPokedex2.setLayoutManager(gridLayoutManager);

        Adapter pokemonAdapter = new Adapter(PokemonRepository.getInstance().getLista(2));
        binding.recyclerViewPokedex2.setAdapter(pokemonAdapter);

        System.out.println("Tamaño de la lista: " + PokemonRepository.getInstance().getLista(2).size());
    }
}