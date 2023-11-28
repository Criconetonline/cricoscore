package com.cricoscore.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import com.cricoscore.R;
import com.cricoscore.Utils.Toaster;
import com.cricoscore.databinding.ActivityTossBinding;
import com.cricoscore.databinding.ToolbarBinding;

import java.util.Objects;
import java.util.Random;

public class TossActivity extends AppCompatActivity {
   ActivityTossBinding activityTossBinding;
    Context mContext;
    Activity mActivity;

    AnimatorSet front_animation,back_animation;
    public static final Random RANDOM = new Random();
    boolean isFront;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTossBinding = com.cricoscore.databinding.ActivityTossBinding.inflate(getLayoutInflater());
        setContentView(activityTossBinding.getRoot());
        mContext = this;
        mActivity = this;

        ToolbarBinding toolbarBinding = activityTossBinding.toolbar;
        setSupportActionBar(toolbarBinding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        toolbarBinding.toolbartext.setText(getResources().getString(R.string.toss));
        toolbarBinding.toolbar.setNavigationOnClickListener(v -> finish());

        float scale = getApplicationContext().getResources().getDisplayMetrics().density;
        activityTossBinding.mbToss.setCameraDistance(8000 * scale);
        activityTossBinding.mbTossBack.setCameraDistance(8000 * scale);

        front_animation = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.anim.front_animator);
        back_animation = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.anim.back_animator);


        initView();
    }

    private void initView() {

        activityTossBinding.tvFlip.setOnClickListener(v -> {
            activityTossBinding.tvFlip.setVisibility(View.GONE);
            activityTossBinding.tvMessage.setText("Decision to choose batting or bowling");
            activityTossBinding.tvTeamName1.setTextColor(mContext.getResources().getColor(R.color.black));
            activityTossBinding.li1.setBackground(mContext.getResources().getDrawable(R.drawable.tab_bacgroundindicator));
            activityTossBinding.li2.setBackground(mContext.getResources().getDrawable(R.drawable.tab_bacgroundindicator));
            activityTossBinding.tvTeamName2.setTextColor(mContext.getResources().getColor(R.color.black));
            if(RANDOM.nextFloat() > 0.5f)
            {
                front_animation.setTarget(activityTossBinding.mbToss);
                back_animation.setTarget(activityTossBinding.mbTossBack);
                front_animation.start();
                back_animation.start();
                new Handler().postDelayed(() -> activityTossBinding.rlCoin.setVisibility(View.GONE),1000);

                new Handler().postDelayed(() -> {
                    activityTossBinding.tvTeamName1.setTextColor(mContext.getResources().getColor(R.color.white));
                    activityTossBinding.tvTeamName2.setTextColor(mContext.getResources().getColor(R.color.black));
                    activityTossBinding.li1.setBackground(mContext.getResources().getDrawable(R.drawable.tab_bacgroundindicator_red));
                    activityTossBinding.li2.setBackground(mContext.getResources().getDrawable(R.drawable.tab_bacgroundindicator));
                },200);

            }
            else
            {
                front_animation.setTarget(activityTossBinding.mbTossBack);
                back_animation.setTarget(activityTossBinding.mbToss);
                back_animation.start();
                front_animation.start();

                new Handler().postDelayed(() -> activityTossBinding.rlCoin.setVisibility(View.GONE),1000);

                new Handler().postDelayed(() -> {
                    activityTossBinding.tvTeamName1.setTextColor(mContext.getResources().getColor(R.color.black));
                    activityTossBinding.tvTeamName2.setTextColor(mContext.getResources().getColor(R.color.white));
                    activityTossBinding.li2.setBackground(mContext.getResources().getDrawable(R.drawable.tab_bacgroundindicator_red));
                    activityTossBinding.li1.setBackground(mContext.getResources().getDrawable(R.drawable.tab_bacgroundindicator));
                },200);

            }
        });

        activityTossBinding.rlCoin.setOnClickListener(v -> {
            activityTossBinding.tvFlip.setVisibility(View.GONE);
            activityTossBinding.tvMessage.setText("Decision to choose batting or bowling");
            activityTossBinding.tvTeamName1.setTextColor(mContext.getResources().getColor(R.color.black));
            activityTossBinding.li1.setBackground(mContext.getResources().getDrawable(R.drawable.tab_bacgroundindicator));
            activityTossBinding.li2.setBackground(mContext.getResources().getDrawable(R.drawable.tab_bacgroundindicator));
            activityTossBinding.tvTeamName2.setTextColor(mContext.getResources().getColor(R.color.black));
            if(RANDOM.nextFloat() > 0.5f)
            {
                front_animation.setTarget(activityTossBinding.mbToss);
                back_animation.setTarget(activityTossBinding.mbTossBack);
                front_animation.start();
                back_animation.start();

                new Handler().postDelayed(() -> activityTossBinding.rlCoin.setVisibility(View.GONE),1000);
                new Handler().postDelayed(() -> {
                    activityTossBinding.tvTeamName1.setTextColor(mContext.getResources().getColor(R.color.white));
                    activityTossBinding.tvTeamName2.setTextColor(mContext.getResources().getColor(R.color.black));
                    activityTossBinding.li1.setBackground(mContext.getResources().getDrawable(R.drawable.tab_bacgroundindicator_red));
                    activityTossBinding.li2.setBackground(mContext.getResources().getDrawable(R.drawable.tab_bacgroundindicator));
                },200);

            }
            else
            {
                front_animation.setTarget(activityTossBinding.mbTossBack);
                back_animation.setTarget(activityTossBinding.mbToss);
                back_animation.start();
                front_animation.start();

                new Handler().postDelayed(() -> activityTossBinding.rlCoin.setVisibility(View.GONE),1000);

                new Handler().postDelayed(() -> {
                    activityTossBinding.tvTeamName1.setTextColor(mContext.getResources().getColor(R.color.black));
                    activityTossBinding.tvTeamName2.setTextColor(mContext.getResources().getColor(R.color.white));
                    activityTossBinding.li2.setBackground(mContext.getResources().getDrawable(R.drawable.tab_bacgroundindicator_red));
                    activityTossBinding.li1.setBackground(mContext.getResources().getDrawable(R.drawable.tab_bacgroundindicator));
                },200);

            }
        });


        activityTossBinding.tvBowling.setOnClickListener(v -> {
            activityTossBinding.tvBowling.setBackground(mContext.getResources().getDrawable(R.drawable.tab_bacgroundindicator_red));
            activityTossBinding.tvBtting.setBackground(mContext.getResources().getDrawable(R.drawable.tab_bacgroundindicator));
            activityTossBinding.tvBowling.setTextColor(mContext.getResources().getColor(R.color.white));
            activityTossBinding.tvBtting.setTextColor(mContext.getResources().getColor(R.color.black));
        });

        activityTossBinding.tvBtting.setOnClickListener(v -> {
            activityTossBinding.tvBowling.setBackground(mContext.getResources().getDrawable(R.drawable.tab_bacgroundindicator));
            activityTossBinding.tvBtting.setBackground(mContext.getResources().getDrawable(R.drawable.tab_bacgroundindicator_red));
            activityTossBinding.tvBowling.setTextColor(mContext.getResources().getColor(R.color.black));
            activityTossBinding.tvBtting.setTextColor(mContext.getResources().getColor(R.color.white));
        });

        activityTossBinding.li1.setOnClickListener(v -> {
            activityTossBinding.rlCoin.setVisibility(View.GONE);
            activityTossBinding.tvFlip.setVisibility(View.GONE);
            activityTossBinding.tvMessage.setText("Decision to choose batting or bowling");
            activityTossBinding.tvTeamName1.setTextColor(mContext.getResources().getColor(R.color.white));
            activityTossBinding.li1.setBackground(mContext.getResources().getDrawable(R.drawable.tab_bacgroundindicator_red));
            activityTossBinding.li2.setBackground(mContext.getResources().getDrawable(R.drawable.tab_bacgroundindicator));
            activityTossBinding.tvTeamName2.setTextColor(mContext.getResources().getColor(R.color.black));
        });

        activityTossBinding.li2.setOnClickListener(v -> {
            activityTossBinding.rlCoin.setVisibility(View.GONE);
            activityTossBinding.tvFlip.setVisibility(View.GONE);
            activityTossBinding.tvMessage.setText("Decision to choose batting or bowling");
            activityTossBinding.tvTeamName2.setTextColor(mContext.getResources().getColor(R.color.white));
            activityTossBinding.li1.setBackground(mContext.getResources().getDrawable(R.drawable.tab_bacgroundindicator));
            activityTossBinding.li2.setBackground(mContext.getResources().getDrawable(R.drawable.tab_bacgroundindicator_red));
            activityTossBinding.tvTeamName1.setTextColor(mContext.getResources().getColor(R.color.black));
        });

        activityTossBinding.mbCreate.setOnClickListener(v -> {
            startActivity(new Intent(mContext,DashboardLiveScoringActivity.class));
        });
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}