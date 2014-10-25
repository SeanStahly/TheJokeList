package edu.calpoly.android.lab2;

import java.util.ArrayList;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;

public class SimpleJokeList extends Activity {

	/** Contains the list Jokes the Activity will present to the user. */
	protected ArrayList<Joke> m_arrJokeList;

	/** LinearLayout used for maintaining a list of Views that each display Jokes. */
	protected LinearLayout m_vwJokeLayout;

	/** EditText used for entering text for a new Joke to be added to m_arrJokeList. */
	protected EditText m_vwJokeEditText;

	/** Button used for creating and adding a new Joke to m_arrJokeList using the
	 * text entered in m_vwJokeEditText. */
	protected Button m_vwJokeButton;
	
	/** Background Color values used for alternating between light and dark rows
	 * of Jokes. */
	protected int m_nDarkColor;
	protected int m_nLightColor;
    protected int m_nTextColor;

    protected boolean darkUsed = false;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        initLayout();
        Resources resources = this.getResources();
        m_arrJokeList = new ArrayList<Joke>();
        m_nDarkColor = resources.getColor(R.color.dark);
        m_nLightColor = resources.getColor(R.color.light);
        m_nTextColor = resources.getColor(R.color.text);
        for (String s : resources.getStringArray(R.array.jokeList)) {
            Log.d("Lab2Sean", "Adding new joke: " + s);
            addJoke(s);
        }
	}
	
	/**
	 * Method used to encapsulate the code that initializes and sets the Layout
	 * for this Activity. 
	 */
	protected void initLayout() {
        m_vwJokeLayout = new LinearLayout(this);
        m_vwJokeLayout.setOrientation(LinearLayout.VERTICAL);
        ScrollView sV = new ScrollView(this);
        sV.addView(m_vwJokeLayout);
        setContentView(sV);
	}
	
	/**
	 * Method used to encapsulate the code that initializes and sets the Event
	 * Listeners which will respond to requests to "Add" a new Joke to the 
	 * list. 
	 */
	protected void initAddJokeListeners() {
		// TODO
	}

	/**
	 * Method used for encapsulating the logic necessary to properly initialize
	 * a new joke, add it to m_arrJokeList, and display it on screen.
	 * 
	 * @param strJoke
	 *            A string containing the text of the Joke to add.
	 */
	protected void addJoke(String strJoke) {
        TextView tV = new TextView(this);
        tV.setText(strJoke);
        tV.setTextSize(16);
        tV.setTextColor(m_nTextColor);
        if (darkUsed) {
            tV.setBackgroundColor(m_nDarkColor);
            darkUsed = false;
        } else {
            tV.setBackgroundColor(m_nLightColor);
            darkUsed = true;
        }
        m_vwJokeLayout.addView(tV);
	}
}