package com.example.gymapp.components

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ShapeDefaults.Medium
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
//import androidx.compose.material.icons.filled.Visibility
//import androidx.compose.material.icons.filled.VisibilityOff

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavController
import com.example.gymapp.R
import com.example.gymapp.data.NavigationItem
import com.example.gymapp.ui.theme.AccentColor
import com.example.gymapp.ui.theme.BgColor
import com.example.gymapp.ui.theme.GrayColor
import com.example.gymapp.ui.theme.Primary
import com.example.gymapp.ui.theme.Secondary
import com.example.gymapp.ui.theme.TextColor
import com.example.gymapp.ui.theme.WhiteColor
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.MediaItem.fromUri
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.ui.StyledPlayerView
import coil.compose.rememberImagePainter
import com.example.gymapp.domain.model.MovieGenres
import com.example.gymapp.navigator.Screen


@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ), color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldComponent(
    labelValue: String, painterResource: Painter,
    onTextChanged: (String) -> Unit,
    errorStatus: Boolean = false
) {

    val textValue = remember {
        mutableStateOf("")
    }
    val localFocusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(5.dp)),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = AccentColor,
            focusedLabelColor = AccentColor,
            cursorColor = AccentColor,
//            containerColor = BgColor
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
            onTextChanged(it)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        },
        isError = !errorStatus
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextFieldComponent(
    labelValue: String, painterResource: Painter,
    onTextSelected: (String) -> Unit,
    errorStatus: Boolean = false
) {

    val localFocusManager = LocalFocusManager.current
    val password = remember {
        mutableStateOf("")
    }

    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(5.dp)),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            containerColor = BgColor
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        singleLine = true,
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        },
        maxLines = 1,
        value = password.value,
        onValueChange = {
            password.value = it
            onTextSelected(it)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        },
        trailingIcon = {

            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Check
            } else {
                Icons.Filled.Warning
            }

            val description = if (passwordVisible.value) {
                stringResource(id = R.string.hide_password)
            } else {
                stringResource(id = R.string.show_password)
            }

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }

        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        isError = !errorStatus
    )
}

@Composable
fun ClickableTextComponent(value: String, onTextSelected: (String) -> Unit) {
    val initialText = "By continuing you accept our "
    val privacyPolicyText = "Privacy Policy"
    val andText = " and "
    val termsAndConditionsText = "Term of Use"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = termsAndConditionsText, annotation = termsAndConditionsText)
            append(termsAndConditionsText)
        }
    }

    ClickableText(text = annotatedString, onClick = { offset ->

        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                Log.d("ClickableTextComponent", "{${span.item}}")

                if ((span.item == termsAndConditionsText) || (span.item == privacyPolicyText)) {
                    onTextSelected(span.item)
                }
            }

    })
}


@Composable
fun CheckboxComponent(
    value: String,
    onTextSelected: (String) -> Unit,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        val checkedState = remember {
            mutableStateOf(false)
        }

        Checkbox(checked = checkedState.value,
            onCheckedChange = {
                checkedState.value = !checkedState.value
                onCheckedChange.invoke(it)
            })

        ClickableTextComponent(value = value, onTextSelected)
    }
}


@Composable
fun ButtonComponent(value: String, onButtonClicked: () -> Unit, isEnabled: Boolean = false) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        onClick = {
            onButtonClicked.invoke()
        },
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        shape = RoundedCornerShape(50.dp),
        enabled = isEnabled
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(Secondary, Primary)),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

        }

    }
}


@Composable
fun DividerTextComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = GrayColor,
            thickness = 1.dp
        )

        Text(
            modifier = Modifier.padding(8.dp),
            text = stringResource(R.string.or),
            fontSize = 18.sp,
            color = TextColor
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = GrayColor,
            thickness = 1.dp
        )
    }
}

@Composable
fun UnderLinedTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ), color = colorResource(id = R.color.colorGray),
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}


