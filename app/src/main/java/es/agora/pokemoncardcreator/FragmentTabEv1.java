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
import es.agora.pokemoncardcreator.databinding.FragmentTabEv1Binding;

public class FragmentTabEv1 extends Fragment {
    private FragmentTabEv1Binding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentTabEv1Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        binding.recyclerViewPokedex1.setLayoutManager(gridLayoutManager);

        Adapter pokemonAdapter = new Adapter(PokemonRepository.getInstance().getLista(1));
        binding.recyclerViewPokedex1.setAdapter(pokemonAdapter);

        System.out.println("Tamaño de la lista: " + PokemonRepository.getInstance().getLista(1).size());
    }
}