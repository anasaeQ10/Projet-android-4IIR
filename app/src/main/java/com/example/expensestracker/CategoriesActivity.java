package com.example.expensestracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.expensestracker.model.User;

public class CategoriesActivity extends AppCompatActivity {
    LinearLayout budgetSection , profilButton,historyButton,addExpense;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_categories);

        user = getIntent().getParcelableExtra("userData");
        if (user == null) {
            Toast.makeText(this, "User data missing!", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }


        budgetSection = findViewById(R.id.budgetSection);
        profilButton=findViewById(R.id.profilButton);

        historyButton=findViewById(R.id.historyButton);
        addExpense=findViewById(R.id.addExpense);


        budgetSection.setOnClickListener(v -> {
            Intent intent = new Intent(this, BudgetActivity.class);
            intent.putExtra("userData", user);
            startActivity(intent);
        });

        addExpense.setOnClickListener(v->{
            Intent intent = new Intent(this,addExpenseActivity.class);
            intent.putExtra("userData", user);
            startActivity(intent);

        });

        profilButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, ProfilActivity.class);
            intent.putExtra("userData", user);
            startActivity(intent);
        });

        historyButton.setOnClickListener(v->{
            Intent intent = new Intent(this,HistoryActivity.class);
            intent.putExtra("userData", user);
            startActivity(intent);

        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}