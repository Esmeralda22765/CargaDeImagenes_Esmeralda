package com.example.cargadeimagenes_esmeralda;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import java.util.ArrayList;
import android.util.Log;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<GetterYSetterHeroe> getterYSetterHeroeArrayList;

    RequestQueue requestQueue;
    Context context;
    MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CargandoImagenes(this);
        solicitudParaCargarURL();
    }

    public void CargandoImagenes(Context context) {
        this.context = context;
        if (context instanceof MainActivity){
            mainActivity = (MainActivity) context;
        }
        requestQueue = Volley.newRequestQueue(context);
    }
    public void solicitudParaCargarURL(){
        String urlHeroes = "https://simplifiedcoding.net/demos/view-flipper/heroes.php";
        JsonRequest jsonRequest = new JsonObjectRequest( urlHeroes, null, response -> {

            JSONArray jsonArray = null;
            try {
                jsonArray = response.getJSONArray("heroes");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Type listType = new TypeToken<ArrayList<GetterYSetterHeroe>>(){}.getType();
                        Gson gson = new Gson();
                        MainActivity.getterYSetterHeroeArrayList = gson.fromJson(jsonArray.toString(), listType);

                        Fragmento selectorFragment = new Fragmento();
                        if (mainActivity.findViewById(R.id.main_activity) != null && mainActivity.getSupportFragmentManager().findFragmentById(R.id.main_activity) == null){
                            mainActivity.getSupportFragmentManager().beginTransaction().add(R.id.main_activity, selectorFragment).commit();
                        }

                },
                error -> {
                    Log.d("imgLoad", " Error: " + error);
                }
        );
        requestQueue.add(jsonRequest);
    }

}