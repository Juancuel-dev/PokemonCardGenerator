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
import es.agora.pokemoncardcreator.databinding.FragmentGenerarBinding;

public class FragmentGenerar extends Fragment {

    private ArrayList<Pokemon> pokedex;
    FragmentGenerarBinding binding;

    public FragmentGenerar() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGenerarBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.botonGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pokedex = PokemonRepository.getInstance().getLista(1);
                ArrayList<Pokemon> generarAux = (ArrayList<Pokemon>) pokedex.clone();
                generarAux.addAll(PokemonRepository.getInstance().getLista(2));
                generarAux.addAll(PokemonRepository.getInstance().getLista(3));
                int indice = (int) (Math.random() * generarAux.size());
                Pokemon pokemonGenerado = generarAux.get(indice);
                System.out.println("Pokémon generado: " + pokemonGenerado.toString());

                String ruta = pokemonGenerado.getDrawableId();
                try {
                    binding.generar.setImageResource(R.drawable.class.getField(ruta).getInt(null));
                } catch (IllegalAccessException | NoSuchFieldException e) {
                    System.out.println("Error al obtener ruta de imagen de pokemon");
                }
                binding.desconocido.setText(pokemonGenerado.getNumero());
                binding.nombre.setText(pokemonGenerado.getNombre());

                if (!PokemonRepository.getInstance().contienePokemon(Integer.parseInt(pokemonGenerado.getNumero()))) {
                    PokemonRepository.getInstance().agregarPokemonAlEquipo(pokemonGenerado);
                    Toast.makeText(view.getContext(), "Pokémon añadido a tu equipo: " + pokemonGenerado.getNombre(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(view.getContext(), "El Pokémon generado ya está en tu equipo", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}