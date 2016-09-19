package cualmemo.memoshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String Array_usuario[] = new String[100];
    String Array_correo[] = new String[100];
    String usario;
    int usario2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();

        String user = extras.getString("usuario");
        String correo = extras.getString("correo");
         usario  = extras.getString("usarioint");
        usario2=Integer.parseInt(usario);
        Array_correo[usario2]=correo;
        Array_usuario[usario2]=user;



        //Toast.makeText(this,user+""+correo+""+usario2, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

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
        }
      return super.onOptionsItemSelected(item);
    }
}

