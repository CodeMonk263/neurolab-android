package io.neurolab.main.output.visual;

import android.content.Context;

import io.neurolab.main.output.feedback.Feedback;
import io.neurolab.settings.FeedbackSettings;
import com.jogamp.opengl.GLProfile;

public class ZenSpaceVisuals extends Feedback {

    private Context context;
    private ZenSpaceGLRenderer zenSpaceRenderer;

    public ZenSpaceVisuals(Context context, FeedbackSettings feedbackSettings) {
        super(feedbackSettings);
        this.context = context;

        GLProfile glprofile = GLProfile.getDefault();

        zenSpaceRenderer = new ZenSpaceGLRenderer(context, glprofile);
    }

    public void setCurrentFeedback(float currentFeedback) {
        zenSpaceRenderer.setCurrentFeedback(currentFeedback);
    }

    @Override
    public void updateCurrentFeedback(double currentFeedback) {
        super.updateCurrentFeedback(currentFeedback);
        setCurrentFeedback((float) currentFeedback);
    }

}