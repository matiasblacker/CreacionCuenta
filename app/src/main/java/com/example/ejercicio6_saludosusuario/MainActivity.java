package com.example.ejercicio6_saludosusuario;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nombre, apellido, correo, password;
    private Button btnCrearCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referenciar los elementos de la vista
        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellido);
        correo = findViewById(R.id.correo);
        password = findViewById(R.id.password);
        btnCrearCuenta = findViewById(R.id.btnCrearCuenta);

        // Configurar el click listener del botón
        btnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuario();
            }
        });
    }

    // Método para registrar usuario
    private void registrarUsuario() {
        String nombreText = nombre.getText().toString().trim();
        String apellidoText = apellido.getText().toString().trim();
        String correoText = correo.getText().toString().trim();
        String passwordText = password.getText().toString().trim();

        // Validar los datos
        if (nombreText.isEmpty()) {
            nombre.setError("Ingrese su nombre");
            return;
        }
        if (apellidoText.isEmpty()) {
            apellido.setError("Ingrese su apellido");
            return;
        }
        if (correoText.isEmpty()) {
            correo.setError("Ingrese su correo electrónico");
            return;
        }
        if (passwordText.isEmpty()) {
            password.setError("Ingrese su contraseña");
            return;
        }

        // Si todos los campos están completos, mostrar el Toast
        String saludo = "Hola " + nombreText + " " + apellidoText + "!";
        String creado = "Cuenta creada con éxito!";
        Toast.makeText(MainActivity.this, creado, Toast.LENGTH_LONG).show();
        Toast.makeText(MainActivity.this, saludo, Toast.LENGTH_LONG).show();
    }
}
