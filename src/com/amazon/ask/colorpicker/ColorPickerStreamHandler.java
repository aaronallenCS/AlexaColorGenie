package com.amazon.ask.colorpicker;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import com.amazon.ask.colorpicker.handlers.HelpIntentHandler;
import com.amazon.ask.colorpicker.handlers.LaunchRequestHandler;
import com.amazon.ask.colorpicker.handlers.SessionEndedRequestHandler;
import com.amazon.ask.colorpicker.handlers.FallbackIntentHandler;
import com.amazon.ask.colorpicker.handlers.WhatsMyColorIntentHandler;
import com.amazon.ask.colorpicker.handlers.CancelandStopIntentHandler;
import com.amazon.ask.colorpicker.handlers.MyColorIsIntentHandler;

public class ColorPickerStreamHandler extends SkillStreamHandler
{
    private static Skill getSkill()
    {
        return Skills.standard()
                .addRequestHandlers(
                        new WhatsMyColorIntentHandler(),
                        new MyColorIsIntentHandler(),
                        new LaunchRequestHandler(),
                        new CancelandStopIntentHandler(),
                        new SessionEndedRequestHandler(),
                        new HelpIntentHandler(),
                        new FallbackIntentHandler())
                .build();
    }

    public ColorPickerStreamHandler() {
        super(getSkill());
    }

}
