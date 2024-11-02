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

import es.agora.pokemoncardcreator.databinding.FragmentEquipoBinding;

public class FragmentEquipo extends Fragment {
    private FragmentEquipoBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentEquipoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        binding.recyclerViewEquipo.setLayoutManager(gridLayoutManager);

        Adapter pokemonAdapter = new Adapter(PokemonRepository.getInstance().getLista());
        binding.recyclerViewEquipo.setAdapter(pokemonAdapter);

        System.out.println("Tamaño de la lista: " + PokemonRepository.getInstance().getLista().size());
    }
}
