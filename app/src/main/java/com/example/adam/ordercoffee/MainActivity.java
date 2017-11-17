package com.example.adam.ordercoffee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view){
        quantity = quantity+1;
        displayQuantity(quantity);
    }

    public void decrement(View view){
        if(quantity==0){
            return;
        }
        quantity = quantity-1;
        displayQuantity(quantity);
    }

    public void submitOrder(View view){
        //get nama
        EditText nameCustomer = (EditText) findViewById(R.id.etName);
        String name = nameCustomer.getText().toString();

        //cek checkbox 1
        CheckBox cb1 = (CheckBox) findViewById(R.id.cb1);
        boolean hasChecked1 = cb1.isChecked();

        //cek checkbox 2
        CheckBox cb2 = (CheckBox) findViewById(R.id.cb2);
        boolean hasChecked2 = cb2.isChecked();

        int price = calculatePrice(hasChecked1, hasChecked2);

        String message = createOrderSummary(name, price, hasChecked1, hasChecked2);

        //tampilkan pesanan
        TextView summary = (TextView) findViewById(R.id.tvSummary);
        summary.setText(message);

    }

    public String createOrderSummary(String name, int price, boolean hasChecked1, boolean hasChecked2){
        String priceMessage = "Hi "+name+ " Your Order:";
        priceMessage+= "\n"+" Toping cream: "+hasChecked1;
        priceMessage+= "\n"+" Toping chocolate: "+hasChecked2;
        priceMessage+= "\n"+" Quantity: "+quantity;
        priceMessage+= "\n"+" Price: "+price;
        return priceMessage;
    }

    public int calculatePrice(boolean cb1, boolean cb2){
        //harga normal
        int basePrice = 5;

        //jika menambah topping +$1
        if(cb1){
            basePrice = basePrice+1;
        }
        if(cb2){
            basePrice = basePrice+1;
        }

        return quantity * basePrice;

    }


    public void displayQuantity(int numberOfCoffee){
        TextView quantityTextview = (TextView) findViewById(R.id.tvSum);
        quantityTextview.setText(""+numberOfCoffee);
    }



}
