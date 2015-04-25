package gran33.com.whois;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.gson.Gson;

public class MainActivity extends Activity {

    private FrameLayout screenFrameLayout;
    private LinearLayout buttonsLayout;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        this.screenFrameLayout = (FrameLayout)findViewById(R.id.screenFrameLayout);
        this.imageView = (ImageView)findViewById(R.id.imageView);
        Math.min(this.screenFrameLayout.getWidth(), this.screenFrameLayout.getHeight());


        String jsonString = "" +
                "{\n" +
                "  \"title_question\":\"Who not suck a dick?\",\n" +
                "  \"question_pic_link\":\"\",\n" +
                "  \"answer_pic_link\":\"\",\n" +
                "  \"num_of_buttons\": 4,\n" +
                "  \"right_answer\":2\n" +
                "}";



        Gson gson = new Gson();
        final WhoIsObject element = gson.fromJson (jsonString, WhoIsObject.class);

        System.out.println();

        LinearLayout screenLinearLayout = new LinearLayout(this);
        screenLinearLayout.setBackgroundColor(0x00000000);
        screenLinearLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams screenLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        screenLinearLayout.setLayoutParams(screenLayoutParams);
        screenLinearLayout.setWeightSum(8f);

        this.buttonsLayout = new LinearLayout(this);
        buttonsLayout.setBackgroundColor(0x00000000);
        buttonsLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams buttonsLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0);
        buttonsLayoutParams.weight = 1f;
        buttonsLayout.setLayoutParams(buttonsLayoutParams);
        buttonsLayout.setWeightSum(element.num_of_buttons);


        LinearLayout dummyLayout = new LinearLayout(this);
        dummyLayout.setBackgroundColor(0x00000000);
        dummyLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams dummyLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0);
        dummyLayoutParams.weight = 7f;
        dummyLayout.setLayoutParams(dummyLayoutParams);


        screenLinearLayout.addView(dummyLayout);
        screenLinearLayout.addView(buttonsLayout);

        this.screenFrameLayout.addView(screenLinearLayout);



        for (int i = 0; i<element.num_of_buttons; i++) {

            Button bt = new Button(this);
            bt.setTag(i+1);
            bt.setText(""+ (i+1) );

            LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
            buttonLayoutParams.weight = 1;
            bt.setLayoutParams(buttonLayoutParams);

            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v.getTag() == element.right_answer) {

                        System.out.println("COOOOOOOOL");
                    }
                }
            });


            this.buttonsLayout.addView(bt);

        }

        this.imageView.setImageResource(R.drawable.question_pic_example);

    }



    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.

    }



}
