package com.example;

import java.util.ArrayList;
import java.util.Random;

public class JokeTellingClass {
    private ArrayList<String> jokesList;
   public  JokeTellingClass(){
       jokesList=new ArrayList<>();
       jokesList.add("A: I have the perfect son. \n" +
               "B: Does he smoke? \n" +
               "A: No, he doesn't. \n" +
               "B: Does he drink whiskey? \n" +
               "A: No, he doesn't. \n" +
               "B: Does he ever come home late? \n" +
               "A: No, he doesn't. \n" +
               "B: I guess you really do have the perfect son. How old is he? \n" +
               "A: He will be six months old next Wednesday.");
       jokesList.add("Girl: You would be a good dancer except for two things. \n" +
               "Boy: What are the two things? \n" +
               "Girl: Your feet. ");
       jokesList.add("The doctor to the patient: 'You are very sick' \n" +
               "The patient to the doctor: 'Can I get a second opinion?' \n" +
               "The doctor again: 'Yes, you are very ugly too...'\n" +
               "I use this joke for retelling in reported speech. ");
       jokesList.add("A man goes to the doctor and says, \"Doctor, wherever I touch, it hurts.\" \n" +
               "The doctor asks, \"What do you mean?\" \n" +
               "The man says, \"When I touch my shoulder, it really hurts. If I touch my knee - OUCH! When I touch my forehead, it really, really hurts.\" \n" +
               "The doctor says, \"I know what's wrong with you - you've broken your finger!\" ");
       jokesList.add("Patient: Doctor, I have a pain in my eye whenever I drink tea. \n" +
               "Doctor: Take the spoon out of the mug before you drink. ");
       jokesList.add("Two boys were arguing when the teacher entered the room.\n" +
               "The teacher says, \"Why are you arguing?\"\n" +
               "\n" +
               "One boy answers, \"We found a ten dollor bill and decided to give it to whoever tells the biggest lie.\"\n" +
               "\n" +
               "\"You should be ashamed of yourselves,\" said the teacher, \"When I was your age I didn't even know what a lie was.\"\n" +
               "\n" +
               "The boys gave the ten dollars to the teacher.");
       jokesList.add("A: Just look at that young person with the short hair and blue jeans. Is it a boy or a girl? \n" +
               "B: It's a girl. She's my daughter. \n" +
               "A: Oh, I'm sorry, sir. I didn't know that you were her father. \n" +
               "B: I'm not. I'm her mother.");
       jokesList.add("Teacher: \"Nick, what is the past participle of the verb to ring?\" \n" +
               "Nick: \"What do you think it is, Sir?\" \n" +
               "Teacher: \"I don't think, I KNOW!\" \n" +
               "Nick: \"I don't think I know either, Sir!\" ");
   }

   public String getJoke(){
       Random random=new Random();
       String joke=jokesList.get(random.nextInt(jokesList.size()));
       return joke;
   }

}
