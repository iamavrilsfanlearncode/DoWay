package nullteam.com.doway.slide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import nullteam.com.doway.R;
public class CustomGrid extends BaseAdapter {
    private Context context;
    private final String[]text;
    private final int[]imageId;



    public CustomGrid(Context context, String[] text, int[] imageId) {
        this.context = context;
        this.text = text;
        this.imageId = imageId;
    }

    @Override
    public int getCount() {
        return text.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            grid = new View(context);
            grid = layoutInflater.inflate(R.layout.grid_layout,null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
            textView.setText(text[position]);
            imageView.setImageResource(imageId[position]);
        }else {
            grid = (View) convertView;
        }
        return grid;
    }
}
