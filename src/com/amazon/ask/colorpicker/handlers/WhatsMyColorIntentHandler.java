package com.amazon.ask.colorpicker.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class WhatsMyColorIntentHandler implements RequestHandler
{
    public static final String COLOR_KEY = "COLOR";
    public static final String COLOR_SLOT = "Color";

    @Override
    public boolean canHandle(HandlerInput input)
    {
        return input.matches(intentName("WhatsMyColorIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input)
    {
        String speechText;
        String favoriteColor = (String) input.getAttributesManager().getSessionAttributes().get(COLOR_KEY);

        boolean noAnswerProvided = false;

        if (favoriteColor != null && !favoriteColor.isEmpty())
        {
            speechText = String.format("Your favorite color is %s. Goodbye.", favoriteColor);
        } else {
            // Since the user's favorite color is not set render an error message.
            speechText =
                    "I'm not sure what your favorite color is. You can say, my favorite color is "
                            + "red.";
            noAnswerProvided = true;
        }

        return input.getResponseBuilder()
                .withSimpleCard("ColorSession", speechText)
                .withSpeech(speechText)
                .withShouldEndSession(!noAnswerProvided)
                .build();

    }
}
