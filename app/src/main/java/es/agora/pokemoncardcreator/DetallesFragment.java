package es.agora.pokemoncardcreator;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.agora.pokemoncardcreator.databinding.FragmentDetallesBinding;

public class DetallesFragment extends Fragment {

    FragmentDetallesBinding binding;
    Pokemon p;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            p= (Pokemon) getArguments().getSerializable("pokemon");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetallesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pintarPokemon(p);
    }

    public void pintarPokemon(Pokemon p){
        binding.nombre.setText(p.getNombre());
        binding.descripcion.setText(p.getDescripcion());
        binding.numero.setText(p.getNumero());
        binding.tipo1.setImageResource((p.getTipo(0)));
        if((p.getTipo(1))!=-1){
            binding.tipo2.setImageResource(p.getTipo(1));
        }

        String ruta=p.getDrawableId();
        try {

            binding.imagenPokemon.setImageResource(R.drawable.class.getField(ruta).getInt(null));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

    }
}