@Composable
fun ClickableLoginTextComponent(tryingToLogin: Boolean = true, onTextSelected: (String) -> Unit) {
    val initialText =
        if (tryingToLogin) "Already have an account? " else "Don’t have an account yet? "
    val loginText = if (tryingToLogin) "Login" else "Register"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }

    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString,
        onClick = { offset ->

            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    Log.d("ClickableTextComponent", "{${span.item}}")

                    if (span.item == loginText) {
                        onTextSelected(span.item)
                    }
                }

        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolbar(
    toolbarTitle: String, logoutButtonClicked: () -> Unit,
    navigationIconClicked: () -> Unit
) {

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Primary,
        ),
        title = {
            Text(
                text = toolbarTitle, color = WhiteColor
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                navigationIconClicked.invoke()
            }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = stringResource(R.string.menu),
                    tint = WhiteColor
                )
            }

        },
        actions = {
            IconButton(onClick = {
                logoutButtonClicked.invoke()
            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = stringResource(id = R.string.logout),
                )
            }
        }
    )
}

@Composable
fun NavigationDrawerHeader(value: String?) {
    Box(
        modifier = Modifier
            .background(
                Brush.horizontalGradient(
                    listOf(Primary, Secondary)
                )
            )
            .fillMaxWidth()
            .height(180.dp)
            .padding(32.dp)
    ) {

        NavigationDrawerText(
            title = value?:stringResource(R.string.navigation_header), 28.sp , AccentColor
        )

    }
}

@Composable
fun NavigationDrawerBody(navigationDrawerItems: List<NavigationItem>,
                         onNavigationItemClicked:(NavigationItem) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {

        items(navigationDrawerItems) {
            NavigationItemRow(item = it,onNavigationItemClicked)
        }

    }
}

@Composable
fun NavigationItemRow(item: NavigationItem,
                      onNavigationItemClicked:(NavigationItem) -> Unit) {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onNavigationItemClicked.invoke(item)
            }
            .padding(all = 16.dp)
    ) {

        Icon(
            imageVector = item.icon,
            contentDescription = item.description,
        )

        Spacer(modifier = Modifier.width(18.dp))

        NavigationDrawerText(title = item.title, 18.sp, Primary)


    }
}

@Composable
fun NavigationDrawerText(title: String, textUnit: TextUnit, color: Color) {

    val shadowOffset = Offset(4f, 6f)

    Text(
        text = title, style = TextStyle(
            color = Color.Black,
            fontSize = textUnit,
            fontStyle = FontStyle.Normal,
            shadow = Shadow(
                color = Primary,
                offset = shadowOffset, 2f
            )
        )
    )
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ), color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}


//@Composable
//fun VideoPlayer(){
//    val sampleVideo = "https://api.mc-dragon.com/upload/video/795687a4-8f67-46ac-8098-365f6c959114.m3u8"
//    val context = LocalContext.current
//    val player = SimpleExoPlayer.Builder(context).build()
//    val playerView = PlayerView(context)
//    val mediaItem = MediaItem.fromUri(sampleVideo)
//    val playWhenReady by rememberSaveable {
//        mutableStateOf(true)
//    }
//    player.setMediaItem(mediaItem)
//    playerView.player = player
//    LaunchedEffect(player) {
//        player.prepare()
//        player.playWhenReady = playWhenReady
//
//    }
//    AndroidView(factory = {
//        playerView
//    })
//}

@Composable
fun Test(category : String ){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = category)
    }
}




