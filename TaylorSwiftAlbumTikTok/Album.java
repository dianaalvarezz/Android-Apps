/************************************************************************
 *                                                                      *
 *     Class Name: Album.java                                           *
 *                                                                      *
 *        Purpose: This class displays relevant information about each  *
 *        album                                                         *
 *                                                                      *
 *                                                                      *
 ************************************************************************/

package edu.niu.android.tictactoe;

public class Album
{

    public static int getImage(int index)
    {
        // Images of my Albums
        int[] images =
                {
                R.drawable.albumcoverart,
                R.drawable.redalbum,
                R.drawable.speaknow,
                R.drawable.fearless,
                R.drawable.nineteen,
                R.drawable.reputation,
                R.drawable.folklore,
                R.drawable.evermore,
                R.drawable.torturex
        };
        return images[index];
    }

    public static String getName(int index)
    {
        //Album Names
        String[] names =
                {
                "Lover",
                "Red",
                "Speak Now",
                "Fearless",
                "1989",
                "Reputation",
                "Folklore",
                "Evermore",
                "TTPD"
        };
        return names[index];
    }

    public static String getExtraInfo(int index)
    {
        // Relevant Information about each Album with songs I like
        String[] infos =
                {
                "Released: 2019\nGenre: Pop\nPopular Songs: Lover, You Need to Calm Down",
                "Released: 2012\nGenre: Country/Pop\nPopular Songs: Red, I Knew You Were Trouble",
                "Released: 2010\nGenre: Country/Pop\nPopular Songs: Speak Now, Mean",
                "Released: 2008\nGenre: Country\nPopular Songs: Love Story, You Belong with Me",
                "Released: 2014\nGenre: Pop\nPopular Songs: Shake It Off, Blank Space",
                "Released: 2017\nGenre: Pop\nPopular Songs: Look What You Made Me Do, Delicate",
                "Released: 2020\nGenre: Indie Folk\nPopular Songs: Cardigan, Exile",
                "Released: 2020\nGenre: Indie Folk\nPopular Songs: Willow, Champagne Problems",
                "Released: 2024\nGenre: Pop\nPopular Songs: loml, So Long London"
        };
        return infos[index];
    }
}
