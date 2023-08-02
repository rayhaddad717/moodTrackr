package com.rayhaddadcompany.moodtrackr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.rayhaddadcompany.moodtrackr.onboarding.MentalOptions
import com.rayhaddadcompany.moodtrackr.onboarding.Onboarding
import com.rayhaddadcompany.moodtrackr.ui.theme.MoodTrackrTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        testDB()
        setContent {
            MoodTrackrTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var isOnBoarding  by remember { mutableStateOf<Boolean>(true) }
                    if(isOnBoarding)
                    Onboarding(
                        1,
                        handleOnboardingDone = { a, b -> this.handleOnboardingDone(a, b);isOnBoarding = false; })
                    else
                        Text(text = "Onboarding done ")
                }
            }
        }

    }

    private fun handleOnboardingDone(
        nickname: String,
        mentalOptionsSelected: MutableSet<MentalOptions>
    ) {
        print(nickname)
        print(mentalOptionsSelected)
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        MoodTrackrTheme {
            Greeting("Android")
        }
    }

    fun testDB(){
        try{
            val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "moodTrackr",
            ).fallbackToDestructiveMigration().build()
            val userDao = db.userDao()
            // Use coroutines to insert data
            GlobalScope.launch {
                userDao.insertAll(UserModel(
                    nickname = "Ray",
                    languageSelected = "en"
                ))

                // Access the data on the background thread as well
                val users: List<UserModel> = userDao.getAll()
                print(users)
                // Do something with the users data
            }
        }catch (E:Exception){

        }
    }
}