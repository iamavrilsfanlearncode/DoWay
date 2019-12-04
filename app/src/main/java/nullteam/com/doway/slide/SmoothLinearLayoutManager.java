package nullteam.com.doway.slide;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

public class SmoothLinearLayoutManager extends LinearLayoutManager {
    public SmoothLinearLayoutManager(Context context) {
        super(context);
    }

    public SmoothLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public void SmoothLinearLayoutManager(RecyclerView recyclerView, RecyclerView.State state, int position) {
        LinearSmoothScroller linearSmoothScroller =
                new LinearSmoothScroller(recyclerView.getContext()) {
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return 0.2f;//返回0.2
                    }
                };
        linearSmoothScroller.setTargetPosition(position);
        startSmoothScroll(linearSmoothScroller);
    }
}