@Composable
fun MovieGenresContainer(
    movieGenres: MovieGenres,
    navController: NavController,
    onDetailButtonClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.surface)
            .clip(MaterialTheme.shapes.medium)
    ) {
        // Movie Image
        Image(
            painter = rememberImagePainter("https://wallpapers.com/images/featured-full/avengers-vm16xv4a69smdauy.jpg"),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(MaterialTheme.shapes.medium)
                .clickable { onDetailButtonClick.invoke() }
        )

        // Title
        movieGenres!!.name?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .padding(16.dp)
                    .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.8f))
                    .clip(MaterialTheme.shapes.medium)
                    .clickable { onDetailButtonClick.invoke() }
            )
        }

        // Description
        Text(

            text = "DESCRIPTION",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.8f))
                .clip(MaterialTheme.shapes.medium)
                .clickable { onDetailButtonClick.invoke() }
        )

        // Detail Button
        IconButton(
            onClick = {
                println("${movieGenres.id}")
                navController.navigate(Screen.GenresDetail.route+"/${movieGenres.id}")
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Detail",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}



//WHEN API DONE ENABLE THIS
//@Composable
//fun MovieGenresContainer(
//    movieGenres: MovieGenres,
//    onDetailButtonClick: () -> Unit = {}
//) {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//            .background(MaterialTheme.colorScheme.surface)
//            .clip(MaterialTheme.shapes.medium)
//            .clickable { onDetailButtonClick.invoke() }
//    ) {
//        // Movie Image
//        Image(
//            //replace
////            painter = rememberImagePainter(movieGenres.thumbnail),
//            painter = rememberImagePainter(movieGenres.thumbnail),
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp)
//                .clip(MaterialTheme.shapes.medium)
//        )
//
//        // Title
//        Text(
//            text = movieGenres.name,
////            text = "Movie Name",
//            style = MaterialTheme.typography.headlineMedium,
//            fontWeight = FontWeight.Bold,
//            color = MaterialTheme.colorScheme.onSurface,
//            modifier = Modifier
//                .padding(16.dp)
//                .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.8f))
//                .clip(MaterialTheme.shapes.medium)
//        )
//
//        // Description
//        Text(
//            text = movieGenres.description,
//            style = MaterialTheme.typography.bodyMedium,
//            color = MaterialTheme.colorScheme.onSurface,
//            modifier = Modifier
//                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
//                .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.8f))
//                .clip(MaterialTheme.shapes.medium)
//        )
//
//        // Detail Button
//        IconButton(
//            onClick = { onDetailButtonClick.invoke() },
//            modifier = Modifier
//                .align(Alignment.BottomEnd)
//                .padding(16.dp)
//        ) {
//            Icon(
//                imageVector = Icons.Default.PlayArrow,
//                contentDescription = "Detail",
//                tint = MaterialTheme.colorScheme.onSurface
//            )
//        }
//    }
//}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieCard(
    movieGenres: MovieGenres,
    navController: NavController,
    onDetailButtonClick: () -> Unit = {}
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFFDAE1E7),
        modifier = Modifier
            .height(210.dp)
            .padding(10.dp),
        shadowElevation = 10.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f),
                verticalArrangement = Arrangement.Center
            ) {
                Surface(
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.wrapContentSize(),
                    color = Color(0xFFD1D5E1)
                ) {
                    Text(
                        text = "New release",
                        fontSize =  12.sp,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = movieGenres.name,
                    fontSize =  24.sp,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(text = "Action movies that have high-intensity fight sequences and larger-than-life stunts can cause the viewer to feel short-term excitement and stress in a safe, controlled environment. ")

                Spacer(modifier = Modifier.height(2.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "4.0",
                        fontSize =  14.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_access_time_filled_24),
                        tint = Color(0xFFF6B266),
                        contentDescription = null
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.baseline_access_time_filled_24),
                        tint = Color(0xFFF6B266),
                        contentDescription = null
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.baseline_visibility_24),
                        tint = Color(0xFFF6B266),
                        contentDescription = null
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_vpn_key_24),
                        tint = Color(0xFFF6B266),
                        contentDescription = null
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                OutlinedButton(
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.White
                    ),
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = "Read More",
                        fontSize =  11.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            Surface(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.size(width = 100.dp, height = 140.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_textsms_24),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallMovieCard(
    movieGenres: MovieGenres,
    modifier: Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(bottom = 16.dp)
    ) {
        Card(
//            shape = Shapes.large,

            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(color = DarkGray)
                .padding(bottom = 8.dp)
        ) {
            Image(
                painter = rememberImagePainter("https://wallpapers.com/images/featured-full/avengers-vm16xv4a69smdauy.jpg"),
                contentDescription = null,
                modifier = Modifier.padding(16.dp)
            )
        }
        Text(text = movieGenres.name, modifier = Modifier.width(100.dp), fontSize = 14.sp)
        Text(text = movieGenres.name, color = DarkGray, modifier = Modifier.width(100.dp), fontSize = 14.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun MovieLargeContainer(
) {

    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(30.dp))
            .background(color = Color.DarkGray),
        contentAlignment = Alignment.Center
    ) {

        Row(
            modifier = Modifier
                .padding(start = 20.dp)
                .padding(top = 25.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(Modifier.width(150.dp)) {
                Text(
                    modifier = Modifier.padding(bottom = 10.dp).size(20.dp),
                    text = "Avengers: Endgame (2019)",
                    color = Color.Black,
//                    fontSize = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.textButtonColors(
                       Color.White
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.menu),
                        color = colorResource(id = R.color.colorGray)
                    )
                }

                Spacer(modifier = Modifier.height(180.dp))

                Text(
                    text = "Hi",
                    color = Color.Black,
//                    fontSize = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 50.dp)
                )
            }

            //Tennis Player Image
            Image(
                painter = rememberImagePainter("https://wallpapers.com/images/featured-full/avengers-vm16xv4a69smdauy.jpg"),
                modifier = Modifier.width(300.dp),
                contentDescription = "A poster image of a tennis player",
                contentScale = ContentScale.FillBounds
            )
        }
    }
}

@Preview
@ExperimentalMaterial3Api
@Composable
fun MovieDetailScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Movie Details") },
            modifier = Modifier.background(color = Color.Black),

            )

        // Movie poster and play button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            Image(
                painter = rememberImagePainter("https://wallpapers.com/images/featured-full/avengers-vm16xv4a69smdauy.jpg"),
                contentDescription = "Movie Poster",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            IconButton(
                onClick = { /* TODO: Handle play movie */ },
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Play",
                    tint = Color.White,
                    modifier = Modifier.size(48.dp)
                )
            }
        }

        // Movie title and actions
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Doctor Strange 2",
                style = TextStyle(fontSize = 24.sp, color = Color.White)
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /* TODO: Handle favorite */ }) {
                Icon(Icons.Default.Favorite, contentDescription = "Like")
            }
            IconButton(onClick = { /* TODO: Handle share */ }) {
                Icon(Icons.Default.Share, contentDescription = "Share")
            }
        }

        // Movie description
        Text(
            text = "This is the sample description of the movie...",
            modifier = Modifier.padding(16.dp),
            color = Color.Gray
        )

        // Recommended section
        Text(
            text = "Recommended",
            modifier = Modifier.padding(16.dp),
            style = TextStyle(fontSize = 18.sp, color = Color.White)
        )
        LazyRow {
            items(recommendations) { recommendation ->
                Card(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .padding(8.dp)
                        .size(120.dp, 180.dp)
                ) {
                    Image(
                        painter = rememberImagePainter(recommendation.imageRes),
                        contentDescription = "Recommended Movie",
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}

// Dummy data for recommendations, replace with real data
val recommendations = listOf(
    Recommendation(imageRes = R.drawable.baseline_textsms_24),
    Recommendation(imageRes = R.drawable.baseline_textsms_24),
    Recommendation(imageRes = R.drawable.baseline_textsms_24)
)

data class Recommendation(val imageRes: Int)


// Movie Detail Screen Component Section

// Will pass a list of movie id, thumbnail, title as parameters
@Composable
fun RecommendedSection(recommendations: List<Recommendation>) {
    Text(
        text = "Recommended",
        modifier = Modifier.padding(16.dp),
        style = TextStyle(fontSize = 18.sp, color = Color.White)
    )
    LazyRow {
        items(recommendations) { recommendation ->
            RecommendationCard(recommendation)
        }
    }
}
// Will pass movie id, thumbnail, title as parameters
@Composable
fun RecommendationCard(recommendation: Recommendation) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .size(120.dp, 180.dp)
    ) {
        Image(
            painter = painterResource(id = recommendation.imageRes),
            contentDescription = "Recommended Movie",
            contentScale = ContentScale.Crop
        )
    }
}


//HOME SCREEN DETAIL COMPONENT

@Preview
@Composable
fun GreetingSection(username: String = "Pheng") {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Hello $username",
            style = TextStyle(fontSize = 24.sp, color = Color.White)
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Profile",
            tint = Color.White,
            modifier = Modifier.size(48.dp)
        )
    }
}

@Preview
@Composable
fun SearchBar(hint: String = "What to Watch?") {
    var text by rememberSaveable { mutableStateOf("") }

    BasicTextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(Color.White, shape = CircleShape)
            .padding(horizontal = 20.dp, vertical = 12.dp),
        decorationBox = { innerTextField ->
            Row(Modifier.fillMaxWidth()) {
                if (text.isEmpty()) {
                    Text(hint, style = TextStyle(color = Color.LightGray, fontSize = 16.sp))
                }
                innerTextField()
            }
        }
    )
}


