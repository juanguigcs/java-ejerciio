package cualmemo.memoshop;

/**
 * Created by El Memo on 11/09/2016.
 */
public class Base_datos {
    private String BDusuario, BDcontrasena, BDcorreo;

    public void setBDusuario(String BDusuario) {
        this.BDusuario = BDusuario;
    }
    public void llenar(String usuario, String contrasena, String correo) {
        BDusuario = usuario;
        BDcontrasena = contrasena;
        BDcorreo = correo;
    }
    public String getBDusuario() {
        return BDusuario;
    }
    public String getBDcontrasena() {
        return BDcontrasena;
    }
    public String getBDcorreo() {
        return BDcorreo;
    }
}

