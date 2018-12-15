package com.example.service_admin.listviewexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ItemActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item_form_layout);

        Button button = findViewById(R.id.addButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListView itemView = findViewById(R.id.listViewPrincipal);

                TextView nameView = findViewById(R.id.nameTxt);
                TextView descView = findViewById(R.id.descTxt);

                Item item = new Item();

                item.setName(nameView.getText().toString());
                item.setDescription(descView.getText().toString());
                item.setImageId(R.mipmap.carro);

                Intent intent = new Intent();
                intent.putExtra("name",item.name);
                intent.putExtra("descripcion",item.description);
                intent.putExtra("imagen",item.imageId);
                setResult(RESULT_OK,intent);
                finish();

            }
        });

    }

    public ItemActivity() {

    }
}
