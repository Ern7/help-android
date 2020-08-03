package za.co.randomteam.help.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by ernestnyumbu on 13/5/2019.
 */

public class FuturaTextView extends TextView {

    public FuturaTextView(Context context, AttributeSet attrs){
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/FuturaLT.ttf"));
    }
}

