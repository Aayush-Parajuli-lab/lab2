package com.example.lab2;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnPopup;
    TextView textContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPopup = findViewById(R.id.btnPopup);
        textContext = findViewById(R.id.textContext);

        // Register context menu
        registerForContextMenu(textContext);

        btnPopup.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(MainActivity.this, btnPopup);
            popup.getMenuInflater().inflate(R.menu.menu_main, popup.getMenu());
            popup.setOnMenuItemClickListener(item -> handleMenuClick(item));
            popup.show();
        });
    }

    // Context Menu Creation
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
    }

    // Context Menu Item Click
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return handleMenuClick(item);
    }

    // Handle all menu clicks
    private boolean handleMenuClick(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.item_file) {
            showToast("File selected");
            return true;
        } else if (id == R.id.item_open) {
            showToast("Open selected");
            return true;
        } else if (id == R.id.item_save) {
            showToast("Save selected");
            return true;
        } else {
            return false;
        }
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
