package es.agora.pokemoncardcreator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

 class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    public List<Pokemon> dataList;

     Adapter(List<Pokemon> dataList) {
        this.dataList = dataList;
    }

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

         // Línea de impresión para depuración
         System.out.println("Nombre de la imagen buscada: " + ruta);

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
     }

     /*
     public int getTipo(Tipo t) {

         if (t != null) {
             switch (t) {
                 case Planta:
                     return R.drawable.planta;
                 case Fuego:
                     return R.drawable.fuego;
                 case Agua:
                     return R.drawable.agua;
                 case Electrico:
                     return R.drawable.electrico;
                 case Hielo:
                     return R.drawable.hielo;
                 case Bicho:
                     return R.drawable.bicho;
                 case Fantasma:
                     return R.drawable.fantasma;
                 case Tierra:
                     return R.drawable.tierra;
                 case Volador:
                     return R.drawable.volador;
                 case Psiquico:
                     return R.drawable.psiquico;
                 case Lucha:
                     return R.drawable.lucha;
                 case Roca:
                     return R.drawable.roca;
                 case Acero:
                     return R.drawable.acero;
                 case Dragon:
                     return R.drawable.dragon;
                 case Siniestro:
                     return R.drawable.siniestro;
                 case Hada:
                     return R.drawable.hada;
                 case Veneno:
                     return R.drawable.veneno;
             }
         }
         return Integer.MIN_VALUE;
     }

      */

    @Override
     public int getItemCount() {
        return dataList.size();
    }
}