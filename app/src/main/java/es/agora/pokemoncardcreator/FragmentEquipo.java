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

import java.util.HashMap;

import es.agora.pokemoncardcreator.databinding.FragmentEquipoBinding;

public class FragmentEquipo extends Fragment {
    private FragmentEquipoBinding binding;
    private NavController navController;
    HashMap<Integer,Pokemon> equipo;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        equipo  = new HashMap<>();
        binding = FragmentEquipoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(equipo.isEmpty()){
            binding.sinEquipo.setText("No hay Pokemon en tu equipo");
        }

    }
}
