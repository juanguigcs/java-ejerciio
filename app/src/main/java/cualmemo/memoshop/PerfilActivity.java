package cualmemo.memoshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilActivity extends AppCompatActivity {
    String Array_usuario[] = new String[100];
    String Array_correo[] = new String[100];
    String  usario;
    int usario2;

    TextView tvUsuario, tvCorreo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tvUsuario =(TextView)findViewById(R.id.tvusuario);
        tvCorreo =(TextView)findViewById(R.id.tvcorreo);

        Bundle extras = getIntent().getExtras();

        String user = extras.getString("usuario");
        String correo = extras.getString("correo");
        usario  = extras.getString("usarioint");
        usario2=Integer.parseInt(usario);
        Array_correo[usario2]=correo;
        Array_usuario[usario2]=user;

        tvUsuario.setText("Usuario"+user);
        tvCorreo.setText("Correo"+correo);


        //Toast.makeText(this,user+correo+usario, Toast.LENGTH_SHORT).show();

    }
}
