package io.neurolab.main.output.visual;

import android.content.Context;

import io.neurolab.main.output.feedback.Feedback;
import io.neurolab.settings.FeedbackSettings;
import com.jogamp.opengl.GLProfile;

public class NeuroGameVisuals extends Feedback {

    private Context context;
    private double currentFeedback = 0;
    private NeuroGameRenderer neurofeedbackRenderer;

    public NeuroGameVisuals(Context context, FeedbackSettings feedbackSettings) {
        super(feedbackSettings);
        this.context = context;

        if (feedbackSettings == null)
            currentFeedback = 0.01f;

        GLProfile glprofile = GLProfile.getDefault();

        neurofeedbackRenderer = new NeuroGameRenderer(glprofile);
    }

    public void setCurrentFeedback(float currentFeedback) {
        neurofeedbackRenderer.setCurrentFeedback(currentFeedback);
    }

    @Override
    public void updateCurrentFeedback(double currentFeedback) {
        super.updateCurrentFeedback(currentFeedback);
        setCurrentFeedback((float) currentFeedback);
    }

}