package com.rayhaddadcompany.moodtrackr.onboarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rayhaddadcompany.moodtrackr.R
import com.rayhaddadcompany.moodtrackr.ui.theme.Black
import com.rayhaddadcompany.moodtrackr.ui.theme.BlueBackground
import com.rayhaddadcompany.moodtrackr.ui.theme.HeaderWhiteColor
import com.rayhaddadcompany.moodtrackr.ui.theme.BlueNextTitle
import com.rayhaddadcompany.moodtrackr.ui.theme.LanguageSelectBackground
import com.rayhaddadcompany.moodtrackr.ui.theme.LanguageSelectBackgroundDisabled
import com.rayhaddadcompany.moodtrackr.ui.theme.LightBlueBackground
import com.rayhaddadcompany.moodtrackr.ui.theme.LightBlueBackgroundIconTint
import com.rayhaddadcompany.moodtrackr.ui.theme.LightPinkBackground
import com.rayhaddadcompany.moodtrackr.ui.theme.PinkBackround
import com.rayhaddadcompany.moodtrackr.ui.theme.PinkNextColor
import com.rayhaddadcompany.moodtrackr.ui.theme.PinkTintColor
import com.rayhaddadcompany.moodtrackr.ui.theme.White

@Composable
fun Onboarding(){
    var currentStep by remember { mutableStateOf(1) }
    var nickname  by remember { mutableStateOf<String>("") }
    if(currentStep == 1){
        OnboardingStep1(currentStep = currentStep, onCurrentStepChanged = {currentStep = it})
    }
    else if(currentStep == 2){
        OnboardingStep2(currentStep = currentStep,onCurrentStepChanged = {currentStep = it})
    }
    else if(currentStep == 3){
        OnboardingStep3(currentStep = currentStep, onCurrentStepChanged = {currentStep = it})
    }

    else if(currentStep == 4){
        OnboardingStep4(currentStep = currentStep,onCurrentStepChanged = { if(validateNickname(nickname)) currentStep = it},nickname, onChangeNickname = { nickname = it})
    }

}

fun validateNickname(nickname:String):Boolean{
    if(nickname.isEmpty() || nickname.isBlank())return false;
    return true
}

@Preview
@Composable
fun previewOnboarding(){
    Onboarding()
}


@Composable
fun OnboardingStep1(currentStep:Int,onCurrentStepChanged:(Int)->Unit){
    Column() {
        Row(
            modifier = Modifier
                .weight(2f)
                .fillMaxHeight()
        ) {


            Box(
                modifier = Modifier.fillMaxSize()
            ) {

                Image(
                    painter = painterResource(
                        id = R.drawable.onboarding_purple_background
                    ),
                    contentDescription = "onboarding screen",

                    modifier =
                    Modifier
                        .defaultMinSize(minHeight = 400.dp)
                        .fillMaxSize(),

                    contentScale = ContentScale.FillBounds
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxHeight()
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "app logo", modifier = Modifier
                                .clip(CircleShape)
                                .border(BorderStroke(1.dp, Color.White), CircleShape)
                                .background(
                                    color = Color.White
                                )

                        )
                    }
                }

            }
        }


        Column(
            modifier =
            Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 15.dp)
                .padding(bottom = 8.dp)
                .weight(1f),
            verticalArrangement = Arrangement.SpaceBetween

        ) {
            Column(
                modifier = Modifier.weight(2.5f)
            ){
                Text(
                    text = "Welcome to",
                    color = MaterialTheme.typography.headlineMedium.color,
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                    fontFamily = MaterialTheme.typography.headlineMedium.fontFamily

                )
                Text(
                    text = "MoodTrackr",
                    color = MaterialTheme.typography.headlineMedium.color,
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                    fontFamily = FontFamily.Cursive
                )
                Text(
                    text = "For living Happier and Healthier, everyday",
                    color = MaterialTheme.typography.bodyMedium.color,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily

                )
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier =
                Modifier
                    .padding(horizontal = 30.dp)
                    .fillMaxWidth()
            ){
                btn<Unit>("start",{onCurrentStepChanged(currentStep + 1)})
            }
        }
    }
}

