package es.agora.pokemoncardcreator;


import android.os.Bundle;

import androidx.annotation.NonNull;

import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import androidx.navigation.NavController;

import androidx.navigation.Navigation;


import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.Button;

import android.widget.Toast;


import java.util.ArrayList;


public class FragmentGenerar extends Fragment {


    private Button botonGenerar;

    private ArrayList<Pokemon> pokedex;


    public FragmentGenerar() {

    }


    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // No necesitas pasar el equipo aquí, lo obtendrás del repositorio

    }


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_generar, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view,savedInstanceState);

        botonGenerar = view.findViewById(R.id.boton_generar);

        botonGenerar.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                pokedex = PokemonRepository.getInstance().getLista();

                int indice = (int) (Math.random() * pokedex.size());

                Pokemon pokemonGenerado = pokedex.get(indice);

                System.out.println("Pokémon generado: " + pokemonGenerado.toString());


                if (!PokemonRepository.getInstance().contienePokemon(Integer.parseInt(pokemonGenerado.getNumero()))) {

                    PokemonRepository.getInstance().agregarPokemonAlEquipo(pokemonGenerado);


                    // Navegar al FragmentEquipo

                    NavController navController = Navigation.findNavController(view);

                    navController.navigate(R.id.fragmentEquipo);

                } else {

                    Toast.makeText(view.getContext(), "El Pokémon generado ya está en tu equipo", Toast.LENGTH_LONG).show();

                }

            }

        });

    }

}