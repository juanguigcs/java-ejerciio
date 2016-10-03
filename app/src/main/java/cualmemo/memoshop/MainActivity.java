package cualmemo.memoshop;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String Array_usuario[] = new String[100];
    String Array_correo[] = new String[100];
    String usario;
    int usario2;

    private Productos_combo[] datos = new Productos_combo[]{
            new Productos_combo(R.drawable.combo1, "$15.000", "Super combo 1", "Realiza tu pedido"),
            new Productos_combo(R.drawable.combo2, "$20.000", "Super combo 2", "Realiza tu pedido"),
            new Productos_combo(R.drawable.combo3, "$18.000", "Super combo 3", "Realiza tu pedido"),
            new Productos_combo(R.drawable.comboa, "$19.000", "Super apanado", "Realiza tu pedido"),
            new Productos_combo(R.drawable.combon, "$23.000", "Super nuggets", "Realiza tu pedido")};
    private ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //info para envíar a otras actividades
        Bundle extras = getIntent().getExtras();
        String user = extras.getString("usuario");
        String correo = extras.getString("correo");
        usario  = extras.getString("usarioint");
        usario2=Integer.parseInt(usario);
        Array_correo[usario2]=correo;
        Array_usuario[usario2]=user;

        Adapter adaptador = new Adapter(this,datos);
        lst =(ListView)findViewById(R.id.listview);
        lst.setAdapter(adaptador);

        //Toast.makeText(this,user+""+correo+""+usario2, Toast.LENGTH_SHORT).show();
    }
        //Adaptador para cambiar el item de los productos del combo
    class Adapter extends ArrayAdapter<Productos_combo> {
        public Adapter(Context context, Productos_combo[] datos) {
            super(context, R.layout.pruducto_promo_item, datos);

        }
        //inflar la clase productos_combo
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item= inflater.inflate(R.layout.pruducto_promo_item, null);

            TextView nombre= (TextView)item.findViewById(R.id.tnombre);
            nombre.setText(datos[position].getNombre());

            TextView precio= (TextView)item.findViewById(R.id.tprecio);
            precio.setText(datos[position].getPrecio());

            TextView descripcion= (TextView)item.findViewById(R.id.tdescripcion);
            descripcion.setText(datos[position].getDescripcion());

            ImageView imagen =(ImageView) item.findViewById(R.id.iImagen);
            imagen.setImageResource(datos[position].getIdImagen());

            return (item);
        }
    }

    //Menu viejo
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    //Menu viejo
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.mPerfil:
                Intent intent= new Intent(this,PerfilActivity.class);
                intent.putExtra("usuario",Array_usuario[usario2]);
                intent.putExtra("correo",Array_correo[usario2]);
                intent.putExtra("usarioint",usario);
                startActivity(intent);
                break;
            case R.id.mProd:
                Intent intent2= new Intent(this,ProductosActivity.class);
                startActivity(intent2);
                break;
        }
      return super.onOptionsItemSelected(item);
    }
}

