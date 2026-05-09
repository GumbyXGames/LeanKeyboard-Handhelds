package com.gumbyxgames.leankeyboard.fragments.settings;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.leanback.app.GuidedStepSupportFragment;
import androidx.leanback.widget.GuidanceStylist.Guidance;
import androidx.leanback.widget.GuidedAction;
import com.gumbyxgames.leankeyboard.helpers.AppInfoHelpers;
import com.gumbyxgames.leankeykeyboard.R;

import java.util.List;

public class AboutFragment extends GuidedStepSupportFragment {
    private static final String RELEASES_URL = "https://github.com/GumbyXGames/LeanKeyboard-Handhelds/releases";
    private static final String ISSUE_URL = "https://github.com/GumbyXGames/LeanKeyboard-Handhelds/issues";
    private static final String[] URL_MAPPING = {RELEASES_URL , ISSUE_URL};
    private int mId;

    @NonNull
    @Override
    public Guidance onCreateGuidance(Bundle savedInstanceState) {
        String title = getActivity().getResources().getString(R.string.about);
        String desc = getActivity().getResources().getString(R.string.about_desc);
        Drawable icon = ContextCompat.getDrawable(getActivity(), R.drawable.ic_launcher);

        return new Guidance(
                title,
                desc,
                "",
                icon
        );
    }

    @Override
    public void onCreateActions(@NonNull List<GuidedAction> actions, Bundle savedInstanceState) {
        appendInfoAction(getString(R.string.about_issue), actions);
        appendInfoAction(getString(R.string.about_releases), actions);

        String appName = AppInfoHelpers.getApplicationName(getActivity());
        String appVersion = AppInfoHelpers.getAppVersionName(getActivity());
        appendInfoAction(String.format("%s (%s)", appName, appVersion), actions);
    }

    private void appendInfoAction(String textLine, List<GuidedAction> actions) {
        GuidedAction action = new GuidedAction.Builder(getActivity())
                .title(textLine)
                .id(mId++)
                .build();
        actions.add(action);
    }
}