@Composable
fun OnboardingStep2(currentStep:Int,onCurrentStepChanged:(Int)->Unit){
    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .background(White))
            {
                Row(
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxHeight()
                ) {


                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {

                        Image(
                            painter = painterResource(
                                id = R.drawable.onboarding_purple_stars_background
                            ),
                            contentDescription = "onboarding screen",

                            modifier =
                            Modifier
                                .fillMaxSize(),

                            contentScale = ContentScale.FillBounds
                        )
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxWidth()
                        ) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ){


                            Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = "app logo", modifier = Modifier
                                    .width(100.dp)
                                    .height(100.dp)
                                    .clip(CircleShape)
                                    .border(BorderStroke(1.dp, Color.White), CircleShape)
                                    .background(
                                        color = Color.White
                                    )

                            )
                        }
                        }

                    }
                }

                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(
                            vertical = 20.dp,
                            horizontal = 10.dp
                        )
                        .weight(7f)
                ){
                    Column(
                        modifier =
                        Modifier
                            .background(White)

                            .verticalScroll(rememberScrollState())
                    ){
                        Text(
                            text="Disclaimer",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(
                            text="This is an early demo to only show how the app would look like while showing the basic functions. This prototype is NOT demonstrating the final version."
                        )
                    }
                    Spacer(
                        modifier  = Modifier.height(20.dp)
                    )
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ){
                        btn<Unit>(text="start",{onCurrentStepChanged(currentStep + 1)})
                    }


                }
            }
}
@Composable
fun <ClickReturnType>btn(text:String,onClick:()->ClickReturnType){


    Button(onClick = {onClick()},
        modifier=
        Modifier
            .height(60.dp)
            .width(300.dp)
        ,
    ) {
        Text(
            text= "start",
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            color = White,
            fontFamily = MaterialTheme.typography.bodyLarge.fontFamily

        )
        Icon(
            painter = painterResource(id = R.drawable.arrow_next),
            contentDescription = "arrow next icon",
            tint = Color.White,
            modifier = Modifier.padding(start = 6.dp)
        )
    }
}


