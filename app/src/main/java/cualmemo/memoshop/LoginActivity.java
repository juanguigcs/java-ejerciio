package cualmemo.memoshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    //Base_datos base_datos_1[]= new Base_datos[100];
    String Array_usuario[] = new String[100];
    String Array_contrasena[] = new String[100];
    String Array_correo[] = new String[100];
    int cont_usuario=0;
    Button bResgistro, bEntrar;
    EditText eUsario, eContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activiy);


        //base_datos_1[cont_usuario].llenar("s","s","s");

        bResgistro = (Button) findViewById(R.id.bRegistro);
        bEntrar = (Button) findViewById(R.id.bEntrar);
        eUsario = (EditText) findViewById(R.id.eUsuario);
        eContrasena = (EditText) findViewById(R.id.eContrasena);

        bResgistro.setOnClickListener(this);
        bEntrar.setOnClickListener(this);
        Toast.makeText(this, "PASAS POR ACA ",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.bRegistro:
                Intent intent = new Intent(this, RegistroActivity.class);
                startActivityForResult(intent, 1234);
                break;
            case R.id.bEntrar:

                if(valida()){
                    Toast.makeText(this, "Vas a entar", Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent2);
                }
                else {
                    Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                    //eUsario.setText("");
                    //eContrasena.setText("");
                }
                break;
        }
    }

    protected boolean valida() {
        String temp_usuario = eUsario.getText().toString();
        String temp_contrasena = eContrasena.getText().toString();
        boolean flag_valida=false;

        if (TextUtils.isEmpty(temp_usuario) || TextUtils.isEmpty(temp_contrasena)) {
           // Toast.makeText(this, "Campos vacíos .-. ", Toast.LENGTH_SHORT).show();
            flag_valida = false;
        }
        else {
            for (int i = 0; i<= cont_usuario; i++) {
                if (temp_contrasena.equals(Array_contrasena[i]) && temp_usuario.equals(Array_usuario[i])) {
                    flag_valida =true;
                    break;
                }
                else {
                    flag_valida = false;
                    }
                }
            }

        if(flag_valida){
            return true;
        }
        else{
           return false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1234 && resultCode == RESULT_OK){
            String user = data.getExtras().getString("usuario");
            String contrasena = data.getExtras().getString("contrasena");
            String correo= data.getExtras().getString("correo");
            Toast.makeText(this, "user: "+user+" contrasena: "+contrasena+"correo: "+correo,Toast.LENGTH_SHORT).show();

            Array_usuario[cont_usuario]= user;
            Array_contrasena[cont_usuario]=contrasena;
            Array_correo[cont_usuario]=correo;
            cont_usuario ++;
            //tbase(user,contrasena,correo);
            //base_datos_1[cont_usuario].llenar(user,contrasena,correo);
           // base_datos_1[cont_usuario].setBDusuario(user);

        }
        if (requestCode==1234 && resultCode == RESULT_CANCELED){
            Log.d("mensaje","no se cargaron datos");
        }
    }
    /*public void stbase(String user, String contrasena, String correo){
        String s1="s", s2="ss",s3="sss";
        //base_datos_1[cont_usuario].llenar(s1,s2,s3);
    }*/
}
//base_datos_1[cont_usuario].llenar(erUsario.getText().toString(),erContrasena.getText().toString(),erCorreo.getText().toString());
//cont_usuario ++;
