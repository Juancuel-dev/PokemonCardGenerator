package es.agora.pokemoncardcreator;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import java.util.HashMap;

import es.agora.pokemoncardcreator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    static HashMap<Integer,Pokemon> pokedex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

        // Cargamos la Toolbar
        setSupportActionBar(binding.toolbar);
        binding.bottomNavView.setItemIconTintList(null);
        // Recuperamos el NavController
        NavController navController = ((NavHostFragment)getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).getNavController();
        // A NavigationUI le indicamos qué elemento debe realizar la navegación y con qué controlador
        NavigationUI.setupWithNavController(binding.bottomNavView, navController);
        // Configuramos la toolbar para que gestione el cambio de título con la navegación bottom
        NavigationUI.setupWithNavController(binding.toolbar, navController);
        pokedex  = PokemonRepository.getInstance().toMapa(1);
        pokedex.putAll(PokemonRepository.getInstance().toMapa(2));
        pokedex.putAll(PokemonRepository.getInstance().toMapa(3));
    }
}