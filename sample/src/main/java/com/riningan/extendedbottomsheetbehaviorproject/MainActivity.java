package com.riningan.extendedbottomsheetbehaviorproject;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.riningan.widget.ExtendedBottomSheetBehavior;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ExtendedBottomSheetBehavior mExtendedBottomSheetBehavior = null;
    private Button btnDragging = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnHide).setOnClickListener(this);
        findViewById(R.id.btnCollapse).setOnClickListener(this);
        findViewById(R.id.btnHalf).setOnClickListener(this);
        findViewById(R.id.btnExpand).setOnClickListener(this);
        btnDragging = (Button) findViewById(R.id.btnDragging);
        btnDragging.setOnClickListener(this);

        NestedScrollView nsv = (NestedScrollView) findViewById(R.id.nsv);
        mExtendedBottomSheetBehavior = ExtendedBottomSheetBehavior.from(nsv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnHide:
                mExtendedBottomSheetBehavior.setState(ExtendedBottomSheetBehavior.STATE_HIDDEN);
                break;
            case R.id.btnCollapse:
                mExtendedBottomSheetBehavior.setState(ExtendedBottomSheetBehavior.STATE_COLLAPSED);
                break;
            case R.id.btnHalf:
                mExtendedBottomSheetBehavior.setState(ExtendedBottomSheetBehavior.STATE_HALF);
                break;
            case R.id.btnExpand:
                mExtendedBottomSheetBehavior.setState(ExtendedBottomSheetBehavior.STATE_EXPANDED);
                break;
            case R.id.btnDragging:
                mExtendedBottomSheetBehavior.setAllowUserDragging(!mExtendedBottomSheetBehavior.isAllowUserDragging());
                if (mExtendedBottomSheetBehavior.isAllowUserDragging()) {
                    btnDragging.setText("Disable dragging");
                } else {
                    btnDragging.setText("Enable dragging");
                }
                break;
        }
    }
}
