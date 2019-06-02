package com.example.cargarempresas;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter adapter;

    List<List_data>Lista_datos;

    public static final String consulta = "http://192.168.1.5/reecorriendocundinamarca.com/services/datos.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lista_datos = new ArrayList<>();

        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        Cargar_empresa();

    }

    private void Cargar_empresa(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, consulta, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray empresas = new JSONArray(response);
                    for (int i=0; i<empresas.length();i++){
                        JSONObject dat_empresa = empresas.getJSONObject(i);
                        String nombre = dat_empresa.getString("nombre");
                        String telefono = dat_empresa.getString("telefono");
                        String logo =  dat_empresa.getString("logo");



                        List_data Empresas = new List_data(nombre,telefono,logo);

                        Lista_datos.add(Empresas);
                    }
                    adapter =new MyAdapter(Lista_datos);
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        },
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "ERROR"+error, Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }

}