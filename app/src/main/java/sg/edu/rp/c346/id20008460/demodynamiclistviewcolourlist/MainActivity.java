package sg.edu.rp.c346.id20008460.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement , etIndexElement;
    Button btnAdd , btnRemove , btnUpdate;
    ListView lvColours;

    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;


    String addColour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etIndexElement = findViewById(R.id.editTextIndex);

        btnAdd = findViewById(R.id.buttonAddItem);
        btnRemove = findViewById(R.id.buttonRemoveColour);
        btnUpdate = findViewById(R.id.buttonUpdateColour);

        lvColours = findViewById(R.id.lisrViewColour);

        alColours = new ArrayList<String>();
        alColours.add(getString(R.string.colourRed));
        alColours.add(getString(R.string.colourOrange));

        aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);
        lvColours.setAdapter(aaColour);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addColour = etElement.getText().toString();

                //alColours.add(addColour);
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos, addColour);
                aaColour.notifyDataSetChanged();

            }
        });

        lvColours.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colourClick = alColours.get(position);
                Toast.makeText(MainActivity.this, colourClick , Toast.LENGTH_SHORT).show();

            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //alColours.add(addColour);
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.remove(pos);
                aaColour.notifyDataSetChanged();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addColour = etElement.getText().toString();

                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos, addColour);
                aaColour.notifyDataSetChanged();

            }
        });
    }


}