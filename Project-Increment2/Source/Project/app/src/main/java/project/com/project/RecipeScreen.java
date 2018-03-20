package project.com.project;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by gangi on 3/18/2018.
 */

public class RecipeScreen extends AppCompatActivity {

    ImageView recipeImageView;
    TextView recipeNameView;
    TextView recipeSourceURLView;
    TextView recipeIngredientsView;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        recipeImageView = findViewById(R.id.recipeImageView);
        recipeNameView = findViewById(R.id.recipeName);
        recipeSourceURLView = findViewById(R.id.fullRecipe);
        recipeIngredientsView = findViewById(R.id.ingredients);
        ratingBar = findViewById(R.id.ratingBar);

        try {
            Intent intent = getIntent();

            Recipe recipe = (Recipe) intent.getExtras().getSerializable("recipeObj");

            // Using Hardcoded ratings as of now
            ratingBar.setRating(Float.parseFloat("4.0"));

            recipeImageView.setImageBitmap(recipe.getBitmap());
            recipeNameView.setText(recipe.getRecipeName());

            String fullRecipeURL = "See Full Recipe at : <a href='"+recipe.getSourceURL()+"'>"+
                    recipe.getSourceName()+"</a>";
            recipeSourceURLView.setText(Html.fromHtml(fullRecipeURL));
            recipeSourceURLView.setMovementMethod(LinkMovementMethod.getInstance());

            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("<strong><u>"+recipe.getIngredientsArray().length()+" Ingredients</u></strong><br/><ul>");
            for(int ingr = 0;ingr < recipe.getIngredientsArray().length();ingr++){
                stringBuilder.append("<li>"+recipe.getIngredientsArray().get(ingr)+"</li>");
            }
            stringBuilder.append("</ul><br/>");
            stringBuilder.append("<strong><u>Nutrients</u></strong><br/>");
            stringBuilder.append("Number of People Dish Serves:"+recipe.getPeopleServes()+"<br/>");
            stringBuilder.append("Calories/Serving : "+recipe.getCaloriePerServing());

            recipeIngredientsView.setText(Html.fromHtml(stringBuilder.toString()));


        }catch (JSONException jsex) {
            jsex.printStackTrace();
        }
    }
}
