package il.ac.huji;

import java.text.NumberFormat;

import com.example.tipcalculator.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class TipCalculatorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		
		final Button button = (Button) findViewById(R.id.btnCalculate);
        button.setOnClickListener(new OnClickListener() {
        	
        	final EditText inputTv = (EditText)findViewById(R.id.edtBillAmount);
        	final TextView resTv = (TextView)findViewById(R.id.txtTipResult);
        	final CheckBox chkRound = (CheckBox)findViewById(R.id.chkRound);
        	
			@Override
			public void onClick(View arg0) {
				
				boolean roundResult = chkRound.isChecked();
				String inputStr = inputTv.getText().toString();
				String outStr = "Tip: $";
				
				try{
					double inputNumber = Double.parseDouble(inputStr);
					if(!roundResult)
						outStr += nf.format(inputNumber*0.12);
					else
						outStr += (int)Math.round(inputNumber*0.12);
					
					
				}catch(NumberFormatException e){
					outStr = "Error, please insert a valid number";
				}
				
				resTv.setText(outStr);			
			}
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