@Composable
fun OnboardingStep3(currentStep: Int,onCurrentStepChanged:(Int)->Unit){
    Column(
        modifier =
        Modifier
            .background(BlueBackground)
            .fillMaxSize()
            .padding(
                vertical = 15.dp,
                horizontal = 10.dp
            ),
        verticalArrangement = Arrangement.SpaceBetween
    ){


           Column(
               modifier =
               Modifier
                   .weight(1f)
                   .fillMaxHeight()
                   .padding(vertical = 30.dp),
           ){
               Row(
                   horizontalArrangement = Arrangement.Center,
                   modifier = Modifier
//                .weight(1f)
                       .fillMaxWidth()
               ){

                Icon(
                    painter = painterResource(id = R.drawable.logo),
                    tint= LightBlueBackgroundIconTint,
                    contentDescription = "app logo", modifier = Modifier
                        .clip(CircleShape)
                        .border(BorderStroke(1.dp, BlueBackground), CircleShape)
                        .background(
                            color = LightBlueBackground
                        )
                        .width(100.dp)
                        .height(100.dp)

                )
               }
               Spacer(
                   modifier=Modifier.height(30.dp)
               )
               Text(
                   text="Choose your language",
                   fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                   fontFamily = MaterialTheme.typography.headlineMedium.fontFamily,
                   color = HeaderWhiteColor,
                   textAlign = TextAlign.Center,
                   modifier = Modifier.fillMaxWidth()
               )
            }
            Column(
                modifier =
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ){

                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(15.dp))
                            .border(4.dp, Color(0xFF171819), RoundedCornerShape(15.dp))
                            .fillMaxWidth()
                            .background(LanguageSelectBackground)
                            .padding(vertical = 25.dp),
                        horizontalArrangement = Arrangement.Center

                        ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .weight(0.4f)
                                .fillMaxWidth()
                        ){}
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .weight(0.7f)
                                .fillMaxWidth()
                                .padding(end = 20.dp)
                        ){
                            Text(
                            text = "English",
                            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                            fontFamily = MaterialTheme.typography.headlineMedium.fontFamily,
                            color = MaterialTheme.typography.headlineMedium.color,
                        )


                        Icon(
                            painter = painterResource(id = R.drawable.check_icon),
                            contentDescription = "selected",
                            tint = Black
                        )
                        }
                    }
                Spacer(
                    modifier = Modifier.height(15.dp)
                )
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.dp))
                        .fillMaxWidth()
                        .background(LanguageSelectBackgroundDisabled)
                        .padding(vertical = 25.dp),
                    horizontalArrangement = Arrangement.Center

                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .weight(0.4f)
                            .fillMaxWidth()
                    ){}
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .weight(0.7f)
                            .fillMaxWidth()
                            .padding(end = 20.dp)
                    ){
                        Text(
                            text = "French",
                            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                            fontFamily = MaterialTheme.typography.headlineMedium.fontFamily,
                            color = MaterialTheme.typography.headlineMedium.color.copy(0.4f),
                        )


                        Text(
                            text="Coming Soon",
                            color = Gray,
                            fontSize = MaterialTheme.typography.bodySmall.fontSize
                        )
                    }
                }
            }
        Column(
            modifier =
            Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onCurrentStepChanged(currentStep + 1) },
    horizontalArrangement = Arrangement.End,

            ){

            Text(
                text="next",
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                color = BlueNextTitle
            )
            Icon(
                painter = painterResource(id = R.drawable.arrow_next),
                contentDescription = "Next step",
                modifier =
                Modifier
                    .width(25.dp)
                    .height(25.dp),
                tint = BlueNextTitle

            )
            }
        }

        }



}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingStep4(currentStep: Int,onCurrentStepChanged:(Int)->Unit,nickname:String,onChangeNickname:(String) -> Unit){
    var hasError by remember { mutableStateOf(false) }
    Column(
        modifier =
        Modifier
            .background(PinkBackround)
            .fillMaxSize()
            .padding(
                vertical = 15.dp,
                horizontal = 10.dp
            ),
        verticalArrangement = Arrangement.SpaceBetween
    ){


        Column(
            modifier =
            Modifier
                .weight(1f)
                .fillMaxHeight()
                .padding(vertical = 30.dp),
        ){
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
//                .weight(1f)
                    .fillMaxWidth()
            ){

                Icon(
                    painter = painterResource(id = R.drawable.logo),
                    tint= PinkTintColor,
                    contentDescription = "app logo", modifier = Modifier
                        .clip(CircleShape)
                        .border(BorderStroke(1.dp, PinkBackround), CircleShape)
                        .background(
                            color = LightPinkBackground
                        )
                        .width(100.dp)
                        .height(100.dp)

                )
            }
            Spacer(
                modifier=Modifier.height(30.dp)
            )
            Column(
            ){

            Text(
                text="Choose a Nickname",
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                fontFamily = MaterialTheme.typography.headlineMedium.fontFamily,
                color = HeaderWhiteColor,
                modifier = Modifier.fillMaxWidth()
            )
                Spacer(
                    modifier = Modifier.height(10.dp)
                )
                Text(
                    text="Don't use your real name",
                    color = HeaderWhiteColor
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(LightPinkBackground)
                .fillMaxWidth()
                .padding(vertical = 10.dp)


        ){

                TextField(
                    value = nickname,
                    onValueChange = {hasError = nickname.isBlank() || nickname.isEmpty(); onChangeNickname(it) },
                    placeholder = @Composable { Text(text = "Jam") },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Black,
                        containerColor = LightPinkBackground,
                        cursorColor = PinkBackround,
                    focusedIndicatorColor = LightPinkBackground,
                    unfocusedIndicatorColor = LightPinkBackground,
                        errorCursorColor = Red,
                        errorIndicatorColor = Red,
                        errorLabelColor = Red,
                        errorSupportingTextColor = Red

                    ),
                    isError = hasError,
                    supportingText = {  if (hasError) Text("Invalid Nickname") else null}
                )

        }

        Column(
            modifier =
            Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        if (nickname.isBlank()) hasError = true else onCurrentStepChanged(
                            currentStep + 1
                        )
                    },
                horizontalArrangement = Arrangement.End,

                ){

                Text(
                    text="next",
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                    color = PinkNextColor
                )
                Icon(
                    painter = painterResource(id = R.drawable.arrow_next),
                    contentDescription = "Next step",
                    modifier =
                    Modifier
                        .width(25.dp)
                        .height(25.dp),

                    tint = PinkNextColor

                )
            }
        }

    }



}

