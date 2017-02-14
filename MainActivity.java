package govender.kevashan.testapplication.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import govender.kevashan.testapplication.Activities.Main2Activity;
import govender.kevashan.testapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void changeActivity(View view) {

        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }


}
