package com.example.laba3;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
public class main extends AppCompatActivity
{
  private LinearLayout linear;
  private TextView textView, textView2;
  private Button pink_red, orange_black, yellow_green,pink,white,red;
  public void onCreate (Bundle savedInstanceState)
  {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.linearlayout);
      linear=(LinearLayout)findViewById(R.id.lin);
      textView=(TextView) findViewById(R.id.textView);
      textView2=(TextView) findViewById(R.id.textView2);
      pink_red=(Button) findViewById(R.id.pink_red);
      orange_black=(Button) findViewById(R.id.orange_black);
      yellow_green=(Button) findViewById(R.id.yellow_green);
      pink=(Button) findViewById(R.id.pink);
      white=(Button) findViewById(R.id.white);
      red=(Button) findViewById(R.id.red);
  }
  public void toRed(View view)
  {
      linear.setBackgroundColor(ContextCompat.getColor(this,R.color.b5));
  }
    public void toPink(View view)
    {
        linear.setBackgroundColor(ContextCompat.getColor(this,R.color.b4));
    }
    public void toWhite(View view)
    {
        linear.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
    }
    public void toPink_Red(View view)
    {
        linear.setBackgroundColor(ContextCompat.getColor(this,R.color.b4));
        textView.setTextColor(ContextCompat.getColor(this,R.color.b5));
        textView2.setTextColor(ContextCompat.getColor(this,R.color.b5));
    }
    public void toOrange_Black(View view)
    {
        linear.setBackgroundColor(ContextCompat.getColor(this,R.color.b2));
        textView.setTextColor(ContextCompat.getColor(this,R.color.black));
        textView2.setTextColor(ContextCompat.getColor(this,R.color.black));
    }
    public void toYellow_Green(View view)
    {
        linear.setBackgroundColor(ContextCompat.getColor(this,R.color.b3));
        textView.setTextColor(ContextCompat.getColor(this,R.color.green));
        textView2.setTextColor(ContextCompat.getColor(this,R.color.green));
    }
}
