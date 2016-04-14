package info.shivam.lab3part2.tests;

/**
 * Created by Shivam on 4/13/2016.
 */
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import info.shivam.lab3part2.MainActivity;
import info.shivam.lab3part2.R;
public class JUnit_test extends ActivityInstrumentationTestCase2<MainActivity>{
    MainActivity mainActivity;
    public JUnit_test(){
        super(MainActivity.class);
    }
    public void test_first(){
        mainActivity = getActivity();


        mainActivity.runOnUiThread(new Runnable() {
            EditText etext = (EditText) mainActivity.findViewById(R.id.editText);
            EditText etext1 = (EditText) mainActivity.findViewById(R.id.editText2);
            Button button = (Button) mainActivity.findViewById(R.id.button);
            TextView textView = (TextView) mainActivity.findViewById(R.id.textView);

            @Override
            public void run() {
                etext.setText(String.valueOf(10));
                etext1.setText(String.valueOf(10));
                button.performClick();
                String tester = textView.getText().toString();
                assertEquals("20", tester);

                etext.setText(String.valueOf(10));
                etext1.setText(String.valueOf(-10));
                button.performClick();
                tester = textView.getText().toString();
                assertEquals("0", tester);
            }
        });



    }
}
