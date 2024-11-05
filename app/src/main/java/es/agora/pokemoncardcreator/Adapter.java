package es.agora.pokemoncardcreator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    public List<Pokemon> dataList;

    // Constructor del adaptador
    Adapter(List<Pokemon> dataList) {
        this.dataList = dataList;
    }

    // ViewHolder que representa cada elemento de la lista
    static class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imagen;
        public TextView numero;
        public TextView nombre;
        public ImageView tipo1;
        public ImageView tipo2;
        public TextView descripcion;

        MyViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            numero = itemView.findViewById(R.id.numero); // Debe ser 'numero'
            tipo1 = itemView.findViewById(R.id.tipo1);
            tipo2 = itemView.findViewById(R.id.tipo2);
            descripcion = itemView.findViewById(R.id.descripcion);
            imagen = itemView.findViewById(R.id.imagen_pokemon);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_pokemon, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pokemon item = dataList.get(position);
        String ruta = item.getDrawableId();

        int idImagen;
        try {
            idImagen = R.drawable.class.getField(ruta).getInt(null);
        } catch (IllegalAccessException e) {
            System.out.println("Error al acceder al recurso de la imagen");
            idImagen = 0;
        } catch (NoSuchFieldException e) {
            System.out.println("Error al buscar la imagen del pokemon: " + ruta);
            idImagen = 0;
        }

        holder.nombre.setText(item.getNombre());
        holder.numero.setText(String.valueOf(item.getNumero()));
        holder.imagen.setImageResource(idImagen);

        holder.itemView.setOnClickListener(v -> navegarPantallaDetalle(item, v));
    }

    public void navegarPantallaDetalle(Pokemon pokemon, View view) {
        NavController navController = Navigation.findNavController(view);

        Bundle args = new Bundle();
        args.putSerializable("pokemon", pokemon);

        if (isInPokedexFragment(view)) {
            navController.navigate(R.id.action_fragmentPokedex_to_detallesFragment, args);
        } else if (isInEquipoFragment(view)) {
            navController.navigate(R.id.action_fragmentEquipo_to_detallesFragment, args);
        }
    }

    private boolean isInPokedexFragment(View view) {
        return Navigation.findNavController(view).getCurrentDestination().getId() == R.id.fragmentPokedex;
    }

    private boolean isInEquipoFragment(View view) {
        return Navigation.findNavController(view).getCurrentDestination().getId() == R.id.fragmentEquipo;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public interface OnPokemonDeletedListener {
        void onPokemonDeleted(int position);
    }
